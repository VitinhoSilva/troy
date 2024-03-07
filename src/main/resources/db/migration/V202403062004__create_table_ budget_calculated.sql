CREATE TABLE IF NOT EXISTS troy.budget_calculated (
    id UUID PRIMARY KEY,
    budget_id uuid NOT NULL,
    value DECIMAL NOT NULL,
    CONSTRAINT fk_budget FOREIGN KEY(budget_id) REFERENCES troy.budget(id) ON DELETE CASCADE
);