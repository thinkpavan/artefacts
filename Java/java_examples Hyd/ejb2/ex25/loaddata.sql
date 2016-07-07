delete from order_lines
/
delete from orders
/
insert into orders values(1,'one','22-oct-03')
/
insert into orders values(2,'two','22-oct-03')
/
insert into order_lines values(1,1,'soap',10)
/
insert into order_lines values(1,2,'pen',10)
/
insert into order_lines values(1,3,'pencil',10)
/
insert into order_lines values(2,1,'x',10)
/
insert into order_lines values(2,2,'y',10)
/
insert into order_lines values(2,3,'z',10)
/
insert into order_lines values(2,4,'a',10)
/
insert into order_lines values(2,5,'b',10)
/
commit
/
