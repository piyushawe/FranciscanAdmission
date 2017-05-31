package masterSettingsPageObject;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pageObjects.Utility;

public class ChangeAcademic {
  WebDriver dr;
  String pg="ChangeAcademic";
  Utility u= new Utility();
		  
  @FindBy(id="ContentPlaceHolder1_ddlYear")WebElement academicyear;
  @FindBy(id="ContentPlaceHolder1_ddlfinance")WebElement financialyear;
  @FindBy(id="ContentPlaceHolder1_ddlSchool")WebElement school;
  @FindBy(name="ctl00$ContentPlaceHolder1$btnSave$ctl00")WebElement save;
		  
  public ChangeAcademic(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openChangeAcademic()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Change Academic")).click();
 	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/SchoolCommonDetails/ChangeAcademicYear.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
	  Select ayr= new Select(academicyear);
	  Select fyr= new Select(financialyear);
	  Select sch= new Select(school);
	  System.out.println(ayr.getFirstSelectedOption().getText());
	  String acayr= ayr.getFirstSelectedOption().getText();
	  String fnyr= fyr.getFirstSelectedOption().getText();
	  String s= sch.getFirstSelectedOption().getText();
	  if(acayr.equals("Please Select")||fnyr.equals("Please Select")||s.equals("Please Select"))
		  System.out.println("No Setting has Been Done On Change Academic");
	  else
		  System.out.println("Settings Are Defined");
  }
}
