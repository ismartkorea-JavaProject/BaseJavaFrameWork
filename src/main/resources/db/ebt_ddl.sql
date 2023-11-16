
grant all privileges on `sondb`.* to `dbuser`@`localhost` identified by '!@sondb9123';

create database `sondb`;

flush privileges;

use `sondb`;

CREATE TABLE IDS (
  TABLE_NAME varchar(20) NOT NULL,
  NEXT_ID decimal(30,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (TABLE_NAME)
) ;



CREATE TABLE LETTCCMMNCLCODE (
  CL_CODE char(3) NOT NULL,
  CL_CODE_NM varchar(60) DEFAULT NULL,
  CL_CODE_DC varchar(200) DEFAULT NULL,
  USE_AT char(1) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (CL_CODE)
) ;



CREATE TABLE LETTCCMMNCODE (
  CODE_ID varchar(6) NOT NULL,
  CODE_ID_NM varchar(60) DEFAULT NULL,
  CODE_ID_DC varchar(200) DEFAULT NULL,
  USE_AT char(1) DEFAULT NULL,
  CL_CODE char(3) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (CODE_ID),
  KEY R_179 (CL_CODE),
  CONSTRAINT LETTCCMMNCODE_ibfk_1 FOREIGN KEY (CL_CODE) REFERENCES LETTCCMMNCLCODE (CL_CODE)
) ;



CREATE TABLE LETTCCMMNDETAILCODE (
  CODE_ID varchar(6) NOT NULL,
  CODE varchar(15) NOT NULL,
  CODE_NM varchar(60) DEFAULT NULL,
  CODE_DC varchar(200) DEFAULT NULL,
  USE_AT char(1) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (CODE_ID,CODE),
  CONSTRAINT LETTCCMMNDETAILCODE_ibfk_1 FOREIGN KEY (CODE_ID) REFERENCES LETTCCMMNCODE (CODE_ID)
) ;



CREATE TABLE LETTNORGNZTINFO (
  ORGNZT_ID char(20) NOT NULL DEFAULT '',
  ORGNZT_NM varchar(20) NOT NULL,
  ORGNZT_DC varchar(100) DEFAULT NULL,
  PRIMARY KEY (ORGNZT_ID)
) ;



CREATE TABLE LETTNAUTHORGROUPINFO (
  GROUP_ID char(20) NOT NULL DEFAULT '',
  GROUP_NM varchar(60) NOT NULL,
  GROUP_CREAT_DE char(20) NOT NULL,
  GROUP_DC varchar(100) DEFAULT NULL,
  PRIMARY KEY (GROUP_ID)
) ;



CREATE TABLE LETTNAUTHORINFO (
  AUTHOR_CODE varchar(30) NOT NULL DEFAULT '',
  AUTHOR_NM varchar(60) NOT NULL,
  AUTHOR_DC varchar(200) DEFAULT NULL,
  AUTHOR_CREAT_DE char(20) NOT NULL,
  PRIMARY KEY (AUTHOR_CODE)
) ;



CREATE TABLE LETTNROLES_HIERARCHY (
  PARNTS_ROLE varchar(30) NOT NULL,
  CHLDRN_ROLE varchar(30) NOT NULL,
  PRIMARY KEY (PARNTS_ROLE,CHLDRN_ROLE),
  KEY R_308 (CHLDRN_ROLE),
  CONSTRAINT LETTNROLES_HIERARCHY_ibfk_2 FOREIGN KEY (CHLDRN_ROLE) REFERENCES LETTNAUTHORINFO (AUTHOR_CODE) ON DELETE CASCADE,
  CONSTRAINT LETTNROLES_HIERARCHY_ibfk_1 FOREIGN KEY (PARNTS_ROLE) REFERENCES LETTNAUTHORINFO (AUTHOR_CODE) ON DELETE CASCADE
) ;



CREATE TABLE LETTNROLEINFO (
  ROLE_CODE varchar(50) NOT NULL DEFAULT '',
  ROLE_NM varchar(60) NOT NULL,
  ROLE_PTTRN varchar(300) DEFAULT NULL,
  ROLE_DC varchar(200) DEFAULT NULL,
  ROLE_TY varchar(80) DEFAULT NULL,
  ROLE_SORT varchar(10) DEFAULT NULL,
  ROLE_CREAT_DE char(20) NOT NULL,
  PRIMARY KEY (ROLE_CODE)
) ;



CREATE TABLE LETTNAUTHORROLERELATE (
  AUTHOR_CODE varchar(30) NOT NULL,
  ROLE_CODE varchar(50) NOT NULL,
  CREAT_DT datetime DEFAULT NULL,
  PRIMARY KEY (AUTHOR_CODE,ROLE_CODE),
  KEY R_292 (ROLE_CODE),
  CONSTRAINT LETTNAUTHORROLERELATE_ibfk_2 FOREIGN KEY (ROLE_CODE) REFERENCES LETTNROLEINFO (ROLE_CODE) ON DELETE CASCADE,
  CONSTRAINT LETTNAUTHORROLERELATE_ibfk_1 FOREIGN KEY (AUTHOR_CODE) REFERENCES LETTNAUTHORINFO (AUTHOR_CODE) ON DELETE CASCADE
) ;



CREATE TABLE LETTNEMPLYRINFO (
  EMPLYR_ID varchar(20) NOT NULL,
  ORGNZT_ID char(20) DEFAULT NULL,
  USER_NM varchar(60) NOT NULL,
  PASSWORD varchar(200) NOT NULL,
  EMPL_NO varchar(20) DEFAULT NULL,
  IHIDNUM varchar(200) DEFAULT NULL,
  SEXDSTN_CODE char(1) DEFAULT NULL,
  BRTHDY char(20) DEFAULT NULL,
  FXNUM varchar(20) DEFAULT NULL,
  HOUSE_ADRES varchar(100) DEFAULT NULL,
  PASSWORD_HINT varchar(100) NOT NULL,
  PASSWORD_CNSR varchar(100) NOT NULL,
  HOUSE_END_TELNO varchar(4) DEFAULT NULL,
  AREA_NO varchar(4) DEFAULT NULL,
  DETAIL_ADRES varchar(100) DEFAULT NULL,
  ZIP varchar(6) DEFAULT NULL,
  OFFM_TELNO varchar(20) DEFAULT NULL,
  MBTLNUM varchar(20) DEFAULT NULL,
  EMAIL_ADRES varchar(50) DEFAULT NULL,
  OFCPS_NM varchar(60) DEFAULT NULL,
  HOUSE_MIDDLE_TELNO varchar(4) DEFAULT NULL,
  GROUP_ID char(20) DEFAULT NULL,
  PSTINST_CODE char(8) DEFAULT NULL,
  EMPLYR_STTUS_CODE varchar(15) NOT NULL,
  ESNTL_ID char(20) NOT NULL,
  CRTFC_DN_VALUE varchar(20) DEFAULT NULL,
  SBSCRB_DE datetime DEFAULT NULL,
  PRIMARY KEY (EMPLYR_ID),
  KEY LETTNEMPLYRINFO_ibfk_2 (GROUP_ID),
  KEY LETTNEMPLYRINFO_ibfk_1 (ORGNZT_ID),
  CONSTRAINT LETTNEMPLYRINFO_ibfk_2 FOREIGN KEY (GROUP_ID) REFERENCES LETTNAUTHORGROUPINFO (GROUP_ID) ON DELETE CASCADE,
  CONSTRAINT LETTNEMPLYRINFO_ibfk_1 FOREIGN KEY (ORGNZT_ID) REFERENCES LETTNORGNZTINFO (ORGNZT_ID) ON DELETE CASCADE
) ;



CREATE TABLE LETTNEMPLYRSCRTYESTBS (
  SCRTY_DTRMN_TRGET_ID varchar(20) NOT NULL,
  MBER_TY_CODE varchar(15) DEFAULT NULL,
  AUTHOR_CODE varchar(30) NOT NULL,
  PRIMARY KEY (SCRTY_DTRMN_TRGET_ID),
  KEY LETTNEMPLYRSCRTYESTBS_ibfk_4 (AUTHOR_CODE),
  CONSTRAINT LETTNEMPLYRSCRTYESTBS_ibfk_4 FOREIGN KEY (AUTHOR_CODE) REFERENCES LETTNAUTHORINFO (AUTHOR_CODE)
) ;



CREATE TABLE LETTNTMPLATINFO (
  TMPLAT_ID char(20) NOT NULL DEFAULT '',
  TMPLAT_NM varchar(255) DEFAULT NULL,
  TMPLAT_COURS varchar(2000) DEFAULT NULL,
  USE_AT char(1) DEFAULT NULL,
  TMPLAT_SE_CODE char(6) DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  PRIMARY KEY (TMPLAT_ID)
) ;



CREATE TABLE LETTNBBSMASTER (
  BBS_ID char(20) NOT NULL,
  BBS_NM varchar(255) NOT NULL,
  BBS_INTRCN varchar(2400) DEFAULT NULL,
  BBS_TY_CODE char(6) NOT NULL,
  BBS_ATTRB_CODE char(6) NOT NULL,
  REPLY_POSBL_AT char(1) DEFAULT NULL,
  FILE_ATCH_POSBL_AT char(1) NOT NULL,
  ATCH_POSBL_FILE_NUMBER decimal(2,0) NOT NULL,
  ATCH_POSBL_FILE_SIZE decimal(8,0) DEFAULT NULL,
  USE_AT char(1) NOT NULL,
  TMPLAT_ID char(20) DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) NOT NULL,
  FRST_REGIST_PNTTM datetime NOT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  PRIMARY KEY (BBS_ID)
) ;



