drop table if exists albums;
drop table if exists artist;
drop table if exists genre;

create  table if not exists genre(
  id serial  PRIMARY KEY,
  name VARCHAR(255) UNIQUE  NULL
);


CREATE TABLE IF NOT EXISTS artist(
  id serial  PRIMARY KEY,
  name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS  albums (
  id serial  PRIMARY KEY,
  release_year VARCHAR(255) NOT NULL,
  title VARCHAR(255) UNIQUE NOT NULL,
  artistID INT NOT NULL,
  FOREIGN KEY (artistID) REFERENCES artist(id)
);
