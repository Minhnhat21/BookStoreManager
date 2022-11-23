package dao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class chitiethoadondao {
	public int Them(String masach, long soluongmua, long mahd) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="insert into ChiTietHoaDon(MaSach,SoLuongMua, MaHoaDon, damua) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, mahd);
			cmd.setBoolean(4, false);
		
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		chitiethoadondao cthd = new chitiethoadondao();
		cthd.Them("b12", 3, 8);
	}
}
