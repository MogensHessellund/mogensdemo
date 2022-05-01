package cgi.labterm.lib.gateway.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementbegrebDetailModel extends ElementbegrebModel  {
    private List<SoegetermModel> soegeTermer;
    private List<ElementbegrebModel> revisions;
    private List<TerminologirelationModel> terminologiRelationer;
    private List<TerminologirelationModel> mappings;
	
}
