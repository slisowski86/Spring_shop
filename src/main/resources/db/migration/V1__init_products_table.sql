create table PRODUCTS
(
    ID          INTEGER auto_increment
        primary key,
    CREATED_ON  TIMESTAMP,
    UPDATED_ON  TIMESTAMP,
    CREATE_DATE TIMESTAMP,
    DESCRIPTION VARCHAR(255),
    NAME        VARCHAR(255),
    PRICE       DOUBLE  not null,
    SOLD_OUT    BOOLEAN not null
);