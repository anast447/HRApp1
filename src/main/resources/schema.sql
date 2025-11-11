CREATE TABLE IF NOT EXISTS employees (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  personnel_number VARCHAR(255) NOT NULL UNIQUE,
  last_name VARCHAR(255),
  first_name VARCHAR(255),
  middle_name VARCHAR(255),
  position VARCHAR(255),
  department VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  employee_id BIGINT NOT NULL,
  order_type VARCHAR(255),
  order_date DATE,
  description VARCHAR(1000),
  CONSTRAINT fk_orders_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE IF NOT EXISTS hire_orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT NOT NULL,
  hire_date DATE,
  position VARCHAR(255),
  department VARCHAR(255),
  salary DOUBLE,
  CONSTRAINT fk_hire_orders_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dismissal_orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT NOT NULL,
  dismissal_date DATE,
  dismissal_reason VARCHAR(1000),
  CONSTRAINT fk_dismissal_orders_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255)
);

ALTER TABLE orders
DROP CONSTRAINT fk_orders_employee;

ALTER TABLE orders
ADD CONSTRAINT fk_orders_employee FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE;