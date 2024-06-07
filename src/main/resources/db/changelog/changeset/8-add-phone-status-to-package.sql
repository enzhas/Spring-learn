--changeset nurzhan:7
ALTER TABLE package
    ADD phone VARCHAR(20);
ALTER TABLE package
    ADD status VARCHAR(10) not null default 'WAITING';
