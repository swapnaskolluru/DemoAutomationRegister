package stepDefinition;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Registration 
{
	WebDriver driver=null;
	
	//Enter URL
	@Given("I enter URL")
	public void EnterURL() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nswap\\Documents\\Swapna Testing\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
	}
	
	//Enter Full Name
	@When("I enter Full Name")
	public void EnterName() 
	{
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("Swapna");
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]")).sendKeys("Kolluru");   
	}
	
	//Enter Address
	@When("I enter Address")
	public void EnterAddress() 
	{
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/textarea[1]")).sendKeys("Slough"); 
	}
	
	//Enter Email address
	@When("I enter Email address")
	public void EnterEmail() 
	{
	    driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).sendKeys("s.k@gmail.com");	
	}
	
	//Enter Phone
	@When("I enter Phone number")
	public void EnterPhone() 
	{
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).sendKeys("0123456789");
	}
	
	//Select Gender
	@When("I select Gender")
	public void SelectGender() 
	{
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/label[2]/input[1]")).click();
	}
	
	//Select Hobbies
	@When("I select Hobbies")
	public void SelectHobbies() 
	{
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();	
	}
	
	//select Languages
	@When("I select Languages")
	public void SelectLanguages() 
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//form[@id='basicBootstrapForm']")).click();
	}
	
	//Select Skills
	@When("I select Skills")
	public void SelectSkills() 
	{
		Select skills=new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
		skills.selectByVisibleText("Software");
	}
	
	//Select Country
	@When("I enter Country")
	public void EnterCountry() 
	{
		driver.findElement(By.xpath("//select[@id='countries']")).click();
		driver.findElement(By.xpath("//select[@id='countries']")).click();
	}
	
	//Select "Select Country:"
	@When("I select Country")
	public void SelectCountry() 
	{	
		driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[10]/div[1]/span[1]/span[1]/span[1]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Australia')]")).click();
	}
	
	//Select Year,Month and Date
	@When("I select Date Of Birth")
	public void SelectDOB() 
	{
		Select year=new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
		year.selectByVisibleText("1985");
		
		Select month=new Select(driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]")));
		month.selectByVisibleText("May");
		
		Select day=new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
		day.selectByVisibleText("28");
	}
	
	//Enter Password
	@When("I enter Password")
	public void EnterPassword() 
	{
	    driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("Sargent-disc");
	}
	
	//Enter Confirm Password
	@When("I enter Confirm Password")
	public void ConfirmPassword() 
	{
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("Sargent-disc");
	}
	
	//Click Submit
	@Then("I click on Submit")
	public void ClickSubmit() 
	{
	    driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
	}
	
	/*
	//Verify user is registered
	@Then("I verify user is registered")
	public void UserRegistered()
	{
	    //Unable to script this verification as the user is not registered on click of Submit. Due to mandatory Country dropdowm being blank / null. 
	}
	*/
	
	//Close browsers
	@Then("I quit")
	public void Quit() 
	{
	    driver.quit();	
	}
	
	//Click Refresh
	@Then("I click on Refresh")
	public void ClickRefresh() 
	{
	    driver.findElement(By.xpath("//button[@id='Button1']")).click();
	}
	
	//Verify field after refresh
	@Then("I verify First Name is blank")
	public void VerifyFirstName() 
	{
		WebElement firstName=driver. findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
		String tooltipText = firstName.getAttribute("validationMessage");
		//System.out.println(tooltipText);
		//String expectedText = "Please fill out this field.";
		//System.out.println(expectedText);
		Assert.assertEquals("Please fill out this field.", tooltipText);
	}
	
	//Click Facebook icon
	@When("I click on Facebook link")
	public void ClickFacebookLink() 
	{
	    driver.findElement(By.xpath("//body/footer[@id='footer']/div[1]/div[1]/div[2]/a[1]/span[1]")).click();
	    List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(browserTabs.get(0));
	    driver.switchTo().window(browserTabs.get(1));
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();    
	}
	
	//Verify Facebook page
	@Then("I verify Facebook page is opened")
	public void VerifyFacebookPage() 
	{
		 Assert.assertEquals("Automation Testing | Facebook", driver.getTitle());
		 // System.out.println(driver.getTitle()); 
		 driver.close();		    
	}
}

