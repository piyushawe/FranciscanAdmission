package pageObjects;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAndImportOnlineRegistration {
   WebDriver dr;
   Utility u= new Utility();
   String r= "SearchAndImportOnlineRegistration";
   
    @FindBy(id="ContentPlaceHolder1_ddlyear") WebElement session;
    @FindBy(id="ContentPlaceHolder1_ddlclass") WebElement cls;
    @FindBy(id="ContentPlaceHolder1_txtfromDate_TextBox") WebElement fromdate;
    @FindBy(id="ContentPlaceHolder1_txttoDate_TextBox") WebElement todate;
    @FindBy(name="ctl00$ContentPlaceHolder1$btnshow$ctl00") WebElement show;
    @FindBy(name="ctl00$ContentPlaceHolder1$btnimportdata$ctl00") WebElement importdata;
    @FindBy(name="ctl00$ContentPlaceHolder1$btnupdateData$ctl00") WebElement updatedatatoerp;
    
    public SearchAndImportOnlineRegistration(WebDriver d)
    {
    	this.dr=d;
    	PageFactory.initElements(d, this);
    }
    public void openSearchAndImportOnlineRegistration()
    {
    	WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
    	Actions builder= new Actions(dr);
    	builder.moveToElement(menu).build().perform();
    	dr.findElement(By.linkText("Search and import online Registration")).click();
    	dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/Search and import online Registration.aspx']")));
    }
    public void selectSession(String sess)
    {
    	new Select(session).selectByVisibleText(sess);
    }
    public void selectClass(String c)
    {
    	new Select(cls).selectByVisibleText(c);
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
  		Thread.sleep(5000);
  		u.captureScreenshot(dr, str, r,sc);
    }
    public void clickImportData(String str, Collection<String>sc) throws IOException, InterruptedException
    {
    	importdata.click();
    	Thread.sleep(5000);
  		u.captureScreenshot(dr, str, r,sc);
    }
    public void clickUpdateDataToERP(String str, Collection<String>sc) throws IOException, InterruptedException
    {
    	updatedatatoerp.click();
        u.verifyShow(dr, str, r, sc);
    	Thread.sleep(5000);
  		u.captureScreenshot(dr, str, r,sc);
    }
}
