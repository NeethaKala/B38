package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Utility {

	public static String getProperty(String path,String key) {
		String v="";
		try 
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch (Exception e) {
			
		}
		return v;
	}
	
	public static String getXLData(String path,String sheet,int row,int col) {
		String v="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(row).getCell(col).toString();
			wb.close();
		}
		catch (Exception e)
		{
		}
		return v;
	}
	
	
	public static int getXlRowCount(String path,String sheet) {
		int row=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			row=wb.getSheet(sheet).getLastRowNum();
			wb.close();
		}
		catch (Exception e)
		{
		}
		return row;
	}
	public static int getXlColCount(String path,String sheet,int row) {
		int col=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			col=wb.getSheet(sheet).getRow(row).getLastCellNum();
			wb.close();
		}
		catch (Exception e)
		{
		}
		return col;
	}
}
