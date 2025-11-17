package hooks;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void beforeHook1(){
        System.out.println("In before hook1");
    }

    @Before("@smoke")
    public void beforeHook2(){
        System.out.println("In before hook2");
    }

    @After
    public void afterHook1(){
        System.out.println("In after hook1");
    }
    @After("@smoke")
    public void afterHook2(){
        System.out.println("In after hook2");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("write logs before each step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("write logs after each step");
    }


}
