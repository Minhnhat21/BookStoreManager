package bo;

import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao= new chitiethoadondao();
	 public int Them(String masach, long soluongmua, long mahd) {
		 return ctdao.Them(masach, soluongmua, mahd);
	 }

}
