DROP DATABASE IF EXISTS messenger;
CREATE DATABASE `messenger`;
USE `messenger`;

CREATE TABLE user (
                      id int not null auto_increment,
                      first_name varchar(50) not null,
                      last_name varchar(50) not null,
                      login varchar(50) not null unique,
                      password varchar(50) not null,
                      Primary key (id)
);



CREATE TABLE dialog (
                        id int not null auto_increment,
                        user1 int not null,
                        user2 int not null,
                        Primary key (id),
                        FOREIGN KEY (user1) REFERENCES user (id)  ON DELETE CASCADE,
                        FOREIGN KEY (user2) REFERENCES user (id)  ON DELETE CASCADE
);

CREATE TABLE message (
                         id int not null auto_increment,
                         `from` int not null,
                         `to` int not null,
                         dialog int not null,
                         message longtext not null,
                         date datetime(6) not null,
                         Primary key (id),
                         FOREIGN KEY (`from`) REFERENCES user (id)  ON DELETE CASCADE,
                         FOREIGN KEY (`to`) REFERENCES user (id)  ON DELETE CASCADE,
                         FOREIGN KEY (dialog) REFERENCES dialog (id)  ON DELETE CASCADE
);

INSERT INTO user(first_name,last_name,login,password) values('vanya','ivanov','vanya','123');
INSERT INTO user(first_name,last_name,login,password) values('petya','petrov','petya','123');
INSERT INTO user(first_name,last_name,login,password) values('alex','alexandrov','alex','123');
INSERT INTO user(first_name,last_name,login,password) values('egor','egorov','egor','123');


