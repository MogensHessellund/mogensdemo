package cgi.labterm.services.npu;

import cgi.labterm.lib.gateway.model.BrugsnavnModel;
import cgi.labterm.lib.gateway.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static cgi.labterm.lib.npu.NpuConst.ELEMENT_IKKE_FUNDET;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BrugsnavnControllerTest {

    BrugsnavnModel.BrugsnavnModelBuilder omRandom;
    BrugsnavnModel.BrugsnavnModelBuilder omTest;
    UserModel userModelEvrything;
    UserModel userDenmark;
    UserModel userEmpty;

    @BeforeEach
    public void opretElmt() {
        userModelEvrything = UserModel.builder()
                .brugernavn("devprofile")
                .navn("Børge Devprofile")
                .releasecenter("INT")
                .releaseCentreCreate(List.of("INT", "DK"))
                .releaseCentreRead(List.of("INT", "DK", "TSTR"))
                .build();

        userDenmark = UserModel.builder()
                .brugernavn("devprofile_denmark")
                .navn("Connie Devprofile")
                .releasecenter("DK")
                .releaseCentreCreate(List.of("DK"))
                .releaseCentreRead(List.of("DK"))
                .build();

        userEmpty = UserModel.builder()
                .brugernavn("devprofile_empty")
                .navn("Allan Devprofile")
                .releasecenter("")
                .releaseCentreCreate(Collections.emptyList())
                .releaseCentreRead(Collections.emptyList())
                .build();

        String begreb = new RandomString().nextString();
        String relationstype = new RandomString().nextString() + "Zorglub";

        omRandom = BrugsnavnModel.builder();

        /*
       (7, 'AKTIV', '2021-11-29', '2021-11-29 10:24:24.477101', NULL, 'import', 1,
        'blod', 'DA', 'INT',
        'QU110347', null, null),
         */


        omTest = BrugsnavnModel.builder().id(7).term("Triple test gruppe;Foster")
                .sprog("DA")
                        .status("AKTIV").releasecenter("TSTR").brugernavn("import");
    }

    /*
        @AfterAll
        public void sletOrg() throws Exception {
            this.mockMvc.perform(MockMvcRequestBuilders
                            .post("/npu/brugsnavn/internal/delete")
                            .content(asJsonString(omRandom.build()))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));
        }
      */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void statusChangeShouldFailUnkownElmt() throws Exception {
        omRandom.id(777);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/npu/brugsnavn/changestatus")
                        .content(asJsonString(omRandom.build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(ELEMENT_IKKE_FUNDET))));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
