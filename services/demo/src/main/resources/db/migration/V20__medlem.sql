CREATE TABLE medlem
(
    id           BIGINT       NOT NULL,
    optlock      INTEGER      NOT NULL,
    virkning_fra date,
    active_at    TIMESTAMP WITHOUT TIME ZONE,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at   TIMESTAMP WITH TIME ZONE,
    brugernavn   VARCHAR(255) NOT NULL,
    navn         VARCHAR(255) NOT NULL,
    instrument   VARCHAR(255) NOT NULL,
    studerende   BOOLEAN,
    telefon      VARCHAR(255),
    erfaring     INTEGER,
    orkester_id  BIGINT,
    CONSTRAINT pk_medlem PRIMARY KEY (id)
);

ALTER TABLE medlem
    ADD CONSTRAINT FK_MEDLEM_ON_ORKESTER FOREIGN KEY (orkester_id) REFERENCES orkester (id);