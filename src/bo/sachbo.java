package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	ArrayList<sachbean> ds;
	sachdao sdao = new sachdao();
	
	public ArrayList<sachbean> getSach() {
		ds = sdao.getSach();
		return ds;
	}
	
	public ArrayList<sachbean> searcMa(String maloai) {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for(sachbean s : ds) {
			if(s.getMaloai().toLowerCase().equals(maloai.toLowerCase())) {
				tam.add(s);
			}
		}
		return tam;
	}
	
	public ArrayList<sachbean> searh(String key) {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for(sachbean s : ds) {
			if(s.getMaloai().toLowerCase()
					.contains(key.toLowerCase()) ||
				s.getTensach().toLowerCase()
				.contains(key.toLowerCase()) ||
				s.getTacgia().toLowerCase()
				.contains(key.toLowerCase())
					) {
				tam.add(s);
			}
		}
		return tam;
	}

}
