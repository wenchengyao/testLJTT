package com.isst.pageobject.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.isst.pageobject.BaseElement;

/***
 * 灯杆界面
 * @author ygg
 *
 */
public class T5LampTree extends BaseElement {
    public T5LampTree(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='#!/setting/lamp/list']")
    private WebElement MenuIotdmElement; //城市菜单
    // search tool
    @FindBy(css = "input[ng-model='vm.query.name']")
    private WebElement searchNameElement; //灯杆名称
    @FindBy(css = "input[ng-model='vm.query.lamppostNum']")
    private WebElement searchNumElement; //灯杆编号
    @FindBy(css = "select[ng-model='vm.query.archId']")
    private WebElement searchStreetElement; //街道列表
    
    @FindBy(css = "button[ng-click='vm.search()']")
    private WebElement ButtonSearchElement; //查询按钮
    @FindBy(css = "button[ng-click='vm.reset()']")
    private WebElement ButtonResetElement; //重置按钮
    @FindBy(css = "button[ng-click='vm.add()']")
    private WebElement ButtonAddElement; //新增按钮
    
    //list
    @FindBy(id = "chk_0")
    private WebElement CheckElement; //第一条记录
    @FindBy(css = "button span[translate='common.edit']")
    private WebElement EditElement; //修改按钮
    @FindBy(css = "button span[translate='common.del']")
    private WebElement DelElement; //删除按钮
    
    
    //add dialog
    @FindBy(css = "input[ng-model='vm.lamppost.name']")
    private WebElement AddLampPostNameElement; //灯杆名称
    @FindBy(css = "input[ng-model='vm.lamppost.lamppostNum']")
    private WebElement AddLampPostNumElement; //灯杆编号
    @FindBy(css = "select[ng-model='vm.area.region']")
    private WebElement AddLampPostAreaElement; //地区
    @FindBy(css = "select[ng-model='vm.area.street']")
    private WebElement AddLampPostStreetElement; //街道
    @FindBy(css = "input[ng-model='vm.lamppost.longitude']")
    private WebElement AddLampPostLgtElement; //精度
    @FindBy(css = "input[ng-model='vm.lamppost.latitude']")
    private WebElement AddLampPostLatElement; //纬度
    @FindBy(css = "textarea[ng-model='vm.lamppost.description']")
    private WebElement AddLampPostDescElement; //备注
    @FindBy(css = "button[ng-click='vm.save()']")
    private WebElement AddConfirmElement; //确定
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement AddCancelElement; //取消
    


    /***
     * 查询
     * @param name
     * @param number
     * @param street
     * @throws InterruptedException
     */
    public void search(String name,String number,String street) throws InterruptedException{
    	if(name != null){
    		searchNameElement.sendKeys(name);
    	}
    	if(number != null){
    		searchNumElement.sendKeys(number);
    	}
    	if(street != null){
    		Select st = new Select(searchStreetElement);
    		st.selectByVisibleText(street);
    	}
    	ButtonSearchElement.click();
    	this.waitBusyDialogDispear();
    }
    
    /**
     * 进入菜单
     * @throws InterruptedException
     */
    public void inPage() throws InterruptedException{
    	this.waitForElement(MenuIotdmElement);
    	MenuIotdmElement.click();
    	Thread.sleep(500);
    	this.waitBusyDialogDispear();
    	this.waitForElement(searchNumElement);
    }
    
    /***
     * 点击新增
     * @param parentLevel
     * @param parent
     * @throws InterruptedException
     */
    public void clickAdd() throws InterruptedException{
    	//点击新增
    	ButtonAddElement.click();
    	this.waitForElement(AddLampPostNameElement);
    }
    
    /***
     * 点击删除
     * @param lampName
     * @param lampNum
     * @param street
     * @throws InterruptedException
     */
    public void clickDel(String lampName,String lampNum,String street) throws InterruptedException{
    	this.search(lampName,lampNum,street);
		//添加国家
    	DelElement.click();
		Thread.sleep(500);
		this.ensureDelete();
		Thread.sleep(500);
		this.waitBusyDialogDispear();
    }
    
    /***
     * 点击编辑
     * @param lampName
     * @param lampNum
     * @param street
     * @throws InterruptedException
     */
    public void clickEdit(String lampName,String lampNum,String street) throws InterruptedException{
    	this.search(lampName,lampNum,street);
    	//添加国家
    	EditElement.click();
    	this.waitForElement(AddLampPostNameElement);
    	Thread.sleep(500);
    }
    
    /***
     * 填写节点
     * @param lampName
     * @param lampNum
     * @param lont
     * @param lat
     * @param desc
     */
    public void fillNode(String lampName,String lampNum,String lont,String lat,String desc){
    	if (lampName != null){
    		this.sendKeys(AddLampPostNameElement,lampName);
    	}
    	if (lampNum != null){
    		this.sendKeys(AddLampPostNumElement, lampNum);
    	}
    	if (lont != null){
    		this.sendKeys(AddLampPostLgtElement, lont);
    	}
    	if (lat != null){
    		this.sendKeys(AddLampPostLatElement, lat);
    	}
    	if (desc != null){
    		this.sendKeys(AddLampPostDescElement, desc);
    	}
    }
    
    /***
     * 填写街道
     * @param region
     * @param street
     * @throws InterruptedException
     */
    public void selectStreet(String region,String street) throws InterruptedException{
    	if (region != null){
    		Select st = new Select(AddLampPostAreaElement);
    		st.selectByVisibleText(region);
    	}
    	Thread.sleep(500);
    	if (street != null){
    		Select st = new Select(AddLampPostStreetElement);
    		st.selectByVisibleText(street);
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