# Tasks schema

# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE TABLE task (
    id integer NOT NULL DEFAULT nextval('task_id_seq'),
    label char(255) NOT NULL
);

# --- !Downs

DROP TABLE IF EXISTS task;
DROP SEQUENCE IF EXISTS task_id_seq;