package com.gyq.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.gyq.bean.Book;
import com.gyq.bean.BookType;
import com.gyq.dao.BookDao;
import com.gyq.dao.BookTypeDao;
import com.gyq.util.DbUtil;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorNameTxt;
	private JComboBox s_bookTypeJcb; 
	private JLabel s_countBook;
	private BookDao bookDao = new BookDao(); 
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	@SuppressWarnings("serial")
	public BookManageInterFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 667, 649);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		s_countBook = new JLabel("");
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(s_countBook, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(s_countBook, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		bookDescTxt. setBorder(new LineBorder(new java. awt. Color(127,157,185),1, false));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookDescTxt))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(priceTxt))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(femaleJrb, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(84)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_5)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {idTxt, bookNameTxt, priceTxt, authorTxt});
		gl_panel_1.linkSize(SwingConstants.HORIZONTAL, new Component[] {idTxt, bookNameTxt, priceTxt, authorTxt});
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authorNameTxt = new JTextField();
		s_authorNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorNameTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_authorNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(46);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(65);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(61);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(66);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(66);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(151);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());

	}
	
	private void bookDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int select = JOptionPane.showConfirmDialog(null, "确认删除该条记录吗？");
		if (select == 0) { // 选择是
			Connection conn = null;
			try {
				conn = DbUtil.getConnection();
				int deletedcount = bookDao.delete(conn, id);
				if (deletedcount == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					resetValue();
					this.fillTable(new Book()); //等价于更新查询所有信息
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "删除失败！");
				e.printStackTrace();
			}finally {
				DbUtil.close(conn, null, null);
			}
		}
	}

	private void bookUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=this.idTxt.getText();
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return;
		}
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		if(bookName.isEmpty()){
			JOptionPane.showMessageDialog(null,"图书名称不能为空！");
			return;
		}
		if(author.isEmpty()){
			JOptionPane.showMessageDialog(null,"图书作者不能为空！");
			return;
		}
		if(price.isEmpty()){
			JOptionPane.showMessageDialog(null,"图书价格不能为空！");
			return;
		}
		String sex="";
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		BookType bookType=(BookType) bookTypeJcb. getSelectedItem(); // 通过下拉框对象获取booktypeid
		int bookTypeId=bookType. getId();
		
		Book book = new Book(Integer.parseInt(id),bookName,author,sex,Float.parseFloat(price),bookTypeId,bookDesc);
		
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			int addNum = bookDao.update(conn, book);
			if (addNum > 0) {
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				resetValue();
				this.fillTable(new Book()); //刷新查询结果
			}else {
				JOptionPane.showMessageDialog(null, "图书修改失败！");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "图书修改失败！");
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
		
		
		
	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount() > 0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}

	private void bookTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=this. bookTable. getSelectedRow();
		this. idTxt. setText((String) bookTable. getValueAt(row,0));
		this. bookNameTxt. setText((String) bookTable. getValueAt(row,1));
		this. authorTxt. setText((String) bookTable. getValueAt(row,2));
		String sex=(String) bookTable. getValueAt(row,3);
		if("男".equals(sex)){
			this.manJrb.setSelected(true);
		}else if("女".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row,4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row,5));
		String bookTypeName = (String)bookTable.getValueAt(row, 6);
		int n = this.bookTypeJcb.getItemCount(); //bookTypeJcb 在this.fillBookType("modify")填充了
		for (int i = 0; i < n; i++) {
			BookType item=(BookType) this. bookTypeJcb. getItemAt(i); //获取下拉框的第i个对象
			if(item. getBookTypeName(). equals(bookTypeName)){ // 当前选中的类型名等于从下拉框获得的类型名
				this. bookTypeJcb. setSelectedIndex(i); //选中
			}
		}
	}

	private void bookSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName=this.s_bookNameTxt. getText();
		String author=this.s_authorNameTxt.getText();
		BookType bookType=(BookType) this.s_bookTypeJcb. getSelectedItem();
		int bookTypeId=bookType. getId();
		Book book = new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	private void fillBookType(String type) {
		Connection conn = null;
		BookType bookType = null;
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = bookTypeDao.query(conn, new BookType());
			if ("search".equals(type)) {
				bookType = new BookType();
				bookType.setBookTypeName("请选择...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while (rs.next()) {
				bookType = new BookType();
				bookType.setBookTypeName(BookTypeManageInterFrm.rtrim(rs.getString("bookTypeName")));
				bookType.setId(rs.getInt("id"));
				if ("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				}else if ("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); // 设置为0行，防止查询数据重复添加
		Connection conn = null;
		int count = 0;
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = bookDao.query(conn, book);
			while (rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector v = new Vector();
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("id")));
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("bookName")));
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("author")));
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("sex")));
				v.add(rs.getFloat("price"));
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("bookDesc")));
				v.add(BookTypeManageInterFrm.rtrim(rs.getString("bookTypeName")));
				dtm.addRow(v);
				count++;
			}
			if (count == 0) {
				s_countBook.setText("没有找到任何相关记录");
			}else {
				s_countBook.setText("已找到"+count+"条结果");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
}
