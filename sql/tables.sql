
-- Table: agents

-- DROP TABLE agents;

CREATE TABLE agents
(
  id_agent integer NOT NULL,
  login character varying(100),
  mdp character varying(100),
  nom character varying(100),
  prenom character varying(100),
  CONSTRAINT agents_pk PRIMARY KEY (id_agent)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE agents
  OWNER TO microjoe;


-- Table: clients

-- DROP TABLE clients;

CREATE TABLE clients
(
  id_client integer NOT NULL,
  nom character varying(100),
  prenom character varying(100),
  date_naissance date,
  lieu_naissance character varying(100),
  permis_numero integer,
  permis_date_delivrance date,
  permis_lieu_delivrance character varying(100),
  permis_ville_delivrance character varying(100),
  CONSTRAINT clients_pk PRIMARY KEY (id_client)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clients
  OWNER TO microjoe;


-- Table: contrats

-- DROP TABLE contrats;

CREATE TABLE contrats
(
  id_contrat integer NOT NULL,
  id_voiture integer,
  date_debut date,
  date_fin date,
  kilometrage_debut integer,
  kilometrage_fin integer,
  id_agent integer,
  CONSTRAINT contrats_pk PRIMARY KEY (id_contrat)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE contrats
  OWNER TO microjoe;


-- Table: voitures

-- DROP TABLE voitures;

CREATE TABLE voitures
(
  id_voiture integer NOT NULL,
  matricule character varying(100),
  kilometrage integer,
  couleur character varying(100),
  marque character varying(100),
  CONSTRAINT voitures_pk PRIMARY KEY (id_voiture)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE voitures
  OWNER TO microjoe;

