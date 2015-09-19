package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.struts2.ServletActionContext;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	private String template_id;
	private String template_name;

	public String execute() throws Exception{
		//
		return "success";
	}

	//获取下载流信息
	public InputStream getInputStream() throws IOException{
		//生成导入模板文件
		createTemplate();
		String path = ServletActionContext.getServletContext().getRealPath("/template");
		String filepath = path+"\\"+template_name+".xls";
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
	}

	//获取下载文件名
	public String getDownloadFileName(){
		String downloadFileName = "";
		String filename = template_name+".xls";
		try {
			//解决中文问题
			downloadFileName = URLEncoder.encode(filename,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadFileName;
	}
	private void createTemplate() {
		//获取解析xml文件路径
		String path = ServletActionContext.getServletContext().getRealPath("/template");
		File file = new File(path,template_id+".xml");
		SAXBuilder builder = new SAXBuilder();
		try {
			//解析xml文件
			Document parse = builder.build(file);
			//创建Excel
			HSSFWorkbook workbook = new HSSFWorkbook();
			//创建sheet
			HSSFSheet sheet = workbook.createSheet();
			//获取xml文件根节点
			Element root = parse.getRootElement();
			//获取模版名称
			template_name = root.getAttributeValue("name");
			//设置列宽
			Element colgroup = root.getChild("colgroup");
			setColumnWidth(sheet,colgroup);
			//表格的行号和列号
			int rownum = 0;
			//设置标题
			Element title = root.getChild("title");
			List<Element> trs = title.getChildren("tr");
//					setSheetTitle(workbook,sheet,trs,rownum);
			//行元素
			for(int i=0; i<trs.size(); i++){
				Element tr = trs.get(i);
				List<Element> tds = tr.getChildren("td");
				HSSFRow row = sheet.createRow(rownum);
				//设置单元格样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				//列元素
				for(int column=0; column<tds.size(); column++){
					Element td = tds.get(column);
					HSSFCell cell = row.createCell(column);
					Attribute rowspan = td.getAttribute("rowspan");
					Attribute colspan = td.getAttribute("colspan");
					Attribute value = td.getAttribute("value");
					if(value != null){
						String val = value.getValue();
						cell.setCellValue(val);
						//获取sheet的行数和列数
						int rspan = rowspan.getIntValue()-1;
						int cspan = colspan.getIntValue()-1;
						//设置单元格字体
						HSSFFont font = workbook.createFont();
						font.setFontName("微软雅黑");
						font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//								font.setFontHeight((short)12);
						font.setFontHeightInPoints((short)12);
						cellStyle.setFont(font);
						cell.setCellStyle(cellStyle);
						//合并单元格
						sheet.addMergedRegion(new CellRangeAddress(rspan,rspan,0,cspan));
					}
				}
				rownum++;
			}
			//设置表头
			Element thead = root.getChild("thead");
			trs = thead.getChildren("tr");
//					setSheetThead(sheet,trs,rownum);
			//行元素
			for(int i=0; i<trs.size(); i++){
				Element tr = trs.get(i);
				HSSFRow row = sheet.createRow(rownum);
				List<Element> ths = tr.getChildren("th");
				//列元素
				for(int column=0; column<ths.size(); column++){
					Element th = ths.get(column);
					Attribute valueAttr = th.getAttribute("value");
					HSSFCell cell = row.createCell(column);
					if(valueAttr != null){
						String value = valueAttr.getValue();
						cell.setCellValue(value);
					}
				}
				rownum++;
			}
			//设置数据区域样式
			Element tbody = root.getChild("tbody");
			//trs = tbody.getChildren("tr");
			Element tr = tbody.getChild("tr");
			int repeat = tr.getAttribute("repeat").getIntValue();
			List<Element> tds = tr.getChildren("td");
			for(int i=0; i<repeat; i++){
				HSSFRow row = sheet.createRow(rownum);
				for(int column=0; column<tds.size(); column++){
					Element td = tds.get(column);
					HSSFCell cell = row.createCell(column);
					//设置单元格样式
					setType(workbook,cell,td);
				}
				rownum++;
			}
			//生成Excel导入模版
			File tempFile = new File(path,template_name+".xls");
			tempFile.delete();
			tempFile.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(tempFile);
			workbook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置单元格样式
	 * @param workbook
	 * @param cell
	 * @param td
	 */
	private void setType(HSSFWorkbook workbook, HSSFCell cell, Element td) {
		Attribute typeAttr = td.getAttribute("type");
		String type = typeAttr.getValue();
		HSSFDataFormat format = workbook.createDataFormat();
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		if("NUMBERIC".equalsIgnoreCase(type)){
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			Attribute formatAttr = td.getAttribute("format");
			String formatValue = formatAttr.getValue();
			formatValue = StringUtils.isNoneBlank(formatValue)?formatValue:"#,##0.00";
			cellStyle.setDataFormat(format.getFormat(formatValue));
		}else if("STRING".equalsIgnoreCase(type)){
			cell.setCellValue("");
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cellStyle.setDataFormat(format.getFormat("@"));
		}else if("DATE".equalsIgnoreCase(type)){
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellStyle.setDataFormat(format.getFormat("yyyy-m-d"));
		}else if("ENUM".equalsIgnoreCase(type)){
			CellRangeAddressList regions = 
					new CellRangeAddressList(cell.getRowIndex(),cell.getRowIndex(),cell.getColumnIndex(),cell.getColumnIndex());
			Attribute enumAttr = td.getAttribute("format");
			String enumValue = enumAttr.getValue();
			//加载下拉列表内容
			DVConstraint constraint =
					DVConstraint.createExplicitListConstraint(enumValue.split(","));
			//数据有效性对象
			HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
			workbook.getSheetAt(0).addValidationData(dataValidation);
		}
		cell.setCellStyle(cellStyle);
	}
	/**
	 * 设置列宽
	 * @param sheet
	 * @param colgroup
	 */
	private void setColumnWidth(HSSFSheet sheet, Element colgroup) {
		List<Element> cols = colgroup.getChildren("col");
		for(int i=0; i<cols.size(); i++){
			Element col = cols.get(i);
			Attribute width = col.getAttribute("width");
			String unit = width.getValue().replaceAll("[0-9,\\.]", "");
			String value = width.getValue().replaceAll(unit, "");
			int v = 0;
			if(StringUtils.isBlank(unit)||"px".endsWith(unit)){
				v = Math.round(Float.parseFloat(value)*37F);
			}else if("em".endsWith(unit)){
				v = Math.round(Float.parseFloat(value)*267.5F);
			}
			sheet.setColumnWidth(i, v);
		}
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}
}