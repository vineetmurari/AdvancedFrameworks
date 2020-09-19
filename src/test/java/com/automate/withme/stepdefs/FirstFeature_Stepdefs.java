package com.automate.withme.stepdefs;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.withme.Utils.DataBaseUtils;
import com.automate.withme.Utils.Decode;
import com.automate.withme.Utils.ExcelSheetUtils;
import com.automate.withme.Utils.Mailutils;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.cucumber.core.gherkin.Step;
import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.TableRow;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.TestStep;
import junit.framework.Assert;

public class FirstFeature_Stepdefs {
	
	public Scenario myScenario;
	
	@BeforeStep
	public void doSomethingBeforeStep(Scenario sc){
		myScenario=sc;
	}
	
	@Before("@ValidCred")
	public void brfore_sceanrio(Scenario sc){
		
		String a =sc.getName();
		Status b =sc.getStatus();
		Collection<String> c=sc.getSourceTagNames();
		
		System.out.println("Scenario Name "+a);
		System.out.println("status "+b.name());
		System.out.println("Tags "+c.toString());
	}
	@After("@InvalidTest")
	public void After_sceanrio(Scenario sc){
		
	/*	String User_emailID ="something@someone.com";// replace with your email ID
		String User_pass = "Someonespass"; // replace with your email password
		String Recievers_Email="Reciever@Reciever.com"; //replace with your receivers email  
		*/
		
		boolean f=sc.isFailed();
		if(f){
			System.out.println("FAILED SCENARIO "+sc.getName());
		}
		else{
			System.out.println("PASSED SCENARIO "+sc.getName());
		}
		
		//Mailutils.Sendmail(User_emailID, User_pass, Recievers_Email, "Automation Test Result", "test output\\Spark\\ExtentSpark.html");
	}
	
	
	
	
	WebDriver driver;
	
	@Given ("^User lauches the App$")
	public void User_lauches_the_App() throws InterruptedException{
		
		//Driver exe config
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\chromedriver.exe");
			
		//Instansiation the WebDriver Instance
		 driver = new ChromeDriver();
		
		//Demo E-commerce APP
		driver.get("http://localhost:8181/");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		myScenario.embed(screenshot, "image/png", myScenario.getName());
		myScenario.write("Success Login");
	}
	
	//  "([^"]*)"
	@When ("User gives right {string} as Username and {string} as Password")
	public void User_gives_right_credentials(String uname, String pass) throws InterruptedException{
		
		//System.out.println("User gives right credentials");
		
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
		
		
	}
	@Then ("^User should see success message$")
	public void User_should_see_success_message(){
		//System.out.println("User should see success message");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Fruits and Veggies']")));
		
		System.out.println("Login Success");
		
		driver.close();
		driver.quit();
	}
	
	@When ("User gives invalid credentials {string} as Username and {string} as Password")
	public void User_gives_invalid_credentials(String uname, String pass) throws InterruptedException{
		//System.out.println("User gives invalid credentials");
		

		//System.out.println("User gives right credentials");
		
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
	}
	
	
	@SuppressWarnings("deprecation")
	@Then ("^User should see Error message$")
	public void User_should_see_Error_smessage(){
		//System.out.println("User should see Error message");
		
		String Exp_Err_message ="Invalid username and password";
		
		String Actual_Err_message =driver.switchTo().alert().getText();
		
		Assert.assertTrue(Exp_Err_message.equals(Actual_Err_message));
		
		driver.switchTo().alert().accept();

		driver.close();
		driver.quit();
	}
	
	@When ("^User gives right Username and Password$")
	public void User_gives_right_Username_and_Password(DataTable data) throws InterruptedException{
		
		/**
		 * List<List<String>> testdata = data.raw(); OLD VERSIONS
		 * 
		 */
		
		List<String> testdata = data.asList();

		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(testdata.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(testdata.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
	}
	
	@When ("^User gives invalid credentials Username and Password$")
	public void invalid_U_P(DataTable data) throws InterruptedException{

		/**
		 * List<List<String>> testdata = data.raw(); OLD VERSIONS
		 * 
		 */
		
		List<String> testdata = data.asList();

		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(testdata.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(testdata.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
	}
	
	@When ("^Get the Credentials from Database and perform login$")
	public void GetData_fromDB_and_Login() throws InterruptedException{
		List<String> DB_Cred = null;
		DB_Cred=DataBaseUtils.Get_data();
		
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(DB_Cred.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(DB_Cred.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
		
	}
	
	@When ("User will give right {string} as Username and {string} as Password")
	public void LoginWith_EncrytedPass(String uname, String pass) throws InterruptedException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException{
		
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(Decode.decypt_data(pass));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
	}
	
	@When ("^Read data from spreadsheet and perform login$")
	public void Excel_sheet() throws InterruptedException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException{
	
		List<String> Excel_Cred = null;
		Excel_Cred=ExcelSheetUtils.Read();
		
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(Excel_Cred.get(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(Decode.decypt_data(Excel_Cred.get(3)));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
		Thread.sleep(2000);
		
	}
	
}
