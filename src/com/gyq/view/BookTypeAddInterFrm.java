package com.gyq.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.gyq.bean.BookType;
import com.gyq.dao.BookTypeDao;
import com.gyq.util.DbUtil;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private  JTextArea bookTypeDescTxt;
	
	private BookTypeDao bookTypeDao = new BookTypeDao(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 482, 329);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		//设置文本域边框
		bookTypeNameTxt. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));
		
		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e); // 重置
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(bookTypeDescTxt)
							.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * 图书类别添加事件处理
	 * @param evt
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookTypeName = this.bookTypeNameTxt.getText();
		String bookTypeDesc = this.bookTypeDescTxt.getText();
		if (bookTypeName.isEmpty()) {
			JOptionPane.showMessageDialog(null,"图书类别名称不能为空！");
			return;
		}
		BookType bookType = new BookType(bookTypeName,bookTypeDesc);
		//连接数据库
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			int count = bookTypeDao.add(conn, bookType); // 此方法内实际执行sql语句
			if (count == 1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}

	/**
	 * 重置事件处理
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
