create or replace view v6 as
select MSG_THREAD_ID, MIN(EXTRACT(DAY FROM SYSDATE - MSG_DATE_TIME)) as min_date from MESSAGE group by MSG_THREAD_ID;

create or replace view v6a as
select MSG_THREAD_ID, count(*) as No_of_Msg from MESSAGE 
group by MSG_THREAD_ID;

create or replace view v6b as
select MSG_THREAD_ID, MAX(MSG_DATE_TIME) as Most_Recent_Msg from MESSAGE 
where (MSG_THREAD_ID, EXTRACT(DAY FROM SYSDATE - MSG_DATE_TIME)) in (select MSG_THREAD_ID, min_date from v6)
group by MSG_THREAD_ID;

create or replace view v6c as
select * from v6a
UNION
select THEAD_ID, 0 as No_of_Msg from THREAD 
where THEAD_ID not in (select MSG_THREAD_ID from v6a);

create or replace view v6d as
select * from v6b
UNION
select THEAD_ID,null from THREAD
where THEAD_ID not in (select MSG_THREAD_ID from v6b);

create or replace view v6e as
select MODERATE_THREAD_ID, MODERATE_PLATINUM_EMAIL from PLATINUM_MODERATE_THREAD;

select THREAD_TITLE, LAST_NAME, MODERATE_PLATINUM_EMAIL, No_of_Msg, Most_Recent_Msg
from CUSTOMER c, THREAD, v6c t1, v6d t2, v6e t3
where THEAD_ID = t1.MSG_THREAD_ID and t1.MSG_THREAD_ID = t2.MSG_THREAD_ID and  t2.MSG_THREAD_ID = t3.MODERATE_THREAD_ID and t3.MODERATE_PLATINUM_EMAIL = c.CUST_EMAIL
order by Most_Recent_Msg;