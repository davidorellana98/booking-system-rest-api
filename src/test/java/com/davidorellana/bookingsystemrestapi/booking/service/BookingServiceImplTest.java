package com.davidorellana.bookingsystemrestapi.booking.service;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;
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
    public void delete_booking_by_id() {

        Mockito.when(bookingRepositoryDao.deleteBookingById("1")).thenReturn(true);

        Boolean deleteBookingResult = bookingService.deleteBookingById("1");

        Assertions.assertEquals(true, deleteBookingResult);
    }

    @Test
    @Order(2)
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
    @Order(2)
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