package stepDef;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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


}
