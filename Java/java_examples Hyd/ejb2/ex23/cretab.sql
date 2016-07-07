drop table oostudents;
create table oostudents (id varchar(5),name varchar(30), oa  varchar(15), CONSTRAINT stud_pk PRIMARY KEY
     (id));
drop table ooaddresses;
create table ooaddresses(id varchar(5),addr varchar(100), CONSTRAINT addr_pk PRIMARY KEY(id),
CONSTRAINT fk FOREIGN KEY(id) REFERENCES oostudents(id));
