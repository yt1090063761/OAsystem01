package cn.yt.oa.action;

import cn.yt.oa.dao.roleDao;
import cn.yt.oa.entity.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public class roleaction extends ActionSupport  {

    private roleDao roleDao;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private Role role;

    public cn.yt.oa.dao.roleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(cn.yt.oa.dao.roleDao roleDao) {
        this.roleDao = roleDao;
    }

    public String list(){
           List<Role> roles=roleDao.list();
        if (roles.size()>0) {
            ServletActionContext.getContext().getSession().put("roleList", roles);
        }
            return "list";
    }
    //跳转到添加页面
    public String saveUI(){

        return "saveUI";
    }


    //保存
    public String save(){
        if (role.getName()!=null&&role.getName()!=""){
            roleDao.save(role);
            return "savesuccess";
        }

        return "saveUI";
    }

    public  String Delete(){
       // System.out.println(role.getRid());
        roleDao.detele(role);
        return "savesuccess";
    }
    public  String UpdateUI(){
        //大于0，说明有id
        if(role.getRid()>0){
            System.out.println("cha"+role.getRid());
            ServletActionContext.getContext().getSession().put("updaterole",  roleDao.byid(role));
        }
        return "UpdateUI";
    }

    public  String update(){

        roleDao.update(role);

        return "updateSUCCESS";
    }

}
