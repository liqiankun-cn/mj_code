package com.for22.mjcp.thread;

/**
 * The Type TestStatic
 *
 * @author lx
 * @Description:
 * @Date 2017/9/19
 */
public class TestStatic {

    public static int add(int i,int b){
        System.out.println("i("+i+")+b("+b+")="+(i+b));
        return i+b;
    }

    public static void main(String[] args) {
        for (int i = 0;i<1000;i++){
            final int finalI = i;
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = add(finalI,finalI);
                    if(i%2!=0){
                        System.out.println("----------------------------"+finalI);
                    }
                }
            });
            a.start();
        }
    }
}
 