package com.gyq.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gyq.bean.BookType;

/**
 * ͼ�����DAO
 * @author computer
 *
 */
public class BookTypeDao {
	
	/**
	 * ͼ��������
	 * @param conn
	 * @param bookType
	 * @return
	 */
	public int add(Connection conn,BookType bookType)  throws Exception{
		//ִ���������ʱ���ݿ������ӣ�����Ҫ��������
		String sql = "insert into t_bookType(bookTypeName,bookTypeDesc) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		return ps.executeUpdate();
	}
	
	/**
	 * ͼ������ѯ
	 * @param conn
	 * @param bookType
	 * @return ��ѯ����
	 */
	public ResultSet query(Connection conn,BookType bookType)  throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_bookType");
		if (bookType.getBookTypeName()!=null) {
			//ģ����ѯ
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%' "); // ע��andǰ���и��ո�,��ʼ����ִ�д˴�
		}
		PreparedStatement ps = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return ps.executeQuery(); // ���ز�ѯ�����
	}
	
	/**
	 * ɾ��ͼ�����
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
	 * ����ͼ�����
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
