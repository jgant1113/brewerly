BEGIN TRANSACTION;

DROP TABLE IF EXISTS beers;

CREATE TABLE beers (
    beer_id serial,
    name character varying(50) NOT NULL,
    style character varying (20) NOT NULL,
    brewery_id integer references breweries(brewery_id),
    abv character varying(4),
    ibu character varying (2),
    color character varying (50),
    CONSTRAINT pk_beers PRIMARY KEY (beer_id)
);

COMMIT TRANSACTION;

--Add all of these inserts to Beer table to allow data uniformity (Jeremy)
INSERT INTO beers
VALUES (3, 'BrianLager', 'Lager', 2, '6.0', '9', 'Brown');

INSERT INTO beers
VALUES (4, 'OverTheHop', 'Pilsner', 2, '6.5', '5', 'Yellow');

INSERT INTO beers
VALUES (5, 'BullHorn IPA', 'IPA', 3, '5.5', '5', 'Amber');

INSERT INTO beers
VALUES (6, 'Minotaur Special', 'Stout', 3, '7.0', '9', 'Brown');

INSERT INTO beers
VALUES (7, 'Quake', 'Stout', 4, '5.5', '7', 'Brown');

INSERT INTO beers
VALUES (8, 'Shake', 'IPA', 4, '5.9', '6', 'Yellow');

INSERT INTO beers
VALUES (9, 'EmPA', 'IPA', 5, '4.2', '4', 'Yellow');

INSERT INTO beers
VALUES (10, 'LagerRama', 'Lager', 5, '6.0', '6', 'Brown');

INSERT INTO beers
VALUES (11, 'Dutchmans-Brew', 'Lager', 6, '6.0', '6', 'Amber');

INSERT INTO beers
VALUES (12, 'KickYourHeinee-Ken', 'Lager', 6, '7.2', '7', 'Brown');

INSERT INTO beers
VALUES (13, 'DiamondBack', 'Ale', 7, '6.0', '6', 'Yellow');

INSERT INTO beers
VALUES (14, 'GemStoneStout', 'Stout', 7, '6.0', '6', 'Brown');

INSERT INTO beers
VALUES (15, 'Avalager', 'Lager', 8 , '6.5', '8', 'Brown');

INSERT INTO beers
VALUES (16, 'Snowy Peak Pilsner', 'Pilsner', 8, '5.0', '5', 'Amber');

INSERT INTO beers
VALUES (17, 'Comet Chaser', 'IPA', 9, '4.2', '4', 'Yellow');

INSERT INTO beers
VALUES (18, 'SolarAle', 'Ale', 9, '4.5', '4', 'Yellow');

INSERT INTO beers
VALUES (19, 'SilverbackIPA', 'IPA', 10, '5.5', '6', 'Amber');

INSERT INTO beers
VALUES (20, 'KongKegger', 'Lager', 10, '7.0', '6', 'Brown');

INSERT INTO beers
VALUES (21, 'MeteorLite', 'Lager', 11, '6.0', '6', 'Brown');

INSERT INTO beers
VALUES (22, 'PitchBlack', 'Stout', 11, '8.0', '9', 'Black');

