package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dao.OrganizationDao;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.model.Organization;
import java.util.ArrayList;
import java.util.List;

/*
Сервис организации
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDao dao;

    public OrganizationServiceImpl (OrganizationDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationDto> getByParams(String name, int inn, boolean is_Active) {

        List<OrganizationDto> dtoList = new ArrayList<>();

        if (name != null) {
            List<Organization> orgList = dao.getByParams(name, inn, is_Active);

            for (Organization organization : orgList) {
                dtoList.add(convertToDtoByParams(organization));
            }
        }
        return dtoList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationDto getById(String uuid) {
        OrganizationDto orgDto = new OrganizationDto();
        if (uuid != null) {
            orgDto = convertToDtoById(dao.getById(uuid));
        }
        return orgDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OrganizationDto orgDto) {
        if (orgDto != null && orgDto.getFull_Name() != null && orgDto.getName() != null && orgDto.getInn() != 0
                && orgDto.getKpp() != 0 && orgDto.getAddress() != null) {
            dao.save(orgDto);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OrganizationDto orgDto) {
        if (orgDto != null && orgDto.getUuid() != null && orgDto.getName() != null) {
            dao.update(orgDto);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        if (id!= null) {
            dao.delete(id);
        }
    }

    public OrganizationDto convertToDtoByParams(Organization organization) {

        OrganizationDto orgDto = new OrganizationDto();

        orgDto.setUuid(organization.getUuid());
        orgDto.setName(organization.getName());
        orgDto.set_Active(organization.is_Active());

        return orgDto;
    }

    public OrganizationDto convertToDtoById(Organization organization) {

        OrganizationDto orgDto = new OrganizationDto();

        orgDto.setUuid(organization.getUuid());
        orgDto.setName(organization.getName());
        orgDto.set_Active(organization.is_Active());
        orgDto.setFull_Name(organization.getFull_Name());
        orgDto.setInn(organization.getInn());
        orgDto.setKpp(organization.getKpp());
        orgDto.setAddress(organization.getAddress());
        orgDto.setPhone(organization.getPhone());

        return orgDto;
    }
}
