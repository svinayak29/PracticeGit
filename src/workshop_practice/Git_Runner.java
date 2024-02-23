package workshop_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Git_Runner {
	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		 driver.get("https://www.youtube.com/");
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 
		 wait.until(ExpectedConditions.titleIs("YouTube"));
		 WebElement searchBar = driver.findElement(By.xpath("//input[@name='search_query']"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(searchBar).pause(3000).click(searchBar).pause(3000).perform();
		 actions.sendKeys(searchBar, "dil ibadat kr rha h").perform();
		 WebElement searchSong = driver.findElement(By.xpath("//ul[@class='sbsb_b']/..//div[@id='sbse0']"));
		 searchSong.click();
		 
		 WebElement targetEle = driver.findElement(By.xpath("//yt-formatted-string[text()='Dil Ibadat Kar Raha Hai Full Song (LYRICS) - K.K | Tum Mile | Pritam, Sayeed Quadri | Emraan Hashmi']"));
		 targetEle.click();
		 Thread.sleep(3000);
		 WebElement noThanksEle = driver.findElement(By.xpath("//span[text()='No thanks']"));
		 actions.moveToElement(noThanksEle).pause(3000).click(noThanksEle).perform();
		 Thread.sleep(2000);
		 WebElement videoPic = driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
		 File tempFile = videoPic.getScreenshotAs(OutputType.FILE);
		 File premFile = new File("./screenShot/"+ timeStamp +"youtubepic.png");
		 FileUtils.copyFile(tempFile, premFile);
			driver.manage().window().minimize();
			driver.quit();

		 
		
		 
	}
  
   
   }