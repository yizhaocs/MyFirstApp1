package com.example.myfirstapp;

import java.io.Serializable;

/**
 * Created by yizhao on 12/8/14.
 */
public class Encode implements Serializable {
    private long downTime = -1;
    private long eventTime = -1;
    private int action = -1;
    private float x = -1;
    private float y = -1;
    private int metaState = -1;

    public Encode(long downTime, long eventTime, int action, float x, float y, int metaState) {
        this.downTime = downTime;
        this.eventTime = eventTime;
        this.action = action;
        this.x = x;
        this.y = y;
        this.metaState = metaState;
    }

    public long getDownTime() {
        return downTime;
    }

    public long getEventTime() {
        return eventTime;
    }

    public int getAction() {
        return action;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getMetaState() {
        return metaState;
    }
}
