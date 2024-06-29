package annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Sample {
  @Test
  public void f() {
	  System.out.println("yu");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("launch the browser");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("close the browser");
  }

}
