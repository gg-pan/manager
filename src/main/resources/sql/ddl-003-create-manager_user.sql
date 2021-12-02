-- Table: public.manager_user

-- DROP TABLE public.manager_user;

CREATE TABLE public.manager_user
(
    id character varying(32) COLLATE pg_catalog."default" NOT NULL,
    create_on timestamp without time zone,
    update_on timestamp without time zone,
    version smallint,
    ref_no character varying(32) COLLATE pg_catalog."default",
    latest boolean,
    status boolean,
    name character varying(20) COLLATE pg_catalog."default",
    email character varying(20) COLLATE pg_catalog."default",
    phone_num character varying(20) COLLATE pg_catalog."default",
    password character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT manager_user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.manager_user
    OWNER to manager;

COMMENT ON TABLE public.manager_user
    IS 'app user';
	