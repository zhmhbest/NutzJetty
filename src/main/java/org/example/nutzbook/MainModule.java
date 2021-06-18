/*
 * 入口文件
 */
package org.example.nutzbook;
import org.nutz.mvc.annotation.*;
@Ok("json:full")                                // 所有控制器默认返回JSON
@SetupBy(value = Initializations.class)         // 初始化模块
@IocBy(args = {                                 // 整个应用将采用何种方式构建 Ioc 容器
        "*js", "ioc/",                          // 加载配置
        "*anno", "org.example.nutzbook",        // 登记该包下所有带@IocBean的类
        "*tx",                                  // 事务拦截AOP
        "*async"                                // 异步执行AOP
})
// @Modules(scanPackage=true)
@Modules()
public class MainModule { }
