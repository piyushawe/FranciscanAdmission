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

public class ClassWiseAdmisssionReport {
    WebDriver dr;
    Utility u= new Utility();
    String r= "ClassWiseAdmisssionReport";
    
     @FindBy(id="ContentPlaceHolder1_ddlsession") WebElement session;
     @FindBy(id="ContentPlaceHolder1_ddlSchool") WebElement school;
     @FindBy(id="ContentPlaceHolder1_ddlClass") WebElement cls;
     @FindBy(id="ContentPlaceHolder1_ddlstream") WebElement stream;
     @FindBy(id="ContentPlaceHolder1_ddlsubject") WebElement subject;
     @FindBy(id="ContentPlaceHolder1_txtFromDate_TextBox") WebElement fromdate;
     @FindBy(id="ContentPlaceHolder1_txtToDate_TextBox") WebElement todate;
     @FindBy(name="ctl00$ContentPlaceHolder1$btn_show$ctl00") WebElement show;
	
     public ClassWiseAdmisssionReport(WebDriver d)
     {
    	 this.dr=d;
         PageFactory.initElements(d, this);			 
     }
     public void openClassWiseAdmisssionReport()
     {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
    	 Actions builder= new Actions(dr);
    	 builder.moveToElement(menu).build().perform();
    	 dr.findElement(By.linkText("Class Wise Admission report")).click();
    	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/ClasswiseAdmissionReport.aspx']")));
     }
     public void selectSession(String sess)
     {
    	 new Select(session).selectByVisibleText(sess);
     }
     public void selectSchool(String sch)
     {
    	 new Select(school).selectByVisibleText(sch);
     }
     public void selectClass(String c)
     {
    	 new Select(cls).selectByVisibleText(c);
     }
     public void selectStream(String str)
     {
    	 new Select(stream).selectByVisibleText(str);
     }
     public void selectSubject(String sub)
     {
    	 new Select(subject).selectByVisibleText(sub);
     }
     public void selectFromDate(String mm, String yy, String dd) throws InterruptedException {
         u.selectDate(dr, fromdate, mm, yy, dd);
     }
      public void selectToDate(String mm, String yy, String dd) throws InterruptedException {
          u.selectDate(dr, todate, mm, yy, dd);
     }
      public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
      {
  		show.click();
        u.verifyShow(dr, str, r, sc);
  		Thread.sleep(5000);
  		u.captureScreenshot(dr, str, r,sc);
      }
}
