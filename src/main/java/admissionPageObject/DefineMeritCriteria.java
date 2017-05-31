package admissionPageObject;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class DefineMeritCriteria {
  WebDriver dr;
  String pg="DefineMeritCriteria";
  Utility u= new Utility();
											  
  public DefineMeritCriteria(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openDefineMeritCriteria()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Define Merit Criteria")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/MeritCriteriaMst.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }	 
}
