package dao;

import java.util.ArrayList;

import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getSach() {
		ArrayList<sachbean> list = new ArrayList<sachbean>();
		list.add(new sachbean("s1", "Trải nghiệm và khác vọng cuộc sống", "Anne Morrow Lindbergh", 1, 10,"b1.jpg", "kt"));
		list.add(new sachbean("s2", "Bí mật của may mắn", "Minh Nhat", 2, 20,"b2.jpg", "bc"));
		list.add(new sachbean("s3", "Cơ sở dữ liệu", "Tran Nguyen Phong", 2, 10,"b3.jpg", "tin"));
		list.add(new sachbean("s4", "Cấu trúc dữ liệu và thuật toán", "Hoàng Quang", 4, 20,"b4.jpg", "tin"));
		list.add(new sachbean("s5", "Java nâng cao", "Nguyễn Quang Hà", 2, 10,"b5.jpg", "tin"));
		list.add(new sachbean("s1", "Xác suất thống kê", "Hoàng Sơn", 2, 10,"b6.jpg", "tin"));
		return list;
	}
}
