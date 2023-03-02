package day28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Selenium.xlsx"));
		String un = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		System.out.println(un);
		String pwd = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		System.out.println(pwd);
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Enter"));
		
		String title = driver.getTitle();
		System.out.println(title);
		wb.getSheet("login").getRow(1).createCell(2).setCellValue(title);
		wb.write(new FileOutputStream("./data/Selenium.xlsx")); // --> to SAVE the excel
		

	}

}
