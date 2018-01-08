package com.for22.mjcp.algorithm;

/**
 * The Type CountNum
 *
 * 写一个函数计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。

 格式：

 输入行输入一个整数 n 和一个数字 k，最后输出数字 k 在 0 到 n 中出现的次数。

 样例输入

 n = 12
 k = 1

 样例输出

 5

 *
 * @author lx
 * @Description:
 * @Date 2017/12/7
 *
 *
 * 解题思路：
 * 先按高位整数计算，然后低位递归计算，如2430,先算2000的，然后再算400的，接着30的，最后0的
 * count为n的位数，如2430的count为4
 * highNum为n的最高位，如2430的highNum为2，diNum为除了最高位后的数，如2430的diNum为430
 *最高位若大于k，则最高位出现过10^(count-1)次k
 *
 *举例：n=2430,k=3
 * fx(2430,3)= (2*10^0)*(10^(4-2)) + (2*10^1)*(10^(4-3)) + (2*10^2)*(10^(4-4))    --先算2000有多少3，因为千位小于3，所以不用算3***这样数字的3，百位的3出现过200次（03**，13**），依次类推
 *            +(4*10^0)*(10^(3-2)) + (4*10^1)*(10^(3-3)) + (10^3-1)  --再算400有多少3
 *            +(3*10^0)*(10^2-2)) + (0+1)  --再算30有多少3，
 *
 *
 * 暴力解题思路：
 * 先把0-n的数字组成字符串，然后遍历
 *
 * 两种解题思路的效率，从两位数开始拉开差距（一下数据来源个人机器，）
 * n     思路1     暴力(单位：ms)
 * 90       0       1
 *500       0       2
 * 5000     1       6
 * 50000    1       32
 */
public class CountNum {

    /**
     *
     * @param n
     * @param k
     * @return
     */
    private static int countNum(int n,int k){
        int num = 0;
        if(n < 10){
            num += n>=k?1:0;
        }else {
            String a = String.valueOf(n);
            char c = a.charAt(0);
            int hignNum = c - 48;
            int count = a.length();
            if (hignNum < k) {
                for(int t=count-2,i=0;t>=0;t--,i++){
                    num += (hignNum*Math.pow(10,i))*(Math.pow(10,t));
                }
                int n1 = (int) (n - (hignNum * Math.pow(10, count-1)));
                if(0 == n1 && 0 == k){
                    num += count -1;
                }else {
                    num += countNum(n1, k);
                }
            }else if(hignNum == k){
                int n1 = (int) (n - (hignNum * Math.pow(10, count-1)));
                for(int t=count-2,i=0;t>=0;t--,i++){
                    num += (hignNum*Math.pow(10,i))*(Math.pow(10,t));
                }
                num += n1+1;
                num += countNum(n1,k);
            }else{
                int n1 = (int) (n - (hignNum * Math.pow(10, count-1)));
                for(int t=count-2,i=0;t>=0;t--,i++){
                    num += (hignNum*Math.pow(10,i))*(Math.pow(10,t));
                }
                num += Math.pow(10,count-1);
                num += countNum(n1,k);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        long abegin = System.currentTimeMillis();
        int a = countNum(123465798,3);
        System.out.println(a);
        long aend = System.currentTimeMillis();
        System.out.println("耗时："+(aend-abegin)+"ms");
        long bbegin = System.currentTimeMillis();
        int b = baoli(50000, 3);
        System.out.println(b);
        long bend = System.currentTimeMillis();
        System.out.println("耗时："+(bend-bbegin)+"ms");
    }



    private static int baoli(int n,int k){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++){
            sb.append(i);
        }
        String b = sb.toString();
        char kc = (char) (k+48);
        int num = 0;
        for(int j=0;j<b.length();j++){
            if(b.charAt(j) == kc){
                num++;
            }
        }
        return num;
    }
}
 