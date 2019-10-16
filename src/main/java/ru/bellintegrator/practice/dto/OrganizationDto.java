package ru.bellintegrator.practice.dto;

import lombok.Data;

@Data
public class OrganizationDto {

    private String uuid;
    private String name;
    private String full_Name;
    private int inn;
    private int kpp;
    private String address;
    private int phone;
    private boolean is_Active;

    @Override
    public String toString() {
        return "{uuid:" + uuid + ";name:" + name + ";full_Name" + full_Name + ";inn" + inn + ";kpp" + kpp + ";phone" + phone + ";is_Active" + is_Active + "}";
    }
}
