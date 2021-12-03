CREATE TABLE OPERATIONS_TYPES (
    operation_type_id serial CONSTRAINT OPERATIONS_TYPES_ID_PK PRIMARY KEY,
	description VARCHAR(50) NOT NULL,
	"transation_type" VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX OPERATION_TYPE_DESCRIPTION_IDX ON OPERATIONS_TYPES (description);

INSERT INTO OPERATIONS_TYPES VALUES( nextval('operations_types_operation_type_id_seq'), 'COMPRA A VISTA', 'EXIT' );
INSERT INTO OPERATIONS_TYPES VALUES( nextval('operations_types_operation_type_id_seq'), 'COMPRA PARCELADA', 'EXIT' );
INSERT INTO OPERATIONS_TYPES VALUES( nextval('operations_types_operation_type_id_seq'), 'SAQUE', 'EXIT'  );
INSERT INTO OPERATIONS_TYPES VALUES( nextval('operations_types_operation_type_id_seq'), 'PAGAMENTO', 'ENTRY');