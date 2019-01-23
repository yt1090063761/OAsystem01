package cn.yt.oa.dao.impl;


import cn.yt.oa.dao.BaseDao.BaseDaoImpl;
import cn.yt.oa.dao.userDao;
import cn.yt.oa.entity.Privilege;
import cn.yt.oa.entity.User;
import cn.yt.oa.entity.UserPri;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class userDaoimpl extends BaseDaoImpl<User> implements userDao {


    @Override
    public List<User> login(User user) {
       // System.out.println(user.getLoginname());
       return (List<User>) this.getHibernateTemplate().find("from User where loginname=? and password=?",user.getLoginname(),user.getPassword());

    }

    @Override
    public User ByLoginName(User user) {
        System.out.println("byname方法");
        this.getHibernateTemplate().find("from User where loginname=?",user.getLoginname()).get(0);
        return null;
    }

    @Override
    /*
    设置用户权限
     */
    public List<UserPri> FindUserPri(int id) {
        String hql;
        if (id > 0) {
            return (List<UserPri>) this.getHibernateTemplate().find("from UserPri where userid=?", id);

        } else {
            return (List<UserPri>) this.getHibernateTemplate().find("from UserPri");

        }


    }


}
