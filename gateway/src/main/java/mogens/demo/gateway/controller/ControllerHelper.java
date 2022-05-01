package mogens.demo.gateway.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
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


}