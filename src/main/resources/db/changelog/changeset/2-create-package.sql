--changeset nurzhan:2
CREATE TABLE package (
    id UUID PRIMARY KEY,
    description VARCHAR(255),
    delivery_address VARCHAR(255),
    employee_id BIGINT,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);