CREATE TABLE LETTNBBSUSE (
  BBS_ID char(20) NOT NULL,
  TRGET_ID char(20) NOT NULL DEFAULT '',
  USE_AT char(1) NOT NULL,
  REGIST_SE_CODE char(6) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) NOT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (BBS_ID,TRGET_ID),
  CONSTRAINT LETTNBBSUSE_ibfk_1 FOREIGN KEY (BBS_ID) REFERENCES LETTNBBSMASTER (BBS_ID)
) ;



CREATE TABLE LETTNBBS (
  NTT_ID decimal(20,0) NOT NULL,
  BBS_ID char(20) NOT NULL,
  NTT_NO decimal(20,0) DEFAULT NULL,
  NTT_SJ varchar(2000) DEFAULT NULL,
  NTT_CN mediumtext,
  ANSWER_AT char(1) DEFAULT NULL,
  PARNTSCTT_NO decimal(10,0) DEFAULT NULL,
  ANSWER_LC int(11) DEFAULT NULL,
  SORT_ORDR decimal(8,0) DEFAULT NULL,
  RDCNT decimal(10,0) DEFAULT NULL,
  USE_AT char(1) NOT NULL,
  NTCE_BGNDE char(20) DEFAULT NULL,
  NTCE_ENDDE char(20) DEFAULT NULL,
  NTCR_ID varchar(20) DEFAULT NULL,
  NTCR_NM varchar(20) DEFAULT NULL,
  PASSWORD varchar(200) DEFAULT NULL,
  ATCH_FILE_ID char(20) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime NOT NULL,
  FRST_REGISTER_ID varchar(20) NOT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (NTT_ID,BBS_ID),
  KEY LETTNBBS_ibfk_1 (BBS_ID),
  CONSTRAINT LETTNBBS_ibfk_1 FOREIGN KEY (BBS_ID) REFERENCES LETTNBBSMASTER (BBS_ID)
) ;



