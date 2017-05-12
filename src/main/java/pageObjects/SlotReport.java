package pageObjects;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SlotReport {
   WebDriver dr;
   String r="SlotReport";
   Utility u= new Utility();
   
   @FindBy(id="ContentPlaceHolder1_ddlSession")WebElement session;
   @FindBy(id="ContentPlaceHolder1_ddlclass")WebElement cls;
   @FindBy(id="ContentPlaceHolder1_ddlslot")WebElement slot;
   @FindBy(name="ctl00$ContentPlaceHolder1$btnShow$ctl00")WebElement show;
   
   public SlotReport(WebDriver d)
   {
	  this.dr=d;
	  PageFactory.initElements(d, this);
   }
   public void openSlotReport()
   {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
  	  Actions builder= new Actions(dr);
  	  builder.moveToElement(menu).build().perform();
  	  dr.findElement(By.linkText("Slot Report")).click();
  	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/SlotReport.aspx']")));
   }
   public void selectSession(String sess)
   {
	   new Select(session).selectByVisibleText(sess);
   }
   public void selectClass(String c)
   {
	   new Select(cls).selectByVisibleText(c);
   }
   public void selectSlot(String s)
   {
	   new Select(slot).selectByVisibleText(s);
   }
   public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
   {
 		show.click();
 		Thread.sleep(5000);
 		u.captureScreenshot(dr, str, r,sc);
   }
}
