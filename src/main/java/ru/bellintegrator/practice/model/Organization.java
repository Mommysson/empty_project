package ru.bellintegrator.practice.model;

import jdk.internal.jline.internal.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



/**
 * Компания
 */
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование
     */
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    /**
     * Полное наименование
     */
    @Column(name = "full_Name", length = 255, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 50, nullable = false)
    private Long inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 50, nullable = false)
    private Long kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    /**
     * Телефон
     */

    @Column(name = "phone", length = 50)
    private Long phone;

    /**
     * Флаг активности
     */

    @Column(name = "is_Active", length = 50)
    private boolean isActive;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Office> offices;

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getInn() {
        return inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public Long getPhone() {
        return phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }


    public Organization() {

    }

    public Organization(Long id, Integer version, String name, String fullName, Long inn, Long kpp, String address, Long phone, boolean isActive, Set<Office> offices) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.offices = offices;
    }

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }


}