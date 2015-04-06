# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table community (
  id                        bigint not null,
  title                     varchar(255),
  description               varchar(255),
  tags                      varchar(255),
  constraint pk_community primary key (id))
;

create table fund (
  id                        bigint not null,
  dateoffunding             timestamp,
  amount                    double,
  proje_id                  bigint not null,
  funder_id                 bigint not null,
  constraint pk_fund primary key (id))
;

create table project (
  id                        bigint not null,
  post_date                 timestamp,
  title                     varchar(255),
  description               varchar(255),
  rating                    double,
  total_fund                double,
  counter                   integer,
  target                    double,
  longitude                 double,
  latitude                  double,
  initiator_id              bigint not null,
  mycommunity_id            bigint not null,
  constraint pk_project primary key (id))
;

create table review (
  id                        bigint not null,
  content                   varchar(255),
  post_date                 timestamp,
  proj_id                   bigint not null,
  author_id                 bigint not null,
  constraint pk_review primary key (id))
;

create table tag (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;

create table user (
  id                        bigint not null,
  picture                   varbinary(1048576),
  birthdate                 timestamp,
  email                     varchar(255),
  password                  varchar(255),
  rating                    double,
  counter                   integer,
  name                      varchar(255),
  lastname                  varchar(255),
  constraint pk_user primary key (id))
;


create table community_user (
  community_id                   bigint not null,
  user_id                        bigint not null,
  constraint pk_community_user primary key (community_id, user_id))
;

create table tag_community (
  tag_id                         bigint not null,
  community_id                   bigint not null,
  constraint pk_tag_community primary key (tag_id, community_id))
;
create sequence community_seq;

create sequence fund_seq;

create sequence project_seq;

create sequence review_seq;

create sequence tag_seq;

create sequence user_seq;

alter table fund add constraint fk_fund_proje_1 foreign key (proje_id) references project (id) on delete restrict on update restrict;
create index ix_fund_proje_1 on fund (proje_id);
alter table fund add constraint fk_fund_funder_2 foreign key (funder_id) references user (id) on delete restrict on update restrict;
create index ix_fund_funder_2 on fund (funder_id);
alter table project add constraint fk_project_initiator_3 foreign key (initiator_id) references user (id) on delete restrict on update restrict;
create index ix_project_initiator_3 on project (initiator_id);
alter table project add constraint fk_project_mycommunity_4 foreign key (mycommunity_id) references community (id) on delete restrict on update restrict;
create index ix_project_mycommunity_4 on project (mycommunity_id);
alter table review add constraint fk_review_proj_5 foreign key (proj_id) references project (id) on delete restrict on update restrict;
create index ix_review_proj_5 on review (proj_id);
alter table review add constraint fk_review_author_6 foreign key (author_id) references user (id) on delete restrict on update restrict;
create index ix_review_author_6 on review (author_id);



alter table community_user add constraint fk_community_user_community_01 foreign key (community_id) references community (id) on delete restrict on update restrict;

alter table community_user add constraint fk_community_user_user_02 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table tag_community add constraint fk_tag_community_tag_01 foreign key (tag_id) references tag (id) on delete restrict on update restrict;

alter table tag_community add constraint fk_tag_community_community_02 foreign key (community_id) references community (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists community;

drop table if exists community_user;

drop table if exists tag_community;

drop table if exists fund;

drop table if exists project;

drop table if exists review;

drop table if exists tag;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists community_seq;

drop sequence if exists fund_seq;

drop sequence if exists project_seq;

drop sequence if exists review_seq;

drop sequence if exists tag_seq;

drop sequence if exists user_seq;

