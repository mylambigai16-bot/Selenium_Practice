package downloadPDF;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PDFDownload {
	
	public static void main(String[] args) throws InterruptedException {
		String FilePath= System.getProperty("user.dir")+File.separator+"downloads";
		ChromeOptions option=new ChromeOptions();
		Map<String, Object> pref=new HashMap<>();
		pref.put("plugins.always_open_pdf_externally",true);
		pref.put("download.default_directory",FilePath);
		option.setExperimentalOption("prefs", pref);
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement link=driver.findElement(By.id("downloadButton"));
		link.click();
		
		Thread.sleep(5000);
		File downloadedFile = new File(FilePath);
	
		if(downloadedFile.exists())
			System.out.println("File downloaded!");
		else
			System.out.println("File not downloaded");
		driver.quit();
	}

}
