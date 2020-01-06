drop table if exists study_node;
drop table if exists study;

create table `study` (
   `id` bigint(13) not null auto_increment comment '主键',
   `name` varchar(50) not null comment '学习名称',
   `learned_time` datetime not null comment '第一天学习时间',
   `finish_status` varchar(10) not null comment '状态: 复习中,已完成,已中断',
   `finish_time` datetime default null comment '完成时间',
   primary key (`id`)
 ) engine=innodb auto_increment=1 default charset=utf8 checksum=1 delay_key_write=1 row_format=dynamic comment='学习表'
;
create table `study_node` (
   `id` bigint(12) not null auto_increment comment '主键',
   `node_name` varchar(20) not null comment '节点名称: 日期代号-学习表主键',
   `study_id` bigint(12) not null comment '关联学习主键',
   `date_code` varchar(10) not null comment '日期代号',
   `review_time` datetime not null comment '复习时间',
   `finish_status` varchar(10) not null comment '状态: 待复习,已完成,已中断',
   `finished_time` datetime default null comment '完成时间',
   primary key (`id`),
   key `FK_study_node` (`study_id`),
   constraint `FK_study_node` foreign key (`study_id`) references `study` (`id`)
 ) engine=innodb auto_increment=1 default charset=utf8 checksum=1 delay_key_write=1 row_format=dynamic comment='学习节点表'
