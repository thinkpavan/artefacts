
DROP TABLE order_lines;

DROP TABLE orders;

CREATE TABLE orders(
   ord_id VARCHAR(5),
  cust_name VARCHAR(50),
  ord_date date,
   CONSTRAINT ord_pk PRIMARY KEY
     (ord_id));

CREATE TABLE order_lines (
   order_id VARCHAR(5),
   line_id VARCHAR(5),
   item_name VARCHAR(20),
   qty number(10),
   CONSTRAINT ol_pk PRIMARY KEY
     (line_id,order_id),
   CONSTRAINT ol_fk FOREIGN KEY
     (order_id)
     REFERENCES orders ( ord_id ));


