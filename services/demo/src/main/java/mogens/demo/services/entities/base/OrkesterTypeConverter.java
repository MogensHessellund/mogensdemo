package mogens.demo.services.entities.base;

import mogens.demo.services.entities.enums.OrkesterType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrkesterTypeConverter implements AttributeConverter<OrkesterType, String> {

    @Override
    public String convertToDatabaseColumn(OrkesterType orkesterType) {
        if (orkesterType == null) {
            return null;
        }
        return orkesterType.getNavn();
    }

    @Override
    public OrkesterType convertToEntityAttribute(String navn) {
        if (navn == null) {
            return null;
        }

        return Stream.of(OrkesterType.values())
                .filter(c -> c.getNavn().equals(navn))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
