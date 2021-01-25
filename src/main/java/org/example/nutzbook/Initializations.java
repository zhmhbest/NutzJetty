package org.example.nutzbook;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
public class Initializations implements Setup {
    public void init(NutConfig nc) {
        // 若不存在，创建所有数据表
        final String scanPackageName = Initializations.class.getPackage().getName() + ".model";
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, scanPackageName, false);
        // 添加一个默认用户
        if (dao.count(org.example.nutzbook.model.User.class) == 0) {
            org.example.nutzbook.model.User user = new org.example.nutzbook.model.User();
            user.setName("admin");
            user.setPassword("admin");
            dao.insert(user);
        }
    }
    public void destroy(NutConfig nc) { }
}