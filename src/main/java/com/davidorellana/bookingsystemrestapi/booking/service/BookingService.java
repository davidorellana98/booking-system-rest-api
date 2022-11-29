package com.davidorellana.bookingsystemrestapi.booking.service;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;

import java.util.HashMap;

public interface BookingService {

    HashMap<Long, Booking> getAllBookings();
    Booking findBookingById(Long idBooking);
    Booking createBooking(BookingDto bookingDto);
    Booking updateBookingById(Long idBooking, BookingDto bookingDto);
    Boolean deleteBookingById(Long idBooking);
}
