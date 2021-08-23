package paczka;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAndQuiz {

	public static void main(String[] args) {


System.out.println("Start!");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wojta\\OneDrive\\Pulpit\\SeleniumWebDriverForChrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 1. Otwórz stronê https://www.testandquiz.com/
		System.out.println("STEP 1");
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

		String url = "https://www.testandquiz.com/";
		
		driver.manage().window().setPosition(new Point (2000, 10)); 
		driver.manage().window().maximize();
		driver.get(url);
		
		String title = driver.getTitle();
		
		if (title.equals("Quiz Show | Test And Quiz")) {
			System.out.println("Title is correctly set to: '" + title + "'");
		} else {
			System.err.format("Title is set to '%s', instead of 'Quiz Show | Test And Quiz'\n", title);
		}


		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 2. Kliknij w link 'Login'
		System.out.println("STEP 2");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
		WebElement logIn = driver.findElement(By.linkText("Login"));	
		
		logIn.click();

		title = driver.getTitle();
		
		if (title.equals("Test And Quiz | User-Login-Form")) {
			System.out.println("Title is correctly set to: " + title + "'");
		} else {
			System.err.format("Title is set to '%s', instead of 'Test And Quiz | User-Login-Form'\n", title);
		}
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 3. Wpisz dane do logowania (email, password)
		System.out.println("STEP 3");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		
		
		WebElement email;
		
		email = driver.findElement(By.id("email"));	
		if (email != null) {					
			System.out.println("Field email is displayed");
		} else {
			System.err.format("Field email is not displayed\n");
		}

		email.sendKeys("wojtek1994@gmail.com");		
		
		String tmpStr = "";		
		
		tmpStr = email.getAttribute("value");		
		if (tmpStr.equals("wojtek1994@gmail.com")) {	
			System.out.println("Email is correctly set to: '" + tmpStr + "'");
		} else {
			System.err.format("Email is set to '%s', instead of 'wojtek1994@gmail.com'\n", tmpStr);
		
		}
		
		WebElement password;
	
		password = driver.findElement(By.id("password"));	
		if (password != null) {							
			System.out.println("Field password is displayed");
		} else {
			System.err.format("Field password is not displayed\n");			
		}
		
		password.sendKeys("123456789");		
		
		tmpStr = password.getAttribute("value");		
		if (tmpStr.equals("123456789")) {	
			System.out.println("Password is correctly set to: '" + tmpStr + "'");
		} else {
			System.err.format("Password is set to '%s', instead of '123456789'\n", tmpStr);	
		}
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 4. Kliknij w przycisk 'Log in'
		System.out.println("STEP 4");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		
		
		WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		
		if (buttonLogin != null) {
			System.out.println("Button Log In is displayed");
		} else {
			System.err.format("Button Log In is nod displayed\n");
		}
		
		tmpStr = buttonLogin.getText();
		if (tmpStr.equals("Log In")) {
			System.out.println("Button text is correctly set to: '" + tmpStr + "'");
		} else {
			System.err.format("Button text is set to '%s', instead of 'Log In'\n", tmpStr);
		}
		
		buttonLogin.click();
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 5. Sprawdz komunikat
		System.out.println("STEP 5");	
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		
		
		
		WebElement errorMess = driver.findElement(By.className("error-mesg"));
		
		tmpStr = errorMess.getText();
		
		if (tmpStr.equals("Sorry ! entered email address or password is not correct")) {
			System.out.println("Error Message text is correctly set to: '" + tmpStr + "'");
		} else {
			System.err.format("Error Message text is set to '%s', instead of 'Sorry ! entered email address or password is not correct'\n", tmpStr);
		}
		driver.close();	
	}
}
