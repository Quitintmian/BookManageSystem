package com.gyq.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtiltest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			System.out.println("已连接到SQL Server！");
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn, null, null);
		}
	}
}
