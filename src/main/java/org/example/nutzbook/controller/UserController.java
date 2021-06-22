package org.example.nutzbook.controller;

import org.example.nutzbook.model.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpSession;

@IocBean
@At("/user")
public class UserController {
    @Inject
    protected Dao dao;

    @At
    @Ok(">>:/user/profile")
    public Boolean login(
            @Param("name") String name,
            @Param("password") String password,
            HttpSession session
    ) {
        User user = dao.fetch(
                User.class,
                Cnd.where("name", "=", name).and("password", "=", password)
        );
        if (null != user) {
            session.setAttribute("name", user.getName());
            return true;
        }
        return false;
    }

    @At
    @Ok("jsp:jsp.profile")
    public void profile(HttpSession session) {
        Object objName = session.getAttribute("name");
        if (null == objName) {
            session.setAttribute("stateText", "Fail!");
        } else {
            session.setAttribute("stateText",
                    String.format("Hello %s", objName.toString())
            );
        }
    }

    @At
    @Ok(">>:/")
    public void logout(HttpSession session) {
        session.setAttribute("name", null);
    }
}