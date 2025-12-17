


-- DROP DATABASE IF EXISTS "signingSimluatorDB";

CREATE DATABASE "signingSimluatorDB"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



-- Table: public.SG_USERS

-- DROP TABLE IF EXISTS public."SG_USERS";

CREATE TABLE IF NOT EXISTS public."SG_USERS"
(
    "USER_ID" character varying(30) COLLATE pg_catalog."default" NOT NULL,
    "USER_USERNAME" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "USER_PASSWORD" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "USER_NAME" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "USER_SURNAME" character varying(50) COLLATE pg_catalog."default",
    "USER_EMAIL" character varying(30) COLLATE pg_catalog."default",
    "DATE_INSERT" date NOT NULL,
    "DATE_MOD" date NOT NULL,
    "CODE_STATUS" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_INSERT" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_MOD" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "SG_USERS_pkey" PRIMARY KEY ("USER_ID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."SG_USERS"
    OWNER to postgres;




-- Table: public.SG_CERTIFICATES

-- DROP TABLE IF EXISTS public."SG_CERTIFICATES";

CREATE TABLE IF NOT EXISTS public."SG_CERTIFICATES"
(
    "CERT_ID" character varying(30) COLLATE pg_catalog."default" NOT NULL,
    "CERT_DOCUMENT" character varying(256) COLLATE pg_catalog."default" NOT NULL,
    "CERT_PASSWORD" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "CERT_NAME" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "CERT_DATEFROM" date,
    "CERT_DATETO" date,
    "DATE_INSERT" date NOT NULL,
    "DATE_MOD" date NOT NULL,
    "CODE_STATUS" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_INSERT" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_MOD" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "SG_CERTIFICATES_pkey" PRIMARY KEY ("CERT_ID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."SG_CERTIFICATES"
    OWNER to postgres;




-- Table: public.SG_USER_CERTIFICATE

-- DROP TABLE IF EXISTS public."SG_USER_CERTIFICATE";

CREATE TABLE IF NOT EXISTS public."SG_USER_CERTIFICATE"
(
    "USER_ID" character varying(30) COLLATE pg_catalog."default" NOT NULL,
    "CERT_ID" character varying(30) COLLATE pg_catalog."default" NOT NULL,
    "DATE_INSERT" date NOT NULL,
    "DATE_MOD" date NOT NULL,
    "CODE_STATUS" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_INSERT" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "USER_MOD" character varying(10) COLLATE pg_catalog."default" NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."SG_USER_CERTIFICATE"
    OWNER to postgres;    







INSERT INTO public."SG_CERTIFICATES" ("CERT_ID", "CERT_DOCUMENT", "CERT_DATEFROM", "CERT_DATETO", "DATE_INSERT", "DATE_MOD", "CODE_STATUS", "USER_INSERT", "USER_MOD", "CERT_PASSWORD", "CERT_NAME") VALUES ('1000', 'qwerqwerasfdfhqwef', '2024-07-10', '2024-07-10', '2024-07-10', '2024-07-10', 'CES001', 'UC0000', 'UC0000', '123456', 'Certificado Persona Fisica');


INSERT INTO public."SG_USERS" ("USER_ID", "USER_USERNAME", "USER_PASSWORD", "USER_NAME", "USER_SURNAME", "USER_EMAIL", "DATE_INSERT", "DATE_MOD", "CODE_STATUS", "USER_INSERT", "USER_MOD") VALUES ('1000', 'Pepe12', '1234', 'Pepe', 'del pilar', 'pepedelpilar12@gmail.com', '2024-07-10', '2024-07-10', 'CES001', 'UC0000', 'UC0000');
INSERT INTO public."SG_USERS" ("USER_ID", "USER_USERNAME", "USER_PASSWORD", "USER_NAME", "USER_SURNAME", "USER_EMAIL", "DATE_INSERT", "DATE_MOD", "CODE_STATUS", "USER_INSERT", "USER_MOD") VALUES ('1001', 'Antonio', '1234', 'Antonio', 'del pilar', 'antoniodelpilar12@gmail.com', '2024-07-10', '2024-07-10', 'CES001', 'UC0000', 'UC0000');

INSERT INTO public."SG_USER_CERTIFICATE" ("USER_ID", "CERT_ID", "DATE_INSERT", "DATE_MOD", "CODE_STATUS", "USER_INSERT", "USER_MOD") VALUES ('1000', '1000', '2024-07-10', '2024-07-10', 'CES001', 'UC0000', 'UC0000');
