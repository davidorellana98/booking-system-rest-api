package com.davidorellana.bookingsystemrestapi.booking.repository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepositoryDao {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    @Override
    public HashMap<Long, Booking> getAllBookings() {
        HashMap<Long, Booking> bookingFounded = new HashMap<>();
        bookingCrudRepository.findAll().forEach(booking -> {
            bookingFounded.put(booking.getIdBooking(), booking);
        });
        return bookingFounded;
    }

    @Override
    public Booking findBookingById(Long idBooking) {
        Optional<Booking> bookingFindById = bookingCrudRepository.findById(idBooking);
        if (bookingFindById.isPresent()) {
            return bookingFindById.get();
        }
        return null;
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto);
        return bookingCrudRepository.save(booking);
    }

    @Override
    public Booking updateBookingById(Long idBooking, BookingDto bookingDto) {
        Booking bookingFound = findBookingById(idBooking);
        if (bookingFound != null) {
            bookingFound.setBookingType(bookingDto.getBookingType());
            bookingFound.setReserved(bookingDto.getReserved());
            bookingFound.setBookingStartDate(bookingDto.getBookingStartDate());
            bookingFound.setBookingEndDate(bookingDto.getBookingEndDate());
            bookingFound.setPaymentMethods(bookingDto.getPaymentMethods());
            return bookingCrudRepository.save(bookingFound);
        }
        return bookingFound;
    }

    @Override
    public Boolean deleteBookingById(Long idBooking) {
        if (bookingCrudRepository.existsById(idBooking)) {
            bookingCrudRepository.deleteById(idBooking);
            return true;
        }
        return false;
    }
}
