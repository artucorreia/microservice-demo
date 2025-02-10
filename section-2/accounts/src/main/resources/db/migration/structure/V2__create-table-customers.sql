CREATE TABLE IF NOT EXISTS customers (
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  phone_number varchar(20) NOT NULL,
  created_at timestamp NOT NULL,
  created_by varchar(20) NOT NULL,
  updated_at timestamp DEFAULT NULL,
  updated_by varchar(20) DEFAULT NULL
);
