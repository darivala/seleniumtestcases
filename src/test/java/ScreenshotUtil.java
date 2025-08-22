package tests;

import java.nio.file.StandardCopyOption;

import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;

public class ScreenshotUtil {

	public static void takeScreenshot(WebDriver driver,String filename) {
		try {
		
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("target/screenshots/"+filename+".png");
			dest.getParentFile().mkdirs();//make sure directory exists
			Files.copy(src.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot saved at "+dest.getAbsolutePath());
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
