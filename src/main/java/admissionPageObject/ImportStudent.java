package admissionPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class ImportStudent {
  WebDriver dr;
  String pg="ImportStudent";
  Utility u= new Utility();
												  
  public ImportStudent(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openImportStudent()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Import Student")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/Importexceltostudent.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
	  verifyUploadDataOption();
  }	 
  public void verifyUploadDataOption()
  {
	  List<WebElement>uploadoption= dr.findElements(By.name("ctl00$ContentPlaceHolder1$tblVisibleOpt"));
	  boolean flag= true;
	  int i=0;
	  for(WebElement uoption:uploadoption)
	  {
		  if(uploadoption.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Upload Data Option is selected");
	  else
		  System.out.println("Upload Data Option is not selected");
  }
}
