package com.gyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gyq.bean.User;

public class UserDao {
	
	//after connecting successfully , doing this method
	public User login(Connection conn,User user) throws Exception {
		User resultUser = null; // 登陆失败返回null
		
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql); // 预编译sql语句
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			resultUser = new User(); // 只有数据库中有记录，resultUser才不为null，才能登录
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;//登录成功返回resultUser
	}
}
