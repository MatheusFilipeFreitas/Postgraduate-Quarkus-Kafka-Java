CREATE TABLE MenuItem (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(1000),
    category ENUM('APPETIZERS', 'MAIN_COURSES', 'DRINKS', 'DESSERT') NOT NULL,
    price DECIMAL(9, 2) NOT NULL,
    promotionalPrice DECIMAL(9, 2)
);

CREATE TABLE MenuItem_SEQ (
    next_val BIGINT
);
