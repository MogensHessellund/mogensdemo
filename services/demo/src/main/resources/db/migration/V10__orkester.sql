CREATE TABLE orkester
(
    id           BIGINT       NOT NULL,
    optlock      INTEGER      NOT NULL,
    virkning_fra date,
    active_at    TIMESTAMP WITHOUT TIME ZONE,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at   TIMESTAMP WITH TIME ZONE,
    brugernavn   VARCHAR(255) NOT NULL,
    navn         VARCHAR(255) NOT NULL,
    forkortelse  VARCHAR(255),
    type         VARCHAR(255),
    formand      VARCHAR(255),
    telefon      VARCHAR(255),
    beskrivelse  VARCHAR(255),
    dirigent     VARCHAR(255),
    CONSTRAINT pk_orkester PRIMARY KEY (id)
);