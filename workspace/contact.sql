-- 테이블 생성
CREATE TABLE relation(
	  rel_no		varchar2(3)
	, rel_nm		varchar2(20)
)
;
CREATE TABLE contact(
	  con_id		varchar2(8)
	, con_nm		VARCHAR2(50)
	, con_num		varchar2(11)
	, con_rel		varchar2(2)
	, con_add		varchar2(50)
	, con_dt		DATE DEFAULT sysdate
)
;

--제약 조건 추가
ALTER TABLE contact
ADD
CONSTRAINT con_id_pk
PRIMARY key(con_id)
;

ALTER TABLE relation
ADD
CONSTRAINT rel_no_pk
PRIMARY key(rel_no)
;

ALTER TABLE contact
ADD CONSTRAINT con_rel_fk
FOREIGN key(con_rel)
REFERENCES relation(rel_no)
;

-- 시퀸스 추가
CREATE SEQUENCE id_seq
       START WITH 1
       INCREMENT BY 1
       MAXVALUE 9999;

CREATE SEQUENCE rel_seq
       START WITH 1
       INCREMENT BY 1
       MAXVALUE 99;

-- 펑션 추가
CREATE OR REPLACE FUNCTION get_seq_id RETURN VARCHAR2 IS
  seq_id VARCHAR2(8);
BEGIN
  SELECT TO_CHAR(SYSDATE, 'YYYY') || LPAD(id_seq.NEXTVAL, 4, '0')
  INTO seq_id
  FROM dual;
  
  RETURN seq_id;
END;

CREATE OR REPLACE FUNCTION get_rel_no RETURN VARCHAR2 IS
  seq_rel VARCHAR2(2);
BEGIN
  SELECT LPAD(id_seq.NEXTVAL, 2, '0')
  INTO seq_rel
  FROM dual;
  
  RETURN seq_rel;
END;
