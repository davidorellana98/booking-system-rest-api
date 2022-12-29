package com.davidorellana.bookingsystemrestapi.booking.controller;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.data.PaymentMethods;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.service.BookingService;
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
    public void find_all_bookings_200_ok() {

        List<Booking> bookingListMockito = new ArrayList<>();
        bookingListMockito.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingListMockito.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingService.findAllBookings()).thenReturn(bookingListMockito);

        ResponseEntity<List<Booking>> listBookingsResult = bookingController.findAllBookings();
        Assertions.assertEquals(200, listBookingsResult.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void find_all_bookings_404_notFound() {

        List<Booking> bookingListMockito = new ArrayList<>();

        Mockito.when(bookingService.findAllBookings()).thenReturn(bookingListMockito);

        ResponseEntity<List<Booking>> listBookingsResult = bookingController.findAllBookings();
        Assertions.assertEquals(404, listBookingsResult.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_booking_by_id_200_ok() {

        Booking bookingMockito = new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0);

        Mockito.when(bookingService.findBookingById("1")).thenReturn(bookingMockito);

        ResponseEntity<Booking> bookingResultController = bookingController.findBookingById("1");
        Assertions.assertEquals(200, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_booking_by_id_404_notFound() {
        Mockito.when(bookingService.findBookingById(Mockito.anyString())).thenReturn(null);

        ResponseEntity<Booking> bookingResultController = bookingController.findBookingById("1");
        Assertions.assertEquals(404, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void create_booking_200_ok() {

        BookingDto bookingDtoMockito = new BookingDto("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 50.0);
        Booking bookingMockito = new Booking(bookingDtoMockito);

        Mockito.when(bookingService.createBooking(bookingDtoMockito)).thenReturn(bookingMockito);

        ResponseEntity<Booking> bookingResponseResult = bookingController.createBooking(bookingDtoMockito);
        Assertions.assertTrue(201 == bookingResponseResult.getStatusCodeValue());
    }

    @Test
    @Order(6)
    public void update_booking_by_id_200_ok() {

        BookingDto bookingDtoMockito = new BookingDto("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 50.0);
        Booking bookingMockito = new Booking(bookingDtoMockito);

        Mockito.when(bookingService.updateBookingById("1", bookingDtoMockito)).thenReturn(bookingMockito);

        ResponseEntity<Booking> bookingResponseResult = bookingController.updateBookingById("1", bookingDtoMockito);
        Assertions.assertTrue(200 == bookingResponseResult.getStatusCodeValue());
        Assertions.assertTrue(bookingResponseResult.getBody() != null);
    }

    @Test
    @Order(7)
    public void delete_booking_by_id_200_ok() {

        Mockito.when(bookingService.deleteBookingById("1")).thenReturn(true);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBookingById("1");
        Assertions.assertEquals(200, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(8)
    public void delete_booking_by_id_400_not_found() {

        Mockito.when(bookingService.deleteBookingById(Mockito.anyString())).thenReturn(false);

        ResponseEntity<Boolean> bookingResultController = bookingController.deleteBookingById("1");
        Assertions.assertEquals(404, bookingResultController.getStatusCodeValue());
    }

    @Test
    @Order(9)
    public void find_bookings_by_bookingType_200_ok() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));

        Mockito.when(bookingService.findBookingsByBookingType("home")).thenReturn(bookingList);

        ResponseEntity<List<Booking>> bookingListResultController = bookingController.findBookingsByBookingType("home");
        Assertions.assertEquals(200, bookingListResultController.getStatusCodeValue());
    }

    @Test
    @Order(10)
    public void find_bookings_by_paymentMethods_200_ok() {

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,30), PaymentMethods.CASH, 2,30.0,60.0));
        bookingList.add(new Booking("home", true, LocalDate.now(), LocalDate.of(2022,12,31), PaymentMethods.ALIPAY, 3,10.0,30.0));


        Mockito.when(bookingService.findBookingsByPaymentMethods("CASH")).thenReturn(bookingList);

        ResponseEntity<List<Booking>> bookingListResultController = bookingController.findBookingsByPaymentMethods("CASH");
        Assertions.assertEquals(200, bookingListResultController.getStatusCodeValue());
    }
}
