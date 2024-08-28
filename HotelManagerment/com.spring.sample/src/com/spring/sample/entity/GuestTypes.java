package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "GUEST_TYPES") // LOAI KHACH
public class GuestTypes extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // MA LOAI KHACH

    @Column(name = "TypeName", length = 20)
    private String typeName; // TEN LOAI KHACH

    @Column(name = "SurchargeRate")
    private Float surchargeRate; // HE SO PHU THU

    @OneToMany(mappedBy = "typeOfGuest", cascade = CascadeType.REMOVE)
    private Set<RegisteredGuests> registeredGuests;

    public GuestTypes(String typeName, Float surchargeRate) {
        this.typeName = typeName;
        this.surchargeRate = surchargeRate;
    }

}
