package com.davidorellana.bookingsystemrestapi.booking.model.dto;

import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;

import java.time.LocalDate;

public class BookingDto {

    private String bookingType;
    private Boolean reserved;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private PaymentMethods paymentMethods;

    public BookingDto() { }

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
        return "BookingDto{" +
                "bookingType='" + bookingType + '\'' +
                ", isReserved=" + reserved +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", paymentsMethods=" + paymentMethods +
                '}';
    }
}
