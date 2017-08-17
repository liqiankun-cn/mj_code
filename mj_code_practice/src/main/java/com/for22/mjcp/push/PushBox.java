package com.for22.mjcp.push;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * The Type PushBox
 *
 * @author lx
 * @Description:
 * @Date 2017/8/9
 */
public class PushBox {

    public static void main(String[] args) {
        pushbox();
    }

    private static void pushbox() {
        long start = System.currentTimeMillis();
//        1：是否存在目的地        2：是否存在箱子        4：是否存在人  0:空地  3：箱子在目的地   5：人在目的地
//        byte[][] b = new byte[][]{
//                {'z','z','z','z','z','z','z','z'},
//                {'z','z','4','0','z','z','z','z'},
//                {'z','z','0','2','0','0','z','z'},
//                {'z','z','z','0','z','0','z','z'},
//                {'z','1','z','0','z','0','0','z'},
//                {'z','1','2','0','0','z','0','z'},
//                {'z','1','0','0','0','2','0','z'},
//                {'z','z','z','z','z','z','z','z'}};
        byte[][] b = new byte[][]{
                {'z','z','z','z','z','z','z','z'},
                {'z','0','0','0','z','1','0','z'},
                {'z','1','0','0','2','0','0','z'},
                {'z','z','2','z','z','0','0','z'},
                {'z','0','0','z','z','2','z','z'},
                {'z','0','0','4','0','0','0','z'},
                {'z','0','1','z','0','0','0','z'},
                {'z','z','z','z','z','z','z','z'}};
//        byte[][] b = new byte[][]{
//                {'z','z','z','z','z','z','z'},
//                {'z','0','1','0','3','0','z'},
//                {'z','0','0','z','0','0','z'},
//                {'z','4','2','3','0','0','z'},
//                {'z','z','0','0','0','z','z'},
//                {'z','z','0','0','0','z','z'},
//                {'z','z','z','z','z','z','z'}};
        Point point = new Point(b,null,-1,-1);
//        point.printMap();
        List<Point.XY> terminis = point.getTerminis();
        List<Wall> walls = point.initWall();
        HashSet<Point> way = new HashSet<>();
        LinkedList<Point> list = new LinkedList<>();
        way.add(point);
        list.add(point);
        Point end = null;
        while(list.size() > 0 && null == end){
            Point temp = list.pop();
            end = temp.push(way,walls,terminis);
            list.addAll(temp.getSons());
        }
        int cout = 0;
        while(null != end){
            System.out.println(end);
            end = end.getParent();
            cout++;
        }
        System.out.println("基数："+way.size());
//        for (Point w:way) {
//            System.out.println(w);
//        }
        System.out.println("步数："+cout);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime -start)+"ms");
    }

    public static byte[][] getMapFromFile(){

        return  null;
    }
}
 