CREATE TABLE `Order` (
    id BIGINT PRIMARY KEY,
    orderDateTime DATETIME NOT NULL,
    status ENUM('PLACED', 'PAID', 'CONFIRMED', 'READY', 'OUT_FOR_DELIVERY', 'DELIVERED') NOT NULL,
    customerName VARCHAR(100) NOT NULL,
    customerCpf VARCHAR(14) NOT NULL,
    customerPhone VARCHAR(16) NOT NULL,
    customerAddress VARCHAR(300) NOT NULL
);

CREATE TABLE Order_SEQ (
    next_val BIGINT
);

CREATE TABLE OrderItem (
    id BIGINT PRIMARY KEY,
    quantity BIGINT NOT NULL,
    unitPrice DECIMAL(9, 2) NOT NULL,
    notes VARCHAR(300),
    order_id BIGINT NOT NULL,
    menu_item_id BIGINT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (menu_item_id) REFERENCES MenuItem(id)
);

CREATE TABLE OrderItem_SEQ (
    next_val BIGINT
);
