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
    @Column(name = "fullName", length = 255, nullable = false)
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

    @Column(name = "isActive", length = 50)
    private boolean isActive;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private Set<Office> offices;



    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }


}