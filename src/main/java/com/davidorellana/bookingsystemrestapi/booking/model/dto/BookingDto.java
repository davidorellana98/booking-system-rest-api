package com.davidorellana.bookingsystemrestapi.booking.model.dto;

import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookingType;
    private Boolean reserved;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private PaymentMethods paymentMethods;
    private Double priceBookingDay;

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

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Double getPriceBookingDay() {
        return priceBookingDay;
    }

    public void setPriceBookingDay(Double priceBookingDay) {
        this.priceBookingDay = priceBookingDay;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "bookingType='" + bookingType + '\'' +
                ", reserved=" + reserved +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", paymentMethods=" + paymentMethods +
                ", priceBookingDay=" + priceBookingDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDto that = (BookingDto) o;
        return Objects.equals(bookingType, that.bookingType) && Objects.equals(reserved, that.reserved) && Objects.equals(bookingStartDate, that.bookingStartDate) && Objects.equals(bookingEndDate, that.bookingEndDate) && paymentMethods == that.paymentMethods && Objects.equals(priceBookingDay, that.priceBookingDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingType, reserved, bookingStartDate, bookingEndDate, paymentMethods, priceBookingDay);
    }
}
