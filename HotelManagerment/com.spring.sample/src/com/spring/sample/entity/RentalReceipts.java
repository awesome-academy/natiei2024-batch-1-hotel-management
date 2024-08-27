package com.spring.sample.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "RENTAL_RECEIPTS") // PHIEU THUE PHONG
public class RentalReceipts extends BaseEntity implements Serializable {

    @Id
    @Column(name = "RentalReceiptID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // MA PHIEU THUE

    @Column(name = "CheckInDateTime")
    private LocalDateTime checkInDateTime; // NGAY THUE PHONG

    @Column(name = "CheckOutDateTime")
    private LocalDateTime checkOutDateTime; // NGAY TRA PHONG

    @Column(name = "RoomPriceForOneDay")
    private Float roomPriceForOneDay; // DON GIA MOT NGAY

    @Column(name = "PaymentStatus")
    private Integer paymentStatus; // TINH TRANG TRA TIEN

    @Column(name = "RentalDays")
    private Integer numOfRentalDays; // SO NGAY THUE

    @Column(name = "Amount")
    private Float amountOfPayment; // SO TIEN 1 PHONG

    @ManyToOne
    @JoinColumn(name = "InvoiceID")
    private Invoices corespondingInvoice; // KHOA NGOAI

    @ManyToOne
    @JoinColumn(name = "RoomID")
    private Room corespondingRoom;

    @ManyToOne
    @JoinColumn(name = "RGuest_ID")
    private RegisteredGuests corespondingRegisteredGuest;

    public RentalReceipts(LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, Float roomPriceForOneDay,
            Integer paymentStatus, Integer numOfRentalDays, Float amountOfPayment, Invoices corespondingInvoice) {
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.roomPriceForOneDay = roomPriceForOneDay;
        this.paymentStatus = paymentStatus;
        this.numOfRentalDays = numOfRentalDays;
        this.amountOfPayment = amountOfPayment;
        this.corespondingInvoice = corespondingInvoice;
    }

}
