

delete from brugsnavn where id in (7,9,13);
--
truncate table syntaxgruppe_unit_draft cascade;
truncate table syntaxgruppe_property_draft cascade;
truncate table syntaxgruppe_system_draft cascade;
truncate table syntaxgruppe_component_draft cascade;
truncate table syntaxgruppe_unit cascade;
truncate table syntaxgruppe_property cascade;
truncate table syntaxgruppe_system cascade;
truncate table syntaxgruppe_component cascade;
---
truncate table demo_gruppe cascade ;
---
delete from demobegreb_draft where id in (-1,-29);
---
delete from terminologirelation where id in (17);
---
delete from demobegreb where id in (1,7,9,13,17,19,23,27);
---
delete from organisation_draft where id in (-1,-2,-3,-4,-5,-6,-13,-14,-15);
---
truncate table terminologirelation_note cascade ;
---
delete from terminologirelation where id in (4,7,9,13);
---
delete from elementterm_note where id in (1,5,7,9,13,17);
---
delete from elementterm where id in (1,5,7,9,13,17);
---
delete from elementbegreb_note where id in (7,9,13,17);
---
delete from elementbegreb where id in (1,7,9,13,17,19,23,29,31,37);
---

truncate table organisation_note cascade;

delete from organisation where id < 28;
