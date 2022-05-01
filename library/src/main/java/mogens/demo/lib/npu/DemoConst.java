package mogens.demo.lib.demo;

/*

1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20
1–20	2	3	5	7	11	13	17	19	23	29	31	37	41	43	47	53	59	61	67	71
21–40	73	79	83	89	97	101	103	107	109	113	127	131	137	139	149	151	157	163	167	173
41–60	179	181	191	193	197	199	211	223	227	229	233	239	241	251	257	263	269	271	277	281
61–80	283	293	307	311	313	317	331	337	347	349	353	359	367	373	379	383	389	397	401	409
81–100	419	421	431	433	439	443	449	457	461	463	467	479	487	491	499	503	509	521	523	541
101–120	547	557	563	569	571	577	587	593	599	601	607	613	617	619	631	641	643	647	653	659
121–140	661	673	677	683	691	701	709	719	727	733	739	743	751	757	761	769	773	787	797	809
141–160	811	821	823	827	829	839	853	857	859	863	877	881	883	887	907	911	919	929	937	941
 */
public class DemoConst {
    public static final int MAALBEGREB_IKKE_MAPPES = 0;
    public static final int MAALBEGREB_EN_TIL_EN = 1;
    public static final int MAALBEGREB_BREDERE = 2;
    public static final int MAALBEGREB_SMALLERE = 3;
    public static final int MAALBEGREB_DELVIST_OVERLAPPENDE = 4;

    public static final int STATUS_IKKE_ANGIVET = 101;
    public static final int STATUS_IKKE_AENDRET = 103;
    public static final int STATUS_UGYLDIGT_SKIFTE = 107;
    public static final int STATUS_UKENDT = 109;

    public static final int ELEMENT_OPTIMISTIC = 123;
    public static final int ELEMENT_IKKE_FUNDET = 127;
    public static final int ELEMENT_IKKE_AKTUELT = 131;
    public static final int ELEMENT_IKKE_ANGIVET = 132;

    public static final int FELT_IKKE_SAT = 137;
    public static final int FELT_FOR_LANGT = 139;
    public static final int ELEMENT_EKSISTERER = 149;
    public static final int ELEMENT_ASSOCIEREDE_MANGLER = 151;
    public static final int BRUGERNAVN_IKKE_ANGIVET = 157;
    public static final int FELT_UGYLDIG_VAERDI = 163;
    public static final int RELEASECENTER_MISMATCH = 167;
    
    public static final int IMPORT_UKENDT_KOLONNE = 200;
    public static final int IMPORT_MANGLENDE_KOLONNE = 201;
    public static final int IMPORT_TOM_FIL = 202;
    public static final int IMPORT_FORKERT_FILTYPE = 203;
    public static final int IMPORT_FORKERT_OBJEKTTYPE = 204;
    public static final int IMPORT_OVERSKRIFTER_MANGLER = 205;
    public static final int IMPORT_INVALIDE_OVERSKIFTER = 206;
    public static final int IMPORT_UKENDT_FEJL_ORGANISATIONER = 207;
    public static final int IMPORT_LAESNING_CSV_FIL = 208;
    public static final int IMPORT_LAESNING_CSV_OVERSKRIFTER = 209;
    public static final int IMPORT_MANGLENDE_KRAEVET_KOLONNE = 210;
    public static final int IMPORT_TEKNISK_ID_FINDES_IKKE = 211;
    public static final int IMPORT_STATUS_IKKE_KLADDE_PAPIRKURV = 212;
    public static final int IMPORT_KRAEVET_DATA_MANGLER = 213;
    public static final int IMPORT_INVALID_DATA = 214;
    public static final int IMPORT_UKENDT_FEJL_ELEMENTBEGREBER = 215;
    public static final int IMPORT_UKENDT_FEJL_SOEGETERMER = 216;
    public static final int IMPORT_UKENDT_FEJL_TERMINOLOGIRELATIONER = 217;
    public static final int IMPORT_MAA_IKKE_HAVE_BAADE_DEMO_OG_ELEMENTBEGREB_KODER = 218;
    public static final int IMPORT_REFERERE_TIL_IKKE_AKTIV_KODE = 219;
    public static final int IMPORT_RELEASECENTER_EJER_IKKE_EKSISTERENDE_ELEMENT = 220;
    public static final int IMPORT_FORKERT_RELEASECENTER = 221;
    
    public static final int ORG_KLADDE_ELEMENT_IKKE_FUNDET = 300;
    public static final int ORG_ELEMENT_IKKE_FUNDET = 301;
    
    public static final int UKENDT_FEJL = 9000;
    

    
}
