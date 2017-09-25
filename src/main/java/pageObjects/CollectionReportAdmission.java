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

public class CollectionReportAdmission {
   WebDriver dr;
   String r="CollectionReportAdmission_";
   Utility u= new Utility();
   
   @FindBy(id="ContentPlaceHolder1_rdoprorpt")WebElement prospectuswise;
   @FindBy(id="ContentPlaceHolder1_rdoadmfrmrpt")WebElement admissionformwise;
   @FindBy(id="ContentPlaceHolder1_rdoadmentrpt")WebElement admissionentrywise;
   @FindBy(id="ContentPlaceHolder1_rdoreslotrpt")WebElement reslotwise;
   @FindBy(id="ContentPlaceHolder1_txtfromDate_TextBox")WebElement fromdate;
   @FindBy(id="ContentPlaceHolder1_txttoDate_TextBox")WebElement todate;
   @FindBy(id="ContentPlaceHolder1_ddlclass")WebElement cls;
   @FindBy(id="ContentPlaceHolder1_ddlSession")WebElement session;
   @FindBy(id="ContentPlaceHolder1_ddlboard")WebElement board;
   @FindBy(id="ContentPlaceHolder1_ddlpaymode")WebElement paymode;
   @FindBy(id="ContentPlaceHolder1_ddlmodepro")WebElement entrymode;
   @FindBy(id="ContentPlaceHolder1_ddlorderby")WebElement orderby;
   @FindBy(id="ContentPlaceHolder1_ddlgroupby")WebElement groupby;
   @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
	
   public CollectionReportAdmission(WebDriver d)
   {
 	  this.dr=d;
 	  PageFactory.initElements(d, this);
   }
   public void openCollectionReportAdmission()
   {
 	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
 	  Actions builder= new Actions(dr);
 	  builder.moveToElement(menu).build().perform();
 	  dr.findElement(By.linkText("Collection Report Admission")).click();
 	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/AdmColletionReportAllForm.aspx']")));
   }
   public void clickProspectusWise()
   {
	   prospectuswise.click();
   }
   public void clickAdmissionFormWise()
   {
	   admissionformwise.click();
   }
   public void clickAdmissionEntryWise()
   {
	   admissionentrywise.click();
   }
   public void clickReslotWise()
   {
	   reslotwise.click();
   }
   public void selectFromDate(String mm, String yy, String dd) throws InterruptedException {
       u.selectDate(dr, fromdate, mm, yy, dd);
   }
    public void selectToDate(String mm, String yy, String dd) throws InterruptedException {
        u.selectDate(dr, todate, mm, yy, dd);
   }
   public void selectClass(String c) throws InterruptedException
   {
	   new Select(cls).selectByVisibleText(c);
	   Thread.sleep(1000);
   }
   public void selectSession(String sess) throws InterruptedException
   {
	   new Select(session).selectByVisibleText(sess);
	   Thread.sleep(1000);
   }
   public void selectBoard(String brd)
   {
	   new Select(board).selectByVisibleText(brd);
   }
   public void selectPayMode(String pmode)
   {
	   new Select(paymode).selectByVisibleText(pmode);
   }
   public void selectEntryMode(String emode)
   {
	   new Select(entrymode).selectByVisibleText(emode);
   }
   public void selectOrderBy(String or)
   {
	   new Select(orderby).selectByVisibleText(or);
   }
   public void selectGroupBy(String gp)
   {
	   new Select(groupby).selectByVisibleText(gp);
   }
   public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
   {
		show.click();
        u.verifyShow(dr, str, r, sc);
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
   }
}
