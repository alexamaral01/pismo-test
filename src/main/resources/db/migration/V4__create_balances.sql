CREATE TABLE TRANSACTIONS (
    TRANSACTION_ID serial CONSTRAINT TRANSACTIONS_ID_PK PRIMARY KEY,
    ACCOUNT_ID INT NOT NULL,
    OPERATION_TYPE_ID INT NOT NULL,
    AMOUNT NUMERIC NOT NULL,
    EVENT_DATE TIMESTAMP NOT NULL
);

CREATE INDEX TRANSACTIONS_ACCOUNT_ID_IDX ON TRANSACTIONS (account_id);
CREATE INDEX TRANSACTIONS_EVENT_DATE_IDX ON TRANSACTIONS (event_date);