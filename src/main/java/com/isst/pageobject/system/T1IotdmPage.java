package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.isst.pageobject.BaseElement;

/***
 * iotdm界面
 * @author ygg
 *
 */
public class T1IotdmPage extends BaseElement {
    public T1IotdmPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "a[href='#!/setting/iotdm']")
    private WebElement MenuIotdmElement; //iotdm菜单

    @FindBy(css = "input[ng-model='vm.iotdm.ip']")
    private WebElement ipElement; //服务地址
    
    @FindBy(css = "input[ng-model='vm.iotdm.port']")
    private WebElement portElement; //端口
    
    @FindBy(css = "select[ng-model='vm.iotdm.isHttps']")
    private WebElement httpsElement; //是否开启认证
    
    @FindBy(css = "input[ng-model='vm.iotdm.keystorePassword']")
    private WebElement passwordElement; //证书密码
    
    @FindBy(css = "button[ng-click='vm.save()']")
    private WebElement commitElement; //提交
    
    /**
     * iotdm连接-关闭https
     * @param ip
     * @param port
     * @throws InterruptedException
     */
    public void authIotdmNoCert(String ip,String port) throws InterruptedException{
//    	this.sendKeys(ipElement,ip);
//    	this.sendKeys(portElement,port);
    	ipElement.clear();
    	ipElement.sendKeys(ip);
    	portElement.clear();
    	portElement.sendKeys(port);
    	
    	Select st = new Select(httpsElement);
    	st.selectByVisibleText("关");
    	
    	commitElement.click();
    	this.waitBusyDialogDispear();
    }
    
    /**
     * 进入菜单
     * @throws InterruptedException
     */
    public void inPage() throws InterruptedException{
    	MenuIotdmElement.click();
    	Thread.sleep(500);
    	this.waitBusyDialogDispear();
    }
}
