package globalMastersPageObject;

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
import pageObjects.Utility;

public class StationaryDetails {
  WebDriver dr;
  String pg="StationaryDetails";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_txtStationary_TextBox")WebElement stationaryname;
  @FindBy(id="ContentPlaceHolder1_txtAmount_TextBox")WebElement amount;
  @FindBy(id="ContentPlaceHolder1_ddlpostAccount")WebElement postaccountname;
  @FindBy(id="ContentPlaceHolder1_ddlAccount")WebElement schoolname;
  @FindBy(id="ContentPlaceHolder1_ddlsession")WebElement session;
  @FindBy(id="ContentPlaceHolder1_BtnControls11_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_BtnControls11_btnView")WebElement view;

  public StationaryDetails(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openStationaryDetails()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Global-Masters.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Stationary Details")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/AdmStationaryDetails.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void enterStationaryName(String sname)
  {
      stationaryname.sendKeys(sname);
  }
  public void enterAmount(String amt)
  {
      amount.sendKeys(amt);
  }
  public void selectPostAccountName()
  {
      new Select(postaccountname).selectByIndex(1);
  }
  public void selectSchoolName()
  {
      new Select(schoolname).selectByIndex(1);
  }
  public void selectSession(String sess)
  {
      new Select(session).selectByVisibleText(sess);
  }
  public void clickSave(String school, Collection<String> sc)throws IOException
  {
      save.click();
      u.verifySave(dr, school, pg, sc);
  }
  public void clickView(String school, Collection<String> sc)throws IOException
  {
      view.click();
      WebElement table= dr.findElement(By.id("example"));
      List<WebElement> cells= table.findElements(By.tagName("td"));
      if (cells.size()>1) {
          for (WebElement cell : cells) {
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptStationary')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_BtnControls11_btnModify")).click();
          dr.findElement(By.id("popup_ok")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
