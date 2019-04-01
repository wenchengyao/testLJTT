package com.isst.driver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    public WebDriver driver;

    public Driver(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<ArrayList<AssertionError>> fList = new ThreadLocal<>();

    public static  WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
    	setFailList(new ArrayList<AssertionError>());
        webDriver.set(driver);
    }
    
    public static ArrayList<AssertionError> getFailList() {
    	return fList.get();
    }
    
    public static void setFailList(ArrayList<AssertionError> fails) {
    	fList.set(fails);
    }
    
    public void addFail(AssertionError e) {
    	ArrayList<AssertionError> ae = getFailList();
    	ae.add(e);
    	setFailList(ae);
    }
    
    public static void clearFail() {
    	setFailList(new ArrayList<AssertionError>());
    }

    /**
     * wait for element visibility
     * @param element
     */
    protected void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * wait for element appear, but invisibility
     * @param element
     */
    protected void waitForElementOp(WebElement element){
    	WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
