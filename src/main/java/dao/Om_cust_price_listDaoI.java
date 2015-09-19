package dao;

import java.sql.SQLException;
import java.util.List;

import model.Om_cust_price_list;

public interface Om_cust_price_listDaoI {

	List<Om_cust_price_list> list(int page,int rows,String sort,String order) throws SQLException;
	int getTotal() throws SQLException;
}