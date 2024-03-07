CREATE TABLE IF NOT EXISTS troy.month (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL
);

INSERT INTO troy.month (id, name) VALUES
('9c6e3d9e-3aa3-4ec3-b2e1-df4d4a442a6d', 'Janeiro'),
('65a65cc9-fb48-4b2f-bf17-ccedf1e7ad97', 'Fevereiro'),
('01c9c4b0-f71b-4742-a94f-faf28e6e882e', 'Março'),
('ae10f017-5f8e-4743-8b59-32b69b8a7f2a', 'Abril'),
('f0c9e997-095a-48f4-b6d6-5ec2aeef259f', 'Maio'),
('7c41bbd0-29a7-42de-9f36-99cfd104fb4d', 'Junho'),
('c65a425a-9124-4f23-8f37-00e56b1b5d17', 'Julho'),
('4d4593ed-8370-4a41-96ed-30347b057b59', 'Agosto'),
('1e6b84c5-46a7-47e4-b0ae-171e5b7bfb63', 'Setembro'),
('42e29121-cc21-4145-b7da-0b44fc1d2080', 'Outubro'),
('7844d8d2-2075-46a0-9254-31d06dbcf9ab', 'Novembro'),
('94625756-19f7-48b9-9ae7-8a15dfc8753c', 'Dezembro');