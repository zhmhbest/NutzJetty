package org.example.nutzbook.model;

import org.nutz.dao.entity.annotation.*;

@Table("tbl_user")
public class User {
    @Id
    private long id;
    @Name
    @Comment("用户名")
    private String name;
    @Column("password")
    @Comment("密码")
    private String password;

    // ■■■■■■■■■■■■■■■■ ■■■■■■■■■■■■■■■■ ■■■■■■■■■■■■■■■■ ■■■■■■■■■■■■■■■■

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}