package cn.yt.oa.dao.impl;

import cn.yt.oa.dao.BaseDao.BaseDaoImpl;
import cn.yt.oa.dao.prDao;
import cn.yt.oa.entity.Privilege;

import java.util.List;

public class priDaoimpl extends BaseDaoImpl<Privilege> implements prDao {


    @Override
    public List<Privilege> toplist() {
        return this.getSessionFactory().getCurrentSession().createSQLQuery("select * From Privilege where parent=0").list();

    }
}
