package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.isst.pageobject.BaseElement;

/***
 * Led文件界面
 * @author ygg
 *
 */
public class T4LedPage extends BaseElement {
    public T4LedPage(WebDriver driver) {
        super(driver);
    }

    // search tool
    @FindBy(css = "select[ng-model='vm.query.searchType']")
    private WebElement searchTypeElement; //查找类型
    @FindBy(css = "input[ng-model='vm.query.searchType']")
    private WebElement searchValueElement; //关键字
    @FindBy(css = "select[ng-model='vm.roleObj']")
    private WebElement searchRoleElement; //角色
    
    @FindBy(css = "button[ng-click='vm.search()']")
    private WebElement ButtonSearchElement; //查询按钮
    @FindBy(css = "button[ng-click='vm.reset()']")
    private WebElement ButtonResetElement; //重置按钮
    @FindBy(css = "button[ng-click='vm.add()']")
    private WebElement ButtonAddElement; //新增按钮
    @FindBy(css = "button[ng-click='vm.delVideos()']")
    private WebElement ButtonDelElement; //批量删除按钮
    
    //list
    @FindBy(css = "button[ng-click='vm.ledAuditing(0)']")
    private WebElement BanElement; //禁播按钮
    @FindBy(css = "button[ng-click='vm.updateVideo(0)']")
    private WebElement EditElement; //修改按钮
    @FindBy(id = "delVideoBtn")
    private WebElement DelElement; //删除按钮
    @FindBy(css = "input[type='checkbox']")
    private WebElement CheckElement; //全选按钮
    
    
    //add dialog
    @FindBy(css = "select[ng-model='vm.brand']")
    private WebElement AddBrandElement; //查询按钮
    @FindBy(css = "input[ng-model='vm.name']")
    private WebElement AddNameElement; //查询按钮
    @FindBy(css = "select[ng-model='vm.roleObj']")
    private WebElement AddRoleElement; //角色
    @FindBy(css = "button[ng-model='vm.selectedSrcFile']")
    private WebElement AddSrcScanElement; //浏览按钮
    @FindBy(css = "input[ng-model='vm.srcFilesName']")
    private WebElement AddSrcFileElement; //资源文件
    @FindBy(css = "button[ng-click='vm.importVideo()']")
    private WebElement AddConfirmElement; //资源文件
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement AddCancelElement; //资源文件
    

    /**
     * 查询
     * @param ip
     * @throws InterruptedException 
     */
    public void search(String name,String role) throws InterruptedException{
    	searchValueElement.sendKeys(name);
    	searchRoleElement.sendKeys(role);
    	ButtonSearchElement.click();
    	this.waitBusyDialogDispear();
    }
}