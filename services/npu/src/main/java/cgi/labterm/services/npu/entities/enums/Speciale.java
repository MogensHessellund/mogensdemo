package cgi.labterm.services.npu.entities.enums;

public enum Speciale {
    CLC("Clinical Chemistry"),
    RAF("Reproduction and Fertility"),
    MBG("Molecular Biology and Genetics."),
    MIC("Microbiology"),
    IMM("Immunology"),
    FUN("Function tests"),
    ALL("Allergology"),
    TAH("Thrombosis and Hemostasis"),
    TOX("Toxicology"),
    CLP("Dansk Selskab for Klinisk farmakologi");

    private final String navn;

    Speciale(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
}
