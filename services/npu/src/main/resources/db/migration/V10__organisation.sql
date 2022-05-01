CREATE TABLE organisation
(
    id                      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    status                  VARCHAR(255)                            NOT NULL,
    virkning_fra            DATE                     DEFAULT CURRENT_DATE,
    created_at              TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP WITH TIME ZONE,
    brugernavn              VARCHAR(255)                            NOT NULL,
    optlock                 INTEGER,
    navn                    VARCHAR(255)                            NOT NULL,
    kort_navn               VARCHAR(255)                            NOT NULL,
    beskrivelse             VARCHAR(2000),
    weblink                 VARCHAR(255),
    kontakt_navn            VARCHAR(255),
    kontakt_mail            VARCHAR(255),
    releasecenter_kort_navn VARCHAR(255),
    releasecenter_sprog     VARCHAR(255),
    marked_as_releasecenter BOOLEAN                  DEFAULT FALSE,
    active_at               TIMESTAMP WITH TIME ZONE,
    organisation_note_id    BIGINT,
    CONSTRAINT pk_organisation PRIMARY KEY (id)
);

ALTER TABLE organisation
    ADD CONSTRAINT uc_organisation_kort_navn UNIQUE (kort_navn);

ALTER TABLE organisation
    ADD CONSTRAINT uc_organisation_navn UNIQUE (navn);

ALTER TABLE organisation
    ADD CONSTRAINT FK_ORGANISATION_ON_RELEASECENTER_KORT_NAVN FOREIGN KEY (releasecenter_kort_navn) REFERENCES organisation (kort_navn);

CREATE TABLE organisation_note
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    tekst                 TEXT                                    NOT NULL,
    bruger                VARCHAR(255)                            NOT NULL,
    created_at            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP WITH TIME ZONE,
    optlock               INTEGER                                 NOT NULL,
    organisation_id       BIGINT,
    organisation_draft_id BIGINT,
    CONSTRAINT pk_organisation_note PRIMARY KEY (id)
);

ALTER TABLE organisation
    ADD CONSTRAINT FK_ORGANISATION_ON_ORGANISATION_NOTE FOREIGN KEY (organisation_note_id) REFERENCES organisation_note (id);