CREATE TABLE LETTCZIP (
  ZIP varchar(6) NOT NULL,
  SN decimal(10,0) NOT NULL DEFAULT '0',
  CTPRVN_NM varchar(20) DEFAULT NULL,
  SIGNGU_NM varchar(20) DEFAULT NULL,
  EMD_NM varchar(60) DEFAULT NULL,
  LI_BULD_NM varchar(60) DEFAULT NULL,
  LNBR_DONG_HO varchar(20) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (ZIP,SN)
) ;



CREATE TABLE LETTHEMPLYRINFOCHANGEDTLS (
  EMPLYR_ID varchar(20) NOT NULL,
  CHANGE_DE DATETIME NOT NULL,
  ORGNZT_ID char(20) DEFAULT NULL,
  GROUP_ID char(20) DEFAULT NULL,
  EMPL_NO varchar(20) DEFAULT NULL,
  SEXDSTN_CODE char(1) DEFAULT NULL,
  BRTHDY char(20) DEFAULT NULL,
  FXNUM varchar(20) DEFAULT NULL,
  HOUSE_ADRES varchar(100) DEFAULT NULL,
  HOUSE_END_TELNO varchar(4) DEFAULT NULL,
  AREA_NO varchar(4) DEFAULT NULL,
  DETAIL_ADRES varchar(100) DEFAULT NULL,
  ZIP varchar(6) DEFAULT NULL,
  OFFM_TELNO varchar(20) DEFAULT NULL,
  MBTLNUM varchar(20) DEFAULT NULL,
  EMAIL_ADRES varchar(50) DEFAULT NULL,
  HOUSE_MIDDLE_TELNO varchar(4) DEFAULT NULL,
  PSTINST_CODE char(8) DEFAULT NULL,
  EMPLYR_STTUS_CODE varchar(15) DEFAULT NULL,
  ESNTL_ID char(20) DEFAULT NULL,
  PRIMARY KEY (EMPLYR_ID,CHANGE_DE)
) ;



