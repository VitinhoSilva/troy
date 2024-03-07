CREATE TABLE IF NOT EXISTS troy.year (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL
);

INSERT INTO troy.year (id, name) VALUES
('ee5b1cfa-034e-48d3-934b-48833344f81f', '2024'),
('628585c8-0b8f-454b-80b6-9578315d67e2', '2025'),
('e55bea9b-b1cf-41fe-afe5-cafdc878ca5a', '2026');