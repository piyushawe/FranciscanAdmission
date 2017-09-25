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

public class MeritListReport {
 	WebDriver dr;
	String r="MeritListReport";
	Utility u= new Utility();
	
	@FindBy(id="ContentPlaceHolder1_ddlSession")WebElement session;
	@FindBy(id="ContentPlaceHolder1_ddlClass")WebElement cls;
	@FindBy(id="ContentPlaceHolder1_ddlmerit")WebElement meritlist;
	@FindBy(name="ctl00$ContentPlaceHolder1$btn_show$ctl00")WebElement show;
	
	public MeritListReport(WebDriver d)
	{
	   this.dr=d;
	   PageFactory.initElements(d, this);
	}
	public void openMeritListReport()
	{
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		Actions builder= new Actions(dr);
	    builder.moveToElement(menu).build().perform();
		dr.findElement(By.linkText("Merit List Report")).click();
		dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/MeritListReports.aspx']")));
	}
	public void selectSession(String sess)
	{
	   new Select(session).selectByVisibleText(sess);
	}
	public void selectClass(String c)
	{
	   new Select(cls).selectByVisibleText(c);
	}
	public void selectMeritList(String mlist)
	{
	   new Select(meritlist).selectByVisibleText(mlist);
	}
	public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
    {
		show.click();
		u.verifyShow(dr, str, r, sc);
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
    }
}
