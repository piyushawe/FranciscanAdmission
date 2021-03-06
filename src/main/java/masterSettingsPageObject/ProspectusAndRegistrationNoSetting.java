package masterSettingsPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class ProspectusAndRegistrationNoSetting {
  WebDriver dr;
  String pg="ProspectusAndRegistrationNoSetting";
  Utility u= new Utility();
  
  public ProspectusAndRegistrationNoSetting(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  
  public void openProspectusAndRegistrationNoSetting()
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Prospectus & Registration No Setting")).click();
 	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/AdmissionManager/ProsRegNoSetting.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
	  verifySettingType();
  }	  
  public void verifySettingType()
  {
	  List<WebElement>settingtype= dr.findElements(By.name("ctl00$ContentPlaceHolder1$Pros"));
	  boolean flag= true;
	  int i=0;
	  for(WebElement stype:settingtype)
	  {
		  if(settingtype.get(i).isSelected())
			  flag=true;
		  i++;
	  }
	  if(flag)
		  System.out.println("Setting Type is selected");
	  else
		  System.out.println("Setting Type is not selected");
  }
}
