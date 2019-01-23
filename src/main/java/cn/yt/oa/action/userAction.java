package cn.yt.oa.action;

import cn.yt.oa.dao.prDao;
import cn.yt.oa.dao.userDao;
import cn.yt.oa.entity.Privilege;
import cn.yt.oa.entity.User;
import cn.yt.oa.entity.UserPri;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class userAction extends ActionSupport {
@Autowired
    public userDao userdao;
    public User user;
    public prDao prDao;

    public cn.yt.oa.dao.prDao getPrDao() {
        return prDao;
    }

    public void setPrDao(cn.yt.oa.dao.prDao prDao) {
        this.prDao = prDao;
    }

    public String getCheckname() {
        return checkname;
    }

    public void setCheckname(String checkname) {
        this.checkname = checkname;
    }

    private String checkname;

    public userDao getUserdao() {
        return userdao;
    }

    public void setUserdao(userDao userdao) {
        this.userdao = userdao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String test(){
       // System.out.println("action");
        return "tc";
    }

    //用户登陆
    public String login(){

        List<User> userList=userdao.login(user);
      if(userList.get(0)!=null){
        ActionContext.getContext().getSession().put("user",userList.get(0));
          return  "loginsuccess";
      }else {

          return "loginfail";
      }

    }
    //用户列表
    public  String list(){
        //System.out.println("222");
        List<User> userList=userdao.list();
       //System.out.println("用户集合长度+"+userList.size());
        ActionContext.getContext().put("ulist",userList);
        return "list";
    }


    //注销
    public  String quit(){
        System.out.println("退出系统");
        ActionContext.getContext().getSession().remove("user");
        return "quit";
    }

    //
    public  String saveUI(){

        return "saveUI";
    }

    public String  save (){
        userdao.save(user);
        return "savesuccess";
    }

    public String checkloginname() throws Exception{
        System.out.println("name is "+user.getLoginname());
        User u= userdao.ByLoginName(user);
        System.out.println(u.getName());
        Map map=new HashMap();
        JSONObject object=JSON.parseObject("可以使用该登陆名");
        checkname=object.toString();

        if(u==null){
         //该登录名可用
            checkname= JSON.toJSONString(map.put("result","可以使用该登陆名")) ;
           return SUCCESS;

        }
           checkname= JSON.toJSONString(map.put("result","该登陆名已存在")) ;
            return SUCCESS;



    }
    //权限设置，从岗位的的权限设置，改成为单独的用户设置权限
    public  String setPrivilegeUI(){

           //最顶层的目录
          List<Privilege> prilist= prDao.toplist();
          System.out.println(prilist.size());
          ServletActionContext.getContext().getSession().put("toplist",prilist);

         //第二层  部门管理

        //第三层  部门的增删改


        return "setPrivilegeUI";
    }
}
