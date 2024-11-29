CREATE TABLE IF NOT EXISTS products
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- Уникальный идентификатор товара, автоматически увеличивается
    description TEXT           NOT NULL,                    -- Описание товара
    price       NUMERIC(10, 2) NOT NULL,                    -- Стоимость товара, десятичное число с 2 знаками после запятой
    quantity    INTEGER        NOT NULL                     -- Количество товара на складе
);

CREATE TABLE IF NOT EXISTS customers
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- Уникальный идентификатор покупателя, автоматически генерируется
    first_name TEXT NOT NULL,                              -- Имя покупателя
    last_name  TEXT NOT NULL                               -- Фамилия покупателя
);

CREATE TABLE IF NOT EXISTS orders
(
    product_id  UUID      NOT NULL,                           -- Идентификатор товара, внешний ключ
    customer_id UUID      NOT NULL,                           -- Идентификатор заказчика, внешний ключ
    order_date  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Дата заказа, по умолчанию текущее время
    quantity    INTEGER   NOT NULL,                           -- Количество товаров в заказе
    FOREIGN KEY (product_id) REFERENCES products (id),        -- Внешний ключ на таблицу products
    FOREIGN KEY (customer_id) REFERENCES customers (id)       -- Внешний ключ на таблицу customers
);


-- Добававляем товары в таблицу products
INSERT INTO products (id, description, price, quantity)
VALUES ('3aa553f6-0df5-48a8-8eb9-ef0e2623ec10', 'Laptop', 1200.00,
        50), -- UUID (генирируется автоматически), Название, цена, количество
       ('5e046d9e-6aae-4b9c-a98f-89166415a90c', 'Smartphone', 800.00, 100),
       ('57af74eb-0d84-4aab-9b6e-e8436c348ae6', 'Tablet', 500.00, 75),
       ('b6d96573-19c9-4459-a939-eebcfc99f740', 'Smartwatch', 200.00, 200),
       ('110c10e1-832f-4e2e-97a0-84a51ac388fa', 'Headphones', 150.00, 300),
       ('f8933413-7242-4dad-96d1-02df58afa610', 'Keyboard', 100.00, 150),
       ('fb6fb35e-2f1c-41be-a00e-a42e6db493a5', 'Mouse', 50.00, 250),
       ('8468eafa-f79a-4bae-8218-822d6c57906e', 'Monitor', 300.00, 80),
       ('f3ccf1e1-4a1d-4e92-b9fd-2a24d26f9302', 'Printer', 250.00, 60),
       ('36b6bbca-2fb5-4ae2-93c9-e3c5bee2583a', 'External Hard Drive', 100.00, 120);


-- Добавляем пользователей в таблицу customers
-- UUID (генирируется автоматически), Имя, Фамилия
INSERT INTO customers (first_name, last_name)
VALUES ('3178fbf7-acee-4201-9441-f24d98300c0f', 'John', 'Doe'),
       ('ff28a40d-4d27-4643-9937-ba4b22b63df2', 'Jane', 'Smith'),
       ('8148f044-539a-498a-8532-b627ceae9269', 'Michael', 'Johnson'),
       ('6249fa16-477a-4dda-a703-898a5a5f0bb7', 'Emily', 'Davis'),
       ('ef1f4b3d-7009-436c-b681-c675fe854c9c', 'Chris', 'Brown'),
       ('28b05281-3d0f-42ac-97b1-414d01cd7d07', 'Jessica', 'Wilson'),
       ('2204f74e-df19-4512-b1b9-426afcebe524', 'Daniel', 'Garcia'),
       ('0f5e2b9f-1aae-4b1c-8f43-3c6529b0cc45', 'Laura', 'Martinez'),
       ('63148b6c-7182-48fe-910b-1cad8a52d6b9', 'James', 'Anderson'),
       ('7bbc0a6f-f753-4acc-aed8-b01b8c13e810', 'Sarah', 'Taylor');

-- Добавляем заказы в таблицу  orders
INSERT INTO orders (product_id, customer_id, order_date, quantity)
VALUES ('3aa553f6-0df5-48a8-8eb9-ef0e2623ec10', '3178fbf7-acee-4201-9441-f24d98300c0f', '2024-01-01 10:00:00', 2), -- Указываем ID товарв, Id покупателяЮ дату заказа, количество товара
       ('5e046d9e-6aae-4b9c-a98f-89166415a90c', '3178fbf7-acee-4201-9441-f24d98300c0f', '2024-01-01 10:00:00', 1),
       ('57af74eb-0d84-4aab-9b6e-e8436c348ae6', 'ff28a40d-4d27-4643-9937-ba4b22b63df2', '2024-01-02 11:00:00', 5),
       ('b6d96573-19c9-4459-a939-eebcfc99f740', 'ff28a40d-4d27-4643-9937-ba4b22b63df2', '2024-01-02 11:00:00', 3),
       ('110c10e1-832f-4e2e-97a0-84a51ac388fa', '8148f044-539a-498a-8532-b627ceae9269', '2024-01-03 12:00:00', 4),
       ('f8933413-7242-4dad-96d1-02df58afa610', '8148f044-539a-498a-8532-b627ceae9269', '2024-01-03 12:00:00', 6),
       ('fb6fb35e-2f1c-41be-a00e-a42e6db493a5', '6249fa16-477a-4dda-a703-898a5a5f0bb7', '2024-01-04 13:00:00', 1),
       ('8468eafa-f79a-4bae-8218-822d6c57906e', '6249fa16-477a-4dda-a703-898a5a5f0bb7', '2024-01-04 13:00:00', 7),
       ('f3ccf1e1-4a1d-4e92-b9fd-2a24d26f9302', 'ef1f4b3d-7009-436c-b681-c675fe854c9c', '2024-01-05 14:00:00', 8),
       ('36b6bbca-2fb5-4ae2-93c9-e3c5bee2583a', 'ef1f4b3d-7009-436c-b681-c675fe854c9c', '2024-01-05 14:00:00', 2),

       ('3aa553f6-0df5-48a8-8eb9-ef0e2623ec10', '28b05281-3d0f-42ac-97b1-414d01cd7d07', '2024-01-06 15:00:00', 3),
       ('5e046d9e-6aae-4b9c-a98f-89166415a90c', '28b05281-3d0f-42ac-97b1-414d01cd7d07', '2024-01-06 15:00:00', 1),
       ('57af74eb-0d84-4aab-9b6e-e8436c348ae6', '2204f74e-df19-4512-b1b9-426afcebe524', '2024-01-07 16:00:00', 5),
       ('b6d96573-19c9-4459-a939-eebcfc99f740', '2204f74e-df19-4512-b1b9-426afcebe524', '2024-01-07 16:00:00', 3),
       ('110c10e1-832f-4e2e-97a0-84a51ac388fa', '0f5e2b9f-1aae-4b1c-8f43-3c6529b0cc45', '2024-01-08 17:00:00', 4),
       ('f8933413-7242-4dad-96d1-02df58afa610', '0f5e2b9f-1aae-4b1c-8f43-3c6529b0cc45', '2024-01-08 17:00:00', 6),
       ('fb6fb35e-2f1c-41be-a00e-a42e6db493a5', '63148b6c-7182-48fe-910b-1cad8a52d6b9', '2024-01-09 18:00:00', 1),
       ('8468eafa-f79a-4bae-8218-822d6c57906e', '63148b6c-7182-48fe-910b-1cad8a52d6b9', '2024-01-09 18:00:00', 7),
       ('f3ccf1e1-4a1d-4e92-b9fd-2a24d26f9302', '7bbc0a6f-f753-4acc-aed8-b01b8c13e810', '2024-01-10 19:00:00', 8),
       ('36b6bbca-2fb5-4ae2-93c9-e3c5bee2583a', '7bbc0a6f-f753-4acc-aed8-b01b8c13e810', '2024-01-10 19:00:00', 2),

       ('3aa553f6-0df5-48a8-8eb9-ef0e2623ec10', '3178fbf7-acee-4201-9441-f24d98300c0f', '2024-01-11 10:00:00', 3),
       ('5e046d9e-6aae-4b9c-a98f-89166415a90c', '3178fbf7-acee-4201-9441-f24d98300c0f', '2024-01-11 10:00:00', 1),
       ('57af74eb-0d84-4aab-9b6e-e8436c348ae6', 'ff28a40d-4d27-4643-9937-ba4b22b63df2', '2024-01-12 11:00:00', 5),
       ('b6d96573-19c9-4459-a939-eebcfc99f740', 'ff28a40d-4d27-4643-9937-ba4b22b63df2', '2024-01-12 11:00:00', 3),
       ('110c10e1-832f-4e2e-97a0-84a51ac388fa', '8148f044-539a-498a-8532-b627ceae9269', '2024-01-13 12:00:00', 4),
       ('f8933413-7242-4dad-96d1-02df58afa610', '8148f044-539a-498a-8532-b627ceae9269', '2024-01-13 12:00:00', 6),
       ('fb6fb35e-2f1c-41be-a00e-a42e6db493a5', '6249fa16-477a-4dda-a703-898a5a5f0bb7', '2024-01-14 13:00:00', 1),
       ('8468eafa-f79a-4bae-8218-822d6c57906e', '6249fa16-477a-4dda-a703-898a5a5f0bb7', '2024-01-14 13:00:00', 7),
       ('f3ccf1e1-4a1d-4e92-b9fd-2a24d26f9302', 'ef1f4b3d-7009-436c-b681-c675fe854c9c', '2024-01-15 14:00:00', 8);

