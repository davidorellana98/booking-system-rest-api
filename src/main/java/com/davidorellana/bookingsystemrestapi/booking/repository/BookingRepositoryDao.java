package com.davidorellana.bookingsystemrestapi.booking.repository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;

import java.util.List;

public interface BookingRepositoryDao {

    List<Booking> findAllBookings();
    Booking findBookingById(String id);
    Booking createBooking(BookingDto bookingDto);
    Booking updateBookingById(String id, BookingDto bookingDto);
    Boolean deleteBookingById(String id);
    void deleteAllBookings();
    List<Booking> findBookingsByBookingType(String bookingType);
    List<Booking> findBookingsByPaymentMethods(String paymentMethods);
}
