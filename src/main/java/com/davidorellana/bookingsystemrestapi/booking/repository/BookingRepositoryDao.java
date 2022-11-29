package com.davidorellana.bookingsystemrestapi.booking.repository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import org.hibernate.annotations.SQLInsert;

import java.util.HashMap;

public interface BookingRepositoryDao {

    HashMap<Long, Booking> getAllBookings();
    Booking findBookingById(Long idBooking);
    Booking createBooking(BookingDto bookingDto);
    Booking updateBookingById(Long idBooking, BookingDto bookingDto);
    Boolean deleteBookingById(Long idBooking);
}
