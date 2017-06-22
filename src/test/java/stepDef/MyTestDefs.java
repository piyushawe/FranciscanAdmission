package stepDef;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import admissionPageObject.AddRemoveGroupHeads;
import admissionPageObject.AdmissionEntry;
import admissionPageObject.AdmissionEntryAmountStructure;
import admissionPageObject.AdmissionFormRegistration;
import admissionPageObject.ChallanAmount;
import admissionPageObject.CreateIDCard;
import admissionPageObject.DefineMeritCriteria;
import admissionPageObject.DefineParentStatus;
import admissionPageObject.Enquiry;
import admissionPageObject.ImportStudent;
import admissionPageObject.ManualListGeneration;
import admissionPageObject.MeritCriteriaEntry;
import admissionPageObject.MeritListGeneration;
import admissionPageObject.ProspectusEntry;
import admissionPageObject.ReSlotting;
import admissionPageObject.SlotCreation;
import admissionPageObject.SlotWisePointEntry;
import admissionPageObject.StudentRegistration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import globalMastersPageObject.DefineAcademicYear;
import globalMastersPageObject.DefineFinancialYear;
import globalMastersPageObject.DefineHouse;
import globalMastersPageObject.DefineOptionalSubject;
import globalMastersPageObject.DefinePeriodsToClass;
import globalMastersPageObject.DefineSmsTemplate;
import globalMastersPageObject.DefineStream;
import globalMastersPageObject.PossibleSiblings;
import globalMastersPageObject.StationaryDetails;
import masterSettingsPageObject.AdmissionClassGroupRelation;
import masterSettingsPageObject.AdmissionFormSettings;
import masterSettingsPageObject.ChangeAcademic;
import masterSettingsPageObject.ChangeActiveInactiveStatus;
import masterSettingsPageObject.DefineDocumentType;
import masterSettingsPageObject.ProspectusAndRegistrationNoSetting;
import masterSettingsPageObject.StudentClassPromotion;
import masterSettingsPageObject.StudentClassSectionTransfer;
import masterSettingsPageObject.StudentImageDownload;
import masterSettingsPageObject.UpdateAddressAndBlood;
import masterSettingsPageObject.UpdateStudentDetails;
import pageObjects.AdmissionWithdrawalRegister;
import pageObjects.ClassWiseAdmisssionReport;
import pageObjects.CollectionReportAdmission;
import pageObjects.MeritCriteriaPrint;
import pageObjects.MeritGenerationList;
import pageObjects.MeritListReport;
import pageObjects.PrintStudentLabel;
import pageObjects.ProspectusChargesReport;
import pageObjects.SearchAndImportOnlineRegistration;
import pageObjects.SiblingReport;
import pageObjects.SlotReport;
import pageObjects.StudentDocumentDetails;
import pageObjects.StudentRepeaterList;
import pageObjects.VerificationAdmissionForm;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

public class MyTestDefs {
	WebDriver driver;
	String schoolname;
	Collection<String>scenario;
	
	@Before
	public void launchBrowser(Scenario sc)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		scenario= sc.getSourceTagNames();
	}
	
	@After
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	
	@When("^passes school name \"([^\"]*)\"$")
	public void passes_school_name(String arg1) throws Throwable {
		schoolname=arg1;
	}

	@Given("^user enter \"([^\"]*)\"$")
	public void user_enter(String arg1) throws Throwable {
	   driver.get(arg1);
	}

	@When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("txtUserName")).sendKeys(arg1);
		driver.findElement(By.id("txtPassword")).sendKeys(arg2);
	}

	@When("^click signin$")
	public void click_signin() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();  
		Thread.sleep(1000);
	}

	@Then("^admission home page is opened$")
	public void admission_home_page_is_opened() throws Throwable {
	    driver.findElement(By.xpath("//img[@src='images/big/Admission-Manager.png']")).click();
	}

//class wise admission report	
	@Then("^class wise admission report is opened$")
	public void class_wise_admission_report_is_opened() throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.openClassWiseAdmisssionReport();
	}

	@When("^user select session \"([^\"]*)\" on class wise admission report$")
	public void user_select_session_on_class_wise_admission_report(String arg1) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectSession(arg1);
	}

	@When("^select school \"([^\"]*)\" on class wise admission report$")
	public void select_school_on_class_wise_admission_report(String arg1) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectSchool(arg1);
	}

	@When("^select class \"([^\"]*)\" on class wise admission report$")
	public void select_class_on_class_wise_admission_report(String arg1) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectClass(arg1);
	}

	@When("^select stream \"([^\"]*)\" on class wise admission report$")
	public void select_stream_on_class_wise_admission_report(String arg1) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectStream(arg1);
	}

	@When("^select subject \"([^\"]*)\" on class wise admission report$")
	public void select_subject_on_class_wise_admission_report(String arg1) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectSubject(arg1);
	}

	@When("^select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on class wise admission report$")
	public void select_from_date_as_month_year_and_day_on_class_wise_admission_report(String arg1, String arg2, String arg3) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectFromDate(arg1, arg2, arg3);
	}

	@When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on class wise admission report$")
	public void select_to_date_as_month_year_and_day_on_class_wise_admission_report(String arg1, String arg2, String arg3) throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.selectToDate(arg1, arg2, arg3);
	}

	@Then("^click show to open class wise admission report$")
	public void click_show_to_open_class_wise_admission_report() throws Throwable {
		ClassWiseAdmisssionReport c= new ClassWiseAdmisssionReport(driver);
		c.clickShow(schoolname, scenario);
	}

