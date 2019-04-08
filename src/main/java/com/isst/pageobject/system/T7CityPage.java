package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.isst.pageobject.BaseElement;

/***
 * 城市界面
 * @author ygg
 *
 */
public class T7CityPage extends BaseElement {
    public T7CityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='#!/setting/arch/list']")
    private WebElement MenuIotdmElement; //城市菜单
    // search tool
    @FindBy(css = "select[ng-model='vm.query.searchType']")
    private WebElement searchTypeElement; //查找类型
    @FindBy(css = "input[ng-model='vm.query.keyword']")
    private WebElement searchValueElement; //关键字
    @FindBy(css = "select[ng-model='vm.query.level']")
    private WebElement searchLevel; //层级
    
    @FindBy(css = "button[ng-click='vm.search()']")
    private WebElement ButtonSearchElement; //查询按钮
    @FindBy(css = "button[ng-click='vm.reset()']")
    private WebElement ButtonResetElement; //重置按钮
    @FindBy(css = "button[ng-click='vm.addArch()']")
    private WebElement ButtonAddElement; //新增按钮
    
    //list
    @FindBy(id = "chk_0")
    private WebElement CheckElement; //第一条记录
    @FindBy(css = "button span[translate='common.edit']")
    private WebElement EditElement; //修改按钮
    @FindBy(css = "button span[translate='common.del']")
    private WebElement DelElement; //删除按钮
    
    
    //add dialog
    @FindBy(css = "input[ng-model='vm.arch.name']")
    private WebElement AddArchNameElement; //名称
    @FindBy(css = "input[ng-model='vm.arch.number']")
    private WebElement AddArchNumElement; //编号
    @FindBy(css = "input[ng-model='vm.arch.longitude']")
    private WebElement AddArchLgtElement; //经度
    @FindBy(css = "input[ng-model='vm.arch.latitude']")
    private WebElement AddArchLtdElement; //纬度
    @FindBy(css = "textarea[ng-model='vm.arch.description']")
    private WebElement AddArchDescElement; //备注
    @FindBy(css = "button[ng-click='vm.save()']")
    private WebElement AddConfirmElement; //确定
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement AddCancelElement; //取消
    

    /***
     * 查询
     * @param name
     * @param text
     * @throws InterruptedException
     */
    public void search(String name,String text) throws InterruptedException{
    	if(name != null){
    		searchValueElement.sendKeys(name);
    	}
    	if(text != null){
    		Select st = new Select(searchLevel);
    		st.selectByVisibleText(text);
    	}
    	ButtonSearchElement.click();
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
    
    /***
     * 点击新增
     * @param parentLevel
     * @param parent
     * @throws InterruptedException
     */
    public void clickAdd(String parentLevel,String parent) throws InterruptedException{
    	this.search(parent,parentLevel);
    	if (parent == null){
    		//添加国家
    		ButtonAddElement.click();
    		this.waitForElement(AddArchNameElement);
    		return;
    	}
    	CheckElement.click();
    	//点击新增
    	ButtonAddElement.click();
    	this.waitForElement(AddArchNameElement);
    }
    
    /***
     * 删除记录
     * @param parentLevel
     * @param parent
     * @throws InterruptedException
     */
    public void clickDel(String parentLevel,String parent) throws InterruptedException{
    	this.search(parent,parentLevel);
		//添加国家
    	DelElement.click();
		Thread.sleep(500);
		this.ensureDelete();
		Thread.sleep(500);
		this.waitBusyDialogDispear();
    }
    
    /***
     * 修改记录
     * @param parentLevel
     * @param parent
     * @throws InterruptedException
     */
    public void clickEdit(String parentLevel,String parent) throws InterruptedException{
    	this.search(parent,parentLevel);
    	//添加国家
    	EditElement.click();
    	this.waitForElement(AddArchNameElement);
    	Thread.sleep(500);
    }
    
    /***
     * 填写参数
     * @param name
     * @param AD
     * @param lont
     * @param lat
     * @param desc
     */
    public void fillNode(String name,String AD,String lont,String lat,String desc){
    	if (name != null){
    		this.sendKeys(AddArchNameElement,name);
    	}
    	if (AD != null){
    		this.sendKeys(AddArchNumElement, AD);
    	}
    	if (lont != null){
    		this.sendKeys(AddArchLgtElement, lont);
    	}
    	if (lat != null){
    		this.sendKeys(AddArchLtdElement, lat);
    	}
    	if (desc != null){
    		this.sendKeys(AddArchDescElement, desc);
    	}
    }
    
    /***
     * confirm
     * @throws InterruptedException
     */
    public void confirm() throws InterruptedException{
    	AddConfirmElement.click();
    	Thread.sleep(500);
    	this.waitBusyDialogDispear();
    }
    
    /***
     * cancel
     * @throws InterruptedException
     */
    public void cancel() throws InterruptedException{
    	AddCancelElement.click();
    	Thread.sleep(500);
    	this.waitBusyDialogDispear();
    }
}