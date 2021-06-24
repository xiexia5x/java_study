package com.heima.pojo2;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;

    private String userName;

    private Byte sex;

    private Date birthday;

    private Date created;

    private Date modified;

    private static final long serialVersionUID = 1L;

    public User(Long id, String userName, Byte sex, Date birthday, Date created, Date modified) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.created = created;
        this.modified = modified;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append("]");
        return sb.toString();
    }
}