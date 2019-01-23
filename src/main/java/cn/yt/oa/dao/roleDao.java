package cn.yt.oa.dao;

import cn.yt.oa.entity.Role;

import java.util.List;

public interface roleDao {
    public List<Role> list();
    public void save(Role role);
    public void detele(Role role);
    public Role byid(Role role);

    public void update(Role role);

}
