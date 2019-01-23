package cn.yt.oa.action;


import cn.yt.oa.dao.deptDao;
import cn.yt.oa.entity.Dept;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import javax.xml.ws.Response;
import java.io.PrintWriter;
import java.util.List;


public class deptaction extends ActionSupport {
    private deptDao deptDao;
    private String jsonresult;

    public String getJsonresult() {
        return jsonresult;
    }

    public void setJsonresult(String jsonresult) {
        this.jsonresult = jsonresult;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    private Dept dept;

    public cn.yt.oa.dao.deptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(deptDao deptDao) {
        this.deptDao = deptDao;
    }

    public String list() throws Exception {
        System.out.println("action");

        ServletActionContext.getContext().getSession().put("deptlist", deptDao.list());

        return "list";
    }

    //跳转到保存页面
    public String saveUI() {

        return "saveUI";
    }

    public String save() {
        deptDao.save(dept);

        return "savesuccess";
    }

    public String delete() {
        // System.out.println("ss");
        deptDao.delete(dept);

        return "deletesuccess";
    }

    public String updateUI() {
        Dept dd = deptDao.byidquery(dept.getDid());
        System.out.println(dd.getName());
        ServletActionContext.getContext().getSession().put("deptt", dd);
        return "updateUI";
    }

    public String update() {
        deptDao.update(dept);
        //产生一个bug，当修改完的时候，dept的id没有清除，当保存的时候，就会使用该id值，报错主键重复，
        //因此赋值为0；0=null
        dept.setDid(0);
        return "updatesuccess";
    }

    public String deptlist() throws Exception {

        System.out.println("s");
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(deptDao.list()));
        jsonresult=jsonArray.toString();
        return SUCCESS;
    }
}
