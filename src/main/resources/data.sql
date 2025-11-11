INSERT INTO employees (personnel_number, last_name, first_name, middle_name, position, department) VALUES
('1001', 'Иванов', 'Иван', 'Иванович', 'Менеджер', 'Продажи'),
('1002', 'Петров', 'Петр', 'Петрович', 'Разработчик', 'ИТ');

INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$Dow1aE6yTbJNrwT29a5GGeTUCmS3/J3NpaDSznM6Oe01rZxiPKKPe', 'ROLE_ADMIN');
-- пароль admin в bcrypt

INSERT INTO orders (employee_id, order_type, order_date, description) VALUES
(1, 'Общий приказ', '2025-01-10', 'Приказ по личному составу №456'),
(2, 'Общий приказ', '2025-01-15', 'Приказ по личному составу №412');

INSERT INTO hire_orders (order_id, hire_date, position, department, salary) VALUES
(1, '2025-01-10', 'Менеджер', 'Продажи', 70000);

INSERT INTO dismissal_orders (order_id, dismissal_date, dismissal_reason) VALUES
(2, '2025-10-01', 'По собственному желанию');
