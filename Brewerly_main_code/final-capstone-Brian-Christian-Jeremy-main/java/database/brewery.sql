--Need to update below, and add new properties in each brewery to meet MVP standards (Jeremy)

BEGIN TRANSACTION;

DROP TABLE IF EXISTS breweries CASCADE;

CREATE TABLE breweries(
    brewery_id serial,
    name varchar(50) NOT NULL,
    street varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    state varchar(2) NOT NULL,
    phonenumber varchar(20) NOT NULL,
    hours_of_operation varchar(20) NOT NULL,
    image_url varchar NOT NULL,
    history varchar (2000) NOT NULL,
    CONSTRAINT pk_breweries PRIMARY KEY (brewery_id)
);

INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('The Blizzard Aleworks', '123 Main St', 'Chicago', 'IL', '800-222-3434', '4:00pm-2:00am', './images/filename.ext', 'Known for its ice cold brews and the best Ales in Chi-town!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('The Over the Hop Fermentary', '1 Beer Rd', 'Orlando', 'FL', '800-300-1000', '4:00pm-1:00am', './images/filename.ext', 'Their craft beers will send you over the moon!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Minotaur Brewing Co.', '300 Ale Ave', 'Seattle', 'WA', '866-123-4567', '2:00pm-1:00am', './images/filename.ext', 'Rest assured, you will be aMAZEd by their selection of stouts!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Magnitude Fermentary', '2 Ipa Circle', 'San Francisco', 'CA', '877-400-5000', '2:00pm-1:00am', './images/filename.ext', 'They are shaking up the industry with their wonderful ambers and delicious IPAs');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Empyrean Brewing', '3456 Lager Lane', 'New York', 'NY', '800-400-1236', '3:45pm-11:00pm', './images/filename.ext', 'A classic East Coast brewery that is head and shoulders above the rest!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Flying Dutchman Fermentary', '2334 Coldbrew Rd', 'Boston', 'MA', '888-121-2323', '1:00pm-1:00am', './images/filename.ext', 'Fly over to our spot, and you will love the ambience of a old school brewery here in Boston!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Diamond Brewing Company', '1 Lightbeer Pass', 'Denver', 'CO', '876-543-2100', '2:30pm-12:15am', './images/filename.ext', 'The diamond of Colorado breweries! Give our custom lagers a try!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Avalanche Brewery', '99 Snowy Rd', 'Sioux Falls', 'SD', '845-200-1000', '4:00pm-1:00am', './images/filename.ext', 'The selection of craft beers are overwhelming!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('The Cosmos Aleworks', '19 Starry Night Rd', 'Virginia Beach', 'VA', '757-111-2222', '2:00pm-3:00am', './images/filename.ext', 'A brewery under the stars near the famous oceanfront!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Gorilla Craft Ales', '42 Silverback St', 'Raleigh', 'NC', '222-333-4444', '1:15pm-1:00am', './images/filename.ext', 'We are definitely not monkeying around with our selection of ales!');
INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES ('Midnight Meteor Brewers', '47 Comet Ave', 'Miami', 'FL', '444-555-1000', '4:00pm-1:00am', './images/filename.ext', 'Take a look at the best dark beers in the southeast!');


COMMIT TRANSACTION;