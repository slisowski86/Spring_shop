create table category
(
    id          int primary key auto_increment,
    description varchar(255),
    category_name   varchar(255),
    amount   int  not null

);

alter table products add column category_group_id int null;
alter table products add foreign key (category_group_id) references category (id);