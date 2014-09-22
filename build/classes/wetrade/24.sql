create or replace view v24 as(select RATE_MSG_ID, RATE_THREAD_ID, count(MSG_STATUS) as Resp_Count from CUST_RATE_MSG where MSG_STATUS = 'DISLIKE' group by(RATE_MSG_ID, RATE_THREAD_ID));

select * from Message;

delete from Message where (MSG_ID, MSG_THREAD_ID) in 
(select RATE_MSG_ID, RATE_THREAD_ID from 
(select  RATE_MSG_ID, RATE_THREAD_ID from CUST_RATE_MSG where  (RATE_MSG_ID, RATE_THREAD_ID) in (select  RATE_MSG_ID, RATE_THREAD_ID from v24 where Resp_Count > 3))t1,
(select MSG_ID, MSG_THREAD_ID from MESSAGE where  (MSG_ID, MSG_THREAD_ID) not in(select ATTACH_MSG_ID, ATTACH_THREAD_ID from MESSAGE_REPLY ))t2
where RATE_MSG_ID = MSG_ID AND RATE_THREAD_ID = MSG_THREAD_ID);

select * from Message;

rollback;