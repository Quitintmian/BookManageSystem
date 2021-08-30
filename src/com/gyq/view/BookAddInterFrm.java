package com.gyq.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.gyq.bean.Book;
import com.gyq.bean.BookType;
import com.gyq.dao.BookDao;
import com.gyq.dao.BookTypeDao;
import com.gyq.util.DbUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	
	private BookTypeDao bookTypeDao =  new BookTypeDao(); 
	private BookDao bookDao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 480, 487);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		bookDescTxt. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(femaleJrb)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(priceTxt)
								.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(51, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_5))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(125)))))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(lblNewLabel_3)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(45))
		);
		getContentPane().setLayout(groupLayout);
		
		fillBookType();
	}
	
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 图书添加事件处理
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName = this.bookNameTxt.getText();
		String author=this. authorTxt.getText();
		String price=this. priceTxt.getText();
		String bookDesc=this. bookDescTxt.getText();
		if (bookName.isEmpty()) {
			JOptionPane.showMessageDialog(null,"图书名称不能为空！");
			return;
		}
		if (author.isEmpty()) {
			JOptionPane.showMessageDialog(null,"图书作者不能为空！");
			return;
		}
		if (price.isEmpty()) {
			JOptionPane.showMessageDialog(null,"图书价格不能为空！");
			return;
		}
		
		String sex = "";
		if (manJrb.isSelected()) {
			sex = "男";
		}else if (femaleJrb.isSelected()) {
			sex = "女";
		}
		
		BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName,author,sex, Float.parseFloat(price), bookTypeId, bookDesc);
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			int addNum = bookDao.add(conn, book);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null,"图书添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null,"图书添加失败！");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"图书添加失败！");
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
	
	
	private void resetValue() {
		this. bookNameTxt.setText("");
		this. authorTxt.setText("");
		this. priceTxt.setText("");
		this. manJrb.setSelected(true);
		this. bookDescTxt.setText("");
		if(this. bookTypeJcb. getItemCount()>0){
			this. bookTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化图书类别下拉框
	 */
	@SuppressWarnings("unchecked")
	private void fillBookType() {
		Connection conn = null;
		BookType bookType = null;
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = bookTypeDao.query(conn, new BookType()); //无名对象显示全部
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id")); // 获取此值，目的是为了隐式添加bookTypeId属性
				bookType.setBookTypeName(BookTypeManageInterFrm.rtrim(rs.getString("bookTypeName")));
				this.bookTypeJcb.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
	
}