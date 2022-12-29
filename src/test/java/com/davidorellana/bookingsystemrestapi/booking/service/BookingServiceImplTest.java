package com.davidorellana.bookingsystemrestapi.booking.service;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.repository.BookingRepositoryDao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepositoryDao bookingRepositoryDao;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    @Order(1)
    public void find_all_bookings() {

        List<Booking> bookingListMockito = new ArrayList<>();
        bookingListMockito.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingListMockito.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingRepositoryDao.findAllBookings()).thenReturn(bookingListMockito);

        List<Booking> bookingsListResult = bookingService.findAllBookings();
        List<Booking> bookingListExpected = new ArrayList<>();
        bookingListExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingListExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Assertions.assertEquals(bookingListExpected, bookingsListResult);
    }

    @Test
    @Order(2)
    public void find_booking_by_id() {

        Booking bookingMockito = new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0);

        Mockito.when(bookingRepositoryDao.findBookingById("1")).thenReturn(bookingMockito);

        Booking bookingResult = bookingService.findBookingById("1");
        Booking bookingExpected = new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0);

        Assertions.assertEquals(bookingExpected, bookingResult);
    }

    @Test
    @Order(3)
    public void create_booking() {

        BookingDto bookingDtoMockito = new BookingDto("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 30.0);
        Booking bookingMockito = new Booking(bookingDtoMockito);

        Mockito.when(bookingRepositoryDao.createBooking(bookingDtoMockito)).thenReturn(bookingMockito);

        Booking bookingResult = bookingService.createBooking(bookingDtoMockito);

        Assertions.assertEquals(bookingMockito, bookingResult);
    }

    @Test
    @Order(4)
    public void update_booking_by_id() {
        BookingDto bookingDtoMockito = new BookingDto("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 30.0);
        Booking bookingMockito = new Booking(bookingDtoMockito);

        Mockito.when(bookingRepositoryDao.updateBookingById("1", bookingDtoMockito)).thenReturn(bookingMockito);

        Booking bookingResult = bookingService.updateBookingById("1", bookingDtoMockito);

        Assertions.assertEquals(bookingMockito, bookingResult);
    }


    @Test
    @Order(5)
    public void delete_booking_by_id() {

        Mockito.when(bookingRepositoryDao.deleteBookingById("1")).thenReturn(true);

        Boolean deleteBookingResult = bookingService.deleteBookingById("1");

        Assertions.assertEquals(true, deleteBookingResult);
    }

    @Test
    @Order(6)
    public void find_bookings_by_bookingType() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingRepositoryDao.findBookingsByBookingType("home")).thenReturn(bookingList);

        List<Booking> findBookingAllResult = bookingService.findBookingsByBookingType(bookingList.listIterator().next().getBookingType());
        List<Booking> bookingListExpected = new ArrayList<>();
        bookingListExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingListExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));


        Assertions.assertEquals(bookingListExpected, findBookingAllResult);
    }

    @Test
    @Order(7)
    public void find_bookings_by_paymentMethods() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingRepositoryDao.findBookingsByPaymentMethods("CASH")).thenReturn(bookingList);

        List<Booking> findBookingPaymentResult = bookingService.findBookingsByPaymentMethods(bookingList.listIterator().next().getPaymentMethods().toString());
        List<Booking> bookingPaymentExpected = new ArrayList<>();
        bookingPaymentExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingPaymentExpected.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));


        Assertions.assertEquals(bookingPaymentExpected, findBookingPaymentResult);
    }
}