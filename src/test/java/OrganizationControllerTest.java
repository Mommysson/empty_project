import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.controller.OrganizationController;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.service.OrganizationService;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
@ContextConfiguration(classes={Application.class})
public class OrganizationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrganizationService service;

    private ObjectWriter jsonConverter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void getOrganizationDTOListByParams() throws Exception {

        OrganizationDto request = new OrganizationDto();
        request.setName("ООО Ромашка");
        request.setInn(1234567);
        request.set_Active(true);

        String jsonRequest = jsonConverter.writeValueAsString(request);

        OrganizationDto response = new OrganizationDto();
        request.setUuid("1");
        request.setName("ООО Ромашка");
        request.setFull_Name("Ромашка");
        request.setInn(1234567);
        request.setKpp(2345);
        request.setAddress("Moscow");
        request.setPhone(8888888);
        request.set_Active(true);

        service.save(response);


        this.mockMvc.perform(
                MockMvcRequestBuilders.post("api/organization/list")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonConverter.writeValueAsString(response)));
    }

    @Test
    public void getOrganizationDtoById() throws Exception {
        OrganizationDto request = new OrganizationDto();
        request.setUuid("1");

        OrganizationDto response = new OrganizationDto();
        request.setUuid("1");
        request.setName("ООО Ромашка");
        request.setFull_Name("Ромашка");
        request.setInn(1234567);
        request.setKpp(2345);
        request.setAddress("Moscow");
        request.setPhone(8888888);
        request.set_Active(true);

        service.save(response);
        String jsonRequest = jsonConverter.writeValueAsString(request);

        given(service.getById(request.getUuid())).willReturn(response);

        this.mockMvc.perform(get("api/organization/uuid")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonConverter.writeValueAsString(response)));
    }

    @Test
    public void updateOrganization() throws Exception {

        OrganizationDto request = new OrganizationDto();
        request.setUuid("1");
        request.setName("ООО Ромашка");
        request.setFull_Name("Ромашка");
        request.setInn(1234567);
        request.setKpp(2345);
        request.setAddress("Moscow");
        request.setPhone(8888888);
        request.set_Active(true);

        String jsonRequest = jsonConverter.writeValueAsString(request);

        OrganizationDto response = service.getById("1");

        this.mockMvc.perform(post("api/organization/update")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonConverter.writeValueAsString(response)));
    }

    @Test
    public void saveOrganization() throws Exception {

        OrganizationDto request = new OrganizationDto();

        request.setName("ООО Ромашка");
        request.setFull_Name("Ромашка");
        request.setInn(1234567);
        request.setKpp(2345);
        request.setAddress("Moscow");

        List<OrganizationDto> response = service.getByParams("1", 1234567,true);

        String jsonRequest = jsonConverter.writeValueAsString(request);

        this.mockMvc.perform(post("api/organization/save")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonConverter.writeValueAsString(response.get(0))));
    }

    @Test
    public void deleteOrganization() throws Exception {

        OrganizationDto request = new OrganizationDto();
        request.setUuid("1");
        request.setName("ООО Ромашка");
        request.setFull_Name("Ромашка");
        request.setInn(1234567);
        request.setKpp(2345);
        request.setAddress("Moscow");
        request.setPhone(8888888);
        request.set_Active(true);

        service.save(request);

        this.mockMvc.perform(post("api/organization/delete/{1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
