package com.isst.listeners;

 
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.isst.driver.Driver;
 
/***
 * 改类为基础类，重写testng的结果处理，目的是为了实现自己的异常类，通过异常数量断定结果
 * <br> 
 * @author  yaowencheng
 * @version  [版本号, 2017年7月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestListener extends TestListenerAdapter {
 
    @Override
    public void onTestStart(ITestResult result) {
    }
     
    @Override
    public void onTestFailure(ITestResult tr) {
        this.handleAssertion(tr);
    }
     
    @Override
    public void onTestSkipped(ITestResult tr) {
        this.handleAssertion(tr);
    }
     
    @Override
    public void onTestSuccess(ITestResult tr) {
        this.handleAssertion(tr);
    }
     
    private int index = 0;
     
    private void handleAssertion(ITestResult tr){
        if(!Driver.getFailList().isEmpty()){
            Throwable throwable = tr.getThrowable();           
            if(throwable==null){
                throwable = new Throwable();
            }           
            StackTraceElement[] traces = throwable.getStackTrace();
            StackTraceElement[] alltrace = new StackTraceElement[0];           
            for (Error e : Driver.getFailList()) {
                StackTraceElement[] errorTraces = e.getStackTrace();
                StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
                StackTraceElement[] message = new StackTraceElement[]{new StackTraceElement("message : "+e.getMessage()+" in method : ", tr.getMethod().getMethodName(), tr.getTestClass().getRealClass().getSimpleName(), index)};
                index = 0;
                alltrace = this.merge(alltrace, message);
                alltrace = this.merge(alltrace, et);
            }
            if(traces!=null){
                traces = this.getKeyStackTrace(tr, traces);
                alltrace = this.merge(alltrace, traces);
            }           
            throwable.setStackTrace(alltrace);
            tr.setThrowable(throwable);
            tr.setStatus(ITestResult.FAILURE);
            Driver.clearFail();
        }
    }
     
    private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] stackTraceElements){
        List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
        for (StackTraceElement stackTraceElement : stackTraceElements) {           
            if(stackTraceElement.getClassName().equals(tr.getTestClass().getName())){               
                ets.add(stackTraceElement);
                index = stackTraceElement.getLineNumber();
            }
        }
        StackTraceElement[] et = new StackTraceElement[ets.size()];
        for (int i = 0; i < et.length; i++) {
            et[i] = ets.get(i);
        }
        return et;
    }
     
    private StackTraceElement[] merge(StackTraceElement[] traces1, StackTraceElement[] traces2){
        StackTraceElement[] ste = new StackTraceElement[traces1.length+traces2.length];
        for (int i = 0; i < traces1.length; i++) {
            ste[i] = traces1[i];
        }
        for (int i = 0; i < traces2.length; i++) {
            ste[traces1.length+i] = traces2[i];
        }
        return ste;
    }
}