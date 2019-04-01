package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.isst.pageobject.BaseElement;

/***
 * 操作日志界面
 * @author ygg
 *
 */
public class T3LogManagePage extends BaseElement {
    public T3LogManagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[ng-model='vm.query.searchType']")
    private WebElement operatorElement; //操作员
    
    /**
     * 查询
     * @param ip
     */
    public void search(String ip){
    	
    }
}