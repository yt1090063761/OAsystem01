package cn.yt.oa.dao.BaseDao;

import cn.yt.oa.dao.BaseDao.BaseDao;
import cn.yt.oa.entity.Privilege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 该类是所有dao实现类的父类
 * 包含的都是通用方法
 * 通过反射来实现获取实际的类型
 * @param <T>
 */
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Resource
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private Class<T> aClass;

    public  BaseDaoImpl(){//构造
        // 通过反射得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.aClass = (Class) pt.getActualTypeArguments()[0];

        System.out.println("clazz = " + aClass.getName());

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(T entity) {
         this.hibernateTemplate.save(entity);
    }

    @Override
    public void delete(T entity) {
       this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public List<T> list() {
        System.out.println("list方法");
        return  (List<T>) this.getHibernateTemplate().find("from "+aClass.getSimpleName());

    }

    @Override
    public T byidquery(int id) {
        System.out.println("修改");
        return (T) this.getHibernateTemplate().get(aClass,id);

    }

//    protected Session getSession(){
//
//        return this.sessionFactory.getCurrentSession();
//    }


}
