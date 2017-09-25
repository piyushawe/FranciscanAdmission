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

public class MeritCriteriaPrint {
  WebDriver dr;
  String r="MeritCriteriaPrint";
  Utility u=new Utility();
   
  @FindBy(id="ContentPlaceHolder1_ddlsession")WebElement session;
  @FindBy(id="ContentPlaceHolder1_ddlClass")WebElement cls;
  @FindBy(id="ContentPlaceHolder1_rbtnCriteriaWise")WebElement criteriawise;
  @FindBy(id="ContentPlaceHolder1_rbtnPointWise")WebElement pointwise;
  @FindBy(id="ContentPlaceHolder1_ddlCriteriaName")WebElement criterianame;
  @FindBy(id="ContentPlaceHolder1_txtCriteriaPoint_TextBox")WebElement criteriapoint;
  @FindBy(id="ContentPlaceHolder1_txtTotalPoint_TextBox")WebElement totalpoint;
  @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
  
  public MeritCriteriaPrint(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this);
  }
  public void openMeritCriteriaPrint()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Merit Criteria Print")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/MeritCriteriaPrint.aspx']")));
  }
  public void selectSession(String sess)
  {
	  new Select(session).selectByVisibleText(sess);
  }
  public void selectClass(String c)
  {
	  new Select(cls).selectByVisibleText(c);
  }
  public void clickPointWise()
  {
	  pointwise.click();
  }
  public void clickCriteriaWise()
  {
	  criteriawise.click();
  }
  public void enterTotalPoint(String p)
  {
	  totalpoint.clear();
	  totalpoint.sendKeys(p);
  }
  public void selectCriteriaName(String cname)
  {
	  new Select(criterianame).selectByVisibleText(cname);
  }
  public void enterCriteriaPoint(String p)
  {
	  criteriapoint.clear();
	  criteriapoint.sendKeys(p);
  }
  public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
  {
		show.click();
        u.verifyShow(dr, str, r, sc);
		Thread.sleep(5000);
		u.captureScreenshot(dr, str, r,sc);
  }
}
 