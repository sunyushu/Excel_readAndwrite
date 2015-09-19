package action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Om_cust_price_list;
import net.sf.json.JSONArray;
import service.Om_cust_price_listServiceI;
import service.impl.Om_cust_price_listImpl;
import utils.ExportUtils;

public class Om_cust_price_listAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Om_cust_price_listServiceI om_cust_price_listService = new Om_cust_price_listImpl();
	private int page;
	private int rows;
	private String sort;
	private String order;
	
	private String className;
	private String methodName;
	private String fields;
	private String titles;
	
	//数据列表
	public void list(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<Om_cust_price_list> om_cust_price_list = new ArrayList<Om_cust_price_list>();
		om_cust_price_list = om_cust_price_listService.list(page, rows, sort, order);
		int total = om_cust_price_listService.getTotal();
		String json = "{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(om_cust_price_list).toString()+","+
				"\"className\":\""+Om_cust_price_listImpl.class.getName()+"\","+
				"\"methodName\":\"list\""+"}";
		try {
			System.out.println(json);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 导出前台列表为Excel文件
	 */
	public void export(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment;filename=export.xls");
		//创建Excel
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		try {
			Class clazz = Class.forName(className);
			Object o = clazz.newInstance();
			Method m = clazz.getDeclaredMethod(methodName);
			List list = (List) m.invoke(o);
			titles = new String(titles.getBytes("ISO-8859-1"),"UTF-8");
			ExportUtils.outputHeaders(fields.split(","), sheet);
			ExportUtils.outputColumns(titles.split(","), list, sheet, 1);
			//获取输出流，写入Excel并关闭
			ServletOutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("titles:"+titles);
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
}