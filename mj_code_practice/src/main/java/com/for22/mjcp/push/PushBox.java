package com.for22.mjcp.push;

/**
 * The Type PushBox
 *
 * @author lx
 * @Description:
 * @Date 2017/8/9
 */
public class PushBox {

    public static void main(String[] args) {
//        1：是否存在目的地        2：是否存在箱子        4：是否存在人  0:空地  3：箱子在目的地   5：人在目的地
        byte[][] b = new byte[][]{
                {'z','z','z','z','z','z','z','z'},
                {'z','z','4','0','z','z','z','z'},
                {'z','z','0','0','0','0','z','z'},
                {'z','z','z','2','z','0','z','z'},
                {'z','1','z','0','z','0','0','z'},
                {'z','1','2','0','0','z','0','z'},
                {'z','1','0','2','0','0','0','z'},
                {'z','z','z','z','z','z','z','z'}};
        byte[][] c = new byte[][]{
                {'z','z','z','z','z','z','z','z'},
                {'z','z','4','0','z','z','z','z'},
                {'z','z','0','0','0','0','z','z'},
                {'z','z','z','2','z','0','z','z'},
                {'z','1','z','0','z','0','0','z'},
                {'z','3','0','0','0','z','0','z'},
                {'z','1','0','2','0','0','0','z'},
                {'z','z','z','z','z','z','z','z'}};
        Point point = new Point(b);
        Point point2 = new Point(c);
        point.printMap();
        point2.printMap();
        System.out.println(point.equals(point2));
    }
}
 