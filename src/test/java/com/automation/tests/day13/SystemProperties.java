package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test() {

        System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.variant"));

        System.out.println("System.getProperty(\"os.arch\") = " + System.getProperty("os.arch"));
        System.out.println(System.getProperty("user.home") + "\\Downloads");

    }

}
