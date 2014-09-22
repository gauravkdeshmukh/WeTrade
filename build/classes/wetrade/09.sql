create or replace view v09a as 
select EXTRACT(MONTH FROM TRANS_DATE_TIME)as month,
  EXTRACT(YEAR FROM TRANS_DATE_TIME)as year,
  TRANS_ID,TRANS_DATE_TIME,AMOUNT,TYPE
  from transaction
order by year,month,TRANS_ID;

create or replace view v09b as
select EXTRACT(MONTH FROM TRANS_DATE_TIME) as month,
  EXTRACT(YEAR FROM TRANS_DATE_TIME) as year , count(TRANS_ID) transnumber
  from transaction
  group by EXTRACT(year FROM TRANS_DATE_TIME),EXTRACT(month FROM TRANS_DATE_TIME)
  order by year, month;

create or replace view v09c as
select EXTRACT(year FROM TRANS_DATE_TIME) year ,EXTRACT(month FROM TRANS_DATE_TIME) month, sum(AMOUNT) SUMMATION 
  from transaction
group by EXTRACT(year FROM TRANS_DATE_TIME),EXTRACT(month FROM TRANS_DATE_TIME)
order by year, month;

select Month_Part as TransactionMonth ,Year_Part as TransactionYear, header as Particulars
from
(
  (select month,year, month as Month_Part, year as Year_Part, (v09a.TRANS_ID ||' '|| v09a.TRANS_DATE_TIME ||' '|| v09a.AMOUNT ||' '|| v09a.TYPE )as header ,1 as sortorder
  from v09a
  union
  select month,year, null as Month_Part, null as Year_Part, ('# of Transactions ' || v09b.TRANSNUMBER ) as header, 2 as sortorder
  from v09b
  union
  select month,year, null as Month_Part, null as Year_Part, ('Monthly Total' ||' '|| V09C.SUMMATION ) as header, 3 as sortorder
  from v09c
  )
)t
order by year, month, sortorder;
