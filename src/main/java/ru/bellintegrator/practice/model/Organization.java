package ru.bellintegrator.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;

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
    private String full_Name;

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
    private boolean is_Active;

    public Organization(String uuid, Integer version, String name, String fullName,
                        int inn, int kpp, String address, int phone, boolean isActive) {
        this.uuid = uuid;
        this.version = version;
        this.name = name;
        this.full_Name = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.is_Active = isActive;
    }
}