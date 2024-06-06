--changeset nurzhan:3
ALTER TABLE employee ALTER COLUMN id SET DEFAULT nextval('empl_id');
SELECT setval('empl_id', COALESCE((SELECT MAX(id) FROM employee), 1));
ALTER TABLE employee ALTER COLUMN id SET NOT NULL;