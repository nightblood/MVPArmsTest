package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class LoginResponse {
    public String action;
    public Body value;
    class Body{
        public String id;
        public String name;
        public String login_key;
    }
}
