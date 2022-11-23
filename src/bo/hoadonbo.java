package bo;

import java.util.ArrayList;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	private hoadondao hddao = new hoadondao();
	
	public long getMaHD() {
		return hddao.getmaxhd();
	}
	
	public int Them(long makh) {
		return hddao.Them(makh);
	}
}
