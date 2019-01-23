package cn.yt.oa.dao.BaseDao;


import cn.yt.oa.entity.Privilege;

import java.util.List;

public interface BaseDao<T> {

    void save(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> list();
    T byidquery(int id);
//    public List<Privilege> getprivileges();
}
