package com.davidorellana.bookingsystemrestapi.booking.repository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.repository.mongorepository.BookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepositoryDao {

    private final BookingMongoRepository bookingMongoRepository;

    @Autowired
    public BookingRepositoryImpl(BookingMongoRepository bookingMongoRepository) {
        this.bookingMongoRepository = bookingMongoRepository;
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingMongoRepository.findAll();
    }

    @Override
    public Booking findBookingById(String id) {
        Optional<Booking> bookingByIdFound = bookingMongoRepository.findById(id);
        if (bookingByIdFound.isPresent()) {
            return bookingByIdFound.get();
        }
        return null;
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        if (bookingDto.getBookingStartDate().isAfter(LocalDate.now())) {
            if (bookingDto.getBookingEndDate().isAfter(bookingDto.getBookingStartDate())) {
                Booking booking = new Booking(bookingDto);
                bookingMongoRepository.insert(booking);
                return bookingMongoRepository.save(booking);
            }
        }
        return null;
    }

    @Override
    public Booking updateBookingById(String id, BookingDto bookingDto) {
        Booking bookingFound = findBookingById(id);
        if (bookingFound != null) {
            Boolean comparisonStartDateNowDto = bookingDto.getBookingStartDate().isAfter(LocalDate.now());
            Boolean comparisonStartDateEndDto = bookingDto.getBookingEndDate().isAfter(bookingDto.getBookingStartDate());
            Boolean comparisonEndDtoDateStartFound = bookingDto.getBookingEndDate().isAfter(bookingFound.getBookingStartDate());
            if (comparisonStartDateNowDto && comparisonStartDateEndDto && comparisonEndDtoDateStartFound) {
                bookingFound.updateBookingCollection(bookingDto);
                return bookingMongoRepository.save(bookingFound);
            }
        }
        return null;
    }

    @Override
    public Boolean deleteBookingById(String id) {
        Booking bookingFound = findBookingById(id);
        if (bookingMongoRepository.existsById(id)) {
            bookingMongoRepository.delete(bookingFound);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllBookings() {
        List<Booking> bookingsFound = findAllBookings();
        bookingMongoRepository.deleteAll(bookingsFound);
    }

    @Override
    public List<Booking> findBookingsByBookingType(String bookingType) {
        List<Booking> bookingsByBookingTypeFound = bookingMongoRepository.findBookingsByBookingType(bookingType);
        if (bookingsByBookingTypeFound.isEmpty()) {
            return null;
        }
        return bookingsByBookingTypeFound;
    }

    @Override
    public List<Booking> findBookingsByPaymentMethods(String paymentMethods) {
        List<Booking> bookingsByPaymentMethodsFound = bookingMongoRepository.findBookingsByPaymentMethods(paymentMethods);
        if (bookingsByPaymentMethodsFound.isEmpty()) {
            return null;
        }
        return bookingsByPaymentMethodsFound;
    }
}
