package com.davidorellana.bookingsystemrestapi.booking.controller;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;
import com.davidorellana.bookingsystemrestapi.booking.repository.mongorepository.BookingMongoRepository;
import com.davidorellana.bookingsystemrestapi.booking.service.BookingService;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    @Order(1)
    public void delete_booking_by_id_200_ok() {

        Mockito.when(bookingService.deleteBookingById(Mockito.anyString())).thenReturn(true);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBookingById("1");
        Assertions.assertEquals(200, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void delete_booking_by_id_400_not_found() {

        Mockito.when(bookingService.deleteBookingById(Mockito.anyString())).thenReturn(false);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBookingById("1");
        Assertions.assertEquals(404, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_bookings_by_bookingType_200_ok() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingService.findBookingsByBookingType("home")).thenReturn(bookingList);

        ResponseEntity<List<Booking>> bookingListResultController = bookingController.findBookingsByBookingType("home");
        Assertions.assertEquals(200, bookingListResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_bookings_by_paymentMethods_200_ok() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));


        Mockito.when(bookingService.findBookingsByPaymentMethods("CASH")).thenReturn(bookingList);

        ResponseEntity<List<Booking>> bookingListResultController = bookingController.findBookingsByPaymentMethods("CASH");
        Assertions.assertEquals(200, bookingListResultController.getStatusCodeValue());
    }

}