//search and import online registration
	@Then("^search and import online registration report is opened$")
	public void search_and_import_online_registration_report_is_opened() throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.openSearchAndImportOnlineRegistration();
	}

	@When("^user select session \"([^\"]*)\" on search and import online registration report page$")
	public void user_select_session_on_search_and_import_online_registration_report_page(String arg1) throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.selectSession(arg1);
	}

	@When("^select class \"([^\"]*)\" on search and import online registration report page$")
	public void select_class_on_search_and_import_online_registration_report_page(String arg1) throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.selectClass(arg1);
	}

	@When("^select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on search and import online registration report page$")
	public void select_from_date_as_month_year_and_day_on_search_and_import_online_registration_report_page(String arg1, String arg2, String arg3) throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.selectFromDate(arg1, arg2, arg3);
	}

	@When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on search and import online registration report page$")
	public void select_to_date_as_month_year_and_day_on_search_and_import_online_registration_report_page(String arg1, String arg2, String arg3) throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user click show to open search and import online registration report$")
	public void user_click_show_to_open_search_and_import_online_registration_report() throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.clickShow(schoolname, scenario);
	}

	@Then("^user click import data to import data on search and import online registration report$")
	public void user_click_import_data_to_import_data_on_search_and_import_online_registration_report() throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.clickImportData(schoolname, scenario);
	}
	
	@Then("^user click update data to erp on search and import online registration report$")
	public void user_click_update_data_to_erp_on_search_and_import_online_registration_report() throws Throwable {
		SearchAndImportOnlineRegistration s= new SearchAndImportOnlineRegistration(driver);
		s.clickUpdateDataToERP(schoolname, scenario);
	}

//slot report
	@Then("^slot report is opened$")
	public void slot_report_is_opened() throws Throwable {
		SlotReport r= new SlotReport(driver);
		r.openSlotReport();
	}

	@When("^user select session \"([^\"]*)\" on slot report$")
	public void user_select_session_on_slot_report(String arg1) throws Throwable {
		SlotReport r= new SlotReport(driver);
		r.selectSession(arg1);
	}

	@When("^select class \"([^\"]*)\" on slot report$")
	public void select_class_on_slot_report(String arg1) throws Throwable {
		SlotReport r= new SlotReport(driver);
		r.selectClass(arg1);
	}

	@When("^select slot \"([^\"]*)\" on slot report$")
	public void select_slot_on_slot_report(String arg1) throws Throwable {
		SlotReport r= new SlotReport(driver);
		r.selectSlot(arg1);
	}

	@Then("^user click show to open slot report$")
	public void user_click_show_to_open_slot_report() throws Throwable {
		SlotReport r= new SlotReport(driver);
		r.clickShow(schoolname, scenario);
	}

//admission withdrawal register
	@Then("^admission withdrawal register report page is opened$")
	public void admission_withdrawal_register_report_page_is_opened() throws Throwable {
		AdmissionWithdrawalRegister a=new AdmissionWithdrawalRegister(driver);
		a.openAdmissionWithdrawalRegister();
	}

	@When("^user select session \"([^\"]*)\" on admission withdrawal register report$")
	public void user_select_session_on_admission_withdrawal_register_report(String arg1) throws Throwable {
		AdmissionWithdrawalRegister a=new AdmissionWithdrawalRegister(driver);
		a.selectSession(arg1);
	}

	@Then("^user click show to open admission withdrawal register report$")
	public void user_click_show_to_open_admission_withdrawal_register_report() throws Throwable {
		AdmissionWithdrawalRegister a=new AdmissionWithdrawalRegister(driver);
		a.clickShow(schoolname, scenario);
	}

//verification admission form
	@Then("^verification admission form is opened$")
	public void verification_admission_form_is_opened() throws Throwable {
		VerificationAdmissionForm a= new VerificationAdmissionForm(driver);
		a.openVerificationAdmissionForm();
	}

	@When("^user select class \"([^\"]*)\" on verification admission form$")
	public void user_select_class_on_verification_admission_form(String arg1) throws Throwable {
		VerificationAdmissionForm a= new VerificationAdmissionForm(driver);
		a.selectClass(arg1);
	}

	@When("^select section \"([^\"]*)\" on verification admission form$")
	public void select_section_on_verification_admission_form(String arg1) throws Throwable {
		VerificationAdmissionForm a= new VerificationAdmissionForm(driver);
		a.selectSection(arg1);
	}

	@When("^select date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on verification admission form$")
	public void select_date_as_month_year_and_day_on_verification_admission_form(String arg1, String arg2, String arg3) throws Throwable {
		VerificationAdmissionForm a= new VerificationAdmissionForm(driver);
		a.selectDate(arg1, arg2, arg3);
	}

	@Then("^user click show to open verification admission form$")
	public void user_click_show_to_open_verification_admission_form() throws Throwable {
		VerificationAdmissionForm a= new VerificationAdmissionForm(driver);
		a.clickShow(schoolname, scenario);
	}

//student repeater list 
	@Then("^student repeater list page is opened$")
	public void student_repeater_list_page_is_opened() throws Throwable {
		StudentRepeaterList s= new StudentRepeaterList(driver);
		s.openStudentRepeaterList();
	}

	@When("^user select class \"([^\"]*)\" on student repeater list page$")
	public void user_select_class_on_student_repeater_list_page(String arg1) throws Throwable {
		StudentRepeaterList s= new StudentRepeaterList(driver);
		s.selectClass(arg1);
	}

	@When("^select section \"([^\"]*)\" on student repeater list page$")
	public void select_section_on_student_repeater_list_page(String arg1) throws Throwable {
		StudentRepeaterList s= new StudentRepeaterList(driver);
		s.selectSection(arg1);
	}

	@Then("^user click show to open student repeater list page$")
	public void user_click_show_to_open_student_repeater_list_page() throws Throwable {
		StudentRepeaterList s= new StudentRepeaterList(driver);
		s.clickShow(schoolname, scenario);
	}

