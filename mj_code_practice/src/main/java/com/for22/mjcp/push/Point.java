package com.for22.mjcp.push;

import java.util.List;

/**
 * The Type Point
 *
 * @author lx
 * @Description:
 * @Date 2017/8/9
 */
public class Point {

    //        1：是否存在目的地        2：是否存在箱子        4：是否存在人  0:空地  3：箱子在目的地   5：人在目的地

    public static final byte Empty = '0';
    public static final byte Termini = '1';
    public static final byte HasBox = '2';
    public static final byte BoxAtTermini = '3';
    public static final byte HasMan = '4';
    public static final byte ManAtTermini = '5';
    public static final byte Wall = 'z';

    private byte[][] boxMap;

    private List<Point> sons;

    private Man man;

    private Box[] boxs;

    public Point(byte[][] boxMap) {
        initMap(boxMap,-1,-1);
        this.boxMap = boxMap;
    }


    public void printMap(){
        for(byte[] bt : boxMap){
            System.out.println(new String(bt).replaceAll("0"," "));
        }
    }

    private void initMap(byte[][] boxMap,int x,int y){
        if(x < 0) {
            int[] manxy = getFirstXy(boxMap);
            if (null == manxy) {
                System.out.println("地图不合规，没人");
            }
            x = manxy[0];
            y = manxy[1];
            if (x < 1 || y < 1) {
                System.out.println("地图不合规，墙壁不对");
            }
        }
        if(canStep(boxMap[x-1][y])) { boxMap[x-1][y] += 4;initMap(boxMap, x-1, y);}
        if(canStep(boxMap[x+1][y])) { boxMap[x+1][y] += 4;initMap(boxMap, x+1, y);}
        if(canStep(boxMap[x][y-1])) { boxMap[x][y-1] += 4;initMap(boxMap, x, y-1);}
        if(canStep(boxMap[x][y+1])) { boxMap[x][y+1] += 4;initMap(boxMap, x, y+1);}
    }

    private boolean canStep(byte te){
        return te == Empty || te == Termini;
    }

    private int[] getFirstXy(byte[][] boxMap){
        for(int i = 0;i<boxMap.length ;i++){
            byte[] bt = boxMap[i];
            for(int j = 0;j<bt.length;j++){
                byte b = bt[j];
                if(b == HasMan || b == ManAtTermini){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        int i = 1;
        for(byte[] bt :boxMap){
            for(byte b : bt){
                hashCode += (int) (Math.sin(i)*b) ;
                i++;
            }
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Point)){
            return false;
        }
        if(this.hashCode() != obj.hashCode()){
            return false;
        }
        Point p = (Point) obj;
        if(p.boxMap.length == this.boxMap.length){
            for(int i = 0;i<boxMap.length;i++){
                byte[] pbt = p.boxMap[i];
                byte[] bt = p.boxMap[i];
                if(pbt.length == bt.length){
                    for(int j = 0;j<bt.length;j++){
                        if(pbt[j] != bt[j]){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }


    public byte[][] getBoxMap() {
        return boxMap;
    }

    public void setBoxMap(byte[][] boxMap) {
        this.boxMap = boxMap;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Box[] getBoxs() {
        return boxs;
    }

    public void setBoxs(Box[] boxs) {
        this.boxs = boxs;
    }

    public List<Point> getSons() {
        return sons;
    }

    public void setSons(List<Point> sons) {
        this.sons = sons;
    }
}
 