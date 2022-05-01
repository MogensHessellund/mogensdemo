package mogens.demo.services;

import mogens.demo.lib.gateway.model.BrugsnavnModel;
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

import static mogens.demo.lib.npu.NpuConst.ELEMENT_IKKE_FUNDET;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BrugsnavnControllerTest {

    BrugsnavnModel.BrugsnavnModelBuilder omRandom;
    BrugsnavnModel.BrugsnavnModelBuilder omTest;

    @BeforeEach
    public void opretElmt() {
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
                .andExpect(status().is4xxClientError());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
