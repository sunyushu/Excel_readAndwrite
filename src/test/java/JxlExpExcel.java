import java.io.File;
import java.io.IOException;

import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExpExcel {

	/**
	 * 写入数据到excel
	 */
	@Test
	public void testWrite(){
		String title[] = {"customer_id","first_name","last_name"};
		//创建Excel文件
		File file = new File("template/xl_test.xls");
		try{
			file.createNewFile();
			//创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			for(int i=0; i<title.length; i++){
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			for(int i=1; i<10; i++){
				label = new Label(0,i,"fwj"+1);
				sheet.addCell(label);
				label = new Label(1,i,"lqh"+1);
				sheet.addCell(label);
				label = new Label(2,i,"fwt"+1);
				sheet.addCell(label);
			}
			//写入数据
			workbook.write();
			workbook.close();
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 读取excel里面的数据
	 */
	@Test
	public void testRead(){
		try {
			//创建workbook
			Workbook workbook = Workbook.getWorkbook(new File("jxl_test.xls"));
			//获取第一个excel的sheet
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			for(int i=0; i<sheet.getRows(); i++){
				for(int j=0; j<sheet.getColumns(); j++){
					Cell cell = sheet.getCell(j,i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}