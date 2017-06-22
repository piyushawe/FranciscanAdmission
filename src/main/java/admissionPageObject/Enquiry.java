package admissionPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class Enquiry {
  WebDriver dr;
  String pg="Enquiry";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_btngetenqno")WebElement getlastenquiryno;
  @FindBy(id="ContentPlaceHolder1_txtVisitorName_TextBox")WebElement visitorname;
  @FindBy(id="ContentPlaceHolder1_txtAddress_TextBox")WebElement visitoraddress;
  @FindBy(id="ContentPlaceHolder1_txtPhoneNo_TextBox")WebElement mobileno;
  @FindBy(id="ContentPlaceHolder1_txtPurpose_TextBox")WebElement purpose;
  @FindBy(id="ContentPlaceHolder1_txtContPerson_TextBox")WebElement contactperson;
  @FindBy(id="ContentPlaceHolder1_txtRefDetails_TextBox")WebElement referencedetails;
  @FindBy(id="ContentPlaceHolder1_ButtonServerControl1_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_ButtonServerControl1_btnView")WebElement view;

  public Enquiry(WebDriver d)
  {
     this.dr=d;
	 PageFactory.initElements(d, this); 
  }	  
  public void openEnquiry()
  {
     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 dr.findElement(By.linkText("Enquiry")).click();
	 dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/AdmStudentEnquiry.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void clickGetLastEnquiryNo()
  {
      getlastenquiryno.click();
  }
  public void enterVisitorName(String vname)
  {
      visitorname.sendKeys(vname);
  }
  public void enterVisitorAddress(String vaddress)
  {
      visitoraddress.sendKeys(vaddress);
  }
  public void enterMobileNo(String mno)
  {
      mobileno.sendKeys(mno);
  }
  public void enterPurpose(String purp)
  {
      purpose.sendKeys(purp);
  }
  public void enterContactPerson(String cperson)
  {
      contactperson.sendKeys(cperson);
  }
  public void enterReferenceDetails(String rdetails)
  {
      referencedetails.sendKeys(rdetails);
  }
  public void clickSave(String school, Collection<String> sc)throws IOException
  {
      save.click();
      try {
          Assert.assertTrue(dr.getPageSource().contains("Gate Pass"));
      }
      catch(Exception e){
          u.verifySave(dr, school, pg, sc);
      }
  }
  public void clickView(String school, Collection<String> sc)throws IOException
  {
      view.click();
      WebElement table= dr.findElement(By.id("example"));
      List<WebElement> cells= table.findElements(By.tagName("td"));
      if (cells.size()>1) {
          for (WebElement cell : cells) {
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptAdmStudentEnq')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_ButtonServerControl1_btnModify")).click();
          dr.findElement(By.id("popup_ok")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
