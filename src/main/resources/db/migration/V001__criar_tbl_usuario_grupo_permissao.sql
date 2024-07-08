create table if not exists privilege (
	id bigint not null auto_increment,
	name varchar(100) not null,
	description varchar(60),
	
	primary key (id)
) engine=InnoDB default charset=UTF8MB4;

create table if not exists role (
	id bigint not null auto_increment,
	name varchar(60) not null,
	description varchar(60),
	
	primary key (id)
) engine=InnoDB default charset=UTF8MB4;

create table if not exists role_privilege (
	role_id bigint not null,
	privilege_id bigint not null,
	
	primary key (role_id, privilege_id)
) engine=InnoDB default charset=UTF8MB4;


create table if not exists user (
	id bigint not null auto_increment,
	name varchar(80) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	register_date datetime not null,
	last_access datetime,
	enabled boolean not null default(1),
	validated boolean not null default(0),
	
	primary key (id)
) engine=InnoDB default charset=UTF8MB4;

create table if not exists user_role (
	user_id bigint not null,
	role_id bigint not null,
	
	primary key (user_id, role_id)
) engine=InnoDB default charset=UTF8MB4;

alter table role_privilege add constraint fk__role_privilege2privilege
foreign key (privilege_id) references privilege (id)
on delete cascade
on update cascade;

alter table role_privilege add constraint fk__role_privilege2role
foreign key (role_id) references role (id)
on delete cascade
on update cascade;

alter table user_role add constraint fk__user_role2user
foreign key (user_id) references user(id)
on delete cascade
on update cascade;

alter table user_role add constraint fk__user_role2role
foreign key (role_id) references role(id)
on delete cascade
on update cascade;