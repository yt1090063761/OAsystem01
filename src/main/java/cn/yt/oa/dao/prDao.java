package cn.yt.oa.dao;

import cn.yt.oa.dao.BaseDao.BaseDao;
import cn.yt.oa.entity.Privilege;

import java.util.List;

public interface prDao extends BaseDao<Privilege> {
public List<Privilege> toplist();

}
