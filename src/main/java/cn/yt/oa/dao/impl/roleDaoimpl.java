package cn.yt.oa.dao.impl;


import cn.yt.oa.dao.roleDao;
import cn.yt.oa.entity.Dept;
import cn.yt.oa.entity.Role;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class roleDaoimpl extends HibernateDaoSupport implements roleDao {

    @Override
    //返回岗位列表
    public List<Role> list() {
        return (List<Role>)this.getHibernateTemplate().find("from Role ");
    }

    @Override
    public void save(Role role) {
        System.out.println("savedao");
        this.getHibernateTemplate().save(role);
    }

    @Override
    public void detele(Role role) {
        this.getHibernateTemplate().delete(role);
    }

    @Override
    public Role byid(Role role) {
        return (Role) this.getHibernateTemplate().find("from Role where rid=?",role.getRid()).get(0);
    }

    @Override
    public void update(Role role) {
        this.getHibernateTemplate().update(role);
    }


}
