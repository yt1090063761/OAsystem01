package cn.yt.oa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_pri", schema = "oadatabase", catalog = "")
public class UserPri {
    private int id;
    private int userid;
    private int privilegeid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "privilegeid")
    public int getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(int privilegeid) {
        this.privilegeid = privilegeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPri userPri = (UserPri) o;
        return id == userPri.id &&
                userid == userPri.userid &&
                privilegeid == userPri.privilegeid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userid, privilegeid);
    }
}
