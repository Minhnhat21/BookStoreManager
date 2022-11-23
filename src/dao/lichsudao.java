package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> getLichSu(long makh) {
		try {
			ArrayList<lichsubean> dsls = new ArrayList<lichsubean>();
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="select * from VLS_01 where makh = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setLong(1, makh);

			ResultSet rs= cmd.executeQuery();
			
			while(rs.next()) {//Dang nhap thanh cong
				String tensach = rs.getString("tensach");
				long soluongmua = rs.getLong("SoLuongMua");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("ThanhTien");
				String ngaymua = rs.getString("NgayMua");
				Boolean damua = rs.getBoolean("damua");
				dsls.add(new lichsubean(makh, tensach, soluongmua, gia, thanhtien, ngaymua, false));
			}
			rs.close();kn.cn.close();
			return dsls;
		} catch (Exception e) {
			e.printStackTrace();return null;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<lichsubean> dsls = new ArrayList<lichsubean>();
		lichsudao lsdao = new lichsudao();
		dsls = lsdao.getLichSu(20);
		for (lichsubean lichsubean : dsls) {
			System.out.println(lichsubean.getTensach());
		}
	}
}
