-- Data Test Users
INSERT INTO users(name, last_name, age, identity_card, email) VALUES('Luis', 'Orellana', 24, '12654789', 'luis@mail.com');
INSERT INTO users(name, last_name, age, identity_card, email) VALUES('Harrison', 'Martinez', 28, '147852369', 'harrison@mail.com');

-- Data Test Bookings
INSERT INTO bookings(booking_type, reserved, booking_start_date, booking_end_date, payment_methods) VALUES('Habitación sola', true, '2021-02-22', '2021-04-22', 'CASH');
INSERT INTO bookings(booking_type, reserved, booking_start_date, booking_end_date, payment_methods) VALUES('Cumpus Escolar', false, '2022-01-10', '2022-04-10', 'CARD');