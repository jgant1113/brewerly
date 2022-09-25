BEGIN TRANSACTION;

DROP TABLE IF EXISTS profiles;

CREATE TABLE profiles(
    profile_id serial,
    username varchar(50) NOT NULL,
    profile_type varchar(50) NOT NULL,
    CONSTRAINT pk_profiles PRIMARY KEY (profile_id),
);

INSERT INTO profiles (username, profile_type) VALUES ('Brian Noble', 'Brewer');
INSERT INTO profiles (username, profile_type) VALUES ('Jeremy Gant', 'Lover');

COMMIT TRANSACTION;