create or replace view v14 as
select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME
from MESSAGE where (MSG_ID, MSG_THREAD_ID) in
(select MSG_ID, MSG_THREAD_ID from MESSAGE where MSG_THREAD_ID = '&MSG_THREAD_ID')
order by MSG_DATE_TIME;

create or replace view v14a as
select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME, No_of_Replies
from 
v14
,
(select THREAD_ID_REPLY, MSG_ID_REPLY, COUNT(*) as No_of_Replies from MESSAGE_REPLY
group by (THREAD_ID_REPLY, MSG_ID_REPLY))
where MSG_ID = MSG_ID_REPLY and MSG_THREAD_ID = THREAD_ID_REPLY;

create or replace view v14b as
select v14.MSG_THREAD_ID, v14.MSG_ID, v14.MSG_TEXT, v14.MSG_DATE_TIME, 0 as No_of_Replies
from 
v14
where (v14.MSG_THREAD_ID, v14.MSG_ID) NOT IN (select v14a.MSG_THREAD_ID, v14a.MSG_ID from v14a);

create or replace view v14c as
select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME,NO_OF_REPLIES, MSG_STATUS 
from (select * from v14a union select * from v14b)t1, CUST_RATE_MSG
where t1.MSG_THREAD_ID = RATE_THREAD_ID AND t1.MSG_ID = RATE_MSG_ID;

create or replace view v14d as
select MSG_THREAD_ID, MSG_ID,count(*) as Like_count
from v14c where MSG_STATUS = 'LIKE'
group by (MSG_THREAD_ID, MSG_ID);

create or replace view v14e as
select MSG_THREAD_ID, MSG_ID,count(*) as Dislike_count
from v14c where MSG_STATUS = 'DISLIKE'
group by (MSG_THREAD_ID, MSG_ID);

create or replace view v14f as
select MSG_THREAD_ID, MSG_ID, Like_count
from v14d 
UNION
select MSG_THREAD_ID, MSG_ID, 0 as Like_count from v14e 
where (MSG_THREAD_ID, MSG_ID) NOT IN (select MSG_THREAD_ID, MSG_ID from v14d);

create or replace view v14g as
select MSG_THREAD_ID, MSG_ID, Dislike_count
from v14e 
UNION
select MSG_THREAD_ID, MSG_ID, 0 as Dislike_count from v14d
where (MSG_THREAD_ID, MSG_ID) NOT IN (select MSG_THREAD_ID, MSG_ID from v14e);

select DISTINCT MSG_ID, MSG_TEXT, MSG_DATE_TIME,NO_OF_REPLIES from v14c
where (MSG_THREAD_ID, MSG_ID) in
(select t1.MSG_THREAD_ID, t1.MSG_ID from
v14f t1
,
v14g t2
where t1.MSG_THREAD_ID = t2.MSG_THREAD_ID and t1.MSG_ID = t2.MSG_ID and Like_count >= Dislike_count)
order by MSG_DATE_TIME;