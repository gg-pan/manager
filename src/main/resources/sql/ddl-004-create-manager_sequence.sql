-- public.manager_user definition

-- Drop table

-- DROP TABLE public.manager_user;

CREATE TABLE public.manager_user (
	id varchar(32) NOT NULL,
	create_on timestamp NULL,
	update_on timestamp NULL,
	"version" int2 NULL,
	ref_no varchar(32) NULL,
	latest bool NULL,
	status bool NULL,
	"name" varchar(20) NULL,
	email varchar(20) NULL,
	phone_num varchar(20) NULL,
	"password" varchar(20) NULL,
	CONSTRAINT manager_user_pkey PRIMARY KEY (id)
);
