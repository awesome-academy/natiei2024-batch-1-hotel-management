package com.spring.sample.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
@Table(name = "INVOICES") // HOA DON
public class Invoices extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // MA HOA DON

    @Column(name = "GuestName")
    private String guestName; // TEN KHACH HANG

    @Column(name = "IssueDate")
    private LocalDateTime createdDate; // NGAY LAP HOA DON

    @Column(name = "PaymentDate")
    private LocalDateTime paymentDate; // NGAY THANH TOAN

    @Column(name = "TotalAmount")
    private Float totalAmount; // TRI GIA HOA DON

    @Column(name = "PaymentStatus")
    private Integer paymentStatus; // TINH TRANG THANH TOAN

    @OneToMany(mappedBy = "corespondingInvoice")
    private Set<RentalReceipts> rentalReceipts;

    public Invoices(String guestName, LocalDateTime createdDate, LocalDateTime paymentDate, Float totalAmount,
            Integer paymentStatus) {
        this.guestName = guestName;
        this.createdDate = createdDate;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

}
