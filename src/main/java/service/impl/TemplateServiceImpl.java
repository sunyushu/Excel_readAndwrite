package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import model.Om_cust_price_list;
import service.TemplateServiceI;
import utils.ConnectionFactory;

public class TemplateServiceImpl implements TemplateServiceI {

	public List<Om_cust_price_list> list(int page, int rows, String sort, String order) {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		StringBuilder sql = new StringBuilder("SELECT id,PL_YH_ITEM,effective_date_from,effective_date_to,user_def1,user_def2,user_def3,user_def4,user_def5,user_def6,user_def7,user_def8,user_def9,user_def10,user_def11,user_def12,user_def13,user_def14,user_def15,user_def16,user_def17,user_def18,user_def19,user_def20,user_def21,user_def22,user_def23,user_def24,user_def25,user_def26,user_def27,user_def28,user_def29,user_def30 FROM Om_cust_price_list WHERE cust_name=GTW and type=STD");
		if(StringUtils.isNoneBlank(sort)){
			sql.append(" ORDER BY "+sort);
		}
		if(StringUtils.isNoneBlank(order)){
			sql.append(" "+order);
		}
		sql.append(" LIMIT "+(page-1)*rows+","+rows);
		List<Om_cust_price_list> om_cust_price_lists = new ArrayList<Om_cust_price_list>();
		Om_cust_price_list om_cust_price_list = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				om_cust_price_list = new Om_cust_price_list();
				om_cust_price_list.setId(rs.getInt("id"));
				om_cust_price_list.setEffective_date_from(rs.getDate("effective_date_from"));
				om_cust_price_list.setEffective_date_to(rs.getDate("effective_date_to"));
				om_cust_price_list.setUser_def1(rs.getString("user_def1"));
				om_cust_price_list.setUser_def2(rs.getString("user_def2"));
				om_cust_price_list.setUser_def3(rs.getString("user_def3"));
				om_cust_price_list.setUser_def4(rs.getString("user_def4"));
				om_cust_price_list.setUser_def5(rs.getString("user_def5"));
				om_cust_price_list.setUser_def6(rs.getString("user_def6"));
				om_cust_price_list.setUser_def7(rs.getString("user_def7"));
				om_cust_price_list.setUser_def8(rs.getString("user_def8"));
				om_cust_price_list.setUser_def9(rs.getString("user_def9"));
				om_cust_price_list.setUser_def10(rs.getString("user_def10"));
				om_cust_price_list.setUser_def11(rs.getString("user_def11"));
				om_cust_price_list.setUser_def12(rs.getString("user_def12"));
				om_cust_price_list.setUser_def13(rs.getString("user_def13"));
				om_cust_price_list.setUser_def14(rs.getString("user_def14"));
				om_cust_price_list.setUser_def15(rs.getString("user_def15"));
				om_cust_price_list.setUser_def16(rs.getString("user_def16"));
				om_cust_price_list.setUser_def17(rs.getString("user_def17"));
				om_cust_price_list.setUser_def18(rs.getString("user_def18"));
				om_cust_price_list.setUser_def19(rs.getString("user_def19"));
				om_cust_price_list.setUser_def20(rs.getString("user_def20"));
				om_cust_price_list.setUser_def21(rs.getString("user_def21"));
				om_cust_price_list.setUser_def22(rs.getString("user_def22"));
				om_cust_price_list.setUser_def23(rs.getString("user_def23"));
				om_cust_price_list.setUser_def24(rs.getString("user_def24"));
				om_cust_price_list.setUser_def25(rs.getString("user_def25"));
				om_cust_price_list.setUser_def26(rs.getString("user_def26"));
				om_cust_price_list.setUser_def27(rs.getString("user_def27"));
				om_cust_price_list.setUser_def28(rs.getString("user_def28"));
				om_cust_price_list.setUser_def29(rs.getString("user_def29"));
				om_cust_price_list.setUser_def30(rs.getString("user_def30"));
				om_cust_price_lists.add(om_cust_price_list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return om_cust_price_lists;
	}
}