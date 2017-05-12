package pageObjects;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintStudentLabel {
  WebDriver dr;
  String r= "PrintStudentLabel";
  Utility u= new Utility();
  
  @FindBy(id="ContentPlaceHolder1_ddlclass")WebElement cls;
  @FindBy(id="ContentPlaceHolder1_ddlsection")WebElement section;
  @FindBy(id="ContentPlaceHolder1_txtSearch")WebElement search;
  @FindBy(id="ContentPlaceHolder1_chkTrans")WebElement transport;
  @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
  
  public PrintStudentLabel(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this);
  }
  public void openPrintStudentLabel()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Print Student Label")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/studentlabelprinting.aspx']")));
  }
  public void selectClass(String c) throws InterruptedException
  {
	 new Select(cls).selectByVisibleText(c);
	 Thread.sleep(1000);
  }
  public void selectSection(String sec)
  {
	  new Select(section).selectByVisibleText(sec);
  }
  public void enterSearchtext(String txt) throws InterruptedException
  {
	  search.sendKeys(txt);
	  Thread.sleep(500);
	  search.sendKeys(Keys.ARROW_DOWN);
	  Thread.sleep(500);
	  search.sendKeys(Keys.ENTER);
	  Thread.sleep(500);
	  search.sendKeys(Keys.ENTER);
  }
  public void clickTransport()
  {
	  if(!transport.isSelected())  
	      transport.click();
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
		show.click();
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
  }
}
