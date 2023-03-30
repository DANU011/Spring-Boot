create table member
(
 id int NOT NULL AUTO_INCREMENT,
pass VARCHAR(255),
name varchar(255),
regidate DATETIME DEFAULT CURRENT_TIMESTAMP,
primary key (id)
)

INSERT INTO member (pass, name) VALUES (1234,'가가가'),(1233,'1가가가'),(1235,'가1가가'),(1236,'가가1가'),(1237,'가가가1');