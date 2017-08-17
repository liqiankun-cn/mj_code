package com.for22.mjcp.push;

/**
 * The Type Wall
 *
 * @author lx
 * @Description:
 * @Date 2017/8/11
 */
class Wall {
    boolean isX;
    int begin;
    int end;
    int lineN;
    int terminiCount;

    public Wall() {
    }

    public Wall(boolean isX, int begin, int end, int lineN, int terminiCount) {
        this.isX = isX;
        this.begin = begin;
        this.end = end;
        this.lineN = lineN;
        this.terminiCount = terminiCount;


    }

    @Override
    public String toString() {
        return "Wall{" +
                "isX=" + isX +
                ", begin=" + begin +
                ", end=" + end +
                ", lineN=" + lineN +
                ", terminiCount=" + terminiCount +
                '}';
    }
}
 