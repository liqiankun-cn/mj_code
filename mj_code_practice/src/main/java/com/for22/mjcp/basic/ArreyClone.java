package com.for22.mjcp.basic;

/**
 * The Type ArreyClone
 *
 * @author lx
 * @Description:
 * @Date 2017/8/15
 */
public class ArreyClone {

    public static void main(String[] args) {
        byte[] c = new byte[]{'z','z','z','z','z','z','z','z'};
        byte[][] b = new byte[][]{
                {'z','z','z','z','z','z','z','z'},
                {'z','z','4','0','z','z','z','z'},
                {'z','z','0','2','0','0','z','z'},
                {'z','z','z','0','z','0','z','z'},
                {'z','1','z','0','z','0','0','z'},
                {'z','1','2','0','0','z','0','z'},
                {'z','1','0','0','0','2','0','z'},
                {'z','z','z','z','z','z','z','z'}};
        byte[][] a = b.clone();
        byte[] d = c.clone();
        a[1][1] = '1';
        d[0] = '1';
        System.out.println(pint(b));
        System.out.println(pint(a));
        System.out.println(pint2(c));
        System.out.println(pint2(d));
    }
    public static String pint(byte[][] t) {
        StringBuilder sb = new StringBuilder();
        for(byte[] bt : t){
            sb.append(new String(bt).replaceAll("0"," ")).append("\n");
        }
        return sb.toString();
    }
    public static String pint2(byte[] t) {
        return new String(t).replaceAll("0"," ");
    }
}
 