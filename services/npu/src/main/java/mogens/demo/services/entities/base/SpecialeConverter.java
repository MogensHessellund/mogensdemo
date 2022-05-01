package mogens.demo.services.entities.base;

import mogens.demo.services.entities.enums.Speciale;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SpecialeConverter implements AttributeConverter<Speciale, String> {

    @Override
    public String convertToDatabaseColumn(Speciale speciale) {
        if (speciale == null) {
            return null;
        }
        return speciale.getNavn();
    }

    @Override
    public Speciale convertToEntityAttribute(String navn) {
        if (navn == null) {
            return null;
        }

        return Stream.of(Speciale.values())
                .filter(c -> c.getNavn().equals(navn))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
