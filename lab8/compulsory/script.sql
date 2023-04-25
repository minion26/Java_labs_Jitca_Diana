DROP TABLE IF EXISTS artists, genres, albums;

CREATE TABLE artists (
    id SERIAL PRIMARY KEY ,
    name TEXT NOT NULL
);

CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE albums (
    id SERIAL PRIMARY KEY ,
    release_year INTEGER NOT NULL,
    artist_id INTEGER NOT NULL,
    genre_id  INTEGER NOT NULL,
    title TEXT NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artists(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id)
);

