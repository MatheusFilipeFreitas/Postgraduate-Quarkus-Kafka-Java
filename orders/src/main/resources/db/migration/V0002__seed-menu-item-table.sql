-- MAIN_COURSES
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice) VALUES
(1, 'Chaves Ham Sandwich', 'Simple ham sandwich, made with lots of love.', 'MAIN_COURSES', 3.50, 2.99);

-- DRINKS
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice) VALUES
(2, 'Chaves Refreshment', 'Lemon juice that looks like tamarind but tastes like gooseberry.', 'DRINKS', 2.99, NULL);

-- APPETIZERS
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice)
VALUES
(3, 'Seu Madruga Toasts', 'Lightly burnt and crispy toasts, Seu Madruga style.', 'APPETIZERS', 5.99, NULL),
(4, 'Dona Clotilde Cucumber Salad', 'Fresh cucumber salad seasoned with lemon and spices.', 'APPETIZERS', 6.99, 5.99);

-- More MAIN_COURSES
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice)
VALUES
(5, 'Dona Florinda Chicken Pie', 'Chicken pie with creamy filling and crispy crust.', 'MAIN_COURSES', 12.99, 10.99),
(6, 'Quico Popcorn', 'Bucket of popcorn prepared with care by Quico.', 'MAIN_COURSES', 4.99, 3.99);

-- More DRINKS
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice)
VALUES
(7, 'Jamaica Water', 'Hibiscus-infused water with a touch of sugar.', 'DRINKS', 2.50, 2.00),
(8, 'Dona Florinda Coffee', 'Strong coffee to start the day with energy.', 'DRINKS', 1.99, 1.50);

-- DESSERT
INSERT INTO MenuItem (id, name, description, category, price, promotionalPrice)
VALUES
(9, 'Chaves Churros', 'Churros filled with dulce de leche, classic and irresistible.', 'DESSERT', 4.99, 3.99),
(10, 'Nhonho Colorful Gelatin', 'Multi-colored gelatin, Nhonho favorite dessert.', 'DESSERT', 3.50, 2.99),
(11, 'Dona Clotilde Chocolate Cake', 'Chocolate cake with brigadeiro topping.', 'DESSERT', 5.99, 4.99);

INSERT INTO MenuItem_SEQ (next_val) VALUES (12);
