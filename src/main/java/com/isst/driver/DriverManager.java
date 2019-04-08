package com.isst.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final String HEADLESS = "headless";
    
    /***
     * 创建驱动
     * @param browserName
     * @param appUrl
     * @param methodName
     * @param dbus 指明chromedriver或者其他的路径
     * @return
     * @throws MalformedURLException
     */
    public static WebDriver createInstance(String browserName, String appUrl, String methodName,String dbus) throws MalformedURLException {
        final String browserMode = System.getProperty("mode");
        WebDriver driver = null;
        if(browserName.toLowerCase().contains("firefox")) {
            System.setProperty("webdriver.gecko.driver", dbus);
            if(browserMode !=null  && browserMode.equals(HEADLESS)){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            }else {
                driver = new FirefoxDriver();
            }

        }
        if(browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", dbus);
            if(browserMode !=null  && browserMode.equals(HEADLESS)){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            }else {
//                driver = new ChromeDriver();
                DesiredCapabilities capabilitie = DesiredCapabilities.chrome();

                capabilitie.setCapability("chrome.switches", "--incognito"); // 屏蔽--ignore-certificate-errors提示
                ChromeOptions options = new ChromeOptions();
                options.addArguments(new String[] {"--test-type" ,"--start-maximized"});// 忽略网站证书错误提示

                options.merge(capabilitie);
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
                        .usingAnyFreePort()
                        .build();
//                capabilitie.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(service,options);
            }

        }
        if(browserName.toLowerCase().contains("zalenium")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability("name", methodName);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }
        driver.navigate().to(new URL(appUrl));
        return driver;
    }
}
