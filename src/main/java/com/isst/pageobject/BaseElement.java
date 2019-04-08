package com.isst.pageobject;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.isst.driver.Driver;

/***
 * 全局的界面元素，如busyDialog，alarmDialog，resultDialog. assertion
 * @author ygg
 *
 */
public class BaseElement extends Driver {
	//定义一个js执行器
	public JavascriptExecutor js;

    public BaseElement(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(css = "span[ng-click='vm.exitBigScreen()']")
    private WebElement guanli; //管理平台按钮
    
    @FindBy(css = "a[href='#!/app/device']")
    private WebElement zhuye; //主页按钮
    
    @FindBy(css = "a[href='#!/setting/block']")
    private WebElement guanlipt; //管理按钮
    
    @FindBy(css = "a[href='#!/bigScreenMove']")
    private WebElement daping; //大屏按钮
    
    @FindBy(css = "a[href='#!/setting/iotdm']")
    private WebElement iotdm; //大屏按钮
    
    //busy dialog 此处定义遮罩层
    @FindBy(css = "div.cg-busy-animation.ng-scope.ng-hide")
    private WebElement busyhide; //遮罩层消失
    
    @FindBy(css = "div.text-info")
    private WebElement topdialog;
    
    @FindBy(css = "button[ng-click='yes()']")
    private WebElement deleteEnsure;
    
    /**
     * 【功能】界面跳转-大屏->首页
     * @throws InterruptedException
     */
    public void goHomePage() throws InterruptedException {
    	js.executeScript("$(arguments[0]).click()",  guanli);
    	this.waitForElement(zhuye);
    	Thread.sleep(500);
    }
    
    /**
     * 【功能】界面跳转-首页->系统管理
     * @throws InterruptedException
     */
    public void goSystemPage() throws InterruptedException {
    	Thread.sleep(1000);
    	this.waitForElement(guanlipt);
    	guanlipt.click();
    	this.waitBusyDialogDispear();
    	this.waitForElement(iotdm);
    	Thread.sleep(500);
    }
    
    /**
     * 【功能】界面跳转-首页->大屏
     * @throws InterruptedException
     */
    public void goBigscreenPage() throws InterruptedException {
    	zhuye.click();
    	this.waitBusyDialogDispear();
    	this.waitForElement(guanli);
    	Thread.sleep(500);
    }
    
    /**
     * 【通用】等待遮罩层消失
     * @throws InterruptedException
     */
    public void waitBusyDialogDispear() throws InterruptedException{
    	//当下面的元素出现时，就说明遮罩层已经消失
    	this.waitForElementOp(busyhide);
    	Thread.sleep(500);
    }
    
    /**
     * clear and sendkeys
     * @param e
     * @param s
     */
    public void sendKeys(WebElement e,String s){
    	e.clear();
    	e.sendKeys(s);
    }
    
    /***
     * 获取弹出框
     * @return
     */
    public String getRespMessage(){
    	return topdialog.getText();
    }
    
    /***
     * 确认删除
     * @throws InterruptedException
     */
    public void ensureDelete() throws InterruptedException{
    	deleteEnsure.click();
    	Thread.sleep(500);
    	this.waitBusyDialogDispear();
    }
    
    
	/***
	 * 实现自己的异常，用于将所有的断言都运行
	 * <功能详细描述>
	 * @param actual
	 * @param expected
	 * @see [类、类#方法、类#成员]
	 */
	public void assertEquals(String actual,String expected){
		try{
			Assert.assertEquals(expected,actual);
		}catch(ComparisonFailure e){
			addFail(e);
		}
	}
	
	/***
	 * 实现自己的异常，用于将所有的断言都运行
	 * @param message
	 * @param actual
	 * @param expected
	 */
	public void assertEquals(String message,String actual,String expected){
		try{
			Assert.assertEquals(message,expected,actual);
		}catch(ComparisonFailure e){
			addFail(e);
		}
	}
	
	/***
	 * 实现自己的异常，用于校验空
	 * @param message
	 * @param object
	 */
	public void assertNull(String message,Object object){
		try{
			Assert.assertNull(message,object);
		}catch(ComparisonFailure e){
			addFail(e);
		}
	}
}
