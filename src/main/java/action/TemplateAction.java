package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Customer;
import model.Om_cust_price_list;
import model.Template;
import net.sf.json.JSONArray;
import service.Om_cust_price_listServiceI;
import service.impl.Om_cust_price_listImpl;

public class TemplateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Om_cust_price_listServiceI om_cust_price_listService = new Om_cust_price_listImpl();
	private int page;//第几页
	private int rows;//对应每页的记录
	private String sort;//标题排序
	private String order;
	
	public void list(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<Om_cust_price_list> om_cust_price_list= new ArrayList<Om_cust_price_list>();
		om_cust_price_list = om_cust_price_listService.list(page, rows, sort, order);
		String json = "{\"total\":"+om_cust_price_list.size()+",\"rows\":"+JSONArray.fromObject(om_cust_price_list).toString()+"}";
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void templates(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<Template> list = new ArrayList<Template>();
		Template t = new Template();
		t.setTemplate_id("customer");
		t.setTemplate_name("customer");
		list.add(t);
		try {
			response.getWriter().write(JSONArray.fromObject(list).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}