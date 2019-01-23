package cn.yt.oa.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页加载
 */
public class homeaction extends ActionSupport {

    public String top(){
        System.out.println("top页面");
        return "top";
    }

    public String left(){
        return "left";
    }

    public String bottom(){

        return "bottom";
    }

    public String right(){

        return "right";
    }
}