CREATE TABLE LETTNBBSMASTEROPTN (
  BBS_ID char(20) NOT NULL DEFAULT '',
  ANSWER_AT char(1) NOT NULL DEFAULT '',
  STSFDG_AT char(1) NOT NULL DEFAULT '',
  FRST_REGIST_PNTTM datetime NOT NULL DEFAULT '1900-01-01 00:00:00', 
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  FRST_REGISTER_ID varchar(20) NOT NULL DEFAULT '',
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  PRIMARY KEY (BBS_ID)
) ;



CREATE TABLE LETTNENTRPRSMBER (
  ENTRPRS_MBER_ID varchar(20) NOT NULL DEFAULT '',
  ENTRPRS_SE_CODE char(15) DEFAULT NULL,
  BIZRNO varchar(10) DEFAULT NULL,
  JURIRNO varchar(13) DEFAULT NULL,
  CMPNY_NM varchar(60) NOT NULL,
  CXFC varchar(50) DEFAULT NULL,
  ZIP varchar(6) DEFAULT NULL,
  ADRES varchar(100) DEFAULT NULL,
  ENTRPRS_MIDDLE_TELNO varchar(4) DEFAULT NULL,
  FXNUM varchar(20) DEFAULT NULL,
  INDUTY_CODE char(15) DEFAULT NULL,
  APPLCNT_NM varchar(50) DEFAULT NULL,
  APPLCNT_IHIDNUM varchar(200) DEFAULT NULL,
  SBSCRB_DE datetime DEFAULT NULL,
  ENTRPRS_MBER_STTUS varchar(15) DEFAULT NULL,
  ENTRPRS_MBER_PASSWORD varchar(200) NOT NULL,
  ENTRPRS_MBER_PASSWORD_HINT varchar(100) NOT NULL,
  ENTRPRS_MBER_PASSWORD_CNSR varchar(100) NOT NULL,
  GROUP_ID char(20) DEFAULT NULL,
  DETAIL_ADRES varchar(100) DEFAULT NULL,
  ENTRPRS_END_TELNO varchar(4) DEFAULT NULL,
  AREA_NO varchar(4) DEFAULT NULL,
  APPLCNT_EMAIL_ADRES varchar(50) DEFAULT NULL,
  ESNTL_ID char(20) NOT NULL,
  PRIMARY KEY (ENTRPRS_MBER_ID),
  KEY LETTNENTRPRSMBER_ibfk_1 (GROUP_ID),
  CONSTRAINT LETTNENTRPRSMBER_ibfk_1 FOREIGN KEY (GROUP_ID) REFERENCES LETTNAUTHORGROUPINFO (GROUP_ID) ON DELETE CASCADE
) ;



CREATE TABLE LETTNFILE (
  ATCH_FILE_ID char(20) NOT NULL,
  CREAT_DT datetime NOT NULL,
  USE_AT char(1) DEFAULT NULL,
  PRIMARY KEY (ATCH_FILE_ID)
) ;



CREATE TABLE LETTNFILEDETAIL (
  ATCH_FILE_ID char(20) NOT NULL,
  FILE_SN decimal(10,0) NOT NULL,
  FILE_STRE_COURS varchar(2000) NOT NULL,
  STRE_FILE_NM varchar(255) NOT NULL,
  ORIGNL_FILE_NM varchar(255) DEFAULT NULL,
  FILE_EXTSN varchar(20) NOT NULL,
  FILE_CN mediumtext,
  FILE_SIZE decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (ATCH_FILE_ID,FILE_SN),
  CONSTRAINT LETTNFILEDETAIL_ibfk_1 FOREIGN KEY (ATCH_FILE_ID) REFERENCES LETTNFILE (ATCH_FILE_ID)
) ;



CREATE TABLE LETTNGNRLMBER (
  MBER_ID varchar(20) NOT NULL DEFAULT '',
  PASSWORD varchar(200) NOT NULL,
  PASSWORD_HINT varchar(100) DEFAULT NULL,
  PASSWORD_CNSR varchar(100) DEFAULT NULL,
  IHIDNUM varchar(200) DEFAULT NULL,
  MBER_NM varchar(50) NOT NULL,
  ZIP varchar(6) DEFAULT NULL,
  ADRES varchar(100) DEFAULT NULL,
  AREA_NO varchar(4) DEFAULT NULL,
  MBER_STTUS varchar(15) DEFAULT NULL,
  DETAIL_ADRES varchar(100) DEFAULT NULL,
  END_TELNO varchar(4) DEFAULT NULL,
  MBTLNUM varchar(20) DEFAULT NULL,
  GROUP_ID char(20) DEFAULT NULL,
  MBER_FXNUM varchar(20) DEFAULT NULL,
  MBER_EMAIL_ADRES varchar(50) DEFAULT NULL,
  MIDDLE_TELNO varchar(4) DEFAULT NULL,
  SBSCRB_DE datetime DEFAULT NULL,
  SEXDSTN_CODE char(1) DEFAULT NULL,
  ESNTL_ID char(20) NOT NULL,
  PRIMARY KEY (MBER_ID),
  KEY LETTNGNRLMBER_ibfk_1 (GROUP_ID),
  CONSTRAINT LETTNGNRLMBER_ibfk_1 FOREIGN KEY (GROUP_ID) REFERENCES LETTNAUTHORGROUPINFO (GROUP_ID) ON DELETE CASCADE
) ;



CREATE TABLE LETTNLOGINLOG (
  LOG_ID char(20) NOT NULL,
  CONECT_ID varchar(20) DEFAULT NULL,
  CONECT_IP varchar(23) DEFAULT NULL,
  CONECT_MTHD char(4) DEFAULT NULL,
  ERROR_OCCRRNC_AT char(1) DEFAULT NULL,
  ERROR_CODE char(3) DEFAULT NULL,
  CREAT_DT datetime DEFAULT NULL,
  PRIMARY KEY (LOG_ID)
) ;



CREATE TABLE LETTNLOGINPOLICY (
  EMPLYR_ID varchar(20) NOT NULL DEFAULT '',
  IP_INFO varchar(23) NOT NULL,
  DPLCT_PERM_AT char(1) NOT NULL,
  LMTT_AT char(1) NOT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  PRIMARY KEY (EMPLYR_ID)
) ;



CREATE TABLE LETTNPROGRMLIST (
  PROGRM_FILE_NM varchar(60) NOT NULL DEFAULT '',
  PROGRM_STRE_PATH varchar(100) NOT NULL,
  PROGRM_KOREAN_NM varchar(60) DEFAULT NULL,
  PROGRM_DC varchar(200) DEFAULT NULL,
  URL varchar(100) NOT NULL,
  PRIMARY KEY (PROGRM_FILE_NM)
) ;



