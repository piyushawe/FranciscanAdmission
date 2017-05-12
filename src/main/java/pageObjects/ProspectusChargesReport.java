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

public class ProspectusChargesReport {
  WebDriver dr;
  String r="ProspectusChargesReport";
  Utility u= new Utility();
  
  @FindBy(id="ContentPlaceHolder1_ddlsession")WebElement session;
  @FindBy(id="ContentPlaceHolder1_txtDateFrom_TextBox")WebElement datefrom;
  @FindBy(id="ContentPlaceHolder1_txtDateTo_TextBox")WebElement dateto;
  @FindBy(id="ContentPlaceHolder1_ddlStanard")WebElement cls;
  @FindBy(id="ContentPlaceHolder1_ddlUser")WebElement user;
  @FindBy(id="ContentPlaceHolder1_ddlmode")WebElement mode;
  @FindBy(name="ctl00$ContentPlaceHolder1$btnShow$ctl00")WebElement show;
  
  public ProspectusChargesReport(WebDriver d)
  {
	 this.dr=d;
	 PageFactory.initElements(d, this);
  }
  public void openProspectusChargesReport()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Prospectus Charges Report")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/ProspectusChargesReport.aspx']")));
  }
  public void selectSession(String sess)
  {
	  new Select(session).selectByVisibleText(sess);
  }
  public void selectFromDate(String mm, String yy, String dd) throws InterruptedException {
      u.selectDate(dr, datefrom, mm, yy, dd);
  }
   public void selectToDate(String mm, String yy, String dd) throws InterruptedException {
       u.selectDate(dr, dateto, mm, yy, dd);
  }
  public void selectClass(String c)
  {
	  new Select(cls).selectByVisibleText(c);
  }
  public void selectUser(String usr)
  {
	  new Select(user).selectByVisibleText(usr);
  }
  public void selectMode(String md)
  {
	  new Select(mode).selectByVisibleText(md);
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
		show.click();
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
  }
}
