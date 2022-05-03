CREATE TABLE koncert
(
    id           BIGINT       NOT NULL,
    optlock      INTEGER      NOT NULL,
    virkning_fra date,
    active_at    TIMESTAMP WITHOUT TIME ZONE,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at   TIMESTAMP WITH TIME ZONE,
    brugernavn   VARCHAR(255) NOT NULL,
    dato         VARCHAR(255) NOT NULL,
    sted         VARCHAR(255) NOT NULL,
    program      VARCHAR(255) NOT NULL,
    dirigent     VARCHAR(255),
    orkester_id  BIGINT,
    CONSTRAINT pk_koncert PRIMARY KEY (id)
);

ALTER TABLE koncert
    ADD CONSTRAINT FK_KONCERT_ON_ORKESTER FOREIGN KEY (orkester_id) REFERENCES orkester (id);