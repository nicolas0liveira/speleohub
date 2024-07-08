set foreign_key_checks = 0;

delete from role;
delete from role_privilege;
delete from privilege;
delete from user;
delete from user_role;

set foreign_key_checks = 1;

alter table role auto_increment = 1;
alter table privilege auto_increment = 1;
alter table user auto_increment = 1;

insert into privilege (id, name, description) values
 (1, 'CONSULTAR_USUARIO', 'Permite consultar users')
,(2, 'GERENCIAR_USUARIO', 'Permite criar, alterar e remover users')
,(3, 'CONSULTAR_ATIVIDADE', 'Permite consultar atividades')
,(4, 'GERENCIAR_ATIVIDADE', 'Permite criar, alterar e remover atividades')
;

insert into role (id, name, description) values
(1, 'Administrador',null),(2, 'Sócio',null), (3, 'Visitante',null)
;

insert into role_privilege (role_id, privilege_id) values
(1, 1), (1, 2), (2, 1), (2, 3), (3, 3);

insert into user (id, name, email, password, register_date,last_access,enabled,validated) values
(1, 'Mr Spliter', 'nk.oliveira+spliter@gmail.com', '123', utc_timestamp, utc_timestamp,true,true)
,(2, 'Michelangelo', 'nk.oliveira+michelangelo@gmail.com', '123', utc_timestamp, null,true,false)
,(3, 'Lonardo', 'nk.oliveira+leonardo@gmail.com', '123', utc_timestamp, null,false,true)
,(4, 'Rafael', 'nk.oliveira+rafael@gmail.com', '123', utc_timestamp, null,true,true)
,(5, 'Donatelo', 'nk.oliveira+donatelo@gmail.com', '123', utc_timestamp, null,true,true)
;

insert into user_role (user_id, role_id) values
(1, 1), (1, 2), (2, 2);