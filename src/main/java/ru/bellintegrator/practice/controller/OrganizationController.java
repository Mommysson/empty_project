package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.service.OrganizationService;
import java.util.List;

@RestController
@RequestMapping(value = "api/organization")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping(value ="/list")

    public List<OrganizationDto> getByParams (@RequestParam("name") String name, @RequestParam("inn") int inn,
                                              @RequestParam("is_Active") boolean is_Active) {
        return service.getByParams(name, inn, is_Active);

    }
    @GetMapping(value ="/{id}")
    public OrganizationDto getById (@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping(value ="/update")
    @ResponseBody
    //TODO На выходе мы должны получить стоку вида {“result”:”success”} У тебя совсем не так.
    public void update (@RequestBody OrganizationDto orgDto) {
        service.update(orgDto);
    }

    @PostMapping(value ="/save")
    @ResponseBody
    public void save(@RequestBody OrganizationDto orgDto) {
        service.save(orgDto);
    }

    @PostMapping(value ="delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }
}
