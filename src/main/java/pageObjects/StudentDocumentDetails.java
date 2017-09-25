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

public class StudentDocumentDetails {
   WebDriver dr;
   String r="StudentDocumentDetails";
   Utility u= new Utility();
   
   @FindBy(id="ContentPlaceHolder1_ddlclass")WebElement cls;
   @FindBy(id="ContentPlaceHolder1_ddlsection")WebElement section;
   @FindBy(name="ctl00$ContentPlaceHolder1$btnShow$ctl00")WebElement show;
   
   public StudentDocumentDetails(WebDriver d)
   {
	   this.dr=d;
	   PageFactory.initElements(d, this);
   }
   public void openStudentDocumentDetails()
   {
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Student Document Details")).click();
	   dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/StudentDocumentDetailsRPT.aspx']")));
   }
   public void selectClass(String c)
   {
	   new Select(cls).selectByVisibleText(c);
   }
   public void selectSection(String c)
   {
	   new Select(section).selectByVisibleText(c);
   }
   public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
   {
 		show.click();
        u.verifyShow(dr, str, r, sc);
 		Thread.sleep(5000);
 		u.captureScreenshot(dr, str, r,sc);
   }

} 
