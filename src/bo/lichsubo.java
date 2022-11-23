package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.lichsubean;
import dao.lichsudao;




public class lichsubo {
	lichsudao lsdao = new lichsudao();
	 
	public ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
	
	public ArrayList<lichsubean> getLichSu(long makh) {
		ds = lsdao.getLichSu(makh);
		return ds;
	}
	
	public static void main(String[] args) {
		ArrayList<lichsubean> dsls = new ArrayList<lichsubean>();
		lichsudao lsdao = new lichsudao();
		dsls = lsdao.getLichSu(20);
//		System.out.println(dsls.size());
		for (lichsubean lichsubean : dsls) {
			System.out.println(lichsubean.getTensach());
		}
	}
}
