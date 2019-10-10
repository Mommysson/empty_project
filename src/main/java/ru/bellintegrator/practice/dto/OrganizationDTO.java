package ru.bellintegrator.practice.dto;

import lombok.Data;

@Data
public class OrganizationDTO {

    public String uuid;
    public String name;
    public String full_Name;
    public int inn;
    public int kpp;
    public String address;
    public int phone;
    public boolean is_Active;


    @Override
    public String toString() {
        return "{uuid:" + uuid + ";name:" + name + ";full_Name" + full_Name + ";inn" + inn + ";kpp" + kpp + ";phone" + phone + ";is_Active" + is_Active + "}";
    }
}
