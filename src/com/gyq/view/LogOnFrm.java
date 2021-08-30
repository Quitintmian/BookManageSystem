package com.gyq.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


import com.gyq.bean.User;
import com.gyq.dao.UserDao;
import com.gyq.util.DbUtil;
import java.awt.Color;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JLabel userNameNotice;
	private JLabel passwordNotice;
	
	private UserDao userDao =  new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
					}
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 240, 528, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 28));
		
		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel passwordLabel = new JLabel("\u5BC6  \u7801\uFF1A");
		passwordLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton loginBtn = new JButton("\u767B\u5F55");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e); // 登录
			}
		});
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e); // 重置
			}
		});
		
		userNameNotice = new JLabel("");
		userNameNotice.setForeground(Color.RED);
		userNameNotice.setFont(new Font("宋体", Font.PLAIN, 13));
		
		passwordNotice = new JLabel("");
		passwordNotice.setFont(new Font("宋体", Font.PLAIN, 13));
		passwordNotice.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordLabel)
								.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordTxt)
									.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addComponent(resetBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addComponent(userNameNotice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(passwordNotice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addGap(168))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameLabel))
					.addGap(3)
					.addComponent(userNameNotice)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordNotice)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(resetBtn))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * 登录系统
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();// 获取用户输入的用户名
		String password = new String(this.passwordTxt.getPassword());// 获取用户输入的密码，并转换成字符串
		if (userName.isEmpty()) {
			this.userNameNotice.setText("用户名不能为空！");
			return;
		}
		if (password.isEmpty()) {
			this.passwordNotice.setText("密码不能为空！");
			return;
		}
		User user = new User(userName,password);
		//连接数据库
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			User currentUser = userDao.login(conn, user);
			if (currentUser!=null) {
				dispose();
				new MainFrm().setVisible(true);
			} else {
				this.userNameNotice.setText("");
				this.passwordNotice.setText("");
				JOptionPane.showMessageDialog(null,"用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重置用户输入的用户名和密码信息
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.userNameNotice.setText("");
		this.passwordNotice.setText("");
	}
}


