package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.OrganizationDTO;
import ru.bellintegrator.practice.dto.ResultMessage;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.service.OrganizationServiceImpl;
import java.util.List;


@RestController
@RequestMapping(value = "api/organization")
public class OrganizationController {

private final OrganizationService organizationService;

    public OrganizationController(OrganizationServiceImpl organizationServiceImpl) {
        this.organizationService = organizationServiceImpl;
    }

    @PostMapping(value ="/list")
    public List<OrganizationDTO> getByName (@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.getByName(organizationDTO);

    }
    @GetMapping(value ="/{id}")
    public OrganizationDTO getById (@PathVariable String uuid) {
        return organizationService.getById(uuid);

    }
    @PostMapping(value ="/update")
    @ResponseBody
    public OrganizationDTO update (@RequestBody OrganizationDTO organizationDTO) {

        organizationService.update(organizationDTO);

return organizationService.getById(organizationDTO.getUuid());
    }

}
