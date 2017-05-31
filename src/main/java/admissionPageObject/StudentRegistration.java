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

public class StudentRegistration {
  WebDriver dr;
  String pg="StudentRegistration";
  Utility u= new Utility();
											  
  public StudentRegistration(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openStudentRegistration()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Student Registration")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/SchoolCommonDetails/StudentsRegistration.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.name("ctl00$ContentPlaceHolder1$BtnControls2$ctl01")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
	  verifyIsNew();
	  verifyGender();
	  verifySibling();
	  verifyIsEws();
  }	 
  public void verifyGender()
  {
	  List<WebElement>gender= dr.findElements(By.name("ctl00$ContentPlaceHolder1$g"));
	  boolean flag= false;
	  int i=0;
	  for(WebElement gd:gender)
	  {
		  if(gender.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Gender is selected");
	  else
		  System.out.println("Gender is Not selected");
  }
  public void verifyIsNew()
  {
	  List<WebElement>isnew= dr.findElements(By.name("ctl00$ContentPlaceHolder1$n"));
	  boolean flag= false;
	  int i=0;
	  for(WebElement in:isnew)
	  {
		  if(isnew.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Is New is selected");
	  else
		  System.out.println("Is New is Not selected");
  }
  public void verifySibling()
  {
	  List<WebElement>sibling= dr.findElements(By.name("ctl00$ContentPlaceHolder1$s"));
	  boolean flag= false;
	  int i=0;
	  for(WebElement sb:sibling)
	  {
		  if(sibling.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Sibling is selected");
	  else
		  System.out.println("Sibling is Not selected");
  }
  public void verifyIsEws()
  {
	  List<WebElement>isews= dr.findElements(By.name("ctl00$ContentPlaceHolder1$e"));
	  boolean flag= false;
	  int i=0;
	  for(WebElement ie:isews)
	  {
		  if(isews.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Is EWS is selected");
	  else
		  System.out.println("Is EWS is Not selected");
  }
}
