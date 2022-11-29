package com.davidorellana.bookingsystemrestapi.booking.service;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.repository.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepositoryDao bookingRepositoryDao;

    @Override
    public HashMap<Long, Booking> getAllBookings() {
        return bookingRepositoryDao.getAllBookings();
    }

    @Override
    public Booking findBookingById(Long idBooking) {
        return bookingRepositoryDao.findBookingById(idBooking);
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        return bookingRepositoryDao.createBooking(bookingDto);
    }

    @Override
    public Booking updateBookingById(Long idBooking, BookingDto bookingDto) {
        return bookingRepositoryDao.updateBookingById(idBooking, bookingDto);
    }

    @Override
    public Boolean deleteBookingById(Long idBooking) {
        return bookingRepositoryDao.deleteBookingById(idBooking);
    }
}
