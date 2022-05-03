package mogens.demo.services.entities.enums;

public enum OrkesterType {
    SYMF("Symfoniorkester"),
    BRASS("Brass-band"),
    HARM("Harmoniorkester");

    private final String navn;

    OrkesterType(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
}
