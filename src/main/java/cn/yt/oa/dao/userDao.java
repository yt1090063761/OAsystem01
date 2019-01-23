package cn.yt.oa.dao;

import cn.yt.oa.dao.BaseDao.BaseDao;
import cn.yt.oa.entity.Privilege;
import cn.yt.oa.entity.User;
import cn.yt.oa.entity.UserPri;

import java.util.List;

public interface userDao extends BaseDao<User> {
    public List<User> login(User user);
    public User ByLoginName(User user);
    public List<UserPri> FindUserPri(int id);

}
