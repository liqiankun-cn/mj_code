package com.for22.mjcp.push;

import java.util.List;

/**
 * The Type Box
 *
 * @author lx
 * @Description:
 * @Date 2017/8/9
 */
public class Box {

    private int x ;
    private int y;

    public Box() {
    }

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private List canPush;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List getCanPush() {
        return canPush;
    }

    public void setCanPush(List canPush) {
        this.canPush = canPush;
    }
}
 