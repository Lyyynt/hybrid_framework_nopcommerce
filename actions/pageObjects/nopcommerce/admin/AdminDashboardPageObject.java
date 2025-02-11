package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nomcommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	
}
