-- changeset nurzhan:5
ALTER TABLE employee
    ADD COLUMN status VARCHAR(255) NOT NULL DEFAULT 'ACTIVE';
