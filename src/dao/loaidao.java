package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getLoai() {
//		ArrayList<loaibean> list = new ArrayList<loaibean>(); // danh sach nay chichua dia chi
//		 
//		 list.add(new loaibean("tin","Công nghệ thông tin")); list.add(new
//		 loaibean("kt","Kiến trúc")); list.add(new loaibean("bc","Báo chí")); 
//		 return list;
		
		
		
		 try { // Tao 1 mang luu all loai 
			 ArrayList<loaibean> ds = new ArrayList<loaibean>(); 
			 // b1: ket noi vao csdl 
			 ketnoi kn = new ketnoi();
			 kn.ketnoi(); 
			 // b2: lay du lieu ve 
			 String sql = "select * from loai";
			 PreparedStatement cmd = kn.cn.prepareStatement(sql); 
			 ResultSet rs = cmd.executeQuery(); 
			 // b3: dua du lieu vao mang ds 
			 while (rs.next()) { 
				 String maloai = rs.getString("maloai"); 
				 String tenloai = rs.getString("tenloai");
				 ds.add(new loaibean(maloai, tenloai)); 
			 } 
			 // b4: dong ket noi rs.close();
			 kn.cn.close(); 
			 return ds; 
		} 
		catch (Exception e) { e.printStackTrace(); 
			return null; 
		 }
		
	}
}
