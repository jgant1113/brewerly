BEGIN TRANSACTION;
DROP TABLE IF EXISTS reviews;

CREATE TABLE reviews (
    review_id serial,
    username character varying(50) NOT NULL,
    rating integer default 1 NOT NULL check (rating between 1 and 5),
    beer_id integer references beers(beer_id) NOT NULL,
    brewery_id integer references breweries(brewery_id) NOT NULL,
    detail character varying(2000),
    CONSTRAINT pk_reviews PRIMARY KEY (review_id)

);

COMMIT TRANSACTION;
