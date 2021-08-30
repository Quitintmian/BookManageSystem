package com.gyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gyq.bean.Book;

/**
 * 图书DAO类
 * @author computer
 *
 */
public class BookDao {
	
	public int add(Connection conn,Book book)  throws Exception{
		String sql = "insert into t_book(bookName,author,sex,price,bookTypeId,bookDesc) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2,book.getAuthor());
		ps.setString(3,book.getSex());
		ps.setFloat(4,book.getPrice());
		ps.setInt(5,book.getBookTypeId());
		ps.setString(6,book.getBookDesc());
		return ps.executeUpdate();
	}
	
	public ResultSet query(Connection conn,Book book) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_book b, t_bookType bt where b.bookTypeId=bt.id");
		if(book. getBookName()!=null){
			sb. append(" and b. bookName like '%"+book.getBookName()+"%'");
		}
		if(book. getAuthor()!=null){
			sb. append(" and b. author like '%"+book.getAuthor()+"%'");
		}
		if (book.getBookTypeId()!=null&&book.getBookTypeId()!=-1) { //combobox已选中
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		return ps.executeQuery();
	}
	
	public int delete(Connection conn,String id) throws Exception { 
		String sql = "delete from t_book where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	public int update(Connection conn,Book book) throws Exception {
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id = ?";
		PreparedStatement pstmt=conn. prepareStatement(sql);
		pstmt. setString(1, book. getBookName());
		pstmt. setString(2, book. getAuthor());
		pstmt. setString(3, book. getSex());
		pstmt. setFloat(4, book. getPrice());
		pstmt. setString(5, book. getBookDesc());
		pstmt. setInt(6, book. getBookTypeId()); // 更改BookTypeId的目的是更换图书类别
		pstmt. setInt(7, book. getId());
		return pstmt. executeUpdate();
	}
	
}
