CREATE SCHEMA IF NOT EXISTS devices;
SET search_path TO devices;


DROP TABLE IF EXISTS mobile_devices;
DROP TABLE IF EXISTS simcards;



CREATE TABLE simcards (
     operator_name VARCHAR (100) NOT NULL,
     phone_number INTEGER PRIMARY KEY
);

CREATE TABLE mobile_devices (
      imei SERIAL PRIMARY KEY,
      brand_name VARCHAR (100) NOT NULL,
      model_name VARCHAR (150) NOT NULL,
      sim_number INTEGER  ,
      FOREIGN KEY (sim_number) REFERENCES simcards (phone_number) ON DELETE CASCADE ON UPDATE CASCADE

);