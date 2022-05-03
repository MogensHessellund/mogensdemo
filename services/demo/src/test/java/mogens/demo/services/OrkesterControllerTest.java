package mogens.demo.services;
import mogens.demo.lib.gateway.model.OrkesterModel;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrkesterControllerTest {

    OrkesterModel.OrkesterModelBuilder omTest;

    @BeforeEach
    public void opretElmt() {
        omTest = OrkesterModel.builder().id(1);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Simpel test af hent orkester")
    public void statusChangeShouldFailUnkownElmt() throws Exception {
        this.mockMvc.perform(get("/demo/orkester?id=1")).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("Aarhus")));
    }



}
