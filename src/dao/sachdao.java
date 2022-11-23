package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getSach() {
		
		try { // Tao 1 mang luu all loai 
			 ArrayList<sachbean> ds = new ArrayList<sachbean>(); 
			 // b1: ket noi vao csdl 
			 ketnoi kn = new ketnoi();
			 kn.ketnoi(); 
			 // b2: lay du lieu ve 
			 String sql = "select * from sach";
			 PreparedStatement cmd = kn.cn.prepareStatement(sql); 
			 ResultSet rs = cmd.executeQuery(); 
			 // b3: dua du lieu vao mang ds 
			 while (rs.next()) { 
				 String masach = rs.getString("masach");
				 String tensach = rs.getString("tensach");
				 String tacgia = rs.getString("tacgia");
				 String sl = rs.getString("soluong");
				 String gia = rs.getString("gia");
				 String anh = rs.getString("anh");
				 String maloai = rs.getString("maloai");
				 ds.add(new sachbean(masach, tensach,tacgia, Integer.parseInt(sl), Integer.parseInt(gia), anh, maloai)); 
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
