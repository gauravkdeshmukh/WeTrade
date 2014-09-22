select * from CUST_RATE_MSG;

update CUST_RATE_MSG
set msg_status = 'LIKE' where (rate_msg_id, rate_thread_id) in
  (select msg_id, msg_thread_id from MESSAGE
    where msg_date_time in 
        (select min(msg_date_time) as earliest_date from MESSAGE
         where msg_id in
          (select post_msg_id from CUST_POST_MSG 
           where post_cust_email in
                        (select platinum_email from platinum
                         where VIEW_COUNT in
                                              (select max(view_count)
                                               from platinum)          
                        )
        )
      )
);
    
select * from CUST_RATE_MSG;

rollback;