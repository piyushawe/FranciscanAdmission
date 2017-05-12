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

public class SiblingReport {
  WebDriver dr;
  String r="SiblingReport";
  Utility u= new Utility();
  
  @FindBy(id="ContentPlaceHolder1_ddlSession")WebElement session;
  @FindBy(id="ContentPlaceHolder1_ddlShowDetailsFor")WebElement showdetailsfor;
  @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
  
  public SiblingReport(WebDriver d)
  {
	  this.dr=d;
 	  PageFactory.initElements(d, this);
  }
  public void openSiblingReport()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
 	  Actions builder= new Actions(dr);
 	  builder.moveToElement(menu).build().perform();
 	  dr.findElement(By.linkText("Sibling Report")).click();
 	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/RptSibling.aspx']")));
  }
  public void selectSession(String sess) throws InterruptedException
  {
	   new Select(session).selectByVisibleText(sess);
	   Thread.sleep(1000);
  }
  public void selectSchool(String sch)
  {
	  dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[2]/div/button")).click();
	  //dr.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a")).click();
	  if(sch.equals("All"))
		  dr.findElement(By.xpath("/html/body/div[2]/div/ul/li[1]/a")).click();
	  else
	  {
		  WebElement w= dr.findElement(By.xpath("/html/body/div[2]/ul"));
		  List<WebElement>options= w.findElements(By.tagName("span"));
		  for(WebElement option:options)
		  {
			  if(option.getText().equals(sch))
			    option.click();
		  } 
	  }
	 // dr.findElement(By.xpath("/html/body/div[2]/div/ul/li[3]/a")).click();
  }
  public void selectClass(String c)
  {
	  dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[3]/div/button")).click();
	  //dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	  if(c.equals("All"))
		  dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[1]/a")).click();
	  else
	  {
		  WebElement w= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		  List<WebElement>options= w.findElements(By.tagName("span"));
		  for(WebElement option:options)
		  {
			  if(option.getText().equals(c))
			     option.click();
		  } 
	  }dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
  }
  public void selectShowDetailsFor(String sdetail)
  {
	   new Select(showdetailsfor).selectByVisibleText(sdetail);
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
		show.click();
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
  }
}
