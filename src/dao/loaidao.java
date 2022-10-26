package dao;

import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getLoai() {
		ArrayList<loaibean> list = new ArrayList<loaibean>(); // danh sach nay chi chua dia chi
		
		list.add(new loaibean("tin","Công nghệ thông tin"));
		list.add(new loaibean("kt","Kiến trúc"));
		list.add(new loaibean("bc","Báo chí"));
		return list;
		
		
	}
}
