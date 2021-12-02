--创建用户
CREATE USER manager WITH PASSWORD 'manager';
--创建数据库
CREATE DATABASE manager OWNER manager;
--授权
GRANT ALL PRIVILEGES ON DATABASE manager TO manager;
