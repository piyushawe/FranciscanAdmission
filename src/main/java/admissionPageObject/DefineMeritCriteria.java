package admissionPageObject;

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

public class DefineMeritCriteria {
  WebDriver dr;
  String pg="DefineMeritCriteria";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_ddlSession")WebElement session;
  @FindBy(id="ContentPlaceHolder1_txtName_TextBox")WebElement name;
  @FindBy(id="ContentPlaceHolder1_txtPoint_TextBox")WebElement maximumpoint;
  @FindBy(id="ContentPlaceHolder1_BtnControl_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_BtnControl_btnView")WebElement view;

  public DefineMeritCriteria(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openDefineMeritCriteria()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Define Merit Criteria")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/MeritCriteriaMst.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void selectSession(String sess)
  {
      new Select(session).selectByVisibleText(sess);
  }
  public void enterName(String nm)
  {
      name.sendKeys(nm);
  }
  public void enterMaximumPoint(String mpoint)
  {
      maximumpoint.sendKeys(mpoint);
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
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptMeritCriteria')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_BtnControl_btnModify")).click();
          dr.findElement(By.id("popup_ok")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
