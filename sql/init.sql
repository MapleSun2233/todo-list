create database if not exists todo_list;

use todo_list;

create table if not exists t_group
(
    id int primary key auto_increment comment "id",
    name varchar(20) not null comment "分组名",
    icon_id int not null comment "图标id"
) comment "分组表";

create table if not exists t_icon
(
    id int primary key auto_increment comment "id",
    url varchar(255) not null comment "图标url"
) comment "图标表";

create table if not exists t_task
(
    id int primary key auto_increment comment "id",
    name varchar(20) not null comment "任务名称",
    description varchar(255) comment "任务描述",
    is_completed boolean default false comment "是否完成",
    is_star boolean default false comment "是否星标",
    create_time datetime default current_timestamp comment "创建时间",
    update_time datetime default current_timestamp comment "更新时间",
    group_id int not null comment "分组id"
) comment "任务表";

