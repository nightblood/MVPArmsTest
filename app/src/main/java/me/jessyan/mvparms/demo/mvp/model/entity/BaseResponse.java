package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class BaseResponse {

    private String action;
    private Object value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
