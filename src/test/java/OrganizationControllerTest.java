import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.controller.OrganizationController;
import ru.bellintegrator.practice.dto.OrganizationDTO;
import ru.bellintegrator.practice.dto.ResultMessage;
import ru.bellintegrator.practice.service.OrganizationService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
public class OrganizationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrganizationService service;

    private ObjectWriter jsonConverter = new ObjectMapper().writer().withDefaultPrettyPrinter();


    @Test
    public void getOrganizationDTOListByName() throws Exception {

        OrganizationDTO request = new OrganizationDTO();
        request.name = "ООО Ромашка";
        request.inn = 1234567;
        request.is_Active = true;
        String jsonRequest = jsonConverter.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/list", request)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    @Test
    public void getOrganizationDTOById() throws Exception {
        OrganizationDTO request = new OrganizationDTO();
        request.uuid = "1";

        OrganizationDTO response = request;

        given(service.getById(request.getUuid())).willReturn(response);

        mockMvc.perform(get("/{uuid}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void updateOrganization() throws Exception {

        OrganizationDTO request = new OrganizationDTO();
        request.uuid = "1";
        request.name = "ООО Ромашка";
        request.full_Name = "Ромашка";
        request.inn = 1234567;
        request.kpp = 2345;
        request.address = "Moscow";
        request.phone = 8888888;
        request.is_Active = true;

       service.update(request);
       OrganizationDTO response = service.getById(request.getUuid());

        mockMvc.perform(post("/update", request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
