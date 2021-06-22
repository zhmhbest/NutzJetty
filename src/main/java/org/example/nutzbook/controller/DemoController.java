package org.example.nutzbook.controller;

import org.example.nutzbook.model.User;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
@At("/demo")
public class DemoController {
    @Inject
    protected Dao dao;

    /**
     * 自定义SQL
     */
    @At("/sql")
    @Ok("json")
    public Object testDaoSql() {
        Sql sql = Sqls.create("SELECT * FROM `tbl_user`;");
        sql.setCallback(Sqls.callback.entities());
        sql.setEntity(dao.getEntity(User.class));
        dao.execute(sql);
        return sql.getList(User.class);  // List<User>
    }
}
