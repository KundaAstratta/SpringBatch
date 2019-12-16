CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TABLE collaborateur (
      id SERIAL NOT NULL PRIMARY KEY,
	   uid  VARCHAR(200),
       civilite VARCHAR(200),
       nom VARCHAR(200),
       prenom VARCHAR(200),
       fonction VARCHAR(200),
       telephone VARCHAR(200),
       mail VARCHAR(200),
       etage VARCHAR(200),
       uo_affectation VARCHAR(200),
       code_immeuble_emplacement_collaborateur VARCHAR(200),
       region VARCHAR(200),
       code_region VARCHAR(200),
       niveau_territoire VARCHAR(200),
       code_territoire VARCHAR(200),
       niveau_entite VARCHAR(200),
       code_entite VARCHAR(200),
       niveau_agence VARCHAR(200),
       code_agence VARCHAR(200),
       localisation_collaborateur VARCHAR(200),
       pj VARCHAR(200),
	   a_migrer VARCHAR(200),
	   created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
       updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);


CREATE TRIGGER set_timestamp
BEFORE UPDATE ON collaborateur
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();



