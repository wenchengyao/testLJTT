package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.isst.pageobject.BaseElement;

/***
 * 视频服务界面
 * @author ygg
 *
 */
public class T2VideoPage extends BaseElement {
    public T2VideoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[ng-model='vm.esdk_server.ip']")
    private WebElement ipElement; //服务地址
    
    @FindBy(css = "input[ng-model='vm.esdk_server.port']")
    private WebElement portElement; //服务端口
    
    @FindBy(css = "input[ng-model='vm.esdk_server.userName']")
    private WebElement userElement; //用户名
    
    @FindBy(css = "input[ng-model='vm.esdk_server.password']")
    private WebElement passwordElement; //密码
    
    @FindBy(css = "button[ng-click=\"vm.saveOrUpdateServer('esdk_server')\"]")
    private WebElement submitElement; //提交
    
    public void submit(String ip,String port,String user,String pass) throws InterruptedException{
    	ipElement.sendKeys(ip);
    	portElement.sendKeys(port);
    	userElement.sendKeys(user);
    	passwordElement.sendKeys(pass);
    	
    	submitElement.click();
    	this.waitBusyDialogDispear();
    }
}