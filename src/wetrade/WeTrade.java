/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wetrade;

import java.util.*;
import java.sql.*;
import java.io.*;

/**
 *
 * @author Robin
 */
public class WeTrade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        // TODO code application logic here
        System.out.println("*** Connecting to database ***");

    /***   Make sure classPath contains location of classes12.zip file   ***/
    //String connectionString = "jdbc:oracle:thin:@shifu:1521:csora11g";
    
    String connectionString = "jdbc:oracle:thin:admin/oracle11g@localhost:1521:xe";
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Login> ");
    String username = sc.nextLine();
    System.out.print("Enter Password> ");
    String password = sc.nextLine();  // Change this line

    try{
      Connection conn = null;
      Class.forName ("oracle.jdbc.driver.OracleDriver");
      System.out.println("*** Oracle driver loaded ***");
      conn = DriverManager.getConnection (connectionString, username, password);
      System.out.println("*** Connection Succeeded ***");

      System.out.println("");
      Statement stmt = conn.createStatement();
      
      ResultSet result = null;
 /*
  * 
  * 
  * String sql1 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,"+
        "CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX)"+
"values ('xyz@xyz.com','ytyudh',1,'XYZYZYZYSY','XYZYZYZYSY','XY','XYZYZYZYSY',10101,to_timestamp"+
"('31-JAN-00 10.27.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Mr','XYZ','Y','ZZ','Sr')";

String sql2 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,"+
"CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX)"+
"values ('maikkruger@jourrapide.com','shjfyts',0,'2649 Arbutus Drive','Doral','FL','USA',33178,to_timestamp"+
 "('26-JUN-02 09.39.16.780000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Dr','Maik',null,'Kruger',null)";
String sql3 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,"+
"CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX)"+
"values ('NoahMiah@dayrep.com','Piegu',0,'2829 Ash Avenue','Tampa','FL','USA',98768,"+
 "to_timestamp('06-JUN-12 08.49.05.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Mr','Noah ',null,'Miah','Jr')";
String sql4 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,"+
"STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX) values "+
"('NellaFiorentino@armyspy.com','Uj4at',0,'70 Merthyr Road','BURDOCKS','GL','Italy',45326030,to_timestamp"+
"('06-JUN-09 10.00.06.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Ms','Nella ',null,'Fiorentino',null)";
String sql5 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,"+
"TITLE,FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('HoneyCrawford@dayrep.com','uwrtsah',3,null,'Denver','CO',"+
"'USA',80209,to_timestamp('25-NOV-01 09.58.38.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Mrs','Honey',null,'Crawford',null)";
String sql6 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME"+
",MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('EveRobey@jourrapide.com','Frokcal',0,'26 Abbey Row','Denver',null,'USA',80209,to_timestamp"+ 
"('31-JAN-14 10.27.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Ms','Eve','S','Robey','Sr')";
String sql7 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,"+
"MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('nihadmadaboutros@armyspy.com','aec1Doh',0,'249 Broadway Street','Denver','CO','USA',80209,"+
"to_timestamp('03-MAR-06 09.31.07.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Ms','Nihad ','M','Boutros',null)";
String sql8 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,"+
"MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('LeeY@teleworm.us','yurtyes',1,'2120 McKinley Avenue','Denver','CO','USA',80209,"+
"to_timestamp('12-DEC-11 01.33.04.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Dr','Lee',null,'Yu',null)";
String sql9 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,"+
"FIRST_NAME,MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('cileOuellet@teleworm.us','uKei6v',0,'Waldowstr. 56','Lauf',null,"+
"'Germany',77886,to_timestamp('14-MAR-13 05.51.18.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Ms','Cécile','L','Ouellet','III')";
String sql10 = "Insert into CUSTOMER (CUST_EMAIL,PASSWORD,NUMBER_BIDS,STREET_ADDR,CITY,STATE,COUNTRY,ZIP,REG_DATE,TITLE,FIRST_NAME,"+
"MIDDLE_INITIALS,LAST_NAME,SUFFIX) values ('SidvanErp@teleworm.us','siugfj',10,'2007 Stanley Rd','Mbazwana',null,'South Africa',3988,"+
"to_timestamp('23-MAR-01 03.53.34.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Mr','Sid ',null,'Erp',null)";

stmt.executeUpdate(sql1);stmt.executeUpdate(sql2);stmt.executeUpdate(sql3);stmt.executeUpdate(sql4);stmt.executeUpdate(sql5);
stmt.executeUpdate(sql6);stmt.executeUpdate(sql7);stmt.executeUpdate(sql8);stmt.executeUpdate(sql9);stmt.executeUpdate(sql10);

String item1 = "Insert into ITEM (ITEM_NO,ITEM_EMAIL,PRICE,WEIGHT,DEADLINE,FILENAME,DESCRIPTION) values (3,'NellaFiorentino@armyspy.com',"+
"1200,300,to_timestamp('03-05-14 03:36:31.000000000 AM','DD-MM-RR HH12:MI:SSXFF AM'),'Armani.png','Purse')";
String item2 = "Insert into ITEM (ITEM_NO,ITEM_EMAIL,PRICE,WEIGHT,DEADLINE,FILENAME,DESCRIPTION) values "+
"(4,'EveRobey@jourrapide.com',20,30,to_timestamp('14-05-14 04:05:22.000000000 PM','DD-MM-RR HH12:MI:SSXFF AM'),'hotwheelscar.png','Toys')";
String item3 = "Insert into ITEM (ITEM_NO,ITEM_EMAIL,PRICE,WEIGHT,DEADLINE,FILENAME,DESCRIPTION) values (23,'GustavPerales@dayrep.com',"+
"1000,500,to_timestamp('05-05-14 01:32:38.000000000 AM','DD-MM-RR HH12:MI:SSXFF AM'),'DellLaptop15R.png','Laptop Alienware')";
String item4 = "Insert into ITEM (ITEM_NO,ITEM_EMAIL,PRICE,WEIGHT,DEADLINE,FILENAME,DESCRIPTION) values "+
"(24,'maikkruger@jourrapide.com',1200,250,to_timestamp('06-05-14 01:32:38.000000000 AM','DD-MM-RR HH12:MI:SSXFF AM'),'Apple.png','Apple iPad 6 ')";

String item5 = "Insert into ITEM (ITEM_NO,ITEM_EMAIL,PRICE,WEIGHT,DEADLINE,FILENAME,DESCRIPTION)"+
"values (25,'EveRobey@jourrapide.com',65,10,to_timestamp('13-05-14 08:50:14.000000000 PM','DD-MM-RR HH12:MI:SSXFF AM'),"+

stmt.executeUpdate(item1);stmt.executeUpdate(item2);stmt.executeUpdate(item3);stmt.executeUpdate(item4);stmt.executeUpdate(item5);
* 
  String Table1 = "CREATE TABLE MESSAGE" + 
  "(MSG_ID NUMBER, " +  
  "MSG_THREAD_ID NUMBER," + 
  "MSG_TEXT VARCHAR2(140)," + 
  "MSG_DATE_TIME TIMESTAMP (6))";
  
  String Table2 = "CREATE TABLE CUST_RATE_MSG" +
  "(RATE_MSG_ID NUMBER," +
  "RATE_THREAD_ID NUMBER," + 
  "RATE_CUST_EMAIL VARCHAR2(30)," + 
  "MSG_STATUS VARCHAR2(10))";
  
  String Table3 = "CREATE TABLE CLASSCUST_REVIEW_ITEM" +
  "(CLASS_EMAIL_REVITEM VARCHAR2(30)," + 
  "ITEM_NO_REVITEM NUMBER, " +
  "ITEM_EMAIL_REVITEM VARCHAR2(30)," + 
  "RATING NUMBER)";
  
  String Table4 = "CREATE TABLE THREAD" +
  "(THEAD_ID NUMBER, THREAD_TITLE VARCHAR2(30))";
  
  String Table41 = "CREATE TABLE CUST_GENERATE_TRANS (CUST_TRANS_EMAIL VARCHAR2(30), GEN_TRANS_ID NUMBER)";
  
  String Table5 = "CREATE TABLE CUSTOMER (CUST_EMAIL VARCHAR2(30)," +
  "PASSWORD VARCHAR2(8), NUMBER_BIDS NUMBER, STREET_ADDR VARCHAR2(50),"+
  "CITY VARCHAR2(50), STATE VARCHAR2(2), COUNTRY VARCHAR2(50), ZIP NUMBER," +
  "REG_DATE TIMESTAMP (6), TITLE VARCHAR2(5), FIRST_NAME VARCHAR2(30),"+ 
  "MIDDLE_INITIALS VARCHAR2(1), LAST_NAME VARCHAR2(30), SUFFIX VARCHAR2(5))";
  
  String Table6 = "CREATE TABLE CUST_BID_ITEM (BID_ITEM_EMAIL VARCHAR2(30)," +
  "BID_ITEM_NO NUMBER, AMOUNT NUMBER, BID_DATE_TIME TIMESTAMP (6), BID_CUST_EMAIL VARCHAR2(30))";
  
  String Table7 = "CREATE TABLE KEYWORDS(KEY_ITEM_NO NUMBER, KEY_ITEM_EMAIL" +
  "VARCHAR2(30), KEYWORD VARCHAR2(50))";
  
  String Table8 = "CREATE TABLE MESSAGE_REPLY(MSG_ID_REPLY NUMBER, THREAD_ID_REPLY NUMBER," +
  "ATTACH_MSG_ID NUMBER, ATTACH_THREAD_ID NUMBER)";
   
  String Table9 = "CREATE TABLE CUST_POST_THREAD(THREAD_ID_POST NUMBER, CUST_EMAIL_POST VARCHAR2(30))";
  
  String Table10 = "CREATE TABLE CLASSIFIED_CUSTOMER(CLASS_EMAIL VARCHAR2(30)," +
  "CLASS_DATE_TIME TIMESTAMP (6), DISCOUNT NUMBER)";
  
  String Table11 = "CREATE TABLE CUSTOMER_TRADE_ITEM(TRADE_ITEM_EMAIL VARCHAR2(30),"+
  "TRADE_ITEM_NO NUMBER, TRADE_ACCEPT_CUST_EMAIL VARCHAR2(30), TRADE_ACCEPT_ITEM_NO NUMBER)";
  
  String Table12 = "CREATE TABLE GOLD (GOLD_EMAIL VARCHAR2(30))";
  
  String Table13 = "CREATE TABLE PLATINUM_MODERATE_THREAD (MODERATE_THREAD_ID NUMBER, MODERATE_PLATINUM_EMAIL VARCHAR2(30))";
  
  String Table14 = "CUSTOMER_TRADE (INITIATE_CUST_EMAIL VARCHAR2(30), ACCEPT_CUST_EMAIL VARCHAR2(30))";
  
  String Table15 = "CREATE TABLE CUST_POST_MSG (POST_CUST_EMAIL VARCHAR2(30), POST_THREAD_ID NUMBER, POST_MSG_ID NUMBER)";
  
  String Table16 = "CREATE TABLE ITEM (ITEM_NO NUMBER, ITEM_EMAIL VARCHAR2(30)," +
  "PRICE NUMBER, WEIGHT NUMBER, DEADLINE TIMESTAMP (6), FILENAME VARCHAR2(30), DESCRIPTION VARCHAR2(50))";
  
  String Table17 = "CREATE TABLE PLATINUM (PLATINUM_EMAIL VARCHAR2(30), URL VARCHAR2(30), VIEW_COUNT NUMBER)";
  
  String Table18 = "CREATE TABLE PLATINUM_REVIEW_CUSTOMER (PLATINUM_EMAIL_REVCUST VARCHAR2(30)," +
  "CUST_EMAIL_REVCUST VARCHAR2(30), CRITIQUE VARCHAR2(10))";
  
  String Table19 = "CREATE TABLE TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID NUMBER," +
  "TRAN_INV_ITEM_NO NUMBER, TRAN_INV_ITEM_EMAIL VARCHAR2(30))";
  
  String Table20 = "CREATE TABLE TRANSACTION (TRANS_ID NUMBER, TRANS_DATE_TIME" +
  "TIMESTAMP (6), TYPE VARCHAR2(2), AMOUNT NUMBER)";
  
  stmt.executeUpdate(Table1);
  stmt.executeUpdate(Table2);
  stmt.executeUpdate(Table3);
  stmt.executeUpdate(Table4);
  stmt.executeUpdate(Table41);
  stmt.executeUpdate(Table5);
  stmt.executeUpdate(Table6);
  stmt.executeUpdate(Table7);
  stmt.executeUpdate(Table8);
  stmt.executeUpdate(Table9);
  stmt.executeUpdate(Table10);
  stmt.executeUpdate(Table11);
  stmt.executeUpdate(Table12);
  stmt.executeUpdate(Table13);
  stmt.executeUpdate(Table14);
  stmt.executeUpdate(Table15);
  stmt.executeUpdate(Table16);
  stmt.executeUpdate(Table17);
  stmt.executeUpdate(Table18);
  stmt.executeUpdate(Table19);
  stmt.executeUpdate(Table20);
  
  stmt.executeUpdate("CREATE UNIQUE INDEX MESSAGE_PK ON MESSAGE (MSG_ID, MSG_THREAD_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUST_RATE_MSG_CON ON CUST_RATE_MSG (RATE_MSG_ID, RATE_THREAD_ID, RATE_CUST_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CLASSCUST_REVIEW_ITEM_CON ON CLASSCUST_REVIEW_ITEM (CLASS_EMAIL_REVITEM, ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX THREAD_PK ON THREAD (THEAD_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUST_GENERATE_TRANS_PK ON CUST_GENERATE_TRANS (GEN_TRANS_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUSTOMER_PK ON CUSTOMER (CUST_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUST_BID_ITEM_PK ON CUST_BID_ITEM (BID_ITEM_EMAIL, BID_ITEM_NO, BID_CUST_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX KEYWORDS_PK ON KEYWORDS (KEY_ITEM_NO, KEY_ITEM_EMAIL, KEYWORD)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX MESSAGE_REPLY_PK ON MESSAGE_REPLY (MSG_ID_REPLY, THREAD_ID_REPLY)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUST_POST_THREAD_PK ON CUST_POST_THREAD (THREAD_ID_POST, CUST_EMAIL_POST)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CLASSIFIED_CUSTOMER_PK ON CLASSIFIED_CUSTOMER (CLASS_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUSTOMER_TRADE_ITEM_PK ON CUSTOMER_TRADE_ITEM (TRADE_ITEM_EMAIL, TRADE_ITEM_NO,"+
  "TRADE_ACCEPT_CUST_EMAIL, TRADE_ACCEPT_ITEM_NO)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX GOLD_PK ON GOLD (GOLD_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX PALTINUM_MODERATE_THREAD_PK ON PLATINUM_MODERATE_THREAD (MODERATE_THREAD_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUSTOMER_TRADE_PK ON CUSTOMER_TRADE (ACCEPT_CUST_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX CUST_POST_MSG_PK ON CUST_POST_MSG(POST_THREAD_ID, POST_MSG_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX ITEM_PK ON ITEM (ITEM_NO, ITEM_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX PLATINUM_PK ON PLATINUM (PLATINUM_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX PLATINUM_REVIEW_CUSTOMER_PK ON PLATINUM_REVIEW_CUSTOMER(PLATINUM_EMAIL_REVCUST, CUST_EMAIL_REVCUST)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX TRANS_INVOLVE_ITEM_PK ON TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID, TRAN_INV_ITEM_NO, TRAN_INV_ITEM_EMAIL)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX TRANSACTION_PK ON TRANSACTION (TRANS_ID)");
  
  stmt.executeUpdate("CREATE UNIQUE INDEX TRANSACTION_UK1 ON TRANSACTION (TRANS_DATE_TIME)");
  
  String alter1 = "ALTER TABLE MESSAGE ADD CONSTRAINT MESSAGE_PK PRIMARY KEY (MSG_ID, MSG_THREAD_ID) ENABLE";
  stmt.executeUpdate(alter1);
  String alter2 = "ALTER TABLE MESSAGE MODIFY (MSG_DATE_TIME NOT NULL ENABLE)";
  stmt.executeUpdate(alter2);
  String alter3 = "ALTER TABLE MESSAGE MODIFY (MSG_THREAD_ID NOT NULL ENABLE)";
  stmt.executeUpdate(alter3);
  String alter4 = "ALTER TABLE MESSAGE MODIFY (MSG_ID NOT NULL ENABLE)";
  stmt.executeUpdate(alter4);
  
  String alter5 = "ALTER TABLE CUST_RATE_MSG ADD CONSTRAINT CUST_RATE_MSG_CON PRIMARY KEY (RATE_MSG_ID, RATE_THREAD_ID, RATE_CUST_EMAIL) ENABLE";
  stmt.executeUpdate(alter5);
  
  String alter6 = "ALTER TABLE CUST_RATE_MSG MODIFY (RATE_CUST_EMAIL NOT NULL ENABLE)";
  stmt.executeUpdate(alter6);
  String alter7 = "ALTER TABLE CUST_RATE_MSG MODIFY (RATE_THREAD_ID NOT NULL ENABLE)";
  stmt.executeUpdate(alter7);
  
  String[] alter = new String[115];
   alter[8] = "ALTER TABLE CUST_RATE_MSG MODIFY (RATE_MSG_ID NOT NULL ENABLE)";
  
   alter[9] ="ALTER TABLE CUST_RATE_MSG ADD CONSTRAINT CUST_RATE_MSG_CK CHECK ( MSG_STATUS in ('LIKE' , 'DISLIKE')) ENABLE";
  
   alter[10] ="ALTER TABLE CLASSCUST_REVIEW_ITEM ADD CONSTRAINT CLASSCUST_REVIEW_ITEM_CON PRIMARY KEY"+
  "(CLASS_EMAIL_REVITEM, ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM) ENABLE";
  alter[11] ="ALTER TABLE CLASSCUST_REVIEW_ITEM ADD CONSTRAINT CLASSCUST_REVIEW_ITEM_CK1 CHECK (RATING BETWEEN 1 AND 5) ENABLE";
   alter[12] ="ALTER TABLE CLASSCUST_REVIEW_ITEM MODIFY (ITEM_EMAIL_REVITEM NOT NULL ENABLE)";
   alter[13] ="ALTER TABLE CLASSCUST_REVIEW_ITEM MODIFY (ITEM_NO_REVITEM NOT NULL ENABLE)";
   alter[14] ="ALTER TABLE CLASSCUST_REVIEW_ITEM MODIFY (CLASS_EMAIL_REVITEM NOT NULL ENABLE)";
  
   alter[15] ="ALTER TABLE THREAD ADD CONSTRAINT THREAD_PK PRIMARY KEY (THEAD_ID) ENABLE";
   alter[16] = "ALTER TABLE THREAD MODIFY (THREAD_TITLE NOT NULL ENABLE)";
   alter[17] ="ALTER TABLE THREAD MODIFY (THEAD_ID NOT NULL ENABLE)";
  
   alter[18] ="ALTER TABLE CUST_GENERATE_TRANS ADD CONSTRAINT CUST_GENERATE_TRANS_PK PRIMARY KEY (GEN_TRANS_ID) ENABLE";
   alter[19] ="ALTER TABLE CUST_GENERATE_TRANS MODIFY (GEN_TRANS_ID NOT NULL ENABLE)";
   alter[20] ="ALTER TABLE CUST_GENERATE_TRANS MODIFY (CUST_TRANS_EMAIL NOT NULL ENABLE)";
  
   alter[21] ="ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_CK2 CHECK (TITLE IN ('Mr', 'Mrs', 'Dr', 'Ms', 'Mast')) ENABLE";
   alter[22] ="ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_PK PRIMARY KEY (CUST_EMAIL) ENABLE";
   alter[23] ="ALTER TABLE CUSTOMER MODIFY (LAST_NAME NOT NULL ENABLE)";
   alter[24] ="ALTER TABLE CUSTOMER MODIFY (FIRST_NAME NOT NULL ENABLE)";
   alter[25] ="ALTER TABLE CUSTOMER MODIFY (REG_DATE NOT NULL ENABLE)";
  alter[26] ="ALTER TABLE CUSTOMER MODIFY (ZIP NOT NULL ENABLE)";
   alter[27] ="ALTER TABLE CUSTOMER MODIFY (CITY NOT NULL ENABLE)";
  alter[28] ="ALTER TABLE CUSTOMER MODIFY (NUMBER_BIDS NOT NULL ENABLE)";
   alter[29] ="ALTER TABLE CUSTOMER MODIFY (PASSWORD NOT NULL ENABLE)";
   alter[30] ="ALTER TABLE CUSTOMER MODIFY (CUST_EMAIL NOT NULL ENABLE)";
  
  alter[31] ="ALTER TABLE CUST_BID_ITEM MODIFY (BID_CUST_EMAIL NOT NULL ENABLE)";
   alter[32] ="ALTER TABLE CUST_BID_ITEM MODIFY (BID_DATE_TIME NOT NULL ENABLE)";
   alter[33] ="ALTER TABLE CUST_BID_ITEM MODIFY (AMOUNT NOT NULL ENABLE)";
   alter[34] ="ALTER TABLE CUST_BID_ITEM MODIFY (BID_ITEM_NO NOT NULL ENABLE)";
  alter[35] ="ALTER TABLE CUST_BID_ITEM MODIFY (BID_ITEM_EMAIL NOT NULL ENABLE)";
   alter[36] ="ALTER TABLE CUST_BID_ITEM ADD CONSTRAINT CUST_BID_ITEM_PK PRIMARY KEY"+
  "(BID_ITEM_EMAIL, BID_ITEM_NO, BID_CUST_EMAIL) ENABLE";
  
   alter[37] ="ALTER TABLE KEYWORDS ADD CONSTRAINT KEYWORDS_PK PRIMARY KEY (KEY_ITEM_NO, KEY_ITEM_EMAIL, KEYWORD) ENABLE";
   alter[38] ="ALTER TABLE KEYWORDS MODIFY (KEY_ITEM_EMAIL NOT NULL ENABLE)";
  alter[39] ="ALTER TABLE KEYWORDS MODIFY (KEY_ITEM_NO NOT NULL ENABLE)";
  
  alter[40] ="ALTER TABLE MESSAGE_REPLY MODIFY (THREAD_ID_REPLY NOT NULL ENABLE)";
  alter[41] ="ALTER TABLE MESSAGE_REPLY MODIFY (MSG_ID_REPLY NOT NULL ENABLE)";
   alter[42] ="ALTER TABLE MESSAGE_REPLY ADD CONSTRAINT MESSAGE_REPLY_PK PRIMARY KEY (MSG_ID_REPLY, THREAD_ID_REPLY) ENABLE";
   alter[43] ="ALTER TABLE MESSAGE_REPLY MODIFY (ATTACH_THREAD_ID NOT NULL ENABLE)";
 alter[44] = "ALTER TABLE MESSAGE_REPLY MODIFY (ATTACH_MSG_ID NOT NULL ENABLE)";
  
   alter[45] ="ALTER TABLE CUST_POST_THREAD ADD CONSTRAINT CUST_POST_THREAD_PK PRIMARY KEY (THREAD_ID_POST, CUST_EMAIL_POST) ENABLE";
  alter[46] ="ALTER TABLE CUST_POST_THREAD MODIFY (CUST_EMAIL_POST NOT NULL ENABLE)";
  alter[47] ="ALTER TABLE CUST_POST_THREAD MODIFY (THREAD_ID_POST NOT NULL ENABLE)";
  
  alter[48] ="ALTER TABLE CLASSIFIED_CUSTOMER ADD CONSTRAINT CLASSIFIED_CUSTOMER_PK PRIMARY KEY (CLASS_EMAIL) ENABLE";
  alter[49] ="ALTER TABLE CLASSIFIED_CUSTOMER MODIFY (CLASS_DATE_TIME NOT NULL ENABLE)";
  alter[50] ="ALTER TABLE CLASSIFIED_CUSTOMER MODIFY (CLASS_EMAIL NOT NULL ENABLE)";
  
   alter[51] ="ALTER TABLE CUSTOMER_TRADE_ITEM MODIFY (TRADE_ACCEPT_CUST_EMAIL NOT NULL ENABLE)";
   alter[52] ="ALTER TABLE CUSTOMER_TRADE_ITEM MODIFY (TRADE_ITEM_NO NOT NULL ENABLE)";
   alter[53] ="ALTER TABLE CUSTOMER_TRADE_ITEM MODIFY (TRADE_ITEM_EMAIL NOT NULL ENABLE)";
  alter[54] ="ALTER TABLE CUSTOMER_TRADE_ITEM ADD CONSTRAINT CUSTOMER_TRADE_ITEM_PK"+
  "PRIMARY KEY (TRADE_ITEM_EMAIL, TRADE_ITEM_NO, TRADE_ACCEPT_CUST_EMAIL, TRADE_ACCEPT_ITEM_NO) ENABLE";
  
   alter[55] ="ALTER TABLE GOLD ADD CONSTRAINT GOLD_PK PRIMARY KEY (GOLD_EMAIL) ENABLE";
  alter[56] ="ALTER TABLE GOLD MODIFY (GOLD_EMAIL NOT NULL ENABLE)";
  
  alter[57] ="ALTER TABLE PLATINUM_MODERATE_THREAD ADD CONSTRAINT PALTINUM_MODERATE_THREAD_PK PRIMARY KEY (MODERATE_THREAD_ID) ENABLE";
   alter[58] ="ALTER TABLE PLATINUM_MODERATE_THREAD MODIFY (MODERATE_PLATINUM_EMAIL NOT NULL ENABLE)";
  alter[59] ="ALTER TABLE PLATINUM_MODERATE_THREAD MODIFY (MODERATE_THREAD_ID NOT NULL ENABLE)";
  
  alter[60] ="ALTER TABLE CUSTOMER_TRADE ADD CONSTRAINT CUSTOMER_TRADE_PK PRIMARY KEY (ACCEPT_CUST_EMAIL) ENABLE";
  alter[61] ="ALTER TABLE CUSTOMER_TRADE MODIFY (ACCEPT_CUST_EMAIL NOT NULL ENABLE)";
  alter[62] ="ALTER TABLE CUSTOMER_TRADE MODIFY (INITIATE_CUST_EMAIL NOT NULL ENABLE)";
  
   alter[63] ="ALTER TABLE CUST_POST_MSG ADD CONSTRAINT CUST_POST_MSG_PK PRIMARY KEY (POST_THREAD_ID, POST_MSG_ID) ENABLE";
 alter[64] ="ALTER TABLE CUST_POST_MSG MODIFY (POST_MSG_ID NOT NULL ENABLE)";
  alter[65] ="ALTER TABLE CUST_POST_MSG MODIFY (POST_THREAD_ID NOT NULL ENABLE)";
   alter[66] ="ALTER TABLE CUST_POST_MSG MODIFY (POST_CUST_EMAIL NOT NULL ENABLE)";
  
 alter[67] ="ALTER TABLE ITEM ADD CONSTRAINT ITEM_PK PRIMARY KEY (ITEM_NO, ITEM_EMAIL) ENABLE";
   alter[68] ="ALTER TABLE ITEM MODIFY (DEADLINE NOT NULL ENABLE)";
  alter[69] ="ALTER TABLE ITEM MODIFY (WEIGHT NOT NULL ENABLE)";
  alter[70] ="ALTER TABLE ITEM MODIFY (PRICE NOT NULL ENABLE)";
   alter[71] ="ALTER TABLE ITEM MODIFY (ITEM_EMAIL NOT NULL ENABLE)";
  alter[72] ="ALTER TABLE ITEM MODIFY (ITEM_NO NOT NULL ENABLE)";
  
  alter[73] ="ALTER TABLE PLATINUM ADD CONSTRAINT PLATINUM_PK PRIMARY KEY (PLATINUM_EMAIL) ENABLE";
  alter[74] ="ALTER TABLE PLATINUM MODIFY (VIEW_COUNT NOT NULL ENABLE)";
   alter[75] ="ALTER TABLE PLATINUM MODIFY (PLATINUM_EMAIL NOT NULL ENABLE)";
  
   alter[76] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER ADD CONSTRAINT PLATINUM_REVIEW_CUSTOMER_CK1"+ 
  "CHECK (CRITIQUE IN ('POOR','FAIR','GOOD','EXCELLENT')) ENABLE";
 alter[77] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER ADD CONSTRAINT PLATINUM_REVIEW_CUSTOMER_PK"+ 
  "PRIMARY KEY (PLATINUM_EMAIL_REVCUST, CUST_EMAIL_REVCUST) ENABLE";
 alter[78] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER MODIFY (CUST_EMAIL_REVCUST NOT NULL ENABLE)";
   alter[79] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER MODIFY (PLATINUM_EMAIL_REVCUST NOT NULL ENABLE)";
  
  
 alter[80] ="ALTER TABLE TRANS_INVOLVE_ITEM ADD CONSTRAINT TRANS_INVOLVE_ITEM_PK PRIMARY KEY "+
  "(TRAN_INV_TRANS_ID, TRAN_INV_ITEM_NO, TRAN_INV_ITEM_EMAIL) ENABLE";
  alter[81] ="ALTER TABLE TRANS_INVOLVE_ITEM MODIFY (TRAN_INV_ITEM_EMAIL NOT NULL ENABLE)";
 alter[82] ="ALTER TABLE TRANS_INVOLVE_ITEM MODIFY (TRAN_INV_ITEM_NO NOT NULL ENABLE)";
  alter[83] ="ALTER TABLE TRANS_INVOLVE_ITEM MODIFY (TRAN_INV_TRANS_ID NOT NULL ENABLE)";
  
   alter[84] ="ALTER TABLE TRANSACTION ADD CONSTRAINT TRANSACTION_UK1 UNIQUE (TRANS_DATE_TIME) ENABLE";
   alter[85] ="ALTER TABLE TRANSACTION ADD CONSTRAINT TRANSACTION_PK PRIMARY KEY (TRANS_ID) ENABLE";
   alter[86]="ALTER TABLE TRANSACTION MODIFY (AMOUNT NOT NULL ENABLE)";
 alter[87] ="ALTER TABLE TRANSACTION MODIFY (TYPE NOT NULL ENABLE)";
   alter[88] ="ALTER TABLE TRANSACTION MODIFY (TRANS_DATE_TIME NOT NULL ENABLE)";
  alter[89] ="ALTER TABLE TRANSACTION MODIFY (TRANS_ID NOT NULL ENABLE)";
   alter[90] = "ALTER TABLE TRANSACTION ADD CONSTRAINT TRANSACTION_CON_CK1 CHECK ( TYPE in ('PB','BI','PI','SI','IT','AT')) ENABLE";
  
  alter[91] ="ALTER TABLE MESSAGE ADD CONSTRAINT MESSAGE_FK FOREIGN KEY (MSG_THREAD_ID) REFERENCES THREAD (THEAD_ID) ON DELETE CASCADE ENABLE";

  alter[92] ="ALTER TABLE CUST_RATE_MSG ADD CONSTRAINT CUST_RATE_MSG_FK FOREIGN KEY"+ 
  "(RATE_MSG_ID, RATE_THREAD_ID) REFERENCES MESSAGE (MSG_ID, MSG_THREAD_ID) ON DELETE CASCADE ENABLE";
  alter[93] ="ALTER TABLE CUST_RATE_MSG ADD CONSTRAINT CUST_RATE_MSG_FK2 FOREIGN KEY (RATE_CUST_EMAIL)"+
  "REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

  alter[94] ="ALTER TABLE CLASSCUST_REVIEW_ITEM ADD CONSTRAINT CLASSCUST_REVIEW_ITEM_FK3"+
  "FOREIGN KEY (CLASS_EMAIL_REVITEM) REFERENCES CLASSIFIED_CUSTOMER (CLASS_EMAIL) ON DELETE CASCADE ENABLE";
  alter[95] ="ALTER TABLE CLASSCUST_REVIEW_ITEM ADD CONSTRAINT CLASSCUST_REVIEW_ITEM_FK4 FOREIGN KEY" +
  "(ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM) REFERENCES ITEM (ITEM_NO, ITEM_EMAIL) ON DELETE CASCADE ENABLE";

   alter[96] ="ALTER TABLE CUST_GENERATE_TRANS ADD CONSTRAINT CUST_GENERATE_TRANS_FK1 FOREIGN KEY (CUST_TRANS_EMAIL)"+
  "REFERENCES CUSTOMER(CUST_EMAIL) ON DELETE CASCADE ENABLE";
  alter[97] ="ALTER TABLE CUST_GENERATE_TRANS ADD CONSTRAINT CUST_GENERATE_TRANS_FK2 FOREIGN KEY (GEN_TRANS_ID)"+
  "REFERENCES TRANSACTION (TRANS_ID) ON DELETE CASCADE ENABLE";

  alter[98] ="ALTER TABLE CUST_BID_ITEM ADD CONSTRAINT CUST_BID_ITEM_FK3 FOREIGN KEY (BID_CUST_EMAIL) REFERENCES"+
  "CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";
 alter[99] ="ALTER TABLE CUST_BID_ITEM ADD CONSTRAINT CUST_BID_ITEM_FK4 FOREIGN KEY (BID_ITEM_NO, BID_ITEM_EMAIL)"+
  "REFERENCES ITEM (ITEM_NO, ITEM_EMAIL) ON DELETE CASCADE ENABLE";

   alter[100] ="ALTER TABLE KEYWORDS ADD CONSTRAINT KEYWORDS_FK FOREIGN KEY (KEY_ITEM_NO, KEY_ITEM_EMAIL) REFERENCES ITEM (ITEM_NO, ITEM_EMAIL)"+
  "ON DELETE CASCADE ENABLE";

   alter[101] ="ALTER TABLE MESSAGE_REPLY ADD CONSTRAINT MESSAGE_REPLY_FK FOREIGN KEY (MSG_ID_REPLY, THREAD_ID_REPLY)"+
  "REFERENCES MESSAGE (MSG_ID, MSG_THREAD_ID) ON DELETE CASCADE ENABLE";
   alter[102] ="ALTER TABLE MESSAGE_REPLY ADD CONSTRAINT MESSAGE_REPLY_FK2 FOREIGN KEY (ATTACH_MSG_ID, ATTACH_THREAD_ID)"+
  "REFERENCES MESSAGE (MSG_ID, MSG_THREAD_ID) ON DELETE CASCADE ENABLE";

   alter[103] ="ALTER TABLE CUST_POST_THREAD ADD CONSTRAINT CUST_POST_THREAD_FK FOREIGN KEY (THREAD_ID_POST)"+
  "REFERENCES THREAD (THEAD_ID) ON DELETE CASCADE ENABLE";
  alter[104] ="ALTER TABLE CUST_POST_THREAD ADD CONSTRAINT CUST_POST_THREAD_FK2 FOREIGN KEY (CUST_EMAIL_POST)" +
  "REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[105] ="ALTER TABLE CLASSIFIED_CUSTOMER ADD CONSTRAINT CLASSIFIED_CUSTOMER_FK"+
  "FOREIGN KEY (CLASS_EMAIL) REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[106] ="ALTER TABLE CUSTOMER_TRADE_ITEM ADD CONSTRAINT CUSTOMER_TRADE_ITEM_FK"+
  "FOREIGN KEY (TRADE_ITEM_NO, TRADE_ITEM_EMAIL) REFERENCES ITEM (ITEM_NO, ITEM_EMAIL) ON DELETE CASCADE ENABLE";
 alter[107] ="ALTER TABLE CUSTOMER_TRADE_ITEM ADD CONSTRAINT CUSTOMER_TRADE_ITEM_FK2" +
  "FOREIGN KEY (TRADE_ACCEPT_ITEM_NO, TRADE_ACCEPT_CUST_EMAIL) REFERENCES ITEM (ITEM_NO, ITEM_EMAIL) ON DELETE CASCADE ENABLE";
  
  alter[108] ="ALTER TABLE CUSTOMER_TRADE_ITEM ADD CONSTRAINT CUSTOMER_TRADE_ITEM_FK3"+
  "FOREIGN KEY (TRADE_ACCEPT_CUST_EMAIL) REFERENCES CUSTOMER_TRADE (ACCEPT_CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[109] ="ALTER TABLE GOLD ADD CONSTRAINT GOLD_FK FOREIGN KEY (GOLD_EMAIL) REFERENCES "+
  "CLASSIFIED_CUSTOMER (CLASS_EMAIL) ON DELETE CASCADE ENABLE";

  alter[110] ="ALTER TABLE PLATINUM_MODERATE_THREAD ADD CONSTRAINT PALTINUM_MODERATE_THREAD_FK" +
  "FOREIGN KEY (MODERATE_THREAD_ID) REFERENCES THREAD (THEAD_ID) ON DELETE CASCADE ENABLE";
  alter[111] ="ALTER TABLE PLATINUM_MODERATE_THREAD ADD CONSTRAINT PALTINUM_MODERATE_THREAD_FK2"+
  "FOREIGN KEY (MODERATE_PLATINUM_EMAIL) REFERENCES PLATINUM (PLATINUM_EMAIL) ON DELETE CASCADE ENABLE";

   alter[112] ="ALTER TABLE CUSTOMER_TRADE ADD CONSTRAINT CUSTOMER_TRADE_FK1 FOREIGN KEY (INITIATE_CUST_EMAIL)"+
  "REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";
   alter[113] ="ALTER TABLE CUSTOMER_TRADE ADD CONSTRAINT CUSTOMER_TRADE_FK2"+
  "FOREIGN KEY (ACCEPT_CUST_EMAIL) REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[114] ="ALTER TABLE CUST_POST_MSG ADD CONSTRAINT CUST_POST_MSG_FK" +
  "FOREIGN KEY (POST_MSG_ID, POST_THREAD_ID) REFERENCES MESSAGE (MSG_ID, MSG_THREAD_ID) ON DELETE CASCADE ENABLE";
  
   alter[115] ="ALTER TABLE CUST_POST_MSG ADD CONSTRAINT CUST_POST_MSG_FK2"+
  "FOREIGN KEY (POST_CUST_EMAIL) REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[116] ="ALTER TABLE ITEM ADD CONSTRAINT ITEM_FK FOREIGN KEY (ITEM_EMAIL)"+
  "REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

  alter[117] ="ALTER TABLE PLATINUM ADD CONSTRAINT PLATINUM_FK FOREIGN KEY" +
  "(PLATINUM_EMAIL) REFERENCES CLASSIFIED_CUSTOMER (CLASS_EMAIL) ON DELETE CASCADE ENABLE";

alter[118] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER ADD CONSTRAINT PLATINUM_REVIEW_CUSTOMER_FK" +
  "FOREIGN KEY (PLATINUM_EMAIL_REVCUST) REFERENCES PLATINUM (PLATINUM_EMAIL) ON DELETE CASCADE ENABLE";
   alter[119] ="ALTER TABLE PLATINUM_REVIEW_CUSTOMER ADD CONSTRAINT PLATINUM_REVIEW_CUSTOMER_FK2"+
  "FOREIGN KEY (CUST_EMAIL_REVCUST) REFERENCES CUSTOMER (CUST_EMAIL) ON DELETE CASCADE ENABLE";

   alter[120 ]="ALTER TABLE TRANS_INVOLVE_ITEM ADD CONSTRAINT TRANS_INVOLVE_ITEM_FK FOREIGN KEY" +
  "(TRAN_INV_TRANS_ID) REFERENCES TRANSACTION (TRANS_ID) ON DELETE CASCADE ENABLE";
   alter[121] ="ALTER TABLE TRANS_INVOLVE_ITEM ADD CONSTRAINT TRANS_INVOLVE_ITEM_FK3"+
  "FOREIGN KEY (TRAN_INV_ITEM_NO, TRAN_INV_ITEM_EMAIL) REFERENCES ITEM (ITEM_NO, ITEM_EMAIL) ON DELETE CASCADE ENABLE";

   alter[122] ="CREATE SEQUENCE THREAD_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999" +
  "INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ";
  
  for ( int i= 7; i<=122; i++){
  stmt.executeUpdate(alter[i]);
  }// end for loop
  
  
  stmt.execute("CREATE OR REPLACE TRIGGER BI_THREAD" +
  "before insert on THREAD" +              
  "for each row"+  
"begin" +  
  "if :NEW.THEAD_ID is null then"+ 
    "select THREAD_SEQ.nextval into :NEW.THEAD_ID from dual"+ 
  "end if"+
"end;") ;
  
  stmt.execute("ALTER TRIGGER BI_THREAD ENABLE"+

  "CREATE OR REPLACE TRIGGER BI_TRANSACTION "+
  "before insert on TRANSACTION "+              
  "for each row "+ 
"begin "+  
  "if :NEW.TRANS_ID is null then"+ 
    "select TRANSACTION_SEQ.nextval into :NEW.TRANS_ID from dual"+ 
  "end if"+ 
"end;"); 
  
      System.out.println("Tables Created");  
*/      
 /*     System.out.print("Enter query number from 1 to 25");
      String input = sc.nextLine();
      
      System.out.print("Query No. : "+ input);
      String sql = "";*/
      
  int inputNum;
  System.out.println("Please select queries from 1-25");

  Scanner reader = new Scanner(System.in);
  inputNum = reader.nextInt(); 
  
  switch(inputNum){

case 1: {
    
stmt.executeUpdate("Insert into CUST_BID_ITEM (BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT,"+
"BID_DATE_TIME,BID_CUST_EMAIL) values ('NellaFiorentino@armyspy.com',3,1400,to_timestamp"+
"('12-APR-14 07.59.24.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'NoahMiah@dayrep.com')");
stmt.executeUpdate("Insert into TRANSACTION (TRANS_ID,TRANS_DATE_TIME,TYPE,AMOUNT)"+
"values (24,to_timestamp('12-APR-14 07.59.24.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'BI',1400)");
stmt.executeUpdate("Insert into CUST_GENERATE_TRANS (CUST_TRANS_EMAIL,GEN_TRANS_ID)"+
"values ('NoahMiah@dayrep.com',24)");
stmt.executeUpdate("Insert into TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID,"+
"TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL) values (24,3,'NellaFiorentino@armyspy.com')");

stmt.executeQuery("select BID_CUST_EMAIL, WinningBid, BID_DATE_TIME from CUST_BID_ITEM natural join"+
"(select MAX(AMOUNT) WinningBid , BID_ITEM_EMAIL,BID_ITEM_NO FROM"+
"(select distinct BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT from CUST_BID_ITEM"+
"where AMOUNT in (select MAX(AMOUNT) MAXAMT from"+
"(Select AMOUNT, TRANS_ID from TRANSACTION where TYPE = 'BI')"+
"group by TRANS_ID)group by BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT"+
"having AMOUNT = MAX(AMOUNT))group by BID_ITEM_EMAIL,BID_ITEM_NO)");

ResultSetMetaData metaData = result.getMetaData();
int numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("create or replace view v01a as"+
"select * from "+
"(select MAX(AMOUNT) WinningBid,BID_ITEM_EMAIL,BID_ITEM_NO,BID_CUST_EMAIL FROM CUST_BID_ITEM natural join"+
"(select distinct BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT from CUST_BID_ITEM"+
"where AMOUNT in"+
"(select MAX(AMOUNT) MAXAMT from"+
"(Select AMOUNT, TRANS_ID from TRANSACTION where TYPE = 'BI')"+
"group by TRANS_ID))"+
"group by BID_ITEM_EMAIL,BID_ITEM_NO,BID_CUST_EMAIL)");

stmt.executeUpdate("create or replace view v01c as"+
"select * from v01a"+
"where WinningBid in"+
"(select Max(WinningBid) from v01a)");

stmt.executeUpdate("Insert into TRANSACTION (TRANS_ID,TRANS_DATE_TIME,TYPE,AMOUNT)"+
"values (TRANSACTION_SEQ.NEXTVAL,to_timestamp(SYSDATE),'PI', (select WINNINGBID from v01c))");
stmt.executeUpdate("Insert into CUST_GENERATE_TRANS (CUST_TRANS_EMAIL,GEN_TRANS_ID) "+
"values ((select BID_CUST_EMAIL from v01c),(select max(TRANS_ID) from TRANSACTION where type = 'PI' and AMOUNT = (select WINNINGBID from v01c)))");
stmt.executeUpdate("Insert into TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID,TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL)"+
"values ((select max(TRANS_ID) from TRANSACTION where type = 'PI' and AMOUNT = (select WINNINGBID from v01c)),"+
 "(select BID_ITEM_NO from v01a where v01a.WINNINGBID in (select WINNINGBID from v10c)),"+
 "(select BID_ITEM_EMAIL from v01a where v01a.WINNINGBID in (select WINNINGBID from v10c)))");      
}
break;

case 2: 
stmt.executeUpdate("select  TITLE, LAST_NAME, CITY, COUNTRY,STATUS, EXTRACT(DAY FROM SYSDATE - CLASS_DATE_TIME) as No_Of_Days from CUSTOMER," +
" (select CLASS_EMAIL, CLASS_DATE_TIME, 'GOLD' as STATUS  from CLASSIFIED_CUSTOMER, GOLD" +
"  where CLASS_EMAIL = GOLD_EMAIL" +
"  UNION" +
"  select CLASS_EMAIL, CLASS_DATE_TIME, 'PLATINUM' as STATUS  from CLASSIFIED_CUSTOMER, PLATINUM" +
"  where CLASS_EMAIL = PLATINUM_EMAIL) " +
"  WHERE CUST_EMAIL = CLASS_EMAIL" +
"  ORDER BY STATUS, No_Of_Days desc, LAST_NAME asc");

result = stmt.executeQuery("select * from customer");

ResultSetMetaData metaData = result.getMetaData();
int numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }

break;
    
case 3: String queryString = " select ITEM_NO, WEIGHT, PRICE, first_name || ' ' || last_name AS full_name, COUNTRY, FILENAME, DESCRIPTION from ITEM, CUSTOMER" + 
  "where CUST_EMAIL = ITEM_EMAIL" +
  "and (ITEM_NO, ITEM_EMAIL) in (select ITEM_NO,ITEM_EMAIL from ITEM where (ITEM_NO, ITEM_EMAIL) in (select KEY_ITEM_NO,KEY_ITEM_EMAIL" +  
  "from KEYWORDS where KEYWORD = '&KEYWORD' or DESCRIPTION like '%KEYWORD%'))" +
  "ORDER BY PRICE desc"; 
  
  PreparedStatement preparedStatement = conn.prepareStatement(queryString);
  
  String keyword;
  Scanner scan = new Scanner(System.in);
  System.out.print("Please enter a search term:");
  keyword = scan.next();
  
  preparedStatement.setString(1, keyword);
  result = preparedStatement.executeQuery();

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
 
break;
    
case 4: 
 stmt.executeUpdate("create or replace view v4 as"+
                        "select  CUST_TRANS_EMAIL, count(*) as No_of_Trans from CUST_GENERATE_TRANS"+
                        "where CUST_TRANS_EMAIL not in (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)"+
                        "group by CUST_TRANS_EMAIL"+
                        "select FIRST_NAME, LAST_NAME, MIDDLE_INITIALS, CUST_EMAIL from CUSTOMER where CUST_EMAIL in" +
                        "(select CUST_TRANS_EMAIL from v4 where No_of_Trans in (select MAX(No_of_Trans) from v4)) ");
stmt.execute("select * from v4");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }  
  
