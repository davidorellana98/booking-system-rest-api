package com.davidorellana.bookingsystemrestapi.booking.model.data;

import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;
import java.time.*;
import java.util.Objects;

@Document(collection = "booking_collection")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String bookingType;
    private Boolean reserved;
    @JsonFormat(timezone = "America/Guayaquil")
    private LocalDate bookingStartDate;
    @JsonFormat(timezone = "America/Guayaquil")
    private LocalDate bookingEndDate;
    @Field(targetType = FieldType.STRING)
    private PaymentMethods paymentMethods;
    private Integer numberDaysBooking;
    private Double priceBookingDay;
    private Double totalPriceBooking;

    public Booking() { }

    public Booking(BookingDto bookingDto) {
        this.updateBookingCollection(bookingDto);
    }

    public Booking(String bookingType, Boolean reserved, LocalDate bookingStartDate, LocalDate bookingEndDate, PaymentMethods paymentMethods, Integer numberDaysBooking, Double priceBookingDay, Double totalPriceBooking) {
        this.bookingType = bookingType;
        this.reserved = reserved;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
        this.paymentMethods = paymentMethods;
        this.numberDaysBooking = numberDaysBooking;
        this.priceBookingDay = priceBookingDay;
        this.totalPriceBooking = totalPriceBooking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Integer getNumberDaysBooking() {
        return numberDaysBooking;
    }

    public void setNumberDaysBooking(Integer numberDaysBooking) {
        this.numberDaysBooking = numberDaysBooking;
    }

    public Double getPriceBookingDay() {
        return priceBookingDay;
    }

    public void setPriceBookingDay(Double priceBookingDay) {
        this.priceBookingDay = priceBookingDay;
    }

    public Double getTotalPriceBooking() {
        return totalPriceBooking;
    }

    public void setTotalPriceBooking(Double totalPriceBooking) {
        this.totalPriceBooking = totalPriceBooking;
    }

    public void updateBookingCollection(BookingDto bookingDto) {
        this.bookingType = bookingDto.getBookingType();
        this.reserved = bookingDto.getReserved();
        this.bookingStartDate = bookingDto.getBookingStartDate();
        this.bookingEndDate = bookingDto.getBookingEndDate();
        this.paymentMethods = bookingDto.getPaymentMethods();
        this.numberDaysBooking = bookingEndDate.getDayOfYear() - bookingStartDate.getDayOfYear();
        this.priceBookingDay = bookingDto.getPriceBookingDay();
        this.totalPriceBooking = priceBookingDay * numberDaysBooking;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", reserved=" + reserved +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", paymentMethods=" + paymentMethods +
                ", numberDaysBooking=" + numberDaysBooking +
                ", priceBookingDay=" + priceBookingDay +
                ", totalPriceBooking=" + totalPriceBooking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(bookingType, booking.bookingType) && Objects.equals(reserved, booking.reserved) && Objects.equals(bookingStartDate, booking.bookingStartDate) && Objects.equals(bookingEndDate, booking.bookingEndDate) && paymentMethods == booking.paymentMethods && Objects.equals(numberDaysBooking, booking.numberDaysBooking) && Objects.equals(priceBookingDay, booking.priceBookingDay) && Objects.equals(totalPriceBooking, booking.totalPriceBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingType, reserved, bookingStartDate, bookingEndDate, paymentMethods, numberDaysBooking, priceBookingDay, totalPriceBooking);
    }
}