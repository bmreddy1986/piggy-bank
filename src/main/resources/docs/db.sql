CREATE TABLE table_group (id varchar(10) NOT NULL, name varchar(30) NOT NULL, organizerid varchar(10) NOT NULL, 
	deposit int, roi int, PRIMARY KEY (id) );

CREATE TABLE table_member (id varchar(10) NOT NULL, name varchar(30) NOT NULL, address varchar(50), 
    email varchar(30), password varchar(30), PRIMARY KEY (id) );

CREATE TABLE table_m2m_grp_mem (groupid varchar(255) NOT NULL, groupstatus varchar(255), memberid varchar(10) NOT NULL, 
    memberstatus varchar(10), PRIMARY KEY (groupid, memberid) );

CREATE TABLE table_deposit (id varchar(10) NOT NULL, memberid varchar(10) NOT NULL, groupid varchar(10), 
    amount int NOT NULL, deposit_month varchar(10), banktxid varchar(30), loanid varchar(10), intamount int, PRIMARY KEY (id) );

CREATE TABLE table_loan (id varchar(10) NOT NULL, memberid varchar(10) NOT NULL, groupid varchar(10), 
	amount int NOT NULL, emicount int, banktxid varchar(30), status varchar(10), parentloanid varchar(10), 
    parentloanbal int, PRIMARY KEY (id) );