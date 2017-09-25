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

public class StudentRepeaterList {
  WebDriver dr;
  String r="StudentRepeaterList";
  Utility u= new Utility();
  
    @FindBy(id="ContentPlaceHolder1_ddlClass")WebElement cls;
    @FindBy(id="ContentPlaceHolder1_ddlSection")WebElement section;
    @FindBy(name="ctl00$ContentPlaceHolder1$SingleButton1$ctl00")WebElement show;
    
    public StudentRepeaterList(WebDriver d)
    {
    	this.dr=d;
    	PageFactory.initElements(d, this);
    }
    public void openStudentRepeaterList()
    {
    	WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
    	Actions builder= new Actions(dr);
    	builder.moveToElement(menu).build().perform();
    	dr.findElement(By.linkText("Student Repeater list")).click();
    	dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/Report/Admission/StudentRepeaterList.aspx']")));
    }
    public void selectClass(String c)
    {
    	new Select(cls).selectByVisibleText(c);
    }
    public void selectSection(String sec)
    {
    	new Select(section).selectByVisibleText(sec);
    }
    public void clickShow(String str, Collection<String>sc ) throws InterruptedException, IOException
    {
  		show.click();
        u.verifyShow(dr, str, r, sc);
  		Thread.sleep(8000);
  		u.captureScreenshot(dr, str, r,sc);
    }
}
