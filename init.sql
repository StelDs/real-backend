CREATE DATABASE "real";
\connect "real";
CREATE SCHEMA IF NOT EXISTS reality;

CREATE USER owner_reality_db WITH PASSWORD 'owner_reality_db';
GRANT ALL PRIVILEGES ON DATABASE "real" TO owner_reality_db;
ALTER USER owner_reality_db WITH SUPERUSER;
