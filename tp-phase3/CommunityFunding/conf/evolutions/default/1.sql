# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table community (
  id                        bigint not null,
  title                     varchar(255),
  description               varchar(255),
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
  title                     varchar(255),
  description               varchar(255),
  rating                    double,
  total_fund                double,
  counter                   integer,
  target                    double,
  initiator_id              bigint not null,
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
  community_id              bigint,
  constraint pk_tag primary key (id))
;

create table user (
  id                        bigint not null,
  picture                   varbinary(255),
  email                     varchar(255),
  password                  varchar(255),
  rating                    double,
  counter                   integer,
  constraint pk_user primary key (id))
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
alter table review add constraint fk_review_proj_4 foreign key (proj_id) references project (id) on delete restrict on update restrict;
create index ix_review_proj_4 on review (proj_id);
alter table review add constraint fk_review_author_5 foreign key (author_id) references user (id) on delete restrict on update restrict;
create index ix_review_author_5 on review (author_id);
alter table tag add constraint fk_tag_community_6 foreign key (community_id) references community (id) on delete restrict on update restrict;
create index ix_tag_community_6 on tag (community_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists community;

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

