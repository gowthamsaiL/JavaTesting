package practice;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class abcdefg {

	static WebDriver driver = null ;
	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the broswer");
		String strbroswer =sc .next();
		sc.close();
		
		lanchapplication(strbroswer,"https://facebook.com/");
		
		WebElement elem = driver.findElement(By.id("email"));
		
		elem.sendKeys("7993576319");
		
		WebElement elem1 =driver.findElement(By.id("pass"));
		
		elem1.sendKeys("gs23k11d");
		
		WebElement elem2 =driver.findElement(By.name("login"));
		elem2.click();
		
		System.out.println("Completed Sucessfully");
		
		}

	public static void lanchapplication(String strbroswer,String url) {
		
		switch(strbroswer){
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();		
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		
		driver.get(url);
	}
	
}
