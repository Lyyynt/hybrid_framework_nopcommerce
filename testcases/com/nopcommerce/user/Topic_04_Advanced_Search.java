package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserSearchPageObject;


public class Topic_04_Advanced_Search extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserSearchPageObject searchPage;
	
	String firstName, lastName, email, password, confirmPassword, country, city, address1, address2, portalCode, phoneNumber, faxNumber;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
		country = "Viet Nam";
		city = "Ha Noi";
		address1 = "No.1 Pham Van Bach Street";
		address2 = "No.10 Duy Tan Street";
		portalCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0123456789";
		
		//precondtion
		registerNewAccountAndLogin();
		homePage.clickToFooterLink(driver, "Search");
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
	}
	
	@Test
	public void Search_01_Empty_Data() {
		log.info("Search 01 - Step 1: Click To Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 01 - Step 2: Verify the warning message displays");
		verifyEquals(searchPage.getWarningMessage(), "Search term minimum length is 3 characters");
		log.info("=============================");
	}
	
	@Test
	public void Search_02_Data_Not_Exist() {
		homePage.openSearchPage();
		
		log.info("Search 02 - Step 1: Send data that is not exist to search box");
		searchPage.inputToSearchKeywordTextbox("Macbook Pro 2050");
		
		log.info("Search 02 - Step 2: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 02 - Step 3: Verify the warning message displays");
		verifyEquals(searchPage.getWarningMessage(), "No products were found that matched your criteria.");
		log.info("=============================");
	}
	
	
	@Test
	public void Search_03_Relative_Product_Name() {
		homePage.openSearchPage();
		
		log.info("Search 03 - Step 1: Send relative product name to search box");
		searchPage.inputToSearchKeywordTextbox("Lenovo");
		
		log.info("Search 03 - Step 2: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 03 - Step 3: Verify the result product is 2 and the name of product is correct");
		verifyEquals(searchPage.getResultItemCount(), "2");
		verifyTrue(searchPage.isProductNameDisplay("Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(searchPage.isProductNameDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
		log.info("=============================");
	}
	
	@Test
	public void Search_04_Absolute_Product_Name() {
		homePage.openSearchPage();
		
		log.info("Search 04 - Step 1: Send absolute product name to search box");
		searchPage.inputToSearchKeywordTextbox("Thinkpad X1 Carbon");
		
		log.info("Search 04 - Step 2: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 04 - Step 3: Verify the result product is 1 and the name of product is correct");
		verifyEquals(searchPage.getResultItemCount(), "1");
		verifyTrue(searchPage.isProductNameDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
		log.info("=============================");
	}
	
	@Test
	public void Search_05_Advanced_With_Parent_Categories() {
		homePage.openSearchPage();
		
		log.info("Search 05 - Step 1: Send keyword search");
		searchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info("Search 05 - Step 2: Check to Advanced Search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();
		
		log.info("Search 05 - Step 3: Select categories dropdown");
		searchPage.selectCategory("Computers");
		
		log.info("Search 05 - Step 4: Uncheck Auto Search Sub Category Checkbox");
		searchPage.uncheckToAutoSearchSubCategoryCheckbox();
		
		log.info("Search 05 - Step 5: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 05 - Step 6: Verify the warning message displays");
		verifyEquals(searchPage.getWarningMessage(), "No products were found that matched your criteria.");
		log.info("=============================");
	}
	
	@Test
	public void Search_06_Advanced_With_Sub_Categories() {
		homePage.openSearchPage();
		
		log.info("Search 06 - Step 1: Send keyword search");
		searchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info("Search 06 - Step 2: Check to Advanced Search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();
		
		log.info("Search 06 - Step 3: Select categories dropdown");
		searchPage.selectCategory("Computers");
		
		log.info("Search 06 - Step 4: Check Auto Search Sub Category Checkbox");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		
		log.info("Search 06 - Step 5: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 06 - Step 6: Verify the result product is 1 and the name of product is correct");
		verifyEquals(searchPage.getResultItemCount(),"1" );
		verifyTrue(searchPage.isProductNameDisplay("Apple MacBook Pro 13-inch"));
		log.info("=============================");
	}
	
	@Test
	public void Search_07_Advanced_With_Incorrect_Manufacturer() {
		homePage.openSearchPage();
		
		log.info("Search 07 - Step 1: Send keyword search");
		searchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info("Search 07 - Step 2: Check to Advanced Search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();
		
		log.info("Search 07 - Step 3: Select categories dropdown");
		searchPage.selectCategory("Computers");
		
		log.info("Search 07 - Step 4: Check Auto Search Sub Category Checkbox");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		
		log.info("Search 07 - Step 5: Select manufacturer dropdown");
		searchPage.selectManufacturer("HP");
		
		log.info("Search 07 - Step 6: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 07 - Step 7: Verify the warning message displays");
		verifyEquals(searchPage.getWarningMessage(), "No products were found that matched your criteria.");
		log.info("=============================");
	}
	
	@Test
	public void Search_08_Advanced_With_Correct_Manufacturer() {
		homePage.openSearchPage();
		
		log.info("Search 08 - Step 1: Send keyword search");
		searchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info("Search 08 - Step 2: Check to Advanced Search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();
		
		log.info("Search 08 - Step 3: Select categories dropdown");
		searchPage.selectCategory("Computers");
		
		log.info("Search 08 - Step 4: Check Auto Search Sub Category Checkbox");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		
		log.info("Search 08 - Step 5: Select manufacturer dropdown");
		searchPage.selectManufacturer("Apple");
		
		log.info("Search 08 - Step 6: Click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search 08 - Step 7: Verify the result product is 1 and the name of product is correct");
		verifyEquals(searchPage.getResultItemCount(), "1");
		verifyTrue(searchPage.isProductNameDisplay("Apple MacBook Pro 13-inch"));
		log.info("=============================");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}
	
	private void registerNewAccountAndLogin() {
		// Pre-condition
		log.info("Pre-condition - Step 1: Enter the valid information");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		log.info("Pre-condition - Step 2: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		log.info("Pre-condition - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Pre-condition - Step 4: Verify the register success message displays");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Pre-condition - Step 5: Back to Home page");
		homePage = registerPage.clickToContinueButton();
		log.info("Pre-condition - Step 6: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		log.info("Pre-condition - Step 7: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		log.info("Pre-condition - Step 8: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		log.info("Pre-condition - Step 9: Verify the home page displays");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		log.info("=============================");
	}
	
}

