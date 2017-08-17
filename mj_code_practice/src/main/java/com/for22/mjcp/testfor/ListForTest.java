package com.for22.mjcp.testfor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The Type ListForTest
 *
 * @author lx
 * @Description:
 * @Date 2017/8/16
 */
public class ListForTest {

    @Test
    public void test(){
        List a = new ArrayList<>();
        a.add("1");
        int c = 3;
        for (int i = 0; i < a.size(); i++) {
            System.out.println(i);
            if(c>0) {

                a.add(i);
                c--;
            }
        }
    }
}
 