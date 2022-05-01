INSERT INTO organisation
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter, releasecenter_sprog)
VALUES (1, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Internationalt Releasecenter',
        'INT', '', '', '', '',
        TRUE, 'EN');

INSERT INTO organisation
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter, releasecenter_sprog)
VALUES (2, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Dansk Releasecenter', 'DK', '',
        '', '', '', TRUE, 'DK');

INSERT INTO organisation
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter, releasecenter_sprog)
VALUES (3, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'TEST Releasecenter', 'TSTR', '',
        '', '', '', TRUE, 'EN');

INSERT INTO organisation
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, releasecenter_kort_navn, kontakt_navn)
VALUES (4, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Til unittest', 'TEST',
        'The quick brown fox jumped over the lazy dog', 'TSTR','Fedtmule');

INSERT INTO organisation
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, releasecenter_kort_navn)
VALUES (27, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Til unittest2', 'TEST2',
        'The quick brown fox jumped over the lazy dog øæå', 'TSTR');

INSERT INTO organisation (id, status, virkning_fra, created_at, updated_at, brugernavn, optlock, navn,
                          kort_navn,
                          beskrivelse, weblink, kontakt_navn, kontakt_mail, releasecenter_kort_navn)
VALUES (5, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        '﻿Bureau International des Poids et Mesures', 'BIPM', '', 'http://www.bipm.org/noflash.html', '', '', 'INT'),
       (6, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'Chemical Abstracts Services', 'CAS', '', 'http://www.cas.org/index.html', '', '', 'INT'),
       (7, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'Enzyme nomenclature database', 'EC', '', 'http://www.expasy.ch/enzyme/', '', '', 'INT'),
       (8, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'International Union of Pure and Applied Chemistry', 'IUPAC', '', 'http://www.iupac.org/', '', '', 'INT'),
       (9, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'Medical Subject Headings', 'MSH', '', '', '', '', 'INT'),
       (10, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'National Center for Biotechnology Information', 'NCBI',
        '1) Use of Taxonomy broweser for microorganisms https://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi?mode=Root2) Use of Gene Browser for not human genes https://www.ncbi.nlm.nih.gov/gene',
        'https://www.ncbi.nlm.nih.gov/', '', '', 'INT'),
       (11, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'NCI thesaurus', 'NCI',
        'Terminological database at the national Cancer Institute, National Institutes of Health, U.S.A.',
        'http://ncit.nci.nih.gov/ncitbrowser/pages/home.jsf?version=14.11d', '', '', 'INT'),
       (12, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        '(Sub)Committee on Nomenclature, Properties and Units in Laboratory Medicine', 'QU', '', '', '', '', 'INT'),
       (13, 'AKTIV', '2021-11-29', '2021-11-29 10:31:33.392348',
        '2021-11-29 10:34:21.426453', 'mogens', 3,
        'Mogens org the quick brown fox jumped over the lazy dog', 'xyz', 'string', 'string', 'test',
        'mogens.hessellund@cgi.com', 'INT');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn, sprog)
VALUES (2, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'RIP', 'RI', 'TSTR', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn, sprog)
VALUES (3, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'RAP', 'And2', 'TSTR', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn, sprog)
VALUES (4, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'RUP', 'RU', 'TSTR', 'EN');

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (1, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'MSHD014556', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (7, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU110347', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (9, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'EC2.4.1.18', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (13, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU101664', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (17, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'MSHD010949', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (19, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU60001', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (23, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'MSHD007074', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (29, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU50106', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (31, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU70500', 'TSTR', 3);

INSERT INTO elementbegreb
(id, status, virkning_fra, created_at, brugernavn, optlock, element_kode, releasecenter_kort_navn, elementterm_id)
VALUES (37, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'test', 0, 'QU100009', 'TSTR', 3);

--NPU01036	MSHD010949	QU60001¤MSHD007074	QU50106¤QU70500	QU100009

INSERT INTO elementbegreb_note
(id, optlock, tekst, bruger, elementbegreb_id)
VALUES (7, 0,
        'Several innovative technologies have been developed for Webb. These include a primary mirror made of 18 separate segments that unfold and adjust to shape after launch.',
        'testbruger', 7);

INSERT INTO elementbegreb_note
(id, optlock, tekst, bruger, elementbegreb_id)
VALUES (9, 0,
        'The mirrors are made of ultra-lightweight beryllium. Webb’s biggest feature is a tennis court sized five-layer sunshield that attenuates heat from the Sun more than a million times.',
        'testbruger', 7);

INSERT INTO elementbegreb_note
(id, optlock, tekst, bruger, elementbegreb_id)
VALUES (13, 0,
        'The telescope’s four instruments - cameras and spectrometers - have detectors that are able to record extremely faint signals.',
        'testbruger', 7);

INSERT INTO elementbegreb_note
(id, optlock, tekst, bruger, elementbegreb_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 7);


INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn,
 elementbegreb_kode, sprog)
VALUES (1, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'Urine', 'U', 'TSTR', 'MSHD014556', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn,
 elementbegreb_kode, sprog)
VALUES (5, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'Pork_bellies', 'PB', 'TSTR', 'MSHD007074', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn, sprog)
VALUES (6, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'flere_term_lang_bruger', 0, 'RAP', 'Dewey', 'INT', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn,
 elementbegreb_kode, sprog)
VALUES (7, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'Kælderkold', 'KK', 'TSTR', 'MSHD010949', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn,
 elementbegreb_kode, sprog)
VALUES (9, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'Chokolade', 'CHK', 'TSTR', 'QU70500', 'EN');

INSERT INTO elementterm
(id, status, virkning_fra, created_at, brugernavn, optlock, term_lang, term_kort, releasecenter_kort_navn,
 elementbegreb_kode, sprog)
VALUES (13, 'AKTIV', CURRENT_DATE, CURRENT_TIMESTAMP, 'testbruger', 0, 'Kelvin', 'KLV', 'TSTR', 'QU100009', 'EN');

INSERT INTO elementterm_note
(id, optlock, tekst, bruger, elementterm_id)
VALUES (7, 0,
        'Several innovative technologies have been developed for Webb. These include a primary mirror made of 18 separate segments that unfold and adjust to shape after launch.',
        'testbruger', 7);

INSERT INTO elementterm_note
(id, optlock, tekst, bruger, elementterm_id)
VALUES (9, 0,
        'The mirrors are made of ultra-lightweight beryllium. Webb’s biggest feature is a tennis court sized five-layer sunshield that attenuates heat from the Sun more than a million times.',
        'testbruger', 7);

INSERT INTO elementterm_note
(id, optlock, tekst, bruger, elementterm_id)
VALUES (13, 0,
        'The telescope’s four instruments - cameras and spectrometers - have detectors that are able to record extremely faint signals.',
        'testbruger', 7);

INSERT INTO elementterm_note
(id, optlock, tekst, bruger, elementterm_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 7);

INSERT INTO organisation_note
(id, optlock, tekst, bruger, organisation_id)
VALUES (7, 0,
        'Der var engang en sød, lille pige, som alle mennesker holdt meget af, men ingen elskede hende som hendes bedstemor, der slet ikke vidste, hvor godt hun skulle gøre det for hende.',
        'testbruger', 4);

INSERT INTO organisation_note
(id, optlock, tekst, bruger, organisation_id)
VALUES (9, 0,
        ' En gang gav hun hende en lille rød fløjlshue, der klædte hende så godt, at hun altid gik med den, og derfor blev hun kaldt Rødhætte',
        'testbruger', 4);

INSERT INTO organisation_note
(id, optlock, tekst, bruger, organisation_id)
VALUES (13, 0,
        '  En dag sagde hendes mor til hende: "Se her, lille Rødhætte, her har du et stykke kage og en flaske vin, kan du bringe det hen til bedstemor. Hun er syg og svag, så det vil nok styrke hende. Du må helst gå med det samme, før det bliver alt for varmt, men gå nu pænt den lige vej og pas på, du ikke falder og slår flasken itu. Og husk så at sige goddag straks, når nu kommer ind i stuen, og stå ikke først og se dig om."',
        'testbruger', 4);

INSERT INTO organisation_note
(id, optlock, tekst, bruger, organisation_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 4);

insert into terminologirelation (id, status, virkning_fra, created_at, updated_at, brugernavn, optlock,
                                 terminologi, begreb, relationstype, maalbegreber, releasecenter_kort_navn,
                                 elementbegreb_kode, npu_kode, terminologirelation_note_id, maalbegrebsnavn)
values (4, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'alfa', 'bravo', 'charlie', 0, 'INT',
        'QU110347', null, null, 'kanarie'),
       (7, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'blod', 'sved', 'tårer', 0, 'INT',
        'QU110347', null, null, 'klaver'),
       (9, 'AKTIV', '2021-10-29', '2021-10-29 10:24:24.477101', NULL, 'import', 1,
        'hud', 'celler', 'hår', 1, 'INT',
        'QU110347', null, null, 'camouflage'),
       (13, 'AKTIV', '2021-09-29', '2021-09-29 10:24:24.477101', NULL, 'import', 1,
        'fødder', 'tær', 'tårer', 2, 'INT',
        'QU101664', null, null, 'fiskepind');

INSERT INTO terminologirelation_note
(id, optlock, tekst, bruger, terminologirelation_id)
VALUES (7, 0,
        'Der var engang en sød, lille pige, som alle mennesker holdt meget af, men ingen elskede hende som hendes bedstemor, der slet ikke vidste, hvor godt hun skulle gøre det for hende.',
        'testbruger', 7);

INSERT INTO terminologirelation_note
(id, optlock, tekst, bruger, terminologirelation_id)
VALUES (9, 0,
        ' En gang gav hun hende en lille rød fløjlshue, der klædte hende så godt, at hun altid gik med den, og derfor blev hun kaldt Rødhætte',
        'testbruger', 7);

INSERT INTO terminologirelation_note
(id, optlock, tekst, bruger, terminologirelation_id)
VALUES (13, 0,
        '  En dag sagde hendes mor til hende: "Se her, lille Rødhætte, her har du et stykke kage og en flaske vin, kan du bringe det hen til bedstemor. Hun er syg og svag, så det vil nok styrke hende. Du må helst gå med det samme, før det bliver alt for varmt, men gå nu pænt den lige vej og pas på, du ikke falder og slår flasken itu. Og husk så at sige goddag straks, når nu kommer ind i stuen, og stå ikke først og se dig om."',
        'testbruger', 7);

INSERT INTO terminologirelation_note
(id, optlock, tekst, bruger, terminologirelation_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 13);

INSERT INTO organisation_draft
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter)
VALUES (-1, 'KLADDE', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Internationalt Releasecenter',
        'INT', '', '', '', '',
        TRUE);

INSERT INTO organisation_draft
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter)
VALUES (-2, 'KLADDE', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Dansk Releasecenter', 'DK', '',
        '', '', '', TRUE);

INSERT INTO organisation_draft
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, weblink, kontakt_navn,
 kontakt_mail, marked_as_releasecenter)
VALUES (-3, 'KLADDE', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'TEST Releasecenter', 'TSTR', '',
        '', '', '', TRUE);

INSERT INTO organisation_draft
(id, status, virkning_fra, created_at, brugernavn, optlock, navn, kort_navn, beskrivelse, releasecenter_kort_navn)
VALUES (-4, 'KLADDE', CURRENT_DATE, CURRENT_TIMESTAMP, 'init', 0, 'Til unittest', 'TEST',
        'The quick brown fox jumped over the lazy dog', 'TSTR');

INSERT INTO organisation_draft (id, status, virkning_fra, created_at, updated_at, brugernavn, optlock, navn,
                                kort_navn,
                                beskrivelse, weblink, kontakt_navn, kontakt_mail, releasecenter_kort_navn)
VALUES (-5, 'KLADDE', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        '﻿Bureau International des Poids et Mesures', 'BIPM', '', 'http://www.bipm.org/noflash.html', '', '', 'INT'),
       (-6, 'KLADDE', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'Chemical Abstracts Services', 'CAS', '', 'http://www.cas.org/index.html', '', '', 'INT'),
       (-13, 'KLADDE', '2021-11-29', '2021-11-29 10:31:33.392348',
        '2021-11-29 10:34:21.426453', 'mogens', 3,
        'Mogens org the quick brown fox jumped over the lazy dog', 'xyz', 'string', 'string', 'test',
        'mogens.hessellund@cgi.com', 'INT'),
       (-14, 'KLADDE', '2021-11-29', '2021-11-29 10:31:33.392348',
        '2021-11-29 10:34:21.426453', 'mogens', 3,
        'Mogens org the quick brown fox jumped over the lazy dog', 'xyz', 'string', 'string', 'test',
        'mogens.hessellund@cgi.com', 'INT'),
       (-15, 'KLADDE', '2021-11-29', '2021-11-29 10:31:33.392348',
        '2021-11-29 10:34:21.426453', 'mogens', 3,
        'Mogens org the quick brown fox jumped over the lazy dog', 'xyz', 'string', 'string', 'test',
        'mogens.hessellund@cgi.com', 'INT');


insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn, gruppeheader)
values (1, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST01234', 'CLC', 'Ratio', false, 'TSTR', true);


insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (7, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST007', 'MIC', 'Mystery', true, 'TSTR');


insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (9, 'AKTIV', CURRENT_TIMESTAMP, 'Poul', 0, 'TST88888', 'ALL', 'Ordinal', false, 'INT');

insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (13, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST2022', 'CLC', 'Differential', false, 'TSTR');

insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (17, 'KLAR_TIL_FRIGIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST711', 'CLC', 'Differential', true, 'TSTR');

insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (19, 'KLADDE', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST747', 'CLC', 'Differential', true, 'TSTR');

insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (23, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'NPU01036', 'CLC', 'Ordinal', true, 'TSTR');

insert into npubegreb (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                       vaerdiskala, kontekstbestemt, releasecenter_kort_navn, erstattet_af_npu_kode)
values (27, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST00001', 'CLC', 'Ordinal', false, 'TSTR', 'NPU01036');

--NPU01036	MSHD010949	QU60001¤MSHD007074	QU50106¤QU70500	QU100009



insert into terminologirelation (id, status, virkning_fra, brugernavn, optlock,
                                 terminologi, begreb, relationstype, maalbegreber, releasecenter_kort_navn,
                                 elementbegreb_kode, npu_kode, maalbegrebsnavn)
values (17, 'AKTIV', '2021-09-29', 'import', 0,
        'kalorielet', 'youghurt', 'kefir', 2, 'INT',
        'QU101664', 'NPU01036', 'skyr');

insert into npubegreb_draft (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                             vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (-1, 'KLADDE', CURRENT_TIMESTAMP, 'testbruger', 0, 'TST01237', 'CLC', 'Ratio', false, 'TSTR');


insert into npubegreb_draft (id, status, virkning_fra, brugernavn, optlock, npu_kode, speciale,
                             vaerdiskala, kontekstbestemt, releasecenter_kort_navn)
values (-29, 'KLADDE', CURRENT_TIMESTAMP, 'testbruger', 0, 'NPU01039', 'CLC', 'Ordinal', true, 'TSTR');



insert into gruppeelement (id, npubegreb_header_npu_kode, npubegreb_npu_kode, pos, brugernavn, optlock)
values (1, 'TST01234', 'TST007', 1,'unittest',0);

insert into gruppeelement (id, npubegreb_header_npu_kode, npubegreb_npu_kode, pos, brugernavn, optlock)
values (2, 'TST01234', 'TST88888', 2,'unittest',0);

insert into gruppeelement (id, npubegreb_header_npu_kode, npubegreb_npu_kode, pos, brugernavn, optlock)
values (3, 'TST01234', 'TST711', 3,'unittest',0);



insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'COMPONENT', 'NPU01036', 'MSHD010949','unittest',0);

insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'SYSTEM', 'NPU01036', 'QU60001','unittest',0);

insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (1, 'SYSTEM', 'NPU01036', 'MSHD007074','unittest',0);

insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'PROPERTY', 'NPU01036', 'QU50106','unittest',0);

insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (1, 'PROPERTY', 'NPU01036', 'QU70500','unittest',0);

insert into syntaxelement (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'UNIT', 'NPU01036', 'QU100009','unittest',0);


insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'COMPONENT','NPU01039', 'MSHD010949','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'SYSTEM','NPU01039', 'QU60001','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (1, 'SYSTEM', 'NPU01039', 'MSHD007074','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (2, 'SYSTEM','NPU01039', 'QU100009','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'PROPERTY', 'NPU01039', 'QU50106','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (1, 'PROPERTY', 'NPU01039', 'QU70500','unittest',0);

insert into syntaxelement_draft (pos, syntaxtype, npubegreb_npu_kode, elementbegreb_element_kode, brugernavn, optlock)
values (0, 'UNIT', 'NPU01039', 'QU100009','unittest',0);


insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (7, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'Foster', 'DK', 'TSTR', '0', 'DA');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (9, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'Koriogonadotropin [HCG] (MOM);P', 'DK', 'TSTR', '711', 'DA');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (13, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'alpha-1-Føtoprotein (MOM);Amv', 'DK', 'TSTR', '-45', 'DA');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (17, 'AKTIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'Klaviatur', 'DK', 'TSTR', '-453', 'EN');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (19, 'KLAR_TIL_FRIGIV', CURRENT_TIMESTAMP, 'testbruger', 0, 'Mussemåtte', 'DK', 'TSTR', '-453', 'EN');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (23, 'INAKTIV', CURRENT_TIMESTAMP, 'AndersAnd', 0, 'Fingernem', 'DK', 'DK', '-453', 'EN');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (29, 'KLADDE', CURRENT_TIMESTAMP, 'testbruger', 0, 'Hovedrig', 'DK', 'DK', '-453', 'EN');

insert into brugsnavn (id, status, virkning_fra, brugernavn, optlock,
                       term, organisation_kort_navn, releasecenter_kort_navn, type, sprog)
values (31, 'KLADDE', CURRENT_TIMESTAMP, 'testbruger', 0, 'Kameluld', 'INT', 'INT', '-453', 'EN');

insert into brugsnavn_npubegreb (npubegreb_id, brugsnavn_id)
values (7, 7);
insert into brugsnavn_npubegreb (npubegreb_id, brugsnavn_id)
values (7, 9);
insert into brugsnavn_npubegreb (npubegreb_id, brugsnavn_id)
values (23, 13);
insert into brugsnavn_npubegreb (npubegreb_id, brugsnavn_id)
values (9, 13);
insert into brugsnavn_npubegreb (npubegreb_id, brugsnavn_id)
values (23, 7);

INSERT INTO brugsnavn_note
    (id, optlock, tekst, bruger, brugsnavn_id)
VALUES (7, 0,
        'Der var engang en sød, lille pige, som alle mennesker holdt meget af, men ingen elskede hende som hendes bedstemor, der slet ikke vidste, hvor godt hun skulle gøre det for hende.',
        'testbruger', 7);

INSERT INTO brugsnavn_note
(id, optlock, tekst, bruger, brugsnavn_id)
VALUES (9, 0,
        ' En gang gav hun hende en lille rød fløjlshue, der klædte hende så godt, at hun altid gik med den, og derfor blev hun kaldt Rødhætte',
        'testbruger', 7);

INSERT INTO brugsnavn_note
(id, optlock, tekst, bruger, brugsnavn_id)
VALUES (13, 0,
        '  En dag sagde hendes mor til hende: "Se her, lille Rødhætte, her har du et stykke kage og en flaske vin, kan du bringe det hen til bedstemor. Hun er syg og svag, så det vil nok styrke hende. Du må helst gå med det samme, før det bliver alt for varmt, men gå nu pænt den lige vej og pas på, du ikke falder og slår flasken itu. Og husk så at sige goddag straks, når nu kommer ind i stuen, og stå ikke først og se dig om."',
        'testbruger', 7);

INSERT INTO brugsnavn_note
(id, optlock, tekst, bruger, brugsnavn_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 13);

insert into soegeterm (id, status, virkning_fra, created_at, updated_at, brugernavn, optlock,
                                 terminologi, sprog, releasecenter_kort_navn,
                                 soegeterm_note_id)
values (4, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'alfa', 'DA', 'TSTR',
         null),
       (7, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'blod', 'DA', 'DK',
        null),
       (9, 'AKTIV', '2021-10-29', '2021-10-29 10:24:24.477101', NULL, 'import', 1,
        'hud', 'DA', 'INT',
        null),
       (13, 'AKTIV', '2021-09-29', '2021-09-29 10:24:24.477101', NULL, 'import', 1,
        'fødder', 'DA', 'INT',
        null);

insert into soegeterm (id, status, virkning_fra, brugernavn, optlock,
                       terminologi, sprog, releasecenter_kort_navn)
values (17, 'AKTIV', '2021-09-29', 'import', 0,
        'kalorielet', 'DA', 'INT');

values (19, 'AKTIV', '2021-09-29', 'import', 0,
        'magnet', 'EN', 'INT');

insert into soegeterm_npubegreb (npubegreb_id, soegeterm_id)
values (7, 7);
insert into soegeterm_npubegreb (npubegreb_id, soegeterm_id)
values (7, 9);
insert into soegeterm_npubegreb (npubegreb_id, soegeterm_id)
values (23, 17);
insert into soegeterm_npubegreb (npubegreb_id, soegeterm_id)
values (9, 17);
insert into soegeterm_npubegreb (npubegreb_id , soegeterm_id) values (23 , 4);
insert into soegeterm_elementbegreb (elementbegreb_id , soegeterm_id) values (7 , 4);
insert into soegeterm_elementbegreb (elementbegreb_id , soegeterm_id) values (7 , 9);
insert into soegeterm_elementbegreb (elementbegreb_id , soegeterm_id) values (13 , 7);
insert into soegeterm_elementbegreb (elementbegreb_id , soegeterm_id) values (17 , 17);

INSERT INTO soegeterm_note
(id, optlock, tekst, bruger, soegeterm_id)
VALUES (7, 0,
        'Der var engang en sød, lille pige, som alle mennesker holdt meget af, men ingen elskede hende som hendes bedstemor, der slet ikke vidste, hvor godt hun skulle gøre det for hende.',
        'testbruger', 7);

INSERT INTO soegeterm_note
(id, optlock, tekst, bruger, soegeterm_id)
VALUES (9, 0,
        ' En gang gav hun hende en lille rød fløjlshue, der klædte hende så godt, at hun altid gik med den, og derfor blev hun kaldt Rødhætte',
        'testbruger', 7);

INSERT INTO soegeterm_note
(id, optlock, tekst, bruger, soegeterm_id)
VALUES (13, 0,
        '  En dag sagde hendes mor til hende: "Se her, lille Rødhætte, her har du et stykke kage og en flaske vin, kan du bringe det hen til bedstemor. Hun er syg og svag, så det vil nok styrke hende. Du må helst gå med det samme, før det bliver alt for varmt, men gå nu pænt den lige vej og pas på, du ikke falder og slår flasken itu. Og husk så at sige goddag straks, når nu kommer ind i stuen, og stå ikke først og se dig om."',
        'testbruger', 7);

INSERT INTO soegeterm_note
(id, optlock, tekst, bruger, soegeterm_id)
VALUES (17, 0,
        'xyz"',
        'testbruger', 13);



