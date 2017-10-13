package com.for22.mjcp.sudo;

import java.util.HashMap;
import java.util.Map;

/**
 * The Type SudoMap
 *
 * @author lx
 * @Description:
 * @Date 2017/10/13
 */
public class SudoMap {

    private short[][] map = new short[9][9];
    //1,2,3,4,5 ,6 ,7 ,8  ,9  ,all
    //1,2,4,8,16,32,64,128,256,511
    public static void main(String[] args) {
        System.out.println();
    }

    public static int log2n(short num){
        return (short)(Math.log(num)/Math.log(2));
    }

    public static int translateTo2n(short num){
        return 1<<num-1;
    }

    public static void init(short[][] source){
        for(int i=0;i<9;i++){

        }
    }
}
 