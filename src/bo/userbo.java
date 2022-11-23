package bo;

import java.util.ArrayList;

import bean.loaibean;
import bean.userbean;
import dao.userdao;

public class userbo {
	userdao user = new dao.userdao(); 
	ArrayList<userbean> ds;
	
	public ArrayList<userbean> getUser() {
		ds = user.getUser();
		return ds;
	}
}
