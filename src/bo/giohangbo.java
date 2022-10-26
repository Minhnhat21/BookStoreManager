package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.sachbean;

public class giohangbo {
    public ArrayList<giohangbean> ds
     		= new ArrayList<giohangbean>();
    public void Them(String masach, String tensach,String anh, long gia, long soluong) {
    	for(giohangbean h: ds)
    		if(h.getMasach().equals(masach)) {
    			h.setSoluong(h.getSoluong()+soluong);
    			return;
    		}
    	ds.add(new giohangbean(masach, tensach, anh, gia, soluong));
    }
    
    public void ChinhSuaSoLuong(String masach, long soluong) {
//    	for (giohangbean h: ds)
//    		if(h.getMasach().equals(masach)) {
//    			h.setSoluong(soluong);
//    			return;
//    		}
    	System.out.print("Plllll----------------------------------");
    	for(int i = 0; i < ds.size(); i++) {
    		if(ds.get(i).getMasach().equals(masach.trim())) {
    			ds.get(i).setSoluong(soluong);
    			return;
    		}
    	}

    }
    public long TongTien() {
    	long s=0;
    	for(giohangbean h: ds)
    		s=s+h.getThanhtien();
    	return s;
    }
    
    public ArrayList<giohangbean> timKiemMaHang(String mahang) {
    	ArrayList<giohangbean> tam = new ArrayList<giohangbean>();
    	for(giohangbean g : ds) {
    		if(g.getMasach().toLowerCase().contains(mahang.trim().toLowerCase())) {
    			tam.add(g);
    		}
    	}
    	return tam;
    }
    
    public ArrayList<giohangbean> timkiem(String key) {
    	ArrayList<giohangbean> tam = new ArrayList<giohangbean>();
    	for(giohangbean g : ds) {
    		if(g.getMasach().toLowerCase()
    			.contains(key.trim().toLowerCase()) ||
    			g.getTensach().toLowerCase()
    			.contains(key.trim().toLowerCase())) {
    			tam.add(g);
    		}
    	}
    	return tam;
    }
    // xóa
    public void Xoa1MatHang(String masach) {
    	ArrayList<giohangbean> revmoveElement = new ArrayList<giohangbean>();
    	for(giohangbean h : ds)
    		if(h.getMasach().equals(masach))
    			revmoveElement.add(h);
    	ds.removeAll(revmoveElement);
    }
    
    public void XoaTatCa() {
    	ds.clear();
    }
    
}

