--changeset nurzhan:6
ALTER TABLE package
ADD city VARCHAR(255) ;

ALTER TABLE package
ADD street VARCHAR(255);

ALTER TABLE employee
ADD city VARCHAR(255);