CREATE TABLE LETTNMENUINFO (
  MENU_NM varchar(60) NOT NULL,
  PROGRM_FILE_NM varchar(60) NOT NULL,
  MENU_NO decimal(20,0) NOT NULL,
  UPPER_MENU_NO decimal(20,0) DEFAULT NULL,
  MENU_ORDR decimal(5,0) NOT NULL,
  MENU_DC varchar(250) DEFAULT NULL,
  RELATE_IMAGE_PATH varchar(100) DEFAULT NULL,
  RELATE_IMAGE_NM varchar(60) DEFAULT NULL,
  PRIMARY KEY (MENU_NO),
  KEY R_2 (PROGRM_FILE_NM),
  KEY R_4 (UPPER_MENU_NO),
  CONSTRAINT LETTNMENUINFO_ibfk_2 FOREIGN KEY (UPPER_MENU_NO) REFERENCES LETTNMENUINFO (MENU_NO),
  CONSTRAINT LETTNMENUINFO_ibfk_1 FOREIGN KEY (PROGRM_FILE_NM) REFERENCES LETTNPROGRMLIST (PROGRM_FILE_NM) ON DELETE CASCADE
) ;



CREATE TABLE LETTNMENUCREATDTLS (
  MENU_NO decimal(20,0) NOT NULL,
  AUTHOR_CODE varchar(30) NOT NULL,
  MAPNG_CREAT_ID varchar(30) DEFAULT NULL,
  PRIMARY KEY (MENU_NO,AUTHOR_CODE),
  KEY R_247 (MAPNG_CREAT_ID),
  KEY R_303 (AUTHOR_CODE),
  CONSTRAINT LETTNMENUCREATDTLS_ibfk_3 FOREIGN KEY (AUTHOR_CODE) REFERENCES LETTNAUTHORINFO (AUTHOR_CODE),
  CONSTRAINT LETTNMENUCREATDTLS_ibfk_1 FOREIGN KEY (MENU_NO) REFERENCES LETTNMENUINFO (MENU_NO) ON DELETE CASCADE
) ;



CREATE TABLE LETTNUSERABSNCE (
  EMPLYR_ID varchar(20) NOT NULL DEFAULT '',
  USER_ABSNCE_AT char(1) NOT NULL,
  FRST_REGISTER_ID varchar(20) DEFAULT NULL,
  FRST_REGIST_PNTTM datetime DEFAULT NULL,
  LAST_UPDUSR_ID varchar(20) DEFAULT NULL,
  LAST_UPDT_PNTTM datetime DEFAULT NULL,
  PRIMARY KEY (EMPLYR_ID)
) ;



CREATE TABLE LETTSSYSLOGSUMMARY (
  OCCRRNC_DE char(20) NOT NULL,
  SRVC_NM varchar(255) NOT NULL,
  METHOD_NM varchar(60) NOT NULL,
  CREAT_CO decimal(10,0) DEFAULT NULL,
  UPDT_CO decimal(10,0) DEFAULT NULL,
  RDCNT decimal(10,0) DEFAULT NULL,
  DELETE_CO decimal(10,0) DEFAULT NULL,
  OUTPT_CO decimal(10,0) DEFAULT NULL,
  ERROR_CO decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (OCCRRNC_DE,SRVC_NM,METHOD_NM)
) ;

CREATE OR REPLACE VIEW COMVNUSERMASTER ( ESNTL_ID,USER_ID,PASSWORD,USER_NM,USER_ZIP,USER_ADRES,USER_EMAIL,GROUP_ID, USER_SE, ORGNZT_ID ) 
AS  
        SELECT ESNTL_ID, MBER_ID,PASSWORD,MBER_NM,ZIP,ADRES,MBER_EMAIL_ADRES,' ','GNR' AS USER_SE, ' ' ORGNZT_ID
        FROM LETTNGNRLMBER
    UNION ALL
        SELECT ESNTL_ID,EMPLYR_ID,PASSWORD,USER_NM,ZIP,HOUSE_ADRES,EMAIL_ADRES,GROUP_ID ,'USR' AS USER_SE, ORGNZT_ID
        FROM LETTNEMPLYRINFO
    UNION ALL
        SELECT ESNTL_ID,ENTRPRS_MBER_ID,ENTRPRS_MBER_PASSWORD,CMPNY_NM,ZIP,ADRES,APPLCNT_EMAIL_ADRES,' ' ,'ENT' AS USER_SE, ' ' ORGNZT_ID
        FROM LETTNENTRPRSMBER 
;