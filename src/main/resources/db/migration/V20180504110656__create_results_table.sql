CREATE TABLE results (
  id SERIAL PRIMARY KEY,
  name VARCHAR (255) NOT NULL,
  feature VARCHAR (255),
  report JSON NOT NULL,
  product_id INT NOT NULL REFERENCES products(id)
);