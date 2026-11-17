create table municipal_service (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name varchar(100) NOT NULL
);

CREATE TABLE incident(
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
title varchar(100) not null,
description text not null,
latitude double precision not null,
longitude double precision not null,
address varchar(255),
status varchar(30) not null default 'PENDING',
analysis_status varchar(30) not null default 'PENDING',
category varchar(50),
severity smallint,
author_id BIGINT NOT NULL,
municipal_service_id BIGINT REFERENCES municipal_service(id),
created_at TIMESTAMPTZ NOT NULL DEFAULT now()
)