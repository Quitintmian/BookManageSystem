package com.gyq.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gyq.bean.BookType;
import com.gyq.dao.BookTypeDao;
import com.gyq.util.DbUtil;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypetable;
	private JLabel s_countBookType;
	
	private BookTypeDao bookTypeDao = new BookTypeDao(); 
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	
	public static String rtrim(String value){
		   if(value==null) return null;
		   return value.replaceAll("\\s+$",""); // ȥ���Ҳ�ĩβ�Ŀո�
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 597, 646);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 14));
		
		s_countBookType = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_countBookType, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(24)
					.addComponent(s_countBookType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(83))
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTypetable = new JTable();
		bookTypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypetable.setFont(new Font("����", Font.PLAIN, 13));
		bookTypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypetable.getColumnModel().getColumn(0).setPreferredWidth(37);
		bookTypetable.getColumnModel().getColumn(1).setPreferredWidth(172);
		bookTypetable.getColumnModel().getColumn(2).setPreferredWidth(296);
		scrollPane.setViewportView(bookTypetable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookType()); //�����˴���ʱ�Զ���ѯ����ͼ�������Ϣ
	}
	
	private void bookTypeDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
			return;
		}
		int select = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��������¼��");
		if (select == 0) { 
			Connection conn = null;
			try {
				conn = DbUtil.getConnection();
				int deletedcount = bookTypeDao.delete(conn, id);
				if (deletedcount == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					resetValue();
					this.fillTable(new BookType()); //�ȼ��ڸ��²�ѯ������Ϣ
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				e.printStackTrace();
			}finally {
				DbUtil.close(conn, null, null);
			}
			
		}
		
	}

	private void bookTypeUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText(); //id ���ᱻ���£���ȡidֻ��Ϊ�˶�λ
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
			return;
		}
		if (bookTypeName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ͼ�����������Ϊ�գ�");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			int count = bookTypeDao.update(conn, bookType);
			if (count == 1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				resetValue();
				this.fillTable(new BookType()); //�ȼ��ڸ��²�ѯ������Ϣ
			}else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			} 		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
		
	}

	/**
	 * ����е���¼�����
	 * @param evt
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = bookTypetable.getSelectedRow(); //���ѡ�е��к�
		idTxt.setText((String)bookTypetable.getValueAt(row, 0)); //��õ�ǰ�кŵĵ�һ���ϵ�ֵ����id�ֶΣ�����idTxt�ı�������ʾ
		bookTypeNameTxt.setText((String)bookTypetable.getValueAt(row, 1)); // ʹ��toString()�ᷢ��nullpointerException
		bookTypeDescTxt.setText((String)bookTypetable.getValueAt(row, 2));
	}

	/**
	 * ͼ������ѯ�¼�����
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_bookTypeName = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName); //ʼ�ն���ͨ��������������Ϣ�ͷ�װ��Ϣ
		this.fillTable(bookType); // ��ͼ��������Ʋ�ѯ��ʵ���ϵ��� select * from t_bookType where bookTypeName like '%bookName%' 
	}

	/**
	 * ��ѯʱ�������ݿ�����������Ϣ����
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) bookTypetable.getModel();
		dtm.setRowCount(0); // ����Ϊ0�У���ֹ��ѯ�����ظ����
		Connection conn = null;
		int count = 0;
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = bookTypeDao.query(conn, bookType);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rtrim(rs.getString("id")));
				v.add(rtrim(rs.getString("bookTypeName")));
				v.add(rtrim(rs.getString("bookTypeDesc")));
				dtm.addRow(v);
				count++;
			}
			if (count == 0) {
				s_countBookType.setText("û���ҵ��κ���ؼ�¼");
			}else {
				s_countBookType.setText("���ҵ�"+count+"�����");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
	
	private void resetValue() {
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
	
}

