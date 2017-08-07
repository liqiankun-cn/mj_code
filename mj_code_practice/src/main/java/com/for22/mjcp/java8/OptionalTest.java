package com.for22.mjcp.java8;

import java.util.Optional;

/**
 * The Type OptionalTest
 *
 * @author lx
 * @Description:
 * @Date 2017/8/7
 */
public class OptionalTest {

    public String getTestNameWithDefault(Test test){
        return Optional.ofNullable(test).map(test1 -> test1.getName()).orElse("meizhi");
    }

    private void test1() {
        Test t = new Test("test1");
        Test t2 = new Test();
        System.out.println(getTestNameWithDefault(t));
        System.out.println(getTestNameWithDefault(t2));
    }



    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.test1();

    }
}

class Test{
    private String name;

    public Test() {
    }

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}