break;

case 5: 
    
Savepoint savePoint = conn.setSavepoint();
 stmt.executeQuery("create or replace view v5 as"+
"select  CUST_TRANS_EMAIL, count(*) as No_of_Trans from CUST_GENERATE_TRANS"+
"where CUST_TRANS_EMAIL not in (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)"+
"group by CUST_TRANS_EMAIL");

stmt.executeQuery("select * from GOLD");
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }

stmt.executeUpdate("INSERT into CLASSIFIED_CUSTOMER VALUES"+
"((select CUST_TRANS_EMAIL from v5 where No_of_Trans in (select MAX(No_of_Trans) from v5)), '05-MAR-14 03:36:35.000000000 AM',"+
"(select COUNT(TRANS_ID) from TRANSACTION where TYPE = 'SI'))");

stmt.executeUpdate("INSERT into GOLD VALUES((select CLASS_EMAIL from CLASSIFIED_CUSTOMER where CLASS_EMAIL not in (select GOLD_EMAIL from GOLD) AND"+
"CLASS_EMAIL not in (select PLATINUM_EMAIL from PLATINUM) AND rownum = 1))");

stmt.executeQuery("select * from GOLD");
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
conn.rollback(savePoint);   
break;

case 6: 
stmt.executeUpdate("create or replace view v6 as"+
"select MSG_THREAD_ID, MIN(EXTRACT(DAY FROM SYSDATE - MSG_DATE_TIME)) as min_date from MESSAGE group by MSG_THREAD_ID");

