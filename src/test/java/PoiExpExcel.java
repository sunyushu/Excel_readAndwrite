import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class PoiExpExcel {

	/**
	 * 写入数据到Excel
	 */
	@Test
	public void testWrite(){
		String title[] = {"id","effective_date_from","effective_date_to","user_def1","user_def2","user_def3","user_def4","user_def5","user_def6","user_def7","user_def8","user_def9","user_def10","user_def11","user_def12","user_def13","user_def14","user_def15","user_def16","user_def17","user_def18","user_def19","user_def20","user_def21","user_def22","user_def23","user_def24","user_def25","user_def26","user_def27","user_def28","user_def29","user_def30"};
		//创建Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		//插入第一行数据custome_id,first_name,last_name
		for(int i=0; i<title.length; i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i=1; i<=10; i++){
			HSSFRow nextrow = sheet.createRow(i);
			HSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue(String.valueOf(i));
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("fwj"+i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("李启华"+i);
		}
		//创建一个文件
		File file = new File("template/poi_test.xls");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取Excel里面的数据
	 */
	@Test
	public void testRead(){
		//需要解析的Excel文件
		File file = new File("poi_test.xls");
		try {
			//创建Excel，读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//第一个工作表workbook.getSheet("Sheet0");
//			HSSFSheet sheet = workbook.getSheet("Sheet0");
			//读取默认第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i=0; i<lastRowNum; i++){
				HSSFRow row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for(int j=0; j<lastCellNum; j++){
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}