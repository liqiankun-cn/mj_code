package com.for22.mjcp.push;

import java.util.*;

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

    private List<XY> manlist;//人可达的位置

    private byte[][] boxMap;//地图

    private List<Point> sons;//子地图

    private List<XY> boxs;//箱子位置
//
    private List<XY> turnels;//角落 // TODO: 2017/8/17 可优化，角落是固定的

    private XY man;//人的位置

    private Point parent;//父地图

    public Point(byte[][] boxMap,Point parent,int x,int y) {
        sons = new ArrayList<>();
        manlist = new ArrayList<>();
        boxs = new ArrayList<>();
        turnels = new ArrayList<>();
        this.parent = parent;
        this.boxMap = boxMap;
        initMap(boxMap);
        if(x>1 && y>1) {
            man = new XY(x, y);
        }else{
            man = manlist.get(0);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(byte[] bt : boxMap){
            sb.append(new String(bt).replaceAll("0"," ")).append("\n");
        }
        return sb.toString();
    }

    private void initMap(byte[][] boxMap){
        getFirstXy(boxMap);

        for(int i=0 ;i<manlist.size() ;i++) {
            XY t = manlist.get(i);
            if (canStep(boxMap[t.x - 1][t.y])) {
//                boxMap[t.x - 1][t.y] += 4;
                XY up = new XY(t.x-1,t.y);
                if(!manlist.contains(up)) {
                    manlist.add(up);
                }
            }
            if (canStep(boxMap[t.x + 1][t.y])) {
//                boxMap[t.x + 1][t.y] += 4;
//                manlist.add(new XY(t.x+1,t.y));
                XY up = new XY(t.x+1,t.y);
                if(!manlist.contains(up)) {
                    manlist.add(up);
                }
            }
            if (canStep(boxMap[t.x][t.y - 1])) {
//                boxMap[t.x][t.y - 1] += 4;
//                manlist.add(new XY(t.x,t.y-1));
                XY up = new XY(t.x,t.y-1);
                if(!manlist.contains(up)) {
                    manlist.add(up);
                }
            }
            if (canStep(boxMap[t.x][t.y + 1])) {
//                boxMap[t.x][t.y + 1] += 4;
//                manlist.add(new XY(t.x,t.y+1));
                XY up = new XY(t.x,t.y+1);
                if(!manlist.contains(up)) {
                    manlist.add(up);
                }
            }
        }
    }

    private boolean canStep(byte te){
        return te == Empty || te == Termini;
    }

    private void getFirstXy(byte[][] boxMap){
        for(int i = 0;i<boxMap.length ;i++){
            byte[] bt = boxMap[i];
            for(int j = 0;j<bt.length;j++){
                byte b = bt[j];
                XY e = new XY(i, j);
                if(b == HasMan || b == ManAtTermini){
                    manlist.add(e);
                }
                if(b == HasBox || b == BoxAtTermini){
                    boxs.add(e);
                }
                if(isTurnal(i,j)){
                    turnels.add(e);
                }
            }
        }
        return ;
    }

    public List<XY> getTerminis(){
        List<XY> terminis = new ArrayList<>();
        for(int i = 0;i<boxMap.length ;i++){
            byte[] bt = boxMap[i];
            for(int j = 0;j<bt.length;j++) {
                byte b = bt[j];
                if(b == Termini || b == ManAtTermini || b == BoxAtTermini){
                    terminis.add(new XY(i,j));
                }
            }
        }
        return terminis;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        int i = 1;
        for(byte[] bt :boxMap){
            for(byte b : bt){
                hashCode += i ^ (hashCode<<(b%10));
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

    public Point push(HashSet<Point> list,List<Wall> walls,List<XY> terminis){
        int i = 3;
        Point p = null;
        for(XY b : boxs){
            XY up = new XY(b.x-1,b.y);
            if(manlist.contains(up)
                    &&(boxMap[b.x+1][b.y] != Wall && boxMap[b.x+1][b.y] != HasBox && boxMap[b.x+1][b.y] != BoxAtTermini)){
                p = push(list, walls, terminis, b.x,b.y,b.x+1,b.y);
                if(null != p) return p;
            }
            XY down = new XY(b.x+1,b.y);
            if(manlist.contains(down)
                    &&(boxMap[b.x-1][b.y] != Wall && boxMap[b.x-1][b.y] != HasBox && boxMap[b.x-1][b.y] != BoxAtTermini)){
                p = push(list, walls, terminis, b.x,b.y,b.x-1,b.y);
                if(null != p) return p;
            }
            XY left = new XY(b.x,b.y-1);
            if(manlist.contains(left)
                    &&(boxMap[b.x][b.y+1] != Wall && boxMap[b.x][b.y+1] != HasBox && boxMap[b.x][b.y+1] != BoxAtTermini)){
                p = push(list, walls, terminis, b.x,b.y,b.x,b.y+1);
                if(null != p) return p;
            }
            XY right = new XY(b.x,b.y+1);
            if(manlist.contains(right)
                    &&(boxMap[b.x][b.y-1] != Wall && boxMap[b.x][b.y-1] != HasBox && boxMap[b.x][b.y-1] != BoxAtTermini)){
                p = push(list, walls, terminis, b.x,b.y,b.x,b.y-1);
                if(null != p) return p;
            }
        }
        return null;
    }

    private Point push(HashSet<Point> list, List<Wall> walls, List<XY> terminis, int x,int y,int nx,int ny) {
        byte[][] nb = mapClone(boxMap);
        //box move
        nb[x][y] = (byte) (nb[x][y]-2 );
        if(nb[nx][ny] > BoxAtTermini){
            nb[nx][ny] = (byte) (nb[nx][ny] - 4 + 2);
        }else{
            nb[nx][ny] = (byte) (nb[nx][ny] + 2);
        }
        //man move
        nb[man.x][man.y] = (byte) (nb[man.x][man.y]-4);
        nb[x][y] = (byte) (nb[x][y]+4 );
        Point sonU = new Point(nb,this,x,y);
        if(!sonU.isDead(walls,terminis) && !list.contains(sonU)){
            sons.add(sonU);
            list.add(sonU);
            if(sonU.isFinished(terminis)){
                return sonU;
            }
        }
        return null;
    }

    public boolean isFinished(List<XY> terminis){
        for(XY t : terminis){
            if(boxMap[t.x][t.y] != BoxAtTermini){
                return false;
            }
        }
        return true;
    }

    public boolean isDead(List<Wall> walls,List<XY> terminis){
        for(int i=0;i<boxs.size();i++){
            XY boxi = boxs.get(i);
            if(!terminis.contains(boxi) && isTurnal(boxi.x,boxi.y)){
                return true;
            }
        }
        for(Wall w : walls){
            int boxNum = 0;
            for(int i = w.begin;i<=w.end;i++){
                if (w.isX){
                    if(boxMap[w.lineN][i] == BoxAtTermini || boxMap[w.lineN][i] == HasBox) boxNum++;
                }
                else {
                    if(boxMap[i][w.lineN] == BoxAtTermini || boxMap[i][w.lineN] == HasBox) boxNum++;
                }
            }
            if(boxNum > w.terminiCount){
                return true;
            }
        }
        return false;
    }

    public boolean isTurnal(int x,int y){
        return boxMap[x][y] != Wall && ((boxMap[x-1][y] == Wall && boxMap[x][y-1] == Wall)
                || (boxMap[x][y-1] == Wall && boxMap[x+1][y] == Wall)
                || (boxMap[x+1][y] == Wall && boxMap[x][y+1] == Wall)
                || (boxMap[x][y+1] == Wall && boxMap[x-1][y] == Wall));
    }

    public List<Wall> initWall(){
        List<Wall> walls = new ArrayList<>();
        for(int i = 0;i<turnels.size();i++){
            XY xyi = turnels.get(i);
            for(int j=i+1;j<turnels.size();j++){
                XY xyj = turnels.get(j);
                if(xyi.x == xyj.x){
                    boolean xWall = true;
                    boolean xUWall = true;
                    boolean xDWall = true;
                    for(int k=xyi.y;k<=xyj.y;k++){
                        if(boxMap[xyi.x-1][k] != Wall){
                            xUWall = false;
                            break;
                        }
                    }
                    for (int k = xyi.y; k <= xyj.y; k++) {
                        if (boxMap[xyi.x + 1][k] != Wall) {
                            xDWall = false;
                            break;
                        }
                    }
                    for (int k = xyi.y; k <= xyj.y; k++) {
                        if (boxMap[xyi.x][k] == Wall) {
                            xWall = false;
                            break;
                        }
                    }
                    if((xDWall ||xUWall) && xWall) {
                        int terminiNum = 0;
                        for (int k = xyi.y; k <= xyj.y; k++) {
                            if (boxMap[xyi.x][k] == Termini || boxMap[xyi.x][k] == BoxAtTermini || boxMap[xyi.x][k] == ManAtTermini) terminiNum++;
                        }
                        walls.add(new Wall(true, xyi.y, xyj.y, xyi.x, terminiNum));
                    }
                }
                if(xyi.y == xyj.y){
                    boolean yWall = true;
                    boolean yLWall = true;
                    boolean yRWall = true;
                    for(int k=xyi.x;k<=xyj.x;k++){
                        if(boxMap[k][xyi.y-1] != Wall) {
                            yLWall = false;
                            break;
                        }
                    }
                    for (int k = xyi.x; k <= xyj.x; k++) {
                        if (boxMap[k][xyi.y+1] != Wall) {
                            yRWall = false;
                            break;
                        }
                    }
                    for (int k = xyi.x; k <= xyj.x; k++) {
                        if (boxMap[k][xyi.y] == Wall) {
                            yWall = false;
                            break;
                        }
                    }
                    if((yLWall || yRWall) && yWall) {
                        int terminiNum = 0;
                        for (int k = xyi.x; k <= xyj.x; k++) {
                            if (boxMap[k][xyi.y] == Termini || boxMap[k][xyi.y] == BoxAtTermini || boxMap[k][xyi.y] == ManAtTermini) terminiNum++;
                        }
                        walls.add(new Wall(false, xyi.x, xyj.x, xyi.y, terminiNum));
                    }
                }

            }
        }
        return walls;
    }

    private byte[][] mapClone(byte[][] o){
        byte[][] b = new byte[o.length][];
        for(int i = 0;i<o.length;i++){
            b[i] = o[i].clone();
        }
        return b;
    }


    public byte[][] getBoxMap() {
        return boxMap;
    }

    public void setBoxMap(byte[][] boxMap) {
        this.boxMap = boxMap;
    }

    public List<Point> getSons() {
        return sons;
    }

    public void setSons(List<Point> sons) {
        this.sons = sons;
    }

    public List<XY> getBoxs() {
        return boxs;
    }

    public List<XY> getTurnels() {
        return turnels;
    }

    public Point getParent() {
        return parent;
    }

    class XY {

        private int x;
        private int y;

        public XY() {
        }

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x*10+y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(!(obj instanceof XY)){
                return false;
            }
            if(this.hashCode() != obj.hashCode()){
                return false;
            }
            XY t = (XY)obj;
            return x == t.x && y == t.y;
        }

        @Override
        public String toString() {
            return "XY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
 