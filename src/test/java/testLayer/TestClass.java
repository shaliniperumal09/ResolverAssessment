package testLayer;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import pomclass.HomePOM;

public class TestClass extends BaseClass {
	
	HomePOM home;
	
	public TestClass() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		Initiation();
		home=new HomePOM();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test
	public void ValidLoginTest()
	{

		boolean validemail=home.InputEmail();

		Assert.assertEquals(true, validemail);

		boolean validpass=home.password();

		Assert.assertEquals(true, validpass);

		boolean buttonvisible=home.signIn();
		Assert.assertEquals(true, buttonvisible);
		home.signinfunction("Shalini@gmail.com","Evolve@2");

	}

	@Test
	public void ItemListTest()
	{
		//List<WebElement> itemList=driver.findElements(By.xpath("//ul[@class='list-group']/li"));
		int count=home.itemListcount();
		Assert.assertEquals(count, 3);

		List<WebElement> itemList=home.itemname();
		WebElement mylist=itemList.get(1);
		String fullText = mylist.getText();
		List<WebElement> childElements = mylist.findElements(By.xpath("./*"));  // Selects all immediate child elements
		String badge=childElements.get(0).getText();
		// Remove each child element's text from the full text
		for (WebElement child : childElements) {
			String childText = child.getText();
			System.out.println(childText);
			if (childText != null && !childText.isEmpty()) {
				fullText = fullText.replace(childText, "").trim();

			}
		}
		
		Assert.assertEquals(fullText, "List Item 2");
		Assert.assertEquals(badge, "6");


	}
	@Test
	public void DropdownTest()
	{
		String buttontxt=home.getdropdownlist();
		Assert.assertEquals("Option 1", buttontxt);
		List<WebElement> l1=home.getdropdowndetails();

		for(WebElement x :l1)
		{
			System.out.print(x.getText());

			if(x.getText().equals("Option 3"))

			{
				x.click();

			}

		}

	}
	
	@Test
	public void ButtonTest()
	{

	
		boolean btn1=home.checkbtn1();
		System.out.print(btn1);
		Assert.assertEquals(btn1, true);

		boolean btn2=home.checkbtn2();
		System.out.print(btn2);
		Assert.assertEquals(btn2, false);

	}
	@Test
	public void AlertTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("test5-button")));
		Assert.assertEquals(true,home.checkbtnfunction());
		
		home.alertfunction();
		String message=home.alertmsg();
		Assert.assertEquals("You clicked a button!", message);

	}



		//test 6
	@Test
	public void TableTest()
	{
		int rows=driver.findElements(By.xpath("//*[@id=\"test-6-div\"]/div/table//tr")).size();
		int col=driver.findElements(By.xpath("//*[@id=\"test-6-div\"]/div/table//th")).size();
		String tbdata=null;

		for(int i=1;i<rows;i++)
		{
			for(int j=1;j<=col;j++)
			{
				tbdata=driver.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(tbdata);
				if(i==2 && j==2)
				{
				System.out.print(tbdata);
				}
				
				if(i==3&&j==3)
				{
					
					Assert.assertEquals(tbdata, "Ventosanzap");
				}

			}


		}
	}
}

