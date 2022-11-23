package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.hoadonbean;
import bean.loaibean;

public class ketnoi {
	public Connection cn;
	public void ketnoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.print("Step 1 : done" + "\n");
			String s2 =  "jdbc:sqlserver://DESKTOP-9E767PR:1433;instance=SQLEXPRESS;databaseName=QlSach;user=sa;password=12345qwert";
			System.out.println("Hello World");
			cn = DriverManager.getConnection(s2);
			System.out.print("Step 2: done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) throws SQLException {
//		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>(); 
//		 // b1: ket noi vao csdl 
//		 ketnoi kn = new ketnoi();
//		 kn.ketnoi(); 
//		 // b2: insert du lieu vao database;
//		 // b3: dua du lieu vao mang ds 
//
//		 
//		 try (PreparedStatement stmt = kn.cn.prepareStatement("INSERT INTO hoadon (MaHoaDon, makh, NgayMua, damua) VALUES (?, ?, ?, ?)")) {
//			 	stmt.setString(1, "6");
//			 	stmt.setString(2, "20");   
//		        stmt.setString(3, "2022-11-14");
//		        stmt.setString(4, "False");
//		        stmt.executeUpdate();
//		  }
//		 
//		 try (PreparedStatement stmt = kn.cn.prepareStatement("INSERT INTO ChiTietHoaDon (MaSach, SoLuongMua, damua, MaHoaDon) VALUES (?, ?, ?, ?)")) {
//		        stmt.setString(1, "b12");   
//		        stmt.setString(2, "6");
//		        stmt.setString(3, "0");
//		        stmt.setString(4, "3");
//		        stmt.executeUpdate();
//		  }
//		 kn.cn.close(); 
//
//	}

}
