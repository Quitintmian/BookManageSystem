package com.gyq.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutmeInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutmeInterFrm frame = new AboutmeInterFrm();
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
	public AboutmeInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("About me");
		setBounds(100, 100, 593, 408);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutmeInterFrm.class.getResource("/images/newgoodisland.jpg")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);

	}

}
