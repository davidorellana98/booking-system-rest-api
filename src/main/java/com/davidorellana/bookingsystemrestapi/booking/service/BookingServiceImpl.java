package com.davidorellana.bookingsystemrestapi.booking.service;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.repository.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepositoryDao bookingRepositoryDao;

    @Autowired
    public BookingServiceImpl(BookingRepositoryDao bookingRepositoryDao) {
        this.bookingRepositoryDao = bookingRepositoryDao;
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepositoryDao.findAllBookings();
    }

    @Override
    public Booking findBookingById(String id) {
        return bookingRepositoryDao.findBookingById(id);
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        return bookingRepositoryDao.createBooking(bookingDto);
    }

    @Override
    public Booking updateBookingById(String id, BookingDto bookingDto) {
        return bookingRepositoryDao.updateBookingById(id, bookingDto);
    }

    @Override
    public Boolean deleteBookingById(String id) {
        return bookingRepositoryDao.deleteBookingById(id);
    }

    @Override
    public void deleteAllBookings() {
        bookingRepositoryDao.deleteAllBookings();
    }

    @Override
    public List<Booking> findBookingsByBookingType(String bookingType) {
        return bookingRepositoryDao.findBookingsByBookingType(bookingType);
    }

    @Override
    public List<Booking> findBookingsByPaymentMethods(String paymentMethods) {
        return bookingRepositoryDao.findBookingsByPaymentMethods(paymentMethods);
    }
}
