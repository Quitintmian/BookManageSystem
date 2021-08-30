package com.gyq.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gyq.bean.BookType;

/**
 * 图书类别DAO
 * @author computer
 *
 */
public class BookTypeDao {
	
	/**
	 * 图书类别添加
	 * @param conn
	 * @param bookType
	 * @return
	 */
	public int add(Connection conn,BookType bookType)  throws Exception{
		//执行这个方法时数据库已连接，不需要重新连接
		String sql = "insert into t_bookType(bookTypeName,bookTypeDesc) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		return ps.executeUpdate();
	}
	
	/**
	 * 图书类别查询
	 * @param conn
	 * @param bookType
	 * @return 查询集合
	 */
	public ResultSet query(Connection conn,BookType bookType)  throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_bookType");
		if (bookType.getBookTypeName()!=null) {
			//模糊查询
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%' "); // 注意and前面有个空格,初始化不执行此处
		}
		PreparedStatement ps = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return ps.executeQuery(); // 返回查询结果集
	}
	
	/**
	 * 删除图书类别
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,String id)  throws Exception{
		String sql = "delete from t_bookType where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	/**
	 * 更新图书类别
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,BookType bookType) throws Exception {
		String sql = "update t_bookType set bookTypeName=?, bookTypeDesc=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		ps.setInt(3, bookType.getId());
		return ps.executeUpdate();
	}

}
