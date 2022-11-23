package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;
import bean.khachhangbean;
import bean.lichsubean;
import bo.lichsubo;

public class hoadondao {
	public long getmaxhd() {
    	try {
    		ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="select max(mahoadon) as maxhd from hoadon";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			long max=0;
			if(rs.next()) 
				max=rs.getLong("maxhd");
			rs.close(); kn.cn.close();
			return max;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
    }
	public int Them( long makh) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="insert into hoadon(makh,NgayMua,damua) values(?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			Date n= new Date();
			SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
			String ngay =dd.format(n);
			Date ngaymua=dd.parse(ngay);
			cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
			cmd.setBoolean(3, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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
