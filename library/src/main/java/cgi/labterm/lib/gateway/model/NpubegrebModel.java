package cgi.labterm.lib.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NpubegrebModel {
    private long id;
    private int version;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String virkningFra;
    private String bruger;
    private int fejlkode;
    private String fejltekst;
    private String npuKode;
    private String kortNavn;
    private String langtNavn;
    private String speciale;
    private String vaerdiskala;
    private boolean kontekstbestemt;
    private boolean gruppeheader;
    private String releasecenter;
    private String erstatter;
    private String erstattetAf;
    private String anvendesaf;
    private String internalhandle;
    private String helterm;
    private String kortHelterm;
    private String langHelterm;
    private String activeAt;
    private String notetekst;
    private String versionsnotetekst;
    private SyntaxModel syntax;
    private List<ElementbegrebModel> component;
    private List<ElementbegrebModel> system;
    private List<ElementbegrebModel> property;
    private List<ElementbegrebModel> unit;
}

