package com.isst.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseElement {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css="input[ng-model='vm.user.username']")
    private WebElement username1;
    
    @FindBy(css="[ng-model='vm.user.password']")
    private WebElement password1;
    
    @FindBy(id = "loginBtn")
    private WebElement submit1;
    
    @FindBy(css = "span[ng-click='vm.exitBigScreen()']")
    private WebElement guanli; //管理平台按钮

    public void login(String username, String password) throws InterruptedException {
    	username1.sendKeys(username);
    	password1.sendKeys(password);
    	Thread.sleep(500);
        submit1.click();
        this.waitForElement(guanli);
        Thread.sleep(500);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
