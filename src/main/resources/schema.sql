ALTER TABLE goods DROP CONSTRAINT goods_fk;
DROP TABLE IF EXISTS member;
DROP INDEX IF EXISTS member_pk;
DROP TABLE IF EXISTS goods;

CREATE TABLE public."member" (
    member_seq bigserial NOT NULL,
    id varchar(128) NOT NULL,
    "name" varchar(20) NOT NULL,
    age int4 NOT NULL,
    reg_dtm timestamp(0) NOT NULL DEFAULT now(),
    CONSTRAINT member_pk PRIMARY KEY (member_seq)
);

CREATE TABLE public.goods (
    goods_seq bigserial NOT NULL,
    member_seq int4 NOT NULL,
    "name" varchar(20) NOT NULL,
    price float8 NOT NULL,
    reg_dtm timestamp NOT NULL DEFAULT now(),
    CONSTRAINT goods_pk PRIMARY KEY (goods_seq)
);

ALTER TABLE public.goods ADD CONSTRAINT goods_fk FOREIGN KEY (member_seq) REFERENCES public."member"(member_seq);