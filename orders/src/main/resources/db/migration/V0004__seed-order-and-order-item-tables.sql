-- Orders
INSERT INTO `Order` (id, orderDateTime, status, customerName, customerCpf, customerPhone, customerAddress)
VALUES
(1, '2024-10-13 12:30:00', 'PLACED', 'Chaves', '123.456.789-00', '(11) 91234-5678', 'Vila 8, Chaves Barrel'),
(2, '2024-10-13 13:00:00', 'PLACED', 'Seu Madruga', '234.567.890-11', '(11) 92345-6789', 'Vila 8, House 72'),
(3, '2024-10-13 13:15:00', 'PLACED', 'Seu Madroga, Seu Madruga Cousin', '345.678.901-22', '(11) 93456-7890', 'Vila 8, House 14'),
(4, '2024-10-13 14:00:00', 'PLACED', 'Quico', '456.789.012-33', '(11) 94567-8901', 'Vila 8, House 14'),
(5, '2024-10-13 14:30:00', 'PLACED', 'Professor Girafales', '567.890.123-44', '(11) 95678-9012', 'Vila 8, Teachers Room'),
(6, '2024-10-13 15:00:00', 'PLACED', 'Dona Clotilde', '678.901.234-55', '(11) 96789-0123', 'Vila 8, House 71'),
(7, '2024-10-13 15:15:00', 'PLACED', 'Seu Barriga', '789.012.345-66', '(11) 97890-1234', 'Vila 8, House 20'),
(8, '2024-10-13 15:30:00', 'PLACED', 'Nhonho', '890.123.456-77', '(11) 98901-2345', 'Vila 8, House 20'),
(9, '2024-10-13 16:00:00', 'PLACED', 'Paty', '901.234.567-88', '(11) 99012-3456', 'Vila 8, House 15'),
(10, '2024-10-13 16:30:00', 'PLACED', 'Godinez', '012.345.678-99', '(11) 90123-4567', 'Vila 8, House 13'),
(11, '2024-10-13 17:00:00', 'PLACED', 'Dona Neves', '123.678.901-00', '(11) 91123-4567', 'Vila 8, House 72'),
(12, '2024-10-13 17:15:00', 'PLACED', 'Popis', '234.789.012-11', '(11) 92234-5678', 'Vila 8, House 14'),
(13, '2024-10-13 17:30:00', 'PLACED', 'Jaiminho', '345.890.123-22', '(11) 93345-6789', 'Post Office, Vila 8'),
(14, '2024-10-13 18:00:00', 'PLACED', 'Chiquinha', '456.901.234-33', '(11) 94456-7890', 'Vila 8, House 73'),
(15, '2024-10-13 18:30:00', 'PLACED', 'Malicha', '567.012.345-44', '(11) 95567-8901', 'Vila 8, House 71');

INSERT INTO Order_SEQ (next_val) VALUES (16);

-- Chaves order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(1, 1, 3.50, 'Extra ham, please!', 1, 1),
(2, 2, 2.99, 'Very cold', 1, 2);

-- Seu Madruga order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(3, 1, 5.99, 'Make it well burnt!', 2, 3),
(4, 1, 1.99, NULL, 2, 8);

-- Seu Madroga order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(5, 1, 12.99, 'No pepper, please.', 3, 5),
(6, 1, 5.99, NULL, 3, 11);

-- Quico order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(7, 1, 4.99, 'Extra popcorn!', 4, 6),
(8, 1, 2.50, 'Very sweet', 4, 7);

-- Professor Girafales order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(9, 1, 4.99, NULL, 5, 9),
(10, 1, 5.99, 'To go', 5, 11);

-- Dona Clotilde order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(11, 2, 6.99, 'Well seasoned, please.', 6, 4),
(12, 1, 3.50, 'The favorite dessert!', 6, 10);

-- Seu Barriga order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(13, 1, 5.99, 'Extra sweet, please.', 7, 11),
(14, 2, 2.99, 'No ice.', 7, 2);

-- Nhonho order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(15, 1, 4.99, 'Extra dulce de leche filling.', 8, 9),
(16, 3, 4.99, NULL, 8, 6);

-- Paty order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(17, 1, 12.99, 'No onion, please.', 9, 5),
(18, 2, 2.50, 'Less sugar.', 9, 7);

-- Godinez order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(19, 2, 3.50, 'To go.', 10, 10),
(20, 1, 4.99, 'Extra topping.', 10, 9);

-- Dona Neves order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(21, 1, 3.50, 'Extra crispy', 11, 1),
(22, 2, 5.99, 'Generous portion', 11, 11);

-- Popis order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(23, 1, 6.99, 'Extra lemon', 12, 4),
(24, 1, 2.50, 'Very sweet', 12, 7);

-- Jaiminho order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(25, 1, 4.99, 'To go', 13, 9),
(26, 1, 3.50, NULL, 13, 10);

-- Chiquinha order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(27, 1, 5.99, 'No sugar', 14, 11),
(28, 1, 4.99, 'Extra salty', 14, 6);

-- Malicha order
INSERT INTO OrderItem (id, quantity, unitPrice, notes, order_id, menu_item_id)
VALUES
(29, 3, 2.99, 'With ice', 15, 2),
(30, 1, 3.50, 'Colorful', 15, 10);

INSERT INTO OrderItem_SEQ (next_val) VALUES (31);
