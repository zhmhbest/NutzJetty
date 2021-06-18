# NutzJetty

基于Jetty和Nutzbook的快速启动模板。

## 初始化数据库

```bash
mysql -uroot -proot
```

```SQL
CREATE DATABASE `nutzbook` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';
CREATE USER 'nutz'@'localhost' IDENTIFIED BY 'nutz';
REVOKE ALL ON *.* FROM 'nutz'@'localhost';
GRANT ALL PRIVILEGES ON `nutzbook`.* TO 'nutz'@'localhost';
```

## 启动

```bash
mvn jetty:run
```

- <http://localhost:8080/nutzbook/>
