-- Table: citizens

-- DROP TABLE citizens;

CREATE TABLE citizens
(
  id numeric,
  name character varying(50),
  surname character varying(100),
  age smallint,
  city character varying(25)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE citizens
  OWNER TO geo;



-- Table: cities

-- DROP TABLE cities;

CREATE TABLE cities
(
  id_cod character varying(25) NOT NULL,
  cod character varying(5),
  dsc_city character varying(100),
  regione character varying(50),
  area character varying(50),
  "COORDINATES" point,
  CONSTRAINT "PK_COD_CITY" PRIMARY KEY (id_cod)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cities
  OWNER TO geo;


-- Table: "USERS"

-- DROP TABLE "USERS";

CREATE TABLE users
(
  "ID_USER" numeric NOT NULL,
  "USER_NAME" character varying NOT NULL,
  "NAME" character varying,
  "LAST_NAME" character varying,
  "EMAIL" character varying,
  "ACTIVATION_DATE" timestamp without time zone NOT NULL,
  "DELETION_DATE" time without time zone,
  CONSTRAINT "PK_USER" PRIMARY KEY ("ID_USER")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO geo;

  
-- Table: "USER_ROLES"

-- DROP TABLE "USER_ROLES";

CREATE TABLE user_roles
(
  "ID_ROLE" numeric NOT NULL,
  "ROLE_DESC" character varying NOT NULL,
  CONSTRAINT "PK_ID_ROLE" PRIMARY KEY ("ID_ROLE")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_roles
  OWNER TO geo;

  
-- Table: "USR_ROLE_REL"

-- DROP TABLE "USR_ROLE_REL";

CREATE TABLE usr_role_rel
(
  "ID_USER" numeric NOT NULL,
  "ID_ROLE" numeric NOT NULL,
  CONSTRAINT "PK_USER_ROLE_REL" PRIMARY KEY ("ID_USER", "ID_ROLE")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usr_role_rel
  OWNER TO geo;

-- Sequence: "SEQ_ID_ROLE"

-- DROP SEQUENCE "SEQ_ID_ROLE";

CREATE SEQUENCE seq_id_role
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_id_role
  OWNER TO geo;

  
  -- Sequence: "SEQ_ID_USER"

-- DROP SEQUENCE "SEQ_ID_USER";

CREATE SEQUENCE seq_id_user
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_id_user
  OWNER TO geo;

  
  
  
  

INSERT INTO geo.citizens(
                        id, name, surname, age, city)
                VALUES (1, 'Nico', 'Giangregorio', 31, '01')
INSERT INTO geo.citizens(
                        id, name, surname, age, city)
                VALUES (1, 'Nico', 'Giangregorio', 31, '02')

INSERT INTO geo.cities(
            id_cod, cod, dsc_city, regione, area)
    VALUES ('01', 'BA', 'BARI', 'PUGLIA', 'SUD', (41.125278,16.866667));
INSERT INTO geo.cities(
            id_cod, cod, dsc_city, regione, area)
    VALUES ('02', 'MI', 'MILANO', 'LOMBARDIA', 'NORD', (45.464161,9.190336));
    
    
INSERT INTO USERS
VALUES
((select nextval('SEQ_ID_USER')),
  'admin',
  'Nico',
  'Giangregorio',
  'nicogorio@gmail.com',
  (select CURRENT_TIMESTAMP),
  NULL
);

INSERT INTO USERS
VALUES
((select nextval('SEQ_ID_USER')),
  'guest',
  'Tizio',
  'Caio',
  'nicogorio@gmail.com',
  (select CURRENT_TIMESTAMP),
  NULL
);
commit;

INSERT INTO usr_role_rel
VALUES
(1,1
);

INSERT INTO usr_role_rel
VALUES
(1,2
);

INSERT INTO usr_role_rel
VALUES
(2,2
);

commit;