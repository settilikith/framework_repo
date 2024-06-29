package annotations;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.combast.crm.objectrepository.CreateNewOrganization;
import com.combast.crm.objectrepository.Homepage;
import com.combast.crm.objectrepository.OrgInfor;
import com.combast.crm.objectrepository.OrganizationInfo;
import com.crm.generic.baseutility.Baseclass;

public class CreateOrganization extends Baseclass {
	@Test
	public  void  createOrgtest()throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String orgname=ej.readdatafromexcel("Sheet1", 1, 2)+j.getRandomNumber();
	    
		Homepage hp =new Homepage(driver);
		hp.getOrglink().click();
		
		OrganizationInfo ob =new OrganizationInfo(driver);
		ob.getCreatenewOrganization().click();
		
		CreateNewOrganization cn =new CreateNewOrganization(driver);
		cn.getOrgnameed().sendKeys(orgname);
		cn.getSavebutt().click();

	    //verify Header msg Expected result
	    String header =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(header.equals(orgname))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }		
	    //Verify Header orgName info Expected Result
	    String actorgname =driver.findElement(By.id("dtlview_Organization Name")).getText();
	    if(actorgname.equals(orgname))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }		

	}
	@Test
	public void CreateOrgWithphoneno() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String orgname =ej.readdatafromexcel("Sheet1", 7, 2)+j.getRandomNumber();
		String pho =ej.readdatafromexcel("Sheet1", 7, 3);
		
		Homepage h =new Homepage(driver);
		h.getOrglink().click();
		
		OrganizationInfo op =new OrganizationInfo(driver);
		op.getCreatenewOrganization().click();
		
		CreateNewOrganization cu =new CreateNewOrganization(driver);
		cu.getOrgnameed().sendKeys(orgname);
		cu.getPhoneed().sendKeys(pho);
		cu.getSavebutt().click();;
		 String ph =driver.findElement(By.id("dtlview_Phone")).getText();
		    if(ph.contains(pho))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("fail");
		    }
		    

	}
	@Test
	public void createcontactwithindustry() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String orgname =ej.readdatafromexcel("Sheet1", 4, 2)+j.getRandomNumber();
		String industry=ej.readdatafromexcel("Sheet1", 4, 3);
		Homepage h =new Homepage(driver);
		h.getOrglink().click();
		
		OrganizationInfo op =new OrganizationInfo(driver);
		op.getCreatenewOrganization().click();
		
		CreateNewOrganization cp =new CreateNewOrganization(driver);
		cp.createorgna(orgname, industry);
		 String actualindutries =driver.findElement(By.id("dtlview_Industry")).getText();
		    if(actualindutries.equals(industry))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("Fail");
		    }
		    
		    String actualtype =driver.findElement(By.id("dtlview_Organization Name")).getText();
		    if(actualtype.equals(orgname))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("fail");
		    }
	}

}
