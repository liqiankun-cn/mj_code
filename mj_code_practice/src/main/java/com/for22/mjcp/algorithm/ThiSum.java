package com.for22.mjcp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Type ThiSum
 *
 * 给出一个有 n 个整数的数组 S，在 S 中找到三个整数 a, b, c，使得 a + b + c = 0。写一个函数找到所有满足要求的三元组。

 注意事项：
 在三元组(a, b, c)，要求a <= b <= c。结果不能包含重复的三元组。

 格式：

 输入行输入一个有 n 个整数的数组 S，最后输出所有满足要求的三元组。

 样例输入

 S = [ -1，0，1，2，-1，-4 ]

 样例输出

 ( -1, 0, 1 )
 ( -1, -1, 2 )


 *
 * @author lx
 * @Description:
 * @Date 2017/12/6
 *
 *
 * 解题思路：
 * 1、先将数据升序排序
 * 2、因为要求a <= b <= c，所以可以顺序遍历，
 * 3、外圈循环从第一位开始到大于0的数字结束，因为三数相加等于0有两种情况：三个0，负数加正数
 * 4、内圈循环从外圈循环的下一位开始
 * 5、0-(a+b)算出第三个要查找的数,若结果小于0，即a+b>0，则跳出内圈循环，因为后面肯定没有小于0的数了
 * 6、通过二分查找判断第三个数是否存在
 * 7、为避免重复三元组，若第一个数和第二个数一样，则外圈循环多跳一个数；若第二个数和下一个循环的数一样，则内圈循环多跳一个数
 *
 */
public class ThiSum {

    private static void sort(int[] param){
        Arrays.sort(param);
    }

    private static boolean find(int[] param,int beginIndex,int endIndex,int num){
        if(beginIndex<0 || endIndex > param.length-1 || beginIndex > endIndex ) {
            return false;
        }
        if(beginIndex == endIndex){
            return num == param[beginIndex];
        }
        int middle = (beginIndex+endIndex)/2;
        if(num == param[middle]){
            return true;
        }
        boolean re ;
        if(num >param[middle]){
            re = find(param, middle+1, endIndex, num);
        }else{
            re = find(param, beginIndex, middle, num);
        }
        return re;
    }

    private static void findTriNum(int[] param){
        for(int i = 0;i<param.length-2;i++){
            if(param[i]>0){
                break;
            }
            for(int j=i+1;j<param.length;j++){
                int trinum = 0-(param[i]+param[j]);
                if(trinum<0){
                    break;
                }
                boolean exists = find(param,j+1,param.length-1,trinum);
                if(exists){
                    System.out.println(param[i]+","+param[j]+","+trinum);
                }
                if(param[i]== param[j]){
                    i++;
                }
                if(j+1<param.length && param[j] == param[j+1]){
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        long timea = System.currentTimeMillis();
        System.out.println(timea);
        int[] a = {1,-2,3,0,5,-4,-1,-1,2,-3};
        sort(a);
//        for(int t: a) {
//            System.out.println(t);
//        }
//        System.out.println(find(a,0,a.length,-5));
        findTriNum(a);
        long timeb = System.currentTimeMillis();
        System.out.println(timeb);
        System.out.println("耗时："+(timeb-timea)+"ms");
    }
}
 