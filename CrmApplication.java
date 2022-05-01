package javatesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrmApplication {

static WebDriver driver ;
public static void main(String[] args) {
	CrmApkCreatingNewContact("chrome");
}
public static void CrmApkCreatingNewContact(String Broswer) {
	LanchApplication(Broswer,"https://freecrm.com/");
	ClickOnLogin();
	Login("gowthamdhanush70773@gmail.com","Gs23k11d");
	clickOncontact();
	createNewContact();
	CreateContactInfo();
	SaveButton();
	Sleep(5000);
	LogOut();
	Sleep(5000);
	driver.quit();
}
public static void LogOut() {
	driver.findElement(By.xpath("//div[@role='listbox']")).click();
	driver.findElement(By.xpath("//span[text()='Log Out']")).click();
}
public static void ClickOnLogin() {
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	
	Sleep(20000);
}
public static void SaveButton() {
	driver.findElement(By.xpath("//div[@class='item']/button[2]")).click();
}
public static void SelectCountryInDropdown() {
	driver.findElement(By.xpath("//div[@name='country'and@role='combobox']")).click();
	List<WebElement> allOpsitions = driver.findElements(By.xpath("//div[@name='country'and@role='combobox']/div[2]/div[@role='option']/span"));
	for(WebElement opt : allOpsitions) {
		String opsition = opt.getText();
		if(opsition.equalsIgnoreCase("india")) {
			opt.click();
		}
	}
	
	
}
public static void clickOncontact() {
	driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/div[3]/a/span[1]")).click();
}
public static void createNewContact() {
		
	driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")).click();
	Sleep(10000);
	
	}


public static void  ClickAndSelectDropDown() {
	driver.findElement(By.xpath("//div[@name='category'and@role='listbox']")).click();
	 
}
public static void AccessPublicOrPrivateButton(String button) {
	
	try {
		driver.findElement(By.xpath("//button[@class='ui small fluid "+button+" toggle button']")).click();
	}catch(org.openqa.selenium.NoSuchElementException e) {

		System.out.println("This Is Already in public");
		
	}
}

public static void EnterAddress() {
	driver.findElement(By.xpath("//input[@name='address'and@placeholder='Street Address']")).sendKeys("Mudigubba, TeachersColony");
	driver.findElement(By.xpath("//input[@name='city'and@placeholder='City']")).sendKeys("Ananthapur");
	driver.findElement(By.xpath("//input[@name='state'and@placeholder='State / County']")).sendKeys("AndhraPradesh");
	driver.findElement(By.xpath("//input[@name='zip'and@placeholder='Post Code']")).sendKeys("515511");
	
}



public static void CreateContactInfo() {
	driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("user");
	driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("one");
	AccessPublicOrPrivateButton("negative");
	EnterAddress();
	SelectCountryInDropdown();
	
}


public static void Login(String Email , String Password)   {
	
	
	WebElement elem =driver.findElement(By.xpath("//input[@name='email'and@placeholder='E-mail address']"));
	elem.sendKeys(Email);
	
	WebElement elem1 = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]"));
	elem1.sendKeys(Password);

	Sleep(5000);
	 driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")).click();
	Sleep(10000);
	
	
}
public static void Sleep(int sec) {
	
	try {
		Thread.sleep(sec);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void LanchApplication(String Broswer,String url ) {

	
	switch(Broswer) {
	
	
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
	case "Edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
	case "Firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
			
	}
	driver.manage().window().maximize();
	driver.get(url);
	
	
}

}
