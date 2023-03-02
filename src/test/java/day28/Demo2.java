package day28;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new File("./data/Selenium.xlsx"));
		int rc = wb.getSheet("Sheet1").getLastRowNum();

		for (int i = 0; i <= rc; i++) {
			try {
				int cc = wb.getSheet("Sheet1").getRow(i).getLastCellNum();
				for (int j = 0; j < cc; j++) {
					try {
						String data = wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
						System.out.print(data + " ");
					} catch (NullPointerException e) {
						System.out.print("-- ");
					}
				}
			} catch (NullPointerException e) {
				System.out.print("-- -- --");
			}
			System.out.println();
		}
		wb.close();
	}

}
