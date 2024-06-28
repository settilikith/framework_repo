package baseutility;

	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;

	import com.combast.crm.objectrepository.Homepage;
	import com.combast.crm.objectrepository.Login;
	import com.comcast.crm.generic.databaseutility.DatabaseUtility;
	import com.comcast.crm.generic.fileutility.ExcelUtility;
	import com.comcast.crm.generic.fileutility.FileUtility;
	import com.comcast.crm.generic.webdriverutility.JavaUtility;

	public class Exampleclass {
		public DatabaseUtility db=new DatabaseUtility();
		public FileUtility fis =new FileUtility();
		public ExcelUtility ej =new ExcelUtility();
		public JavaUtility j=new JavaUtility();
		public WebDriver driver =null;
		public static WebDriver sdriver=null;
		@BeforeSuite
		public void confibc()
		{
			System.out.println("connect to db,Report config");
			db.getDbconnection();
		}
		@BeforeClass
		public void configBc() throws IOException
		{
			System.out.println("Launch the browser");
			String Browser= fis.getDatafromProperty("browser");
			if(Browser.equals("chrome"))
			{
				driver =new ChromeDriver();
			}
				else if(Browser.equals("firefox"))
			{
				driver =new FirefoxDriver();
			}
			else if(Browser.equals("edge"))
			{
				driver =new EdgeDriver();
			}
			else
			{
				driver =new ChromeDriver();
			}
			sdriver =driver;
		}
		@BeforeMethod
		public void configBm() throws IOException
		{
			System.out.println("login");
			Login lo =new Login(driver);
			String url =fis.getDatafromProperty("url");
			String username =fis.getDatafromProperty("username");
			String password =fis.getDatafromProperty("password");
			lo.loginToapp(url,username,password);
		}
		@AfterMethod
		public void configAm()
		{
			System.out.println("logout");
			Homepage hp=new Homepage(driver);
			hp.logoutbutt();
			
		}
		@AfterClass
		public void configAc()
		{
			System.out.println("close the browser");
			driver.quit();
		}
		@AfterSuite
		public void configAs()
		{
			System.out.println("close Db,Report backup");
			db.closeDbconnection();
			
		}

	}




