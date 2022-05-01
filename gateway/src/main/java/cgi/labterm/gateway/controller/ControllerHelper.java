package cgi.labterm.gateway.controller;

import cgi.labterm.lib.gateway.model.UserModel;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class ControllerHelper {

    private final Environment environment;

    public ControllerHelper(Environment environment) {
        this.environment = environment;
    }

    public boolean isDevProfile() {
        for (String profileName : environment.getActiveProfiles()) {
            if ("dev".equals(profileName)) {
                System.out.println("Dev profile !");
                return true;
            }
        }
        return false;
    }

    public boolean isTestProfile() {
        for (String profileName : environment.getActiveProfiles()) {
            if ("test".equals(profileName)) {
                System.out.println("Test profile !");
                return true;
            }
        }
        return false;
    }

    public UserModel extractUserModel() {
        return extractUserModel("empty");
    }

    public UserModel extractUserModel(String releasecenter) {
            return UserModel.builder()
                    .brugernavn("devprofile")
                    .navn("Børge Devprofile")
                    .releasecenter("empty".equals(releasecenter) ? "INT" : releasecenter)
                    .releaseCentreCreate(List.of("INT", "DK"))
                    .releaseCentreRead(List.of("INT", "DK"))
                    .build();
        }

    HttpEntity<MultiValueMap<String, Object>> gethttpRequestEntity(String brugernavn, String releasecenter, List<Long> elmts, String newStatus) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("newStatus", newStatus);
        map.add("brugernavn", brugernavn);
        map.add("releasecenter", releasecenter);
        if (elmts != null) {
            for (Long id : elmts) {
                if (map.get("orgs") == null || !Objects.requireNonNull(map.get("orgs")).contains(id)) {
                    map.add("orgs", id);
                }
            }
        }

        return new HttpEntity<>(map, headers);
    }

}