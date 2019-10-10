package ru.bellintegrator.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


/**
 * Компания
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UUID")
    private String uuid;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Полное наименование
     */
    @Column(name = "full_Name",nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 50, nullable = false)
    private int inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 50, nullable = false)
    private int kpp;

    /**
     * Адрес
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Телефон
     */

    @Column(name = "phone", length = 50)
    private int phone;

    /**
     * Флаг активности
     */

    @Column(name = "is_Active", length = 50)
    private boolean isActive;


    public Organization(String uuid, Integer version, String name, String fullName, int inn, int kpp, String address, int phone, boolean isActive) {
        this.uuid = uuid;
        this.version = version;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;

    }



}