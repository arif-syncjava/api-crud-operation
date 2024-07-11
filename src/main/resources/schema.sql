CREATE SCHEMA IF NOT EXISTS devices;
SET search_path TO devices;

DROP TABLE IF EXISTS mobile_devices;
DROP TABLE IF EXISTS sim_cards;

CREATE TABLE sim_cards (
     number VARCHAR PRIMARY KEY,
     operator_name VARCHAR(255) NOT NULL

 );

CREATE TABLE mobile_devices (
      imei VARCHAR PRIMARY KEY,
      brand_name VARCHAR (100) NOT NULL,
      model_name VARCHAR (150) NOT NULL,
      number VARCHAR ,
      FOREIGN KEY (number) REFERENCES sim_cards (number) ON DELETE CASCADE ON UPDATE CASCADE

);