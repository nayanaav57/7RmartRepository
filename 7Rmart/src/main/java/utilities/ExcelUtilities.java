package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;

public class ExcelUtilities {

	static FileInputStream fi;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String readString(int i, int j, String sheet) throws Exception {// string sheet is given to pass the
																					// sheet name of each page

		String filepath = Constants.TESTDATAFILE;// Constants.TESTDATAFILE - static variable
		fi = new FileInputStream(filepath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		XSSFRow row = sh.getRow(i);
		XSSFCell cell = row.getCell(j);
		return cell.getStringCellValue();// give the data type that has to be returned
	}

	public static String readInteger(int i, int j, String sheet) throws Exception {
		String filepath = Constants.TESTDATAFILE;
		fi = new FileInputStream(filepath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		XSSFRow row = sh.getRow(i);
		XSSFCell cell = row.getCell(j);
		int val = (int) cell.getNumericCellValue();//// return chyunnath double value ann so (int) use chythath
		return String.valueOf(val);// give the data type that has to be returned
	}

}
