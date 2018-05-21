package picc.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

import com.lijian.util.FileTool;

public class ExcelKit {

	@Test
	public void testExcel() {
		List<List> list = new ArrayList<List>();
		
		for(int i=0;i<10 ;i++) {
			List<String> row  =new ArrayList<String>();
			row.add("李健");
			row.add("150010");
			row.add("蒙a362ed");
			row.add("tbdddd1111");
			row.add("baodan2222");
			row.add("110xxxxxx");
			row.add("2015-02-03");
			list.add(row);
		}
		createExcel("C:\\Users\\Administrator\\Desktop\\","writehead.xls",list , "ddd" ,true);
		
	}
	
	// 向d://test.xls中追加内容，（前提是：必须已经存在字段列头，可以没有内容）
	
	/**
	 *  
	 * @Description: TODO( 根据路径  创建 一个 xls文件 不支持  xlsx)  
	 * @author 李健   
	 * @version V1.0   
	 * @param filePath 文件物理路径 (c:\\user\\)
	 * @param fileName 文件名称 (1.xlx)
	 * @param data  数据内容( [[1,2,3],[a,b,c]])
	 * @param sheetName sheet名称
	 * @param sheetState 是否刷新这个sheet (true 刷新 ,false 不刷新)
	 */
	public void createExcel(String filePath, String fileName, List<List> data, String sheetName ,boolean sheetState) {

		try {
			createFile(filePath, fileName);
			FileInputStream fs = new FileInputStream(filePath+fileName); // 获取d://test.xls
			POIFSFileSystem ps = new POIFSFileSystem(fs); // 使用POI提供的方法得到excel的信息
			HSSFWorkbook wb = new HSSFWorkbook(ps);
			HSSFSheet sheet = wb.getSheet(sheetName); // 获取到工作表，因为一个excel可能有多个工作表
			HSSFRow row;
			if(null==sheet ) {
				System.out.println(filePath+fileName+" 文件 里边的 sheet "+sheetName+" 不存在");
				sheet=wb.createSheet(sheetName);
				row = sheet.getRow(0);
				createHeader(sheet,row);
			}
			if(sheetState) {
				wb.removeSheetAt(wb.getSheetIndex(sheetName));
//				;
				sheet=wb.createSheet(sheetName);
				row = sheet.getRow(0);
				createHeader(sheet,row);
			}
			
			 row = sheet.getRow(0); // 获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			;
			System.out.println( "最后一样行号:"+sheet.getLastRowNum() );

			FileOutputStream out = new FileOutputStream(filePath+fileName); // 向d://test.xls中写数据
			
			
			for(List s:data) { 
//				System.out.println("最后一行的 行号"+sheet.getLastRowNum());
//				System.out.println("一行有多少数据"+s.size());
				
				row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 在现有行号后追加数据
				for(int i=0; i<s.size() ;i++) {
					row.createCell(i).setCellValue((String)s.get(i)); // 设置第一个（从0开始）单元格的数据
				}
			}
			
//			row.createCell(1).setCellValue(24); // 设置第二个（从0开始）单元格的数据

			out.flush();
			wb.write(out);
			out.close();
			System.out.println(row.getPhysicalNumberOfCells() + " " + row.getLastCellNum());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	private void createHeader(HSSFSheet sheet,HSSFRow row) {
		// TODO Auto-generated method stub
		row = sheet.createRow(0);
		row.createCell(0).setCellValue("姓名");
		row.createCell(1).setCellValue("手机号");
		row.createCell(2).setCellValue("车牌号");
		row.createCell(3).setCellValue("投保号");
		row.createCell(4).setCellValue("保单号");
		row.createCell(5).setCellValue("身份证");
		row.createCell(6).setCellValue("投保时间");
	}
	
	public void createFile(String filePath,String fileName){
		 try {
			 FileTool.createFile(filePath, fileName);
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        FileOutputStream fileOut = new FileOutputStream(filePath+fileName);
		        workbook.write(fileOut);
		        fileOut.close();
	    } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
