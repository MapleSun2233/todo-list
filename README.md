## 工程简介
- TodoList应用
- 后端技术栈：Spring Boot + Mybatis Plus + Mysql
- 前端技术栈：React + TypeScript + Vite
## Docker Compose部署
1. 命令行终端进入`/docker`目录
2. `docker compose up -d`一键部署
3. 访问localhost即可
## 二次开发部署
### 后端开发模式部署提示
1. 使用`/sql/init.sql`初始化数据库
2. 修改`application.yaml`中数据库相关配置
### 前端开发模式部署提示
1. 命令行进入`/web-ui`路径
2. `yarn`安装依赖
3. `yarn dev`启动开发调试