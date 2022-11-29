package com.davidorellana.bookingsystemrestapi.booking.model.data;

import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Long idBooking;
    @Column(name = "booking_type")
    private String bookingType;
    private Boolean reserved;
    @Column(name = "booking_start_date")
    private LocalDate bookingStartDate;
    @Column(name = "booking_end_date")
    private LocalDate bookingEndDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_methods")
    private PaymentMethods paymentMethods;

    public Booking() { }

    public Booking(BookingDto bookingDto) {
        this.bookingType = bookingDto.getBookingType();
        this.reserved = bookingDto.getReserved();
        this.bookingStartDate = bookingDto.getBookingStartDate();
        this.bookingEndDate = bookingDto.getBookingEndDate();
        this.paymentMethods = PaymentMethods.valueOf(bookingDto.getPaymentMethods());
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public LocalDate getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(LocalDate bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getPaymentMethods() {
        return paymentMethods.name();
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = PaymentMethods.valueOf(paymentMethods);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", bookingType='" + bookingType + '\'' +
                ", isReserved=" + reserved +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", paymentsMethods=" + paymentMethods +
                '}';
    }
}