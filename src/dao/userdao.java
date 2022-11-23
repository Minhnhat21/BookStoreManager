package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;
import bean.userbean;
import dao.userdao;
public class userdao {
	public ArrayList<userbean> getUser() {
			
			try { // Tao 1 mang luu all loai 
				 ArrayList<userbean> ds = new ArrayList<userbean>(); 
				 // b1: ket noi vao csdl 
				 ketnoi kn = new ketnoi();
				 kn.ketnoi(); 
				 // b2: lay du lieu ve 
				 String sql = "select * from KhachHang";
				 PreparedStatement cmd = kn.cn.prepareStatement(sql); 
				 ResultSet rs = cmd.executeQuery(); 
				 // b3: dua du lieu vao mang ds 
				 while (rs.next()) { 
					 String ten = rs.getString("tendn");
					 String mk = rs.getString("pass");
					 //String quyen = rs.getString("Quyen");
					 ds.add(new userbean(ten, mk, 1)); 
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
