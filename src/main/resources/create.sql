create table products (
                        id serial primary key,
                        title varchar(128),
                        price integer
);

create table customers (
    id serial primary key,
    name varchar(128)
);


-- тут могла быть история редактирования товара, заказ и список товаров в заказе, но этого нет
create table customer_product_relation (
    id serial primary key,
    customer_id integer,
    product_id integer,
    created_at integer,
    product_price integer
);

ALTER TABLE customer_product_relation
    ADD CONSTRAINT fk_customer_product_relation_customer_id FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE customer_product_relation
    ADD CONSTRAINT fk_customer_product_relation_product_id FOREIGN KEY (product_id) REFERENCES products (id);

INSERT INTO products(title, price) VALUES
('product 1', 1),
('product 2', 2),
('product 3', 3),
('product 4', 4),
('product 5', 5);

INSERT INTO customers(name) VALUES
    ('Name 1'),
    ('Name 2'),
    ('Name 3'),
    ('Name 4'),
    ('Name 5');

INSERT INTO customer_product_relation(customer_id, product_id, created_at, product_price) VALUES
(1, 2, 1613075001, 3),
(2, 2, 1613075001, 3),
(3, 5, 1613075001, 3),
(5, 4, 1613075001, 3),
(4, 1, 1613075001, 3);
