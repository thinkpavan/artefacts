create or replace FUNCTION findEmpSal(eno1 number)
 return number  as 
sal1 number;
begin
  select  sal into sal1 from emp1 where eno=eno1 ;
 return sal1;
end;
/