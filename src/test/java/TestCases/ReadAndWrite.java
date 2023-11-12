package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWrite {
	
	public static void main(String[] args) throws IOException {
		String excelPath = ".\\Utilities\\Data_asses.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		ArrayList<ArrayList<String>> ans = Read(fis);
		Iterator it = ans.iterator();
		while(it.hasNext()) {
			ArrayList<String> an = (ArrayList<String>) it.next();
			Iterator iter = an.iterator();
			while(iter.hasNext()) {
				 System.out.print(iter.next()+" \t");
			}
			System.out.println();
		}
		
	}
	public static ArrayList<ArrayList<String>> Read(FileInputStream fis) throws IOException {
		ArrayList<ArrayList<String>> lis = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<>();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sht =  wb.getSheetAt(0);
		int rowTot = sht.getLastRowNum();
		int colTot = sht.getRow(0).getLastCellNum();
		for(int i=0; i<=rowTot; i++) {
			XSSFRow row = sht.getRow(i);
			for(int j=0; j<colTot; j++) {
				XSSFCell cell = row.getCell(j);
//				System.out.print(cell.getCellType()+" ");
				temp.add(cell.getStringCellValue());
//				System.out.print(cell.getStringCellValue()+"\t");
			}
			lis.add(new ArrayList<>(temp));
			temp.clear();
//			System.out.println();
		}
		return lis;
		
	}
}

