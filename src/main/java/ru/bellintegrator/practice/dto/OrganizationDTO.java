package ru.bellintegrator.practice.dto;

public class OrganizationDTO {

    public String uuid;
    public String name;
    public String full_Name;
    public Long inn;
    public Long kpp;
    public String address;
    public Long phone;
    public boolean is_Active;


    @Override
    public String toString() {
        return "{uuid:" + uuid + ";name:" + name + ";full_Name" + full_Name + ";inn" + inn + ";kpp" + kpp + ";phone" + phone + ";is_Active" + is_Active + "}";
    }
}
