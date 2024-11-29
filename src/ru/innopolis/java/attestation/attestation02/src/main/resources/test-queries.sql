--1. Запрос выводит имя пользователей с фамилиями 'Anderson' и 'Smith'
select c.id, c.first_name as "Имя"
from customers c
where c.last_name in ('Anderson', 'Smith');

--2. Запрос показывает заказы покупателей where c.last_name in ('Anderson', 'Smith')
select p.description                          as "Название товара",
       concat(c.last_name, ' ', c.first_name) as "ФИО",
       o.order_date                           as "Дата заказа",
       o.quantity                             as "Количество товара"
from orders o
         join customers c on o.customer_id = c.id
         join products p on p.id = o.product_id
where c.last_name in ('Anderson', 'Smith');

--3. Запрос выводит товары которых более 50 шт
select p.description as "Название товара",
       p.quantity    as "Количество",
       p.price       as "Цена"
from products p
where p.quantity > 50;

--4. Запрос меняет имя у конкретного пользователя
update customers
set first_name = 'Daniel'
where id = '3178fbf7-acee-4201-9441-f24d98300c0f';

--5. Запрос меняет количество у конкретного товара
update products
set quantity = 90
where id = '3aa553f6-0df5-48a8-8eb9-ef0e2623ec10';

-- 6. Запрос меняет количество товара у конкретного пользователя
--с конкретным товаром в определенное время
update orders
set quantity = 5
where product_id = '3aa553f6-0df5-48a8-8eb9-ef0e2623ec10'
  and customer_id = '3178fbf7-acee-4201-9441-f24d98300c0f'
  and order_date = '2024-01-01 10:00:00.000000';

/*INSERT INTO customers (first_name, last_name)
VALUES ('f24b004c-c092-45ad-9e95-c9008ad70859', 'Chris', 'Smith');
Добавли пользователя, которого не будет в смежных таблицах*/
--7. Запрос на удаление конкретного пользователя
delete
from customers
where id = 'f24b004c-c092-45ad-9e95-c9008ad70859';

/*INSERT INTO products (id, description, price, quantity)
VALUES ('56b12b8b-adb0-44a0-8809-870b3e904f8e', 'Samovar777', 7777.00,700);
  Добавли товар, которого не будет в смежных таблицах*/
--8. Запрос на удаление конкретного товара
delete
from products
where id = '56b12b8b-adb0-44a0-8809-870b3e904f8e';

--9. Запрос на удаление конкретного заказа
delete
from orders
where product_id = '3aa553f6-0df5-48a8-8eb9-ef0e2623ec10'
  and customer_id = '3178fbf7-acee-4201-9441-f24d98300c0f'
  and order_date = '2024-01-11 10:00:00.000000'

--10. Запрос выводит Фамилию Имя  пользователей которые купили определенный товар

select p.description                          as "Название товара",
       p.price                                as "Цена товара",
       concat(c.last_name, ' ', c.first_name) as "Фамилия Имя"
from orders o
         join products p on o.product_id = p.id
         join customers c on o.customer_id = c.id
where p.id = 'fb6fb35e-2f1c-41be-a00e-a42e6db493a5'

