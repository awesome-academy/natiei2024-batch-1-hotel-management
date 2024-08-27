package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "REGISTERED_GUESTS") // KHÁCH ĐỨNG TÊN PHÒNG
public class RegisteredGuests extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ID", length = 20)
    private String id; // CMND

    @Column(name = "FirstName", length = 20)
    private String firstName; // TEN

    @Column(name = "LastName", length = 20)
    private String lastName; // HO

    @Column(name = "Address", length = 50)
    private String address; // DIA CHI

    @ManyToOne
    @JoinColumn(name = "GuestType_ID")
    private GuestTypes typeOfGuest; // KHOA NGOAI

    @OneToMany(mappedBy = "corespondingRegisteredGuest")
    private Set<RentalReceipts> rentalReceipts;

}
