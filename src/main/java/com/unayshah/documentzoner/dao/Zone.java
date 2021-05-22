package com.unayshah.documentzoner.dao;

import java.util.UUID;

public class Zone {
    private int x;
    private int y;
    private int w;
    private int h;
    private String content;
    private String id;

    public Zone() {
        this(0, 0, 0, 0, "");
    }

    public Zone(Zone zone){
        this(zone.getX(), zone.getY(), zone.getW(), zone.getH(), zone.getContent());
        this.id = zone.getId();
    }

    public Zone(int x, int y, int w, int h, String content) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.content = content;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Zone [content=" + content + ", h=" + h + ", w=" + w + ", x=" + x + ", y=" + y + "]";
    }

}
