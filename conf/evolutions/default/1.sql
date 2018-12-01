# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  book_id                       integer auto_increment not null,
  isbn                          varchar(255),
  title                         varchar(255) not null,
  sector                        varchar(255) not null,
  published_date                datetime(6) not null,
  date_borrowed                 datetime(6) not null,
  author_name                   varchar(255) not null,
  publisher_name                varchar(255) not null,
  number_of_pages               bigint not null,
  reader_reader_id              integer,
  constraint pk_book primary key (book_id)
);

create table company (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_company primary key (id)
);

create table computer (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime(6),
  discontinued                  datetime(6),
  company_id                    bigint,
  constraint pk_computer primary key (id)
);

create table date_util (
  record_id                     datetime(6) not null,
  borrwed_date                  datetime(6) not null,
  returned_date                 datetime(6),
  published_date                datetime(6) not null,
  constraint pk_date_util primary key (record_id)
);

create table dvd (
  dvd_id                        integer auto_increment not null,
  isbn                          varchar(255),
  title                         varchar(255) not null,
  sector                        varchar(255) not null,
  published_date                datetime(6) not null,
  date_borrowed                 datetime(6) not null,
  language                      varchar(255) not null,
  subtitles                     varchar(255) not null,
  producer_name                 varchar(255) not null,
  actors                        varchar(255) not null,
  reader_reader_id              integer,
  constraint pk_dvd primary key (dvd_id)
);

create table reader (
  reader_id                     integer auto_increment not null,
  reader_name                   varchar(255) not null,
  reader_mobile_num             varchar(255) not null,
  reader_email                  varchar(255) not null,
  constraint pk_reader primary key (reader_id)
);

alter table book add constraint fk_book_reader_reader_id foreign key (reader_reader_id) references reader (reader_id) on delete restrict on update restrict;
create index ix_book_reader_reader_id on book (reader_reader_id);

alter table computer add constraint fk_computer_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_id on computer (company_id);

alter table dvd add constraint fk_dvd_reader_reader_id foreign key (reader_reader_id) references reader (reader_id) on delete restrict on update restrict;
create index ix_dvd_reader_reader_id on dvd (reader_reader_id);


# --- !Downs

alter table book drop foreign key fk_book_reader_reader_id;
drop index ix_book_reader_reader_id on book;

alter table computer drop foreign key fk_computer_company_id;
drop index ix_computer_company_id on computer;

alter table dvd drop foreign key fk_dvd_reader_reader_id;
drop index ix_dvd_reader_reader_id on dvd;

drop table if exists book;

drop table if exists company;

drop table if exists computer;

drop table if exists date_util;

drop table if exists dvd;

drop table if exists reader;

