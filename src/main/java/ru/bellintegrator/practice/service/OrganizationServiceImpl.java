package ru.bellintegrator.practice.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dao.OrganizationDao;
import ru.bellintegrator.practice.dao.OrganizationDaoImpl;
import ru.bellintegrator.practice.dto.OrganizationDTO;
import ru.bellintegrator.practice.model.Organization;
import java.util.ArrayList;
import java.util.List;

/*
Сервис организации
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{

    OrganizationDao organizationDao;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<OrganizationDTO> getByName(OrganizationDTO organizationDTO) {
        List<OrganizationDTO> dtoList = new ArrayList<>();
        if (organizationDTO != null && organizationDTO.name != null) {
            List<Organization> orgList = organizationDao.getByName(organizationDTO.name, organizationDTO.inn, organizationDTO.is_Active);

            for (Organization organization : orgList) {
                OrganizationDTO newDTO = new OrganizationDTO();
                newDTO.uuid = organization.getUuid();
                newDTO.name = organization.getName();
                newDTO.is_Active = organization.isActive();
                dtoList.add(newDTO);
            }
        }
        return dtoList;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationDTO getById(String uuid) {
        OrganizationDTO orgDTO = new OrganizationDTO();
        if (uuid != null) {
            Organization organization = organizationDao.getById(uuid);
            orgDTO.uuid = organization.getUuid();
            orgDTO.name = organization.getName();
            orgDTO.full_Name = organization.getFullName();
            orgDTO.inn = organization.getInn();
            orgDTO.kpp = organization.getKpp();
            orgDTO.address = organization.getAddress();
            orgDTO.phone = organization.getPhone();
            orgDTO.is_Active = organization.isActive();

        }
        return orgDTO;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OrganizationDTO organizationDTO) {

        Organization organization = new Organization();
        if (organizationDTO != null && organizationDTO.uuid != null && organizationDTO.name != null
                && organizationDTO.full_Name != null && organizationDTO.inn != 0 && organizationDTO.kpp != 0
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

            organizationDao.update(organization);

    }

}
