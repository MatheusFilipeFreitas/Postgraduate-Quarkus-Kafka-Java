CREATE TABLE Payment (
    id BIGINT PRIMARY KEY,
    amount DECIMAL(9, 2) NOT NULL,
    status ENUM('CREATED', 'CONFIRMED', 'CANCELLED') NOT NULL,
    orderId BIGINT NOT NULL
);

CREATE TABLE Payment_SEQ (
    next_val BIGINT
);
