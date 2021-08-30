package com.gyq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

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
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1200, 780);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setFont(new Font("苹方-简", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm. setVisible(true);
				table. add(bookTypeAddInterFrm);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm. setVisible(true);
				table. add(bookTypeManageInterFrm);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm. setVisible(true);
				table. add(bookAddInterFrm);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm. setVisible(true);
				table. add(bookManageInterFrm);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
				//用户选择是，关闭窗口
				if (result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_5.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setFont(new Font("苹方-简", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u672C\u7CFB\u7EDF");
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutmeInterFrm aboutmeInterFrm = new AboutmeInterFrm();
				aboutmeInterFrm.setVisible(true);
				table.add(aboutmeInterFrm);
			}
		});
		mntmNewMenuItem.setFont(new Font("苹方-简", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setOpaque(false);
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		//在主界面上方显示当前时间
		JLabel currentTimeTxt = new JLabel("");
		currentTimeTxt.setForeground(Color.WHITE);
		currentTimeTxt.setFont(new Font("微软雅黑 Light", Font.PLAIN, 26));
		currentTimeTxt.setBounds(495, 10, 438, 55);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		table.add(currentTimeTxt);
		new Thread() {
			public void run() {
				while (true) {
					try {
						currentTimeTxt.setText("当前时间："+dateFormat.format(new Date()));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//设置窗口最大化
		this.setExtendedState(MAXIMIZED_BOTH);
		
	}
}
