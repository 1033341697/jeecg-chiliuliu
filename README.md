哧溜溜demo（前后端分离版本）
===============

当前最新版本： 1.0.0（发布日期：2022-08-30） 


后台目录结构
-----------------------------------
```
项目结构
├─jeecg-boot-parent			父POM： 项目依赖、modules组织
│  ├─jeecg-boot-base 			共通模块： 基础包、工具类、config、权限、查询过滤器、注解等
│     ├─jeecg-boot-base-api      	对外提供访问api
│     ├─jeecg-boot-base-core     	核心基础包 
│     ├─jeecg-boot-base-tools    	工具服务
│  ├─jeecg-module-system  		系统后台管理
│  ├─cloud-products         		云平台业务模块
│     ├─cloud-risk           		风险分级管控
```

 
技术架构：
-----------------------------------
#### 开发环境

- 语言：Java 8+ (小于17)

- IDE(JAVA)： IDEA (必须安装lombok插件 )

- IDE(前端)： Vscode、WebStorm、IDEA

- 依赖管理：Maven

- 缓存：Redis

- 数据库脚本：MySQL5.7+  &  Oracle 11g & Sqlserver2017


#### 后端

- 基础框架：Spring Boot 2.3.5.RELEASE

- 持久层框架：MybatisPlus 3.4.3.1

- 安全框架：Apache Shiro 1.8.0，Jwt 3.11.0

- 数据库连接池：阿里巴巴Druid 1.1.22

- 日志打印：logback

- 其他：autopoi, fastjson，poi，Swagger-ui，quartz, lombok（简化代码）等。
