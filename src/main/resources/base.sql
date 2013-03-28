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