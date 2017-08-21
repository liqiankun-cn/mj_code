package com.for22.mjcp.push;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.*;

/**
 * The Type PushBox
 *
 * @author lx
 * @Description:
 * @Date 2017/8/9
 */
public class PushBox {

    public static void main(String[] args) {
        int stage = 10;
        byte[][] map = getMapFromFile(stage);
        if(null != map) {
            for (byte[] b : map) {
                if(null != b) {
                    System.out.println(new String(b));
                }
            }
//            System.out.println(map.length);
        }
        pushbox(map,stage);
    }

    private static void pushbox(byte[][] b,int stage) {
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
//        byte[][] b = new byte[][]{
//                {'z','z','z','z','z','z','z','z'},
//                {'z','0','0','0','z','1','0','z'},
//                {'z','1','0','0','2','0','0','z'},
//                {'z','z','2','z','z','0','0','z'},
//                {'z','0','0','z','z','2','z','z'},
//                {'z','0','0','4','0','0','0','z'},
//                {'z','0','1','z','0','0','0','z'},
//                {'z','z','z','z','z','z','z','z'}};
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
        //终点是固定的，所以抽出来
        List<Point.XY> terminis = point.getTerminis();
        //墙也是固定的
        List<Wall> walls = point.initWall();
        //记录遍历的子地图
        HashSet<Point> way = new HashSet<>();
        //待遍历的子地图
        LinkedList<Point> list = new LinkedList<>();
        way.add(point);
        list.add(point);
        Point end = null;//终点子地图
        //广度优先遍历，计算箱子可推动的方向，并且推动后不是死局，则加入带遍历的list中
        while(list.size() > 0 && null == end){
            Point temp = list.pop();
            end = temp.push(way,walls,terminis);
            list.addAll(temp.getSons());
        }
        int cout = 0;
        //通过终点子地图逆向获取parent得出路径
        while(null != end){
            writeAnswer(stage,end.toString()+"\n");
            System.out.println(end);
            end = end.getParent();
            cout++;
        }
        writeAnswer(stage,"\n基数："+way.size());
        System.out.println("基数："+way.size());
//        for (Point w:way) {
//            System.out.println(w);
//        }
        writeAnswer(stage,"\n步数："+cout);
        System.out.println("步数："+cout);
        long endTime = System.currentTimeMillis();
        writeAnswer(stage,"\n耗时："+(endTime -start)+"ms");
        System.out.println("耗时："+(endTime -start)+"ms");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

//        System.out.println("heap max:"+changeMem(memoryMXBean.getHeapMemoryUsage().getMax()));
//        System.out.println("heap init:"+changeMem(memoryMXBean.getHeapMemoryUsage().getInit()));
        writeAnswer(stage,"\nheap used:"+changeMem(memoryMXBean.getHeapMemoryUsage().getUsed()));
        System.out.println("heap used:"+changeMem(memoryMXBean.getHeapMemoryUsage().getUsed()));
//        System.out.println("non heap init:"+changeMem(memoryMXBean.getNonHeapMemoryUsage().getInit()));
        writeAnswer(stage,"\nnon heap used:"+changeMem(memoryMXBean.getNonHeapMemoryUsage().getUsed()));
        System.out.println("non heap used:"+changeMem(memoryMXBean.getNonHeapMemoryUsage().getUsed()));
    }

    public static byte[][] getMapFromFile(int stage){
        byte[][] result ;
//        Path path = Paths.get("D:\\pers\\stu\\pushbox",stage+".txt");
        Path path = Paths.get("mj_code_practice/src/main/static",stage+".txt");
        try {
            System.out.println(path.toRealPath().toString());
            List<String> list = Files.readAllLines(path);
            result = new byte[list.size()][];
            for(int i = 0 ;i<list.size();i++){
                String s = list.get(i);
                if(StringUtils.isNotEmpty(s)){
                    byte[] b = s.getBytes();
                    result[i] = b;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return  result;
    }

    private static String changeMem(long mem){
        Map<Integer,String> mapped = new HashMap<Integer, String>(){{put(0,"b");put(1,"B");put(2,"M");put(3,"G");}};
        int i = 0;
        while(mem > 1024){
            mem = mem/1024;
            i++;
        }
        return mem+mapped.get(i);
    }

    private static void writeAnswer(int stage,String content){
        Path path = Paths.get("mj_code_practice/src/main/static",stage+"_answer.txt");
        File f = new File(path.toUri());
        if(!f.exists()){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write( path,content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
 