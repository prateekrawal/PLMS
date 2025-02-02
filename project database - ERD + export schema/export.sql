--------------------------------------------------------
--  File created - Thursday-September-05-2019   
--------------------------------------------------------
DROP TABLE "PL_MMT"."ACCOUNT" cascade constraints;
DROP TABLE "PL_MMT"."FX_RATES" cascade constraints;
DROP TABLE "PL_MMT"."INTEREST_RATE" cascade constraints;
DROP TABLE "PL_MMT"."MONEY_MARKET" cascade constraints;
DROP TABLE "PL_MMT"."TRANSACTION" cascade constraints;
DROP TABLE "PL_MMT"."USER_DETAILS" cascade constraints;
--------------------------------------------------------
--  DDL for Table ACCOUNT
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."ACCOUNT" 
   (	"ACCOUNTNO" NUMBER, 
	"CURRENCY_TYPE" VARCHAR2(20 BYTE), 
	"BALANCE" NUMBER, 
	"USERID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FX_RATES
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."FX_RATES" 
   (	"ASK_RATE" NUMBER, 
	"BID_RATE" NUMBER, 
	"CURRENCY_PAIR" VARCHAR2(20 BYTE), 
	"RATE_GEN_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table INTEREST_RATE
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."INTEREST_RATE" 
   (	"ASK_RATE" NUMBER, 
	"BID_RATE" NUMBER, 
	"CURRENCY" VARCHAR2(20 BYTE), 
	"INTEREST_RATE_GEN_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MONEY_MARKET
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."MONEY_MARKET" 
   (	"MARKETID" NUMBER, 
	"AMOUNT" NUMBER, 
	"LEND_BORROW" VARCHAR2(20 BYTE), 
	"TXN_DATE" DATE, 
	"DUE_DATE" DATE, 
	"ACCOUNTNO" NUMBER, 
	"TRANSACTIONID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRANSACTION
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."TRANSACTION" 
   (	"TRANSACTIONID" NUMBER, 
	"ACCOUNTNO" NUMBER, 
	"DEBIT_OR_CREDIT" NUMBER, 
	"AMOUNT" NUMBER, 
	"TIMESTAMP" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_DETAILS
--------------------------------------------------------

  CREATE TABLE "PL_MMT"."USER_DETAILS" 
   (	"USERID" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into PL_MMT.ACCOUNT
SET DEFINE OFF;
REM INSERTING into PL_MMT.FX_RATES
SET DEFINE OFF;
REM INSERTING into PL_MMT.INTEREST_RATE
SET DEFINE OFF;
REM INSERTING into PL_MMT.MONEY_MARKET
SET DEFINE OFF;
REM INSERTING into PL_MMT.TRANSACTION
SET DEFINE OFF;
REM INSERTING into PL_MMT.USER_DETAILS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index MONEY_MARKET_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."MONEY_MARKET_PK" ON "PL_MMT"."MONEY_MARKET" ("MARKETID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ACCOUNT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."ACCOUNT_PK" ON "PL_MMT"."ACCOUNT" ("ACCOUNTNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."TABLE1_PK" ON "PL_MMT"."USER_DETAILS" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index INTEREST_RATE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."INTEREST_RATE_PK" ON "PL_MMT"."INTEREST_RATE" ("CURRENCY", "INTEREST_RATE_GEN_DATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FX_RATES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."FX_RATES_PK" ON "PL_MMT"."FX_RATES" ("CURRENCY_PAIR", "RATE_GEN_DATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TRANSACTION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PL_MMT"."TRANSACTION_PK" ON "PL_MMT"."TRANSACTION" ("TRANSACTIONID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table TRANSACTION
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."TRANSACTION" ADD CONSTRAINT "TRANSACTION_PK" PRIMARY KEY ("TRANSACTIONID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."TRANSACTION" MODIFY ("TRANSACTIONID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MONEY_MARKET
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."MONEY_MARKET" ADD CONSTRAINT "MONEY_MARKET_PK" PRIMARY KEY ("MARKETID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."MONEY_MARKET" MODIFY ("MARKETID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FX_RATES
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."FX_RATES" ADD CONSTRAINT "FX_RATES_PK" PRIMARY KEY ("CURRENCY_PAIR", "RATE_GEN_DATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."FX_RATES" MODIFY ("RATE_GEN_DATE" NOT NULL ENABLE);
  ALTER TABLE "PL_MMT"."FX_RATES" MODIFY ("CURRENCY_PAIR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table INTEREST_RATE
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."INTEREST_RATE" ADD CONSTRAINT "INTEREST_RATE_PK" PRIMARY KEY ("CURRENCY", "INTEREST_RATE_GEN_DATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."INTEREST_RATE" MODIFY ("INTEREST_RATE_GEN_DATE" NOT NULL ENABLE);
  ALTER TABLE "PL_MMT"."INTEREST_RATE" MODIFY ("CURRENCY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_DETAILS
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."USER_DETAILS" ADD CONSTRAINT "TABLE1_PK" PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."USER_DETAILS" MODIFY ("USERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."ACCOUNT" ADD CONSTRAINT "ACCOUNT_PK" PRIMARY KEY ("ACCOUNTNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PL_MMT"."ACCOUNT" MODIFY ("ACCOUNTNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."ACCOUNT" ADD CONSTRAINT "USERID" FOREIGN KEY ("USERID")
	  REFERENCES "PL_MMT"."USER_DETAILS" ("USERID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MONEY_MARKET
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."MONEY_MARKET" ADD CONSTRAINT "TRANSACTIONID" FOREIGN KEY ("TRANSACTIONID")
	  REFERENCES "PL_MMT"."TRANSACTION" ("TRANSACTIONID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TRANSACTION
--------------------------------------------------------

  ALTER TABLE "PL_MMT"."TRANSACTION" ADD CONSTRAINT "ACCOUNTNO" FOREIGN KEY ("ACCOUNTNO")
	  REFERENCES "PL_MMT"."ACCOUNT" ("ACCOUNTNO") ENABLE;
