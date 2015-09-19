import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class PoiExpExcel2 {

	/**
	 * 写入数据到Excel
	 */
	@Test
	public void testWrite(){
		String title[] = {"customer_id","first_name","last_name"};
		//创建Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表sheet
		XSSFSheet sheet = workbook.createSheet();
		//创建第一行
		Row row = sheet.createRow(0);
		Cell cell = null;
		//插入第一行数据custome_id,first_name,last_name
		for(int i=0; i<title.length; i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i=1; i<=10; i++){
			Row nextrow = sheet.createRow(i);
			Cell cell2 = nextrow.createCell(0);
			cell2.setCellValue(String.valueOf(i));
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("fwj"+i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("李启华"+i);
		}
		//创建一个文件
		File file = new File("template/poi_test.sxls");
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
		File file = new File("poi_test.sxls");
		try {
			//创建Excel，读取文件内容
			XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
			//第一个工作表workbook.getSheet("Sheet0");
//			Sheet sheet = workbook.getSheet("Sheet0");
			//读取默认第一个工作表sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i=0; i<lastRowNum; i++){
				Row row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for(int j=0; j<lastCellNum; j++){
					Cell cell = row.getCell(j);
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