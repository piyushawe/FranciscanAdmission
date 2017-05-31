package masterSettingsPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class StudentImageDownload {
  WebDriver dr;
  String pg="StudentImageDownload";
  Utility u= new Utility();
				  
  public StudentImageDownload(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openStudentImageDownload()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Student Image Download")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/SchoolCommonDetails/DownloadStudentImage.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
	  verifySearchDetails();
  }	  
  public void verifySearchDetails()
  {
	  List<WebElement>searchdetails= dr.findElements(By.name("ctl00$ContentPlaceHolder1$search1"));
	  boolean flag= true;
	  int i=0;
	  for(WebElement sdetails:searchdetails)
	  {
		  if(searchdetails.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Search Detail is selected");
	  else
		  System.out.println("Search Detail is not selected");
  }
}