//merit generation list
	@Then("^merit generation list page is opened$")
	public void merit_generation_list_page_is_opened() throws Throwable {
		MeritGenerationList m= new MeritGenerationList(driver);
		m.openMeritGenerationList();
	}

	@When("^user select session \"([^\"]*)\" on merit generation list$")
	public void user_select_session_on_merit_generation_list(String arg1) throws Throwable {
		MeritGenerationList m= new MeritGenerationList(driver);
		m.selectSession(arg1);
	}

	@When("^user select class \"([^\"]*)\" on merit generation list$")
	public void user_select_class_on_merit_generation_list(String arg1) throws Throwable {
		MeritGenerationList m= new MeritGenerationList(driver);
		m.selectClass(arg1);
	}

	@When("^user select merit list \"([^\"]*)\" on merit generation list$")
	public void user_select_merit_list_on_merit_generation_list(String arg1) throws Throwable {
		MeritGenerationList m= new MeritGenerationList(driver);
		m.selectMeritList(arg1);
	}

	@Then("^user click show to open merit generation list$")
	public void user_click_show_to_open_merit_generation_list() throws Throwable {
		MeritGenerationList m= new MeritGenerationList(driver);
		m.clickShow(schoolname, scenario);
	}

//student document details
	@Then("^student document details page is opened$")
	public void student_document_details_page_is_opened() throws Throwable {
		StudentDocumentDetails s= new StudentDocumentDetails(driver);
		s.openStudentDocumentDetails();
	}

	@When("^user select class \"([^\"]*)\" on student document details page$")
	public void user_select_class_on_student_document_details_page(String arg1) throws Throwable {
		StudentDocumentDetails s= new StudentDocumentDetails(driver);
		s.selectClass(arg1);
	}

	@When("^select section \"([^\"]*)\" on student document details page$")
	public void select_section_on_student_document_details_page(String arg1) throws Throwable {
		StudentDocumentDetails s= new StudentDocumentDetails(driver);
		s.selectSection(arg1);
	}

	@Then("^user click show to open student document details page$")
	public void user_click_show_to_open_student_document_details_page() throws Throwable {
		StudentDocumentDetails s= new StudentDocumentDetails(driver);
		s.clickShow(schoolname, scenario);
	}

//merit list report
	@Then("^merit list report page is opened$")
	public void merit_list_report_page_is_opened() throws Throwable {
		MeritListReport m= new MeritListReport(driver);
		m.openMeritListReport();
	}

	@When("^user select session \"([^\"]*)\" on merit list report page$")
	public void user_select_session_on_merit_list_report_page(String arg1) throws Throwable {
		MeritListReport m= new MeritListReport(driver);
		m.selectSession(arg1);
	}

	@When("^user select class \"([^\"]*)\" on merit list report page$")
	public void user_select_class_on_merit_list_report_page(String arg1) throws Throwable {
		MeritListReport m= new MeritListReport(driver);
		m.selectClass(arg1);
	}

	@When("^user select merit list \"([^\"]*)\" on merit list report page$")
	public void user_select_merit_list_on_merit_list_report_page(String arg1) throws Throwable {
		MeritListReport m= new MeritListReport(driver);
		m.selectMeritList(arg1);
	}

	@Then("^user click show to open merit list report page$")
	public void user_click_show_to_open_merit_list_report_page() throws Throwable {
		MeritListReport m= new MeritListReport(driver);
		m.clickShow(schoolname, scenario);
	}

//prospectus charges report
	@Then("^prospectus charges report page is opened$")
	public void prospectus_charges_report_page_is_opened() throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.openProspectusChargesReport();
	}

	@When("^user select session \"([^\"]*)\" on prospectus charges report page$")
	public void user_select_session_on_prospectus_charges_report_page(String arg1) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectSession(arg1);
	}

	@When("^select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on prospectus charges report page$")
	public void select_from_date_as_month_year_and_day_on_prospectus_charges_report_page(String arg1, String arg2, String arg3) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectFromDate(arg1, arg2, arg3);
	}

	@When("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on prospectus charges report page$")
	public void select_to_date_as_month_year_and_day_on_prospectus_charges_report_page(String arg1, String arg2, String arg3) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectToDate(arg1, arg2, arg3);
	}

	@When("^user select class \"([^\"]*)\" on prospectus charges report page$")
	public void user_select_class_on_prospectus_charges_report_page(String arg1) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectClass(arg1);
	}

	@When("^select user \"([^\"]*)\" on prospectus charges report page$")
	public void select_user_on_prospectus_charges_report_page(String arg1) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectUser(arg1);
	}

	@When("^select mode \"([^\"]*)\" on prospectus charges report page$")
	public void select_mode_on_prospectus_charges_report_page(String arg1) throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.selectMode(arg1);
	}

	@Then("^user click show to open prospectus charges report page$")
	public void user_click_show_to_open_prospectus_charges_report_page() throws Throwable {
		ProspectusChargesReport p= new ProspectusChargesReport(driver);
		p.clickShow(schoolname, scenario);
	}

//merit criteria print
	@Then("^merit criteria print report page is opened$")
	public void merit_criteria_print_report_page_is_opened() throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.openMeritCriteriaPrint();
	}

	@When("^user select session \"([^\"]*)\" on merit criteria print report page$")
	public void user_select_session_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.selectSession(arg1);
	}

	@When("^user select class \"([^\"]*)\" on merit criteria print report page$")
	public void user_select_class_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.selectClass(arg1);
	}

	@When("^click criteria wise on merit criteria print report page$")
	public void click_criteria_wise_on_merit_criteria_print_report_page() throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.clickCriteriaWise();
	}

	@When("^select criteria name \"([^\"]*)\" on merit criteria print report page$")
	public void select_criteria_name_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.selectCriteriaName(arg1);
	}


	@When("^enter criteria point \"([^\"]*)\" on merit criteria print report page$")
	public void enter_criteria_point_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.enterCriteriaPoint(arg1);
	}

	@Then("^user click show to open merit criteria print report page$")
	public void user_click_show_to_open_merit_criteria_print_report_page() throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.clickShow(schoolname, scenario);
	    
	}

	@When("^click point wise on merit criteria print report page$")
	public void click_point_wise_on_merit_criteria_print_report_page() throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.clickPointWise();
	}

	@When("^enter total point \"([^\"]*)\" on merit criteria print report page$")
	public void enter_total_point_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		MeritCriteriaPrint m=new MeritCriteriaPrint(driver);
		m.enterTotalPoint(arg1);
	}
	
//print student label
	@Then("^print student label page is opened$")
	public void print_student_label_page_is_opened() throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.openPrintStudentLabel();
	}

	@Then("^user select class \"([^\"]*)\" on  print student label page$")
	public void user_select_class_on_print_student_label_page(String arg1) throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.selectClass(arg1);
	}

	@When("^user select section \"([^\"]*)\" on  print student label page$")
	public void user_select_section_on_print_student_label_page(String arg1) throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.selectSection(arg1);
	}

	@When("^enter search text \"([^\"]*)\" on merit criteria print report page$")
	public void enter_search_text_on_merit_criteria_print_report_page(String arg1) throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.enterSearchtext(arg1);
	}

	@Then("^user click show to open print student label page$")
	public void user_click_show_to_open_print_student_label_page() throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.clickShow(schoolname, scenario);
	}
	
	@When("^click transport on print student label page$")
	public void click_transport_on_print_student_label_page() throws Throwable {
		PrintStudentLabel p= new PrintStudentLabel(driver);
		p.clickTransport();
	}

//collection report admission
	@Then("^collection report admission page is opened$")
	public void collection_report_admission_page_is_opened() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.openCollectionReportAdmission();
	}

	@Then("^select prospectus wise on collection report admission page$")
	public void select_prospectus_wise_on_collection_report_admission_page() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.clickProspectusWise();
	}

	@Then("^select admission form wise on collection report admission page$")
	public void select_admission_form_wise_on_collection_report_admission_page() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.clickAdmissionFormWise();
	}
	
	@Then("^select admission entry wise on collection report admission page$")
	public void select_admission_entry_wise_on_collection_report_admission_page() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.clickAdmissionEntryWise();
	}

	@Then("^select reslot wise on collection report admission page$")
	public void select_reslot_wise_on_collection_report_admission_page() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.clickReslotWise();
	}
	
	@Then("^select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on collection report admission page$")
	public void select_from_date_as_month_year_and_day_on_collection_report_admission_page(String arg1, String arg2, String arg3) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on collection report admission page$")
	public void select_to_date_as_month_year_and_day_on_collection_report_admission_page(String arg1, String arg2, String arg3) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select class \"([^\"]*)\" on collection report admission page$")
	public void user_select_class_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectClass(arg1);
	}

	@When("^user select session \"([^\"]*)\" on collection report admission page$")
	public void user_select_session_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectSession(arg1);
	}

	@When("^select board \"([^\"]*)\" on collection report admission page$")
	public void select_board_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectBoard(arg1);
	}

	@When("^select pay mode \"([^\"]*)\" on collection report admission page$")
	public void select_pay_mode_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectPayMode(arg1);
	}

	@When("^select entry mode \"([^\"]*)\" on collection report admission page$")
	public void select_entry_mode_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectEntryMode(arg1);
	}

	@When("^select order by \"([^\"]*)\" on collection report admission page$")
	public void select_order_by_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectOrderBy(arg1);
	}

	@When("^select group by \"([^\"]*)\" on collection report admission page$")
	public void select_group_by_on_collection_report_admission_page(String arg1) throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.selectGroupBy(arg1);
	}

	@Then("^user click show to open collection report admission page$")
	public void user_click_show_to_open_collection_report_admission_page() throws Throwable {
		CollectionReportAdmission c= new CollectionReportAdmission(driver);
		c.clickShow(schoolname, scenario);
	}

//sibling report
	@Then("^sibling report page is opened$")
	public void sibling_report_page_is_opened() throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.openSiblingReport();
	}

	@When("^user select session \"([^\"]*)\" on sibling report page$")
	public void user_select_session_on_sibling_report_page(String arg1) throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.selectSession(arg1);
	}

	@When("^select school \"([^\"]*)\" on sibling report page$")
	public void select_school_on_sibling_report_page(String arg1) throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.selectSchool(arg1);
	}

	@When("^select class \"([^\"]*)\" on sibling report page$")
	public void select_class_on_sibling_report_page(String arg1) throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.selectClass(arg1);
	}

	@When("^select show details for \"([^\"]*)\" on sibling report page$")
	public void select_show_details_for_on_sibling_report_page(String arg1) throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.selectShowDetailsFor(arg1);
	}

	@Then("^user click show to open sibling report$")
	public void user_click_show_to_open_sibling_report() throws Throwable {
		SiblingReport s= new SiblingReport(driver);
		s.clickShow(schoolname, scenario);
	}

//change academic
	@When("^user open change academic page$")
	public void user_open_change_academic_page() throws Throwable {
		ChangeAcademic ca= new ChangeAcademic(driver);
		ca.openChangeAcademic();
	}

	@Then("^verify change academic page$")
	public void verify_change_academic_page() throws Throwable {
		ChangeAcademic ca= new ChangeAcademic(driver);
		ca.verifyPage(schoolname, scenario);
	}
	
//prospectus & registration no setting
	@When("^user open prospectus & registration no setting page$")
	public void user_open_prospectus_registration_no_setting_page() throws Throwable {
		ProspectusAndRegistrationNoSetting prs= new ProspectusAndRegistrationNoSetting(driver);
		prs.openProspectusAndRegistrationNoSetting();
	}

	@Then("^verify prospectus & registration no setting page$")
	public void verify_prospectus_registration_no_setting_page() throws Throwable {
		ProspectusAndRegistrationNoSetting prs= new ProspectusAndRegistrationNoSetting(driver);
		prs.verifyPage(schoolname, scenario);
	}
	
//admission class group relation
	@When("^user open admission class group relation page$")
	public void user_open_admission_class_group_relation_page() throws Throwable {
		AdmissionClassGroupRelation acgr= new AdmissionClassGroupRelation(driver);
		acgr.openAdmissionClassGroupRelation();
	}

	@Then("^verify admission class group relation page$")
	public void verify_admission_class_group_relation_page() throws Throwable {
		AdmissionClassGroupRelation acgr= new AdmissionClassGroupRelation(driver);
		acgr.verifyPage(schoolname, scenario);
	}

//student class section transfer
	@When("^user open student class section transfer page$")
	public void user_open_student_class_section_transfer_page() throws Throwable {
		StudentClassSectionTransfer scst= new StudentClassSectionTransfer(driver);
		scst.openStudentClassSectionTransfer();
	}

	@Then("^verify student class section transfer page$")
	public void verify_student_class_section_transfer_page() throws Throwable {
		StudentClassSectionTransfer scst= new StudentClassSectionTransfer(driver);
		scst.verifyPage(schoolname, scenario);
	}
	
//change active inactive status
	@When("^user open change active inactive status page$")
	public void user_open_change_active_inactive_status_page() throws Throwable {
		ChangeActiveInactiveStatus cais= new ChangeActiveInactiveStatus(driver);
		cais.openChangeActiveInactiveStatus();
	}

	@Then("^verify change active inactive status page$")
	public void verify_change_active_inactive_status_page() throws Throwable {
		ChangeActiveInactiveStatus cais= new ChangeActiveInactiveStatus(driver);
		cais.verifyPage(schoolname, scenario);
	}

//update address and blood
	@When("^user open update address and blood page$")
	public void user_open_update_address_and_blood_page() throws Throwable {
		UpdateAddressAndBlood uab= new UpdateAddressAndBlood(driver);
		uab.openUpdateAddressAndBlood();
	}

	@Then("^verify update address and blood page$")
	public void verify_update_address_and_blood_page() throws Throwable {
		UpdateAddressAndBlood uab= new UpdateAddressAndBlood(driver);
		uab.verifyPage(schoolname, scenario);
	}
	
//update student details
	@When("^user open update student details page$")
	public void user_open_update_student_details_page() throws Throwable {
		UpdateStudentDetails usd= new UpdateStudentDetails(driver);
		usd.openUpdateStudentDetails();
	}

	@Then("^verify update student details page$")
	public void verify_update_student_details_page() throws Throwable {
		UpdateStudentDetails usd= new UpdateStudentDetails(driver);
		usd.verifyPage(schoolname, scenario);
	}
	
//define document type
	@When("^user open define document type page$")
	public void user_open_define_document_type_page() throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.openDefineDocumentType();
	}

	@Then("^verify define document type page$")
	public void verify_define_document_type_page() throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.verifyPage(schoolname, scenario);
	}

	@When("^select document type on define document type page$")
	public void select_document_type_on_define_document_type_page() throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.selectDocumentType();
	}

	@When("^enter document name as \"([^\"]*)\" on define document type page$")
	public void enter_document_name_as_on_define_document_type_page(String arg1) throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.enterDocumentName(arg1);
	}

	@Then("^click save on define document type page$")
	public void click_save_on_define_document_type_page() throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.clickSave(schoolname, scenario);
	}

	@Then("^click view on define document type page$")
	public void click_view_on_define_document_type_page() throws Throwable {
		DefineDocumentType ddt= new DefineDocumentType(driver);
		ddt.clickView(schoolname, scenario);
	}

//student class promotion
	@When("^user open student class promotion page$")
	public void user_open_student_class_promotion_page() throws Throwable {
		StudentClassPromotion scp= new StudentClassPromotion(driver);
		scp.openStudentClassPromotion();
	}

	@Then("^verify student class promotion page$")
	public void verify_student_class_promotion_page() throws Throwable {
		StudentClassPromotion scp= new StudentClassPromotion(driver);
		scp.verifyPage(schoolname, scenario);
	}

//student image download
	@When("^user open student image download page$")
	public void user_open_student_image_download_page() throws Throwable {
		StudentImageDownload sid= new StudentImageDownload(driver);
		sid.openStudentImageDownload();
	}

	@Then("^verify student image download page$")
	public void verify_student_image_download_page() throws Throwable {
		StudentImageDownload sid= new StudentImageDownload(driver);
		sid.verifyPage(schoolname, scenario);
	}
	
//admission form settings
	@When("^user open admission form settings page$")
	public void user_open_admission_form_settings_page() throws Throwable {
		AdmissionFormSettings afs= new AdmissionFormSettings(driver);
		afs.openAdmissionFormSettings();
	}

	@Then("^verify admission form settings page$")
	public void verify_admission_form_settings_page() throws Throwable {
		AdmissionFormSettings afs= new AdmissionFormSettings(driver);
		afs.verifyPage(schoolname, scenario);
	}

//possible siblings
	@When("^user open possible siblings page$")
	public void user_open_possible_siblings_page() throws Throwable {
		PossibleSiblings ps= new PossibleSiblings(driver);
		ps.openPossibleSiblings();
	}

	@Then("^verify possible siblings page$")
	public void verify_possible_siblings_page() throws Throwable {
		PossibleSiblings ps= new PossibleSiblings(driver);
		ps.verifyPage(schoolname, scenario);
	}
	
//stationary details
	@When("^user open stationary details page$")
	public void user_open_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);   
		sd.openStationaryDetails();
	}

	@Then("^verify stationary details page$")
	public void verify_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);   
		sd.verifyPage(schoolname, scenario);
	}

	@When("^enter stationary name \"([^\"]*)\" on stationary details page$")
	public void enter_stationary_name_on_stationary_details_page(String arg1) throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.enterStationaryName(arg1);
	}

	@When("^enter amount \"([^\"]*)\" on stationary details page$")
	public void enter_amount_on_stationary_details_page(String arg1) throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.enterAmount(arg1);
	}

	@When("^select post account name on stationary details page$")
	public void select_post_account_name_on_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.selectPostAccountName();
	}

	@When("^select school name on stationary details page$")
	public void select_school_name_on_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.selectSchoolName();
	}

	@When("^select session \"([^\"]*)\" on stationary details page$")
	public void select_session_on_stationary_details_page(String arg1) throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.selectSession(arg1);
	}

	@Then("^click save on stationary details page$")
	public void click_save_on_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.clickSave(schoolname, scenario);
	}

	@Then("^click view on stationary details page$")
	public void click_view_on_stationary_details_page() throws Throwable {
		StationaryDetails sd= new StationaryDetails(driver);
		sd.clickView(schoolname, scenario);
	}

//define academic year
	@When("^user open define academic year page$")
	public void user_open_define_academic_year_page() throws Throwable {
		DefineAcademicYear day= new DefineAcademicYear(driver);
		day.openDefineAcademicYear();
	}

	@Then("^verify define academic year page$")
	public void verify_define_academic_year_page() throws Throwable {
		DefineAcademicYear day= new DefineAcademicYear(driver);
		day.verifyPage(schoolname, scenario);
	}
	
//define financial year	
	@When("^user open define financial year page$")
	public void user_open_define_financial_year_page() throws Throwable {
		DefineFinancialYear dfy= new DefineFinancialYear(driver);
		dfy.openDefineFinancialYear();
	}

	@Then("^verify define financial year page$")
	public void verify_define_financial_year_page() throws Throwable {
		DefineFinancialYear dfy= new DefineFinancialYear(driver);
		dfy.verifyPage(schoolname, scenario);
	}
	
//define periods to class
	@When("^user open define periods to class page$")
	public void user_open_define_periods_to_class_page() throws Throwable {
		DefinePeriodsToClass dpc= new DefinePeriodsToClass(driver);
		dpc.openDefinePeriodsToClass();
	}

	@Then("^verify define periods to class page$")
	public void verify_define_periods_to_class_page() throws Throwable {
		DefinePeriodsToClass dpc= new DefinePeriodsToClass(driver);
		dpc.verifyPage(schoolname, scenario);
	}
	
//define house
	@When("^user open define house page$")
	public void user_open_define_house_page() throws Throwable {
		DefineHouse dh= new DefineHouse(driver);
		dh.openDefineHouse();
	}

	@Then("^verify define house page$")
	public void verify_define_house_page() throws Throwable {
		DefineHouse dh= new DefineHouse(driver);
		dh.verifyPage(schoolname, scenario);
	}

	@When("^enter house name as \"([^\"]*)\" on define house page$")
	public void enter_house_name_as_on_define_house_page(String arg1) throws Throwable {
		DefineHouse dh= new DefineHouse(driver);
		dh.enterHouse(arg1);
	}

	@Then("^click save on define house page$")
	public void click_save_on_define_house_page() throws Throwable {
		DefineHouse dh= new DefineHouse(driver);
		dh.clickSave(schoolname, scenario);
	}

	@Then("^click view on define house page$")
	public void click_view_on_define_house_page() throws Throwable {
		DefineHouse dh= new DefineHouse(driver);
		dh.clickView(schoolname, scenario);
	}

//define stream
	@When("^user open define stream page$")
	public void user_open_define_stream_page() throws Throwable {
		DefineStream ds= new DefineStream(driver);
		ds.openDefineStream();
	}

	@Then("^verify define stream page$")
	public void verify_define_stream_page() throws Throwable {
		DefineStream ds= new DefineStream(driver);
		ds.verifyPage(schoolname, scenario);
	}

	@When("^enter stream name as \"([^\"]*)\" on define stream page$")
	public void enter_stream_name_as_on_define_stream_page(String arg1) throws Throwable {
		DefineStream ds= new DefineStream(driver);
		ds.enterStreamName(arg1);
	}

	@Then("^click save on define stream page$")
	public void click_save_on_define_stream_page() throws Throwable {
		DefineStream ds= new DefineStream(driver);
		ds.clickSave(schoolname, scenario);
	}

	@Then("^click view on define stream page$")
	public void click_view_on_define_stream_page() throws Throwable {
		DefineStream ds= new DefineStream(driver);
		ds.clickView(schoolname, scenario);
	}

//define optional subject
	@When("^user open define optional subject page$")
	public void user_open_define_optional_subject_page() throws Throwable {
		DefineOptionalSubject dos= new DefineOptionalSubject(driver);
		dos.openDefineOptionalSubject();
	}

	@Then("^verify define optional subject page$")
	public void verify_define_optional_subject_page() throws Throwable {
		DefineOptionalSubject dos= new DefineOptionalSubject(driver);
		dos.verifyPage(schoolname, scenario);
	}

	@When("^enter subject name as \"([^\"]*)\" on define optional subject page$")
	public void enter_subject_name_as_on_define_optional_subject_page(String arg1) throws Throwable {
		DefineOptionalSubject dos= new DefineOptionalSubject(driver);
		dos.enterSubjectName(arg1);
	}

	@Then("^click save on define optional subject page$")
	public void click_save_on_define_optional_subject_page() throws Throwable {
		DefineOptionalSubject dos= new DefineOptionalSubject(driver);
		dos.clickSave(schoolname, scenario);
	}

	@Then("^click view on define optional subject page$")
	public void click_view_on_define_optional_subject_page() throws Throwable {
		DefineOptionalSubject dos= new DefineOptionalSubject(driver);
		dos.clickView(schoolname, scenario);
	}

//define sms template
	@When("^user open define sms template page$")
	public void user_open_define_sms_template_page() throws Throwable {
		DefineSmsTemplate dst= new DefineSmsTemplate(driver); 
		dst.openDefineSmsTemplate();
	}

	@Then("^verify define sms template page$")
	public void verify_define_sms_template_page() throws Throwable {
		DefineSmsTemplate dst= new DefineSmsTemplate(driver); 
		dst.verifyPage(schoolname, scenario);
	}
	
//define parent status
	@When("^user open define parent status page$")
	public void user_open_define_parent_status_page() throws Throwable {
		DefineParentStatus dps= new DefineParentStatus(driver);
		dps.openDefineParentStatus();
	}

	@Then("^verify define parent status page$")
	public void verify_define_parent_status_page() throws Throwable {
		DefineParentStatus dps= new DefineParentStatus(driver);
		dps.verifyPage(schoolname, scenario);
	}

	@When("^enter parent status as \"([^\"]*)\" on define parent status page$")
	public void enter_parent_status_as_on_define_parent_status_page(String arg1) throws Throwable {
		DefineParentStatus dps= new DefineParentStatus(driver);
		dps.enterParentStatus(arg1);
	}

	@Then("^click save on define parent status page$")
	public void click_save_on_define_parent_status_page() throws Throwable {
		DefineParentStatus dps= new DefineParentStatus(driver);
		dps.clickSave(schoolname, scenario);
	}

	@Then("^click view on define parent status page$")
	public void click_view_on_define_parent_status_page() throws Throwable {
		DefineParentStatus dps= new DefineParentStatus(driver);
		dps.clickView(schoolname, scenario);
	}

//slot creation
	@When("^user open slot creation page$")
	public void user_open_slot_creation_page() throws Throwable {
		SlotCreation sc= new SlotCreation(driver);
		sc.openSlotCreation();
	}

	@Then("^verify slot creation page$")
	public void verify_slot_creation_page() throws Throwable {
		SlotCreation sc= new SlotCreation(driver);
		sc.verifyPage(schoolname, scenario);
	}

//enquiry
	@When("^user open enquiry page$")
	public void user_open_enquiry_page() throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.openEnquiry();
	}

	@Then("^verify enquiry page$")
	public void verify_enquiry_page() throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.verifyPage(schoolname, scenario);
	}

	@When("^click get last enquiry no on enquiry page$")
	public void click_get_last_enquiry_no_on_enquiry_page() throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.clickGetLastEnquiryNo();
	}

	@When("^enter visitor name as \"([^\"]*)\" on enquiry page$")
	public void enter_visitor_name_as_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterVisitorName(arg1);
	}

	@When("^enter visitor address \"([^\"]*)\" on enquiry page$")
	public void enter_visitor_address_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterVisitorAddress(arg1);
	}

	@When("^enter mobile no \"([^\"]*)\" on enquiry page$")
	public void enter_mobile_no_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterMobileNo(arg1);
	}

	@When("^enter purpose \"([^\"]*)\" on enquiry page$")
	public void enter_purpose_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterPurpose(arg1);
	}

	@When("^enter contact person \"([^\"]*)\" on enquiry page$")
	public void enter_contact_person_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterContactPerson(arg1);
	}

	@When("^enter reference details \"([^\"]*)\" on enquiry page$")
	public void enter_reference_details_on_enquiry_page(String arg1) throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.enterReferenceDetails(arg1);
	}

	@Then("^click save on enquiry page$")
	public void click_save_on_enquiry_page() throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.clickSave(schoolname, scenario);
	}

	@Then("^click view on enquiry page$")
	public void click_view_on_enquiry_page() throws Throwable {
		Enquiry eq= new Enquiry(driver);
		eq.clickView(schoolname, scenario);
	}

	//prospectus entry
	@When("^user open prospectus entry page$")
	public void user_open_prospectus_entry_page() throws Throwable {
		ProspectusEntry pe= new ProspectusEntry(driver);
		pe.openProspectusEntry();
	}

	@Then("^verify prospectus entry page$")
	public void verify_prospectus_entry_page() throws Throwable {
		ProspectusEntry pe= new ProspectusEntry(driver);
		pe.verifyPage(schoolname, scenario);
	}
	
//define merit criteria
	@When("^user open define merit criteria page$")
	public void user_open_define_merit_criteria_page() throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.openDefineMeritCriteria();
	}

	@Then("^verify define merit criteria page$")
	public void verify_define_merit_criteria_page() throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.verifyPage(schoolname, scenario);
	}

	@When("^select session \"([^\"]*)\" on define merit criteria page$")
	public void select_session_on_define_merit_criteria_page(String arg1) throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.selectSession(arg1);
	}

	@When("^enter name as \"([^\"]*)\" on define merit criteria page$")
	public void enter_name_as_on_define_merit_criteria_page(String arg1) throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.enterName(arg1);
	}

	@When("^enter maximum point \"([^\"]*)\" on define merit criteria page$")
	public void enter_maximum_point_on_define_merit_criteria_page(String arg1) throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.enterMaximumPoint(arg1);
	}

	@Then("^click save on define merit criteria page$")
	public void click_save_on_define_merit_criteria_page() throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.clickSave(schoolname, scenario);
	}

	@Then("^click view on define merit criteria page$")
	public void click_view_on_define_merit_criteria_page() throws Throwable {
		DefineMeritCriteria dmc= new DefineMeritCriteria(driver);
		dmc.clickView(schoolname, scenario);
	}

//merit criteria entry
	@When("^user open merit criteria entry page$")
	public void user_open_merit_criteria_entry_page() throws Throwable {
		MeritCriteriaEntry mce= new MeritCriteriaEntry(driver);
		mce.openMeritCriteriaEntry();
	}

	@Then("^verify merit criteria entry page$")
	public void verify_merit_criteria_entry_page() throws Throwable {
		MeritCriteriaEntry mce= new MeritCriteriaEntry(driver);
		mce.verifyPage(schoolname, scenario);
	}
	
//merit list generation	
	@When("^user open merit list generation page$")
	public void user_open_merit_list_generation_page() throws Throwable {
		MeritListGeneration mlg= new MeritListGeneration(driver);
		mlg.openMeritListGeneration();
	}

	@Then("^verify merit list generation page$")
	public void verify_merit_list_generation_page() throws Throwable {
		MeritListGeneration mlg= new MeritListGeneration(driver);
		mlg.verifyPage(schoolname, scenario);
	}
	
//admission entry
	@When("^user open admission entry page$")
	public void user_open_admission_entry_page() throws Throwable {
		AdmissionEntry ae= new AdmissionEntry(driver);
		ae.openAdmissionEntry();
	}

	@Then("^verify admission entry page$")
	public void verify_admission_entry_page() throws Throwable {
		AdmissionEntry ae= new AdmissionEntry(driver);
		ae.verifyPage(schoolname, scenario);
	}
	
//import student
	@When("^user open import student page$")
	public void user_open_import_student_page() throws Throwable {
		ImportStudent is= new ImportStudent(driver);
		is.openImportStudent();
	}

	@Then("^verify import student page$")
	public void verify_import_student_page() throws Throwable {
		ImportStudent is= new ImportStudent(driver);
		is.verifyPage(schoolname, scenario);
	}
	
//add remove group heads
	@When("^user open add remove group heads page$")
	public void user_open_add_remove_group_heads_page() throws Throwable {
		AddRemoveGroupHeads argh= new AddRemoveGroupHeads(driver);
		argh.openAddRemoveGroupHeads();
	}

	@Then("^verify add remove group heads page$")
	public void verify_add_remove_group_heads_page() throws Throwable {
		AddRemoveGroupHeads argh= new AddRemoveGroupHeads(driver);
		argh.verifyPage(schoolname, scenario);
	}
	
//manual list generation
	@When("^user open manual list generation page$")
	public void user_open_manual_list_generation_page() throws Throwable {
		ManualListGeneration mlg= new ManualListGeneration(driver);
		mlg.openManualListGeneration();
	}

	@Then("^verify manual list generation page$")
	public void verify_manual_list_generation_page() throws Throwable {
		ManualListGeneration mlg= new ManualListGeneration(driver);
		mlg.verifyPage(schoolname, scenario);
	}
	
//create id card
	@When("^user open create id card page$")
	public void user_open_create_id_card_page() throws Throwable {
		CreateIDCard cid= new CreateIDCard(driver);
		cid.openCreateIDCard();
	}

	@Then("^verify create id card page$")
	public void verify_create_id_card_page() throws Throwable {
		CreateIDCard cid= new CreateIDCard(driver);
		cid.verifyPage(schoolname, scenario);
	}
	
//admission entry amount structure
	@When("^user open admission entry amount structure page$")
	public void user_open_admission_entry_amount_structure_page() throws Throwable {
		AdmissionEntryAmountStructure aeas= new AdmissionEntryAmountStructure(driver);
		aeas.openAdmissionEntryAmountStructure();
	}

	@Then("^verify admission entry amount structure page$")
	public void verify_admission_entry_amount_structure_page() throws Throwable {
		AdmissionEntryAmountStructure aeas= new AdmissionEntryAmountStructure(driver);
		aeas.verifyPage(schoolname, scenario);
	}
	
//slot wise point entry
	@When("^user open slot wise point entry page$")
	public void user_open_slot_wise_point_entry_page() throws Throwable {
		SlotWisePointEntry swpe= new SlotWisePointEntry(driver);
		swpe.openSlotWisePointEntry();
	}

	@Then("^verify slot wise point entry page$")
	public void verify_slot_wise_point_entry_page() throws Throwable {
		SlotWisePointEntry swpe= new SlotWisePointEntry(driver);
		swpe.verifyPage(schoolname, scenario);
	}
	
//challan amount
	@When("^user open challan amount page$")
	public void user_open_challan_amount_page() throws Throwable {
		ChallanAmount ca= new ChallanAmount(driver);
		ca.openChallanAmount();
	}

	@Then("^verify challan amount page$")
	public void verify_challan_amount_page() throws Throwable {
		ChallanAmount ca= new ChallanAmount(driver);
		ca.verifyPage(schoolname, scenario);
	}

//re slotting
	@When("^user open re slotting page$")
	public void user_open_re_slotting_page() throws Throwable {
		ReSlotting rs= new ReSlotting(driver);
		rs.openReSlotting();
	}

	@Then("^verify re slotting page$")
	public void verify_re_slotting_page() throws Throwable {
		ReSlotting rs= new ReSlotting(driver);
		rs.verifyPage(schoolname, scenario);
	}

//admission form registration
	@When("^user open admission form registration page$")
	public void user_open_admission_form_registration_page() throws Throwable {
		AdmissionFormRegistration afr= new AdmissionFormRegistration(driver);
		afr.openAdmissionFormRegistration();
	}

	@Then("^verify admission form registration page$")
	public void verify_admission_form_registration_page() throws Throwable {
		AdmissionFormRegistration afr= new AdmissionFormRegistration(driver);
		afr.verifyPage(schoolname, scenario);
	}

//student registration
	@When("^user open student registration page$")
	public void user_open_student_registration_page() throws Throwable {
		StudentRegistration sr= new StudentRegistration(driver);
		sr.openStudentRegistration();
	}

	@Then("^verify student registration page$")
	public void verify_student_registration_page() throws Throwable {
		StudentRegistration sr= new StudentRegistration(driver);
		sr.verifyPage(schoolname, scenario);
	}

}
