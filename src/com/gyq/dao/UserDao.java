package com.gyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gyq.bean.User;

public class UserDao {
	
	//after connecting successfully , doing this method
	public User login(Connection conn,User user) throws Exception {
		User resultUser = null; // ��½ʧ�ܷ���null
		
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql); // Ԥ����sql���
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			resultUser = new User(); // ֻ�����ݿ����м�¼��resultUser�Ų�Ϊnull�����ܵ�¼
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;//��¼�ɹ�����resultUser
	}
}
