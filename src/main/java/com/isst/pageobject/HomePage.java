package com.isst.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseElement {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    private WebElement loginPageLink;

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void goToLoginPage() {

        waitForElement(loginPageLink);
        loginPageLink.click();
    }
}
