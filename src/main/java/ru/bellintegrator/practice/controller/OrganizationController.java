package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.OrganizationDTO;
import ru.bellintegrator.practice.dto.ResultMessage;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationServiceImpl;
import java.util.List;


@RestController
@RequestMapping(value = "api/organization")
public class OrganizationController {

private final OrganizationServiceImpl organizationServiceImpl;

    public OrganizationController(OrganizationServiceImpl organizationServiceImpl) {
        this.organizationServiceImpl = organizationServiceImpl;
    }

    @PostMapping(value ="/list")
    public List<OrganizationDTO> getByName (@RequestBody OrganizationDTO organizationDTO) {
        return organizationServiceImpl.getByName(organizationDTO);

    }
    @GetMapping(value ="/{id}")
    public OrganizationDTO getById (@PathVariable String uuid) {
        return organizationServiceImpl.getById(uuid);

    }
    @PostMapping(value ="/update")
    @ResponseBody
    public ResultMessage update (@RequestBody OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        if (organizationDTO != null && organizationDTO.uuid != null && organizationDTO.name != null
                && organizationDTO.full_Name != null && organizationDTO.inn != null && organizationDTO.kpp != null
                && organizationDTO.address != null) {
            organization.setUuid(organizationDTO.uuid);
            organization.setName(organizationDTO.name);
            organization.setFullName(organizationDTO.full_Name);
            organization.setInn(organizationDTO.inn);
            organization.setKpp(organizationDTO.kpp);
            organization.setAddress(organizationDTO.address);
            organization.setPhone(organizationDTO.phone);
            organization.setActive(organizationDTO.is_Active);
        }
        organizationServiceImpl.update(organization);

        //TODO Метод должен возвращать не стоку, а объект, который будет потом сериализован в json вида {“result”:”success”}
return new ResultMessage("success");
    }

}