stmt.executeUpdate("create or replace view v6a as"+
"select MSG_THREAD_ID, count(*) as No_of_Msg from MESSAGE"+ 
"group by MSG_THREAD_ID");

stmt.executeUpdate("create or replace view v6b as"+
"select MSG_THREAD_ID, MAX(MSG_DATE_TIME) as Most_Recent_Msg from MESSAGE "+
"where (MSG_THREAD_ID, EXTRACT(DAY FROM SYSDATE - MSG_DATE_TIME)) in (select MSG_THREAD_ID, min_date from v6)"+
"group by MSG_THREAD_ID");

stmt.executeQuery("select THREAD_TITLE, LAST_NAME, MODERATE_PLATINUM_EMAIL, No_of_Msg, Most_Recent_Msg"+
"from CUSTOMER c, THREAD t,"+
"(select * from v6a"+
"UNION"+
"select THEAD_ID, 0 as No_of_Msg from THREAD"+ 
"where THEAD_ID not in (select MSG_THREAD_ID from v6a)"+
")t1,"+

"(select * from v6b"+
"UNION"+
"select THEAD_ID,null from THREAD"+
"where THEAD_ID not in (select MSG_THREAD_ID from v6b)"+
")t2," +

"(select MODERATE_THREAD_ID, MODERATE_PLATINUM_EMAIL from PLATINUM_MODERATE_THREAD)t3"+

"where THEAD_ID = t1.MSG_THREAD_ID and t1.MSG_THREAD_ID = t2.MSG_THREAD_ID and"+
"t2.MSG_THREAD_ID = t3.MODERATE_THREAD_ID and t3.MODERATE_PLATINUM_EMAIL = c.CUST_EMAIL"+
"order by Most_Recent_Msg");    

 metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");

 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 7: 
 stmt.executeUpdate("create or replace view v7 as"+
"select TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM"+
"where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN"+
"(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'SI'))");

stmt.executeUpdate("create or replace view v7a as"+
"SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'SI')"+
"group by CUST_TRANS_EMAIL");

stmt.executeUpdate("create or replace view v7b as|"+
"select ITEM_EMAIL, SUM(tot_cost) as TOTAL_COST from"+
"(select ITEM_EMAIL, ITEM_NO, SUM(PRICE) as tot_cost from ITEM WHERE (ITEM_EMAIL, ITEM_NO) IN (select * from v7)"+
"group by ITEM_EMAIL, ITEM_NO)"+
"group by ITEM_EMAIL");

stmt.executeUpdate("create or replace view v7c as"+
"SELECT TRAN_INV_ITEM_EMAIL, AVG(avg_rat) as Avg_Rating from"+
"(SELECT TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO, AVG(RATING) as avg_rat from PLATINUM, v7, CLASSCUST_REVIEW_ITEM"+
"where PLATINUM_EMAIL = CLASS_EMAIL_REVITEM and ITEM_EMAIL_REVITEM = TRAN_INV_ITEM_EMAIL and ITEM_NO_REVITEM = TRAN_INV_ITEM_NO"+
"group by TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO)"+
"group by TRAN_INV_ITEM_EMAIL");

stmt.executeUpdate("create or replace view v7d as"+
"SELECT CUST_EMAIL, 0 as Avg_Rating from CUSTOMER"+
"where CUST_EMAIL not in (select TRAN_INV_ITEM_EMAIL from v7c)"+
"UNION"+
"SELECT * from v7c");

stmt.executeUpdate("create or replace view v7e as"+
"SELECT CUST_EMAIL, 0 as Total_Cost from CUSTOMER"+
"where CUST_EMAIL not in (select ITEM_EMAIL from v7b)"+
"UNION"+
"SELECT * from v7b)");

stmt.executeUpdate("create or replace view v7f as"+
"SELECT CUST_EMAIL, 0 as Items_Sold from CUSTOMER"+
"where CUST_EMAIL not in (select CUST_TRANS_EMAIL from v7a)"+
"UNION"+
"SELECT * from v7a");

stmt.executeUpdate("create or replace view v7g as"+
"select concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME) as FULL_NAME, Items_Sold, TOTAL_COST, Avg_Rating"+
"from  CUSTOMER, v7d, v7e, v7f"+
"where CUSTOMER.CUST_EMAIL = v7d.CUST_EMAIL and v7d.CUST_EMAIL = v7e.CUST_EMAIL and v7e.CUST_EMAIL = v7f.CUST_EMAIL"+
"order by Items_Sold desc");

stmt.executeQuery("select FULL_NAME, Items, Costs, Avg_Rating from"+
"((select FULL_NAME, ('' || Items_Sold) as Items, ('' || TOTAL_COST) as Costs, Avg_Rating, 0 as priority from v7g)"+
"UNION"+
"(select null, ('Total items = ' || sum(Items_Sold)) as Items, ('Total cost = ' || sum(TOTAL_COST))as Costs, null, 1 as priority"+
"from v7g))"+
"order by priority, Items desc");
 
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }  
break;

case 8: 
 stmt.executeUpdate("create or replace view v8 as"+
"select TRAN_INV_ITEM_EMAIL, TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM"+
"where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN"+
"(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'IT'))");

stmt.executeUpdate("create or replace view v8a as"+
"select TRADE_ACCEPT_CUST_EMAIL, TRADE_ACCEPT_ITEM_NO from CUSTOMER_TRADE_ITEM"+
"WHERE (TRADE_ITEM_EMAIL, TRADE_ITEM_NO) IN ("+
"select TRAN_INV_ITEM_EMAIL, TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM"+
"where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN"+
"(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'IT')))");

stmt.executeUpdate("create or replace view v8b as"+
"SELECT CUST_TRANS_EMAIL, count(*) as No_of_Trade from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'AT') OR GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'IT')"+
"group by CUST_TRANS_EMAIL");

stmt.executeUpdate("create or replace view v8c as"+
"select TRAN_INV_ITEM_EMAIL, COUNT(*) as tot_item1 from v8"+
"group by TRAN_INV_ITEM_EMAIL");

stmt.executeUpdate("create or replace view v8d as"+
"select TRADE_ACCEPT_CUST_EMAIL, COUNT(*) as tot_item2 from v8a"+
"group by TRADE_ACCEPT_CUST_EMAIL");

stmt.executeUpdate("create or replace view v8e as"+
"SELECT CUST_EMAIL, 0 as No_of_Trade from CUSTOMER"+
"where CUST_EMAIL not in (select CUST_TRANS_EMAIL from v8b)"+
"UNION"+
"SELECT * from v8b");

stmt.executeUpdate("create or replace view v8f as"+
"SELECT CUST_EMAIL, 0 as No_of_Items1 from CUSTOMER"+
"where CUST_EMAIL not in (select TRAN_INV_ITEM_EMAIL from v8c)"+
"UNION"+
"SELECT * from v8c");

stmt.executeUpdate("create or replace view v8g as"+
"SELECT CUST_EMAIL, 0 as No_of_Items2 from CUSTOMER"+
"where CUST_EMAIL not in (select TRADE_ACCEPT_CUST_EMAIL from v8d)"+
"UNION"+
"SELECT * from v8d");

stmt.executeUpdate("create or replace view v8h as"+
"select v8f.CUST_EMAIL, (v8f.No_of_Items1 + v8g.No_of_Items2) as No_of_Items from"+
"v8f, v8g"+
"where v8f.CUST_EMAIL = v8g.CUST_EMAIL");

stmt.executeUpdate("create or replace view v8i as"+
"select concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME) as FULL_NAME, No_of_Trade, No_of_Items"+
"from  CUSTOMER, v8e, v8h"+
"where CUSTOMER.CUST_EMAIL = v8e.CUST_EMAIL and v8e.CUST_EMAIL = v8h.CUST_EMAIL"+ 
"order by No_of_Trade desc");

stmt.executeUpdate("select FULL_NAME, Trades, Items from"+
"((select FULL_NAME, ('' || No_of_Trade) as Trades, ('' || No_of_Items) as Items, 0 as priority from v8i)"+
"UNION"+
"(select null, ('Total trades = ' || sum(No_of_Trade)) as Trades, ('Total items = ' || sum(No_of_Items))as Items, 1 as priority"+
"from v8i))"+
"order by priority, Trades desc");

break;

case 9:
 stmt.executeUpdate("create or replace view v09a as"+ 
"select EXTRACT(MONTH FROM TRANS_DATE_TIME)as month,"+
  "EXTRACT(YEAR FROM TRANS_DATE_TIME)as year,"+
  "TRANS_ID,TRANS_DATE_TIME,AMOUNT,TYPE"+
  "from transaction"+
"order by year,month,TRANS_ID");

stmt.executeUpdate("create or replace view v09b as"+
"select EXTRACT(MONTH FROM TRANS_DATE_TIME) as month,"+
  "EXTRACT(YEAR FROM TRANS_DATE_TIME) as year , count(TRANS_ID) transnumber"+
  "from transaction"+
  "group by EXTRACT(year FROM TRANS_DATE_TIME),EXTRACT(month FROM TRANS_DATE_TIME)"+
  "order by year, month");

stmt.executeUpdate("create or replace view v09c as"+
"select EXTRACT(year FROM TRANS_DATE_TIME) year ,EXTRACT(month FROM TRANS_DATE_TIME) month, sum(AMOUNT) SUMMATION"+ 
  "from transaction"+
"group by EXTRACT(year FROM TRANS_DATE_TIME),EXTRACT(month FROM TRANS_DATE_TIME)"+
"order by year, month");

stmt.executeQuery("select Month_Part as TransactionMonth ,Year_Part as TransactionYear, header as Particulars"+
"from"+
"("+
  "(select month,year, month as Month_Part, year as Year_Part,"+
  "(v09a.TRANS_ID ||' '|| v09a.TRANS_DATE_TIME ||' '|| v09a.AMOUNT ||' '|| v09a.TYPE )as header ,1 as sortorder"+
  "from v09a"+
  "union"+
  "select month,year, null as Month_Part, null as Year_Part, ('# of Transactions ' || v09b.TRANSNUMBER ) as header, 2 as sortorder"+
  "from v09b"+
  "union"+
  "select month,year, null as Month_Part, null as Year_Part, ('Monthly Total' ||' '|| V09C.SUMMATION ) as header, 3 as sortorder"+
  "from v09c"+
  ")"+
")t order by year, month, sortorder");

 metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 10: 
    
stmt.executeUpdate("create or replace view v10a as"+
"select distinct CUST_TRANS_EMAIL as email from CUST_GENERATE_TRANS"+
"inner join TRANSACTION"+
"on GEN_TRANS_ID IN"+
"(select TRANS_ID from Transaction"+
"where type = 'PI')");

//-- customers who are classified
stmt.executeUpdate("create or replace view v10b as"+
"select CUST_EMAIL, 'REGULAR' as STATUS from CUSTOMER"+
  "where CUST_EMAIL NOT IN (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)"+
  "UNION"+
  "select CLASS_EMAIL, 'GOLD' as STATUS  from CLASSIFIED_CUSTOMER, GOLD"+
  "where CLASS_EMAIL = GOLD_EMAIL"+
  "UNION"+
  "select CLASS_EMAIL, 'PLATINUM' as STATUS  from CLASSIFIED_CUSTOMER, PLATINUM"+
  "where CLASS_EMAIL = PLATINUM_EMAIL");
  
  //-- status of customers who won bid
  stmt.executeUpdate("create or replace view v10c as"+
  "select distinct v10b.CUST_EMAIL , v10b.STATUS"+
  "from v10b"+
  "where CUST_EMAIL in (select email from v10a)");
  
  //-- items that were sold to winners
  stmt.executeUpdate("create or replace view v10d as"+ 
  "select distinct ITEM_NO,ITEM_EMAIL,PRICE from item inner join CUST_BID_ITEM on "+
  "BID_ITEM_EMAIL = ITEM_EMAIL"+
  "and BID_ITEM_NO = ITEM_NO");
  
  //-- amount paid by winning customers
  stmt.executeUpdate("create or replace view v10e as"+
  "select max(AMOUNT) maxamt ,BID_ITEM_EMAIL,BID_ITEM_NO from CUST_BID_ITEM"+
  "where BID_CUST_EMAIL in"+ 
  "(select CUST_EMAIL from v10c)"+
  "group by (BID_ITEM_EMAIL,BID_ITEM_NO)");
  
  //-- get discount 
  stmt.executeUpdate("create or replace view v10f as"+
  "select CUST_EMAIL, 0 as discount from v10c"+
  "where STATUS = 'REGULAR'"+
  "UNION"+
  "select CLASS_EMAIL, DISCOUNT as discount from CLASSIFIED_CUSTOMER"+
  "where CLASS_EMAIL in (select CUST_EMAIL from v10c where STATUS = 'GOLD')"+
  "UNION"+
  "select CLASS_EMAIL, DISCOUNT as discount from CLASSIFIED_CUSTOMER"+
  "where CLASS_EMAIL in (select CUST_EMAIL from v10c where STATUS = 'PLATINUM'");
  
  stmt.executeQuery("select distinct CUST_EMAIL,(MAXAMT - ((DISCOUNT*MAXAMT)/100) - PRICE)"+
  "as OVERPAID  from v10d natural join v10e natural join v10f"+ 
  "where "+
  "ITEM_EMAIL = BID_ITEM_EMAIL"+
  "and"+ 
  "ITEM_NO = BID_ITEM_NO");

 metaData = result.getMetaData();

 numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 11: 

stmt.executeQuery("select cust_email from customer where zip in"+ 
"(select zip from CUSTOMER having count(zip) ="+
"(select max(count(zip)) from customer"+ 
"group by zip)group by zip)");
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("create or replace view v11a as "+
"select count(*) as totaltrades from CUSTOMER_TRADE");

stmt.executeUpdate("create or replace view v11b as"+
"select count(*) as tradesinsamezip from CUSTOMER_TRADE"+
"where INITIATE_CUST_EMAIL in (select cust_email from customer "+
"where zip in (select zip from CUSTOMER having count(zip) ="+
"(select max(count(zip)) from customer group by zip)"+
"group by zip))"+
"AND"+
"ACCEPT_CUST_EMAIL in "+

"(select cust_email from customer"+ 
"where zip in "+
"(select zip from CUSTOMER"+
"having count(zip) ="+
"(select max(count(zip)) from customer "+
"group by zip)"+
"group by zip))");

stmt.executeQuery("select ((TRADESINSAMEZIP/TOTALTRADES)*100)"+
"percenttrade,TOTALTRADES,TRADESINSAMEZIP from v11a,v11b");
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 12: 
stmt.executeUpdate("create or replace view v12a as"+ 
"select CUST_EMAIL_REVCUST, count(*) numberratings FROM"+
"(select CUST_EMAIL_REVCUST, CRITIQUE from PLATINUM_REVIEW_CUSTOMER"+
"where CRITIQUE = 'POOR' or  CRITIQUE = 'FAIR')"+
"group by CUST_EMAIL_REVCUST");

stmt.executeQuery("select ITEM_NO, WEIGHT, PRICE, (FIRST_NAME ||"+
 "MIDDLE_INITIALS || LAST_NAME) CustomerName  from customer inner join"+
"(select * from item where ITEM_EMAIL in"+
"(select CUST_EMAIL_REVCUST as customer from V12A"+
"where NUMBERRATINGS IN (select Numberratings From v12a"+
 "where numberratings >= 2))) on ITEM_EMAIL = customer.CUST_EMAIL"+
 "order by LAST_NAME,FIRST_NAME,MIDDLE_INITIALS");
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
 metaData = result.getMetaData();
 numberOfColumns= metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
    
case 13: 
    
stmt.executeUpdate("create or replace view v13 as "+
"select TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL, count(*) as Trade_Count"+ 
"from CUSTOMER_TRADE_ITEM"+
"group by TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL");

stmt.executeUpdate("create or replace view v13a as"+
"select t1.TRADE_ITEM_EMAIL, t1.TRADE_ACCEPT_CUST_EMAIL, t1.Trade_Count from v13 t1,v13 t2"+
"where t1.TRADE_ITEM_EMAIL = t2.TRADE_ACCEPT_CUST_EMAIL"+
         " and t1.TRADE_ACCEPT_CUST_EMAIL = t2.TRADE_ITEM_EMAIL");

stmt.executeUpdate("create or replace view v13b as "+
"select ROWNUM as row_num, TRADE_ITEM_EMAIL, "+
 "TRADE_ACCEPT_CUST_EMAIL, Trade_Count from v13a");

stmt.executeUpdate("create or replace view v13c as "+
"select  TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL,"+
"Trade_Count from v13b where  mod(row_num,2) = 1");

stmt.executeUpdate("create or replace view v13d as "+
"select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL, Trade_Count" +
" from v13b where  mod(row_num,2) = 0");

stmt.executeUpdate("create or replace view v13e as "+
"select v13c.TRADE_ACCEPT_CUST_EMAIL, v13c.TRADE_ITEM_EMAIL," +
"v13c.Trade_Count + v13d.Trade_Count as Max_Trade from v13c,v13d"+
"where v13c.TRADE_ACCEPT_CUST_EMAIL = v13d.TRADE_ITEM_EMAIL"+
 "and v13c.TRADE_ITEM_EMAIL = v13d.TRADE_ACCEPT_CUST_EMAIL");

stmt.executeUpdate("create or replace view v13f as"+
"select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL"+
 "from v13e where Max_Trade = (select Max(Max_Trade) from v13e)");

stmt.executeQuery("(select ROWNUM, concat(FIRST_NAME,LAST_NAME)"+
"|| ' -> ' as CUSTOMER1 from CUSTOMER where CUST_EMAIL in (select TRADE_ACCEPT_CUST_EMAIL FROM v13f))");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("(select ROWNUM, ' -> ' || concat(FIRST_NAME,LAST_NAME) "+
 "as CUSTOMER2 from CUSTOMER where CUST_EMAIL in (select TRADE_ITEM_EMAIL FROM v13f))");
break;
    
case 14: 
queryString = "create or replace view v14 as"+
"select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME"+
"from MESSAGE where (MSG_ID, MSG_THREAD_ID) in"+
"(select MSG_ID, MSG_THREAD_ID from MESSAGE where MSG_THREAD_ID = '&MSG_THREAD_ID')"+
"order by MSG_DATE_TIME";
preparedStatement = conn.prepareStatement(queryString);
  
  scan = new Scanner(System.in);
  System.out.print("Please enter thread id:");
  keyword = scan.next();
  
  preparedStatement.setString(1, keyword);
  
  ResultSet rset = preparedStatement.executeQuery(); 


stmt.executeUpdate("create or replace view v14a as"+
"select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME, No_of_Replies"+
"from v14,"+
"(select THREAD_ID_REPLY, MSG_ID_REPLY, COUNT(*) as No_of_Replies from MESSAGE_REPLY"+
"group by (THREAD_ID_REPLY, MSG_ID_REPLY))"+
"where MSG_ID = MSG_ID_REPLY and MSG_THREAD_ID = THREAD_ID_REPLY");

stmt.executeUpdate("create or replace view v14b as"+
"select v14.MSG_THREAD_ID, v14.MSG_ID, v14.MSG_TEXT, v14.MSG_DATE_TIME, 0 as No_of_Replies"+
"from v14"+
"where (v14.MSG_THREAD_ID, v14.MSG_ID) NOT IN (select v14a.MSG_THREAD_ID, v14a.MSG_ID from v14a");

stmt.executeUpdate("create or replace view v14c as"+
"select MSG_THREAD_ID, MSG_ID, MSG_TEXT, MSG_DATE_TIME,NO_OF_REPLIES, MSG_STATUS"+ 
"from (select * from v14a union select * from v14b)t1, CUST_RATE_MSG"+
"where t1.MSG_THREAD_ID = RATE_THREAD_ID AND t1.MSG_ID = RATE_MSG_ID");

stmt.executeUpdate("create or replace view v14d as"+
"select MSG_THREAD_ID, MSG_ID,count(*) as Like_count"+
"from v14c where MSG_STATUS = 'LIKE'"+
"group by (MSG_THREAD_ID, MSG_ID)");

stmt.executeUpdate("create or replace view v14e as"+
"select MSG_THREAD_ID, MSG_ID,count(*) as Dislike_count"+
"from v14c where MSG_STATUS = 'DISLIKE'"+
"group by (MSG_THREAD_ID, MSG_ID)");

stmt.executeUpdate("create or replace view v14f as"+
"select MSG_THREAD_ID, MSG_ID, Like_count"+
"from v14d"+ 
"UNION"+
"select MSG_THREAD_ID, MSG_ID, 0 as Like_count from v14e"+ 
"where (MSG_THREAD_ID, MSG_ID) NOT IN (select MSG_THREAD_ID, MSG_ID from v14d)");

stmt.executeUpdate("create or replace view v14g as"+
"select MSG_THREAD_ID, MSG_ID, Dislike_count"+
"from v14e UNION"+
"select MSG_THREAD_ID, MSG_ID, 0 as Dislike_count from v14d"+
"where (MSG_THREAD_ID, MSG_ID) NOT IN (select MSG_THREAD_ID, MSG_ID from v14e)");

stmt.executeUpdate("select DISTINCT MSG_ID, MSG_TEXT, MSG_DATE_TIME,NO_OF_REPLIES from v14c"+
"where (MSG_THREAD_ID, MSG_ID) in"+
"(select t1.MSG_THREAD_ID, t1.MSG_ID from"+
"v14f t1,"+
"v14g t2"+
"where t1.MSG_THREAD_ID = t2.MSG_THREAD_ID and t1.MSG_ID = t2.MSG_ID and Like_count >= Dislike_count)"+
"order by MSG_DATE_TIME");
break;

case 15: 
    
stmt.executeUpdate("create or replace view t1 as"+
"select distinct * from"+
"(select country as SellingCountry from CUSTOMER"+
"where CUST_EMAIL IN"+
"(select CUST_TRANS_EMAIL from CUST_GENERATE_TRANS"+
"where GEN_TRANS_ID IN"+
"(select TRANS_ID from TRANSACTION"+ 
"where TYPE = 'SI')"+
"))v1,"+
"(select country as PurchaseCountry from CUSTOMER"+
"where CUST_EMAIL IN"+
"(select CUST_TRANS_EMAIL from CUST_GENERATE_TRANS"+
"where GEN_TRANS_ID IN"+
"(select TRANS_ID from TRANSACTION"+ 
"where TYPE = 'PI')"+
"))v2"+
"where v1.SellingCountry <> v2.PurchaseCountry");

stmt.executeUpdate("create or replace view t2 as"+
"select country, count(distinct(item_found)) as NUMBER_OF_ITEMS_SOLD from item,"+
  "(select country, CUST_EMAIL as country_cust_email, item_found  from CUSTOMER,"+
      "(select TRAN_INV_ITEM_EMAIL ,TRAN_INV_ITEM_NO as item_found from TRANS_INVOLVE_ITEM"+
        "where TRAN_INV_TRANS_ID IN"+
                "(select TRANS_ID from TRANSACTION "+
                 "where TYPE = 'SI')"+
     " )where CUST_EMAIL = TRAN_INV_ITEM_EMAIL)"+
"group by country");

stmt.executeQuery("select t2.COUNTRY,t2.NUMBER_OF_ITEMS_SOLD from"+ 
"t1 join t2 on t1.SELLINGCOUNTRY = t2.COUNTRY");
 
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }   
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }    
break;

case 16: 
    
stmt.executeQuery("select s1.CUST_EMAIL,s1.LAST_NAME,s1.REG_DATE,s2.STATUS"+
"from"+
  "(select CUST_EMAIL,LAST_NAME,REG_DATE"+
    "from CUSTOMER,"+ 
      "(select v1.CUST_TRANS_EMAIL from"+
      "(select CUST_TRANS_EMAIL, COUNT(*) as count_bi  from CUST_GENERATE_TRANS, TRANSACTION"+
      "where GEN_TRANS_ID = TRANS_ID AND type = 'BI'"+
      "GROUP BY CUST_TRANS_EMAIL)v1,"+
      "(select CUST_TRANS_EMAIL, COUNT(*) as count_pi  from CUST_GENERATE_TRANS, TRANSACTION"+
      "where GEN_TRANS_ID = TRANS_ID AND type = 'PI'"+
      "GROUP BY CUST_TRANS_EMAIL)v2"+
      "where v1.CUST_TRANS_EMAIL = v2.CUST_TRANS_EMAIL AND v1.count_bi > v2.count_pi"+
      ")t1"+
  "WHERE"+
  "T1.CUST_TRANS_EMAIL = CUST_EMAIL)S1,"+
  "(select CUST_EMAIL, 'REGULAR' as STATUS from CUSTOMER"+
  "where CUST_EMAIL NOT IN (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)"+
  "UNION"+
  "select CLASS_EMAIL, 'GOLD' as STATUS  from CLASSIFIED_CUSTOMER, GOLD"+
  "where CLASS_EMAIL = GOLD_EMAIL"+
  "UNION"+
  "select CLASS_EMAIL, 'PLATINUM' as STATUS  from CLASSIFIED_CUSTOMER, PLATINUM"+
  "where CLASS_EMAIL = PLATINUM_EMAIL)S2"+
"where s1.CUST_EMAIL = s2.CUST_EMAIL"+
"order by s1.REG_DATE, s2.STATUS");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 17: 

stmt.executeUpdate("create or replace view v17a as"+
"select count(*) numbertimessoldtraded,TRAN_INV_ITEM_NO from"+ 
"(select distinct TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL  from TRANSACTION natural join TRANS_INVOLVE_ITEM"+
"where TYPE = 'SI' or TYPE = 'AT')"+
"group by TRAN_INV_ITEM_NO");

stmt.executeUpdate("create or replace view v17b as"+
"select AMOUNT,TRAN_INV_ITEM_NO from"+ 
"(select distinct TRAN_INV_ITEM_NO,AMOUNT  from TRANSACTION natural join TRANS_INVOLVE_ITEM"+
"where TYPE = 'SI' or TYPE = 'AT')");

stmt.executeQuery("select distinct ITEM_NO, WEIGHT, PRICE, AMOUNT MAXAMOUNT from ITEM inner join"+ 
"(select TRAN_INV_ITEM_NO,NUMBERTIMESSOLDTRADED, AMOUNT from "+ 
"(select * from v17a"+
"NATURAL join"+ 
"v17b))"+
"on ITEM_NO = TRAN_INV_ITEM_NO"+
"where NUMBERTIMESSOLDTRADED > 1");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
break;

case 18: 
 stmt.executeQuery("select BID_CUST_EMAIL, concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME)"+
 "as FULL_NAME, COUNTRY, BID_DATE_TIME, AMOUNT from CUSTOMER,"+
"(select BID_CUST_EMAIL, AMOUNT, BID_DATE_TIME from CUST_BID_ITEM where (BID_ITEM_NO, BID_ITEM_EMAIL) in"+
"(select ITEM_NO, ITEM_EMAIL from ITEM where price in (select max(price) from ITEM))"+
")where CUST_EMAIL = BID_CUST_EMAIL"+
"order by AMOUNT desc");
 
metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }   
break;

case 19: 
 stmt.executeQuery("select CUST_EMAIL from CUSTOMER"+
"where CUST_EMAIL in "+
"( select cust_trans_email "+
  "from CUST_GENERATE_TRANS"+
  "where GEN_TRANS_ID in"+
      "(SELECT Trans_id"+
      "FROM transaction"+
      "WHERE EXTRACT(YEAR FROM"+
      "to_timestamp(TRANS_DATE_TIME,'DD-MON-RR HH.MI.SSXFF AM'))"+
 "< EXTRACT(YEAR FROM to_timestamp(SYSDATE,'DD-MON-RR HH.MI.SSXFF AM'))- 1  )");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("create or replace view v19b as"+
"select CUST_EMAIL from CUSTOMER"+
"where CUST_EMAIL in "+
"(select cust_trans_email"+ 
  "from CUST_GENERATE_TRANS"+
  "where GEN_TRANS_ID in"+
      "(SELECT Trans_id"+
      "FROM transaction"+
      "WHERE EXTRACT(YEAR FROM"+
      "to_timestamp(TRANS_DATE_TIME,'DD-MON-RR HH.MI.SSXFF AM'))"+
"> EXTRACT(YEAR FROM to_timestamp(SYSDATE,'DD-MON-RR HH.MI.SSXFF AM'))- 1))");

stmt.executeQuery("select * from CUSTOMER");
ResultSetMetaData metaData2 = result.getMetaData();
int numberOfColumns2 = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns2; i++)
  {
       System.out.print(metaData2.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData2.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("update CUSTOMER set password = 'xyzzy'"+
"where CUST_EMAIL in"+
"(select CUST_EMAIL from "+
"(select * from v19a) minus (select * from v19b))");

stmt.executeQuery("select * from customer");
 ResultSetMetaData metaData3 = result.getMetaData();
int numberOfColumns3 = metaData3.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData3.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }   
break;

case 20:
stmt.executeUpdate("update CUST_RATE_MSG"+
"set msg_status = 'LIKE' where (rate_msg_id, rate_thread_id) in"+
  "(select msg_id, msg_thread_id from MESSAGE"+
    "where msg_date_time in"+ 
        "(select min(msg_date_time) as earliest_date from MESSAGE"+
         "where msg_id in"+
          "(select post_msg_id from CUST_POST_MSG "+
           "where post_cust_email in"+
                        "(select platinum_email from platinum"+
    "where VIEW_COUNT in (select max(view_count) from platinum))) ) )");
break;

case 21: 
Savepoint save = conn.setSavepoint();
stmt.executeUpdate("create or replace view v21 as"+
"(select ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM,"+
 "AVG(RATING) AS Avg_Rating from CLASSCUST_REVIEW_ITEM"+
"GROUP BY ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM)");

stmt.executeUpdate("create or replace view v21a as"+
"select ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM from"+
"v21 where Avg_Rating in (select MIN(Avg_Rating) from v21)");

result = stmt.executeQuery("select * from ITEM");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("update ITEM set PRICE = PRICE * 0.5"+
"where (ITEM_NO,ITEM_EMAIL) IN (select * from v21a)");

stmt.executeQuery("select * from ITEM");
 metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
conn.rollback(save);

case 22:
    
stmt.executeUpdate("create or replace view v22 as"+
"select TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM"+
"where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN"+
"(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'SI'))");

stmt.executeUpdate("create or replace view v22 as"+
"select MAX(Items_Sold) as Max_Sold_Plat from"+
"(SELECT PLATINUM_EMAIL, Items_Sold FROM PLATINUM,"+
"(SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from"+
 "CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'SI')"+
"group by CUST_TRANS_EMAIL)"+
"where PLATINUM_EMAIL = CUST_TRANS_EMAIL)");

stmt.executeUpdate("create or replace view v22a as"+
"SELECT GOLD_EMAIL, Items_Sold FROM GOLD,"+
"(SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from "+
"CUST_GENERATE_TRANS where GEN_TRANS_ID in ("+
"select TRANS_ID from TRANSACTION where TYPE = 'SI')"+
"group by CUST_TRANS_EMAIL)"+
"where GOLD_EMAIL = CUST_TRANS_EMAIL");

stmt.executeUpdate("update CLASSIFIED_CUSTOMER"+
"set DISCOUNT = DISCOUNT * 1.05"+
"where CLASS_EMAIL in (select GOLD_EMAIL from v22a,v22 where v22a.Items_Sold > v22.MAX_SOLD_PLAT)");

break;

case 23: 
    
save = conn.setSavepoint();

stmt.executeUpdate("create or replace view v23 as"+
"(select CUST_EMAIL_REVCUST, count(*) as REV_COUNT from PLATINUM_REVIEW_CUSTOMER"+
 "where critique='POOR' group by(CUST_EMAIL_REVCUST))");

stmt.executeQuery("select * from customer");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("delete from customer where CUST_EMAIL in"+
"(select CUST_EMAIL_REVCUST from v23 where REV_COUNT >2)");

stmt.executeQuery("select * from customer");
 metaData = result.getMetaData();
 numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
conn.rollback(save);

break;

case 24: 
    
save = conn.setSavepoint();   
stmt.executeUpdate("create or replace view v24 as(select RATE_MSG_ID, RATE_THREAD_ID,"+
"count(MSG_STATUS) as Resp_Count from CUST_RATE_MSG where"+
"MSG_STATUS = 'DISLIKE' group by(RATE_MSG_ID, RATE_THREAD_ID))");

stmt.executeQuery("select * from Message");
 metaData = result.getMetaData();
 numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("delete from Message where (MSG_ID, MSG_THREAD_ID) in"+ 
"(select RATE_MSG_ID, RATE_THREAD_ID from "+
"(select  RATE_MSG_ID, RATE_THREAD_ID from CUST_RATE_MSG where "+
"(RATE_MSG_ID, RATE_THREAD_ID) in (select  RATE_MSG_ID, RATE_THREAD_ID from v24"+
"where Resp_Count > 3))t1,"+
"(select MSG_ID, MSG_THREAD_ID from MESSAGE where  (MSG_ID, MSG_THREAD_ID)"+
"not in(select ATTACH_MSG_ID, ATTACH_THREAD_ID from MESSAGE_REPLY ))t2"+
 "where RATE_MSG_ID = MSG_ID AND RATE_THREAD_ID = MSG_THREAD_ID)");

stmt.executeQuery("select * from Message");
 metaData = result.getMetaData();
 numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
conn.rollback(save);
break;

case 25:
save = conn.setSavepoint();
stmt.executeUpdate("create or replace view v25 as"+
"(select ITEM_EMAIL, ITEM_NO from ITEM where SYSDATE > DEADLINE and (ITEM_EMAIL, ITEM_NO)"+ 
"not in (select ITEM_EMAIL, ITEM_NO from ITEM, (select BID_ITEM_EMAIL, BID_ITEM_NO, Amount from CUST_BID_ITEM)t"+
"where ITEM_EMAIL = BID_ITEM_EMAIL AND ITEM_NO = BID_ITEM_NO and AMOUNT < PRICE))");

stmt.executeQuery("select * from ITEM");

metaData = result.getMetaData();
numberOfColumns = metaData.getColumnCount();
  for(int i = 1; i <= numberOfColumns; i++)
  {
       System.out.print(metaData.getColumnLabel(i) + " | \t");
  }
   System.out.println("\n");
 //int count =0;
 while (result.next())
      {
        for(int j = 1; j <= metaData.getColumnCount(); j++)
    {
     System.out.print(result.getString(j) + " | \t");
    }
   System.out.println("\n");
      }
stmt.executeUpdate("delete from ITEM where (ITEM_EMAIL, ITEM_NO) in (select ITEM_EMAIL, ITEM_NO from v25)");

stmt.executeQuery("select * from ITEM");

conn.rollback(save);
break;
        
}
     
      stmt.close();
      conn.close();
}
    
    catch (ClassNotFoundException | SQLException e)
    {
      System.out.println("*** Connection Failed ***");
    }
  }
    
    
}
