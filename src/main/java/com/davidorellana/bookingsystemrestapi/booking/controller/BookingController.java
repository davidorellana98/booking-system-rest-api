package com.davidorellana.bookingsystemrestapi.booking.controller;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(summary = "Find all bookings")
    @GetMapping
    public ResponseEntity<List<Booking>> findAllBookings() {
        List<Booking> allBookings = bookingService.findAllBookings();
        if (allBookings.isEmpty()) {
            return new ResponseEntity("The bookings collection is empty.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @Operation(summary = "Find a booking by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable String id) {
        Booking bookingByIdFound = bookingService.findBookingById(id);
        if (bookingByIdFound != null) {
            return new ResponseEntity<>(bookingByIdFound, HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " does not exist in the bookings collection.", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Create Booking")
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto) {
        Booking bookingCreated = bookingService.createBooking(bookingDto);
        if (bookingCreated != null) {
            return new ResponseEntity<>(bookingCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity("Error creating booking, inconsistent dates, please enter the start and end dates correctly.", HttpStatus.CONFLICT);

    }

    @Operation(summary = "Update a booking by its id")
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable String id, @RequestBody BookingDto bookingDto) {
        Booking bookingUpdated = bookingService.updateBookingById(id, bookingDto);
        if (bookingUpdated != null) {
            return new ResponseEntity<>(bookingUpdated, HttpStatus.OK);
        }
        return new ResponseEntity("Booking update failed due to inconsistent ID or dates.", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete a booking by its id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBookingById(@PathVariable String id) {
        if (bookingService.deleteBookingById(id)) {
            return new ResponseEntity("Deleted booking.", HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " is not found in the collection of bookings to delete.", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete all bookings")
    @DeleteMapping
    public ResponseEntity deleteAllBookings() {
        List<Booking> allBookings = bookingService.findAllBookings();
        bookingService.deleteAllBookings();
        if (allBookings.isEmpty()) {
            return new ResponseEntity("There is no collection of bookings to delete.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Correct deletion of the entire booking collection.", HttpStatus.OK);
    }

    @Operation(summary = "Find bookings by its booking type")
    @GetMapping("/bookingType/{bookingType}")
    public ResponseEntity<List<Booking>> findBookingsByBookingType(@PathVariable String bookingType) {
       List<Booking> bookingsByBookingTypeFound = bookingService.findBookingsByBookingType(bookingType);
       if (bookingsByBookingTypeFound != null) {
           return new ResponseEntity<>(bookingsByBookingTypeFound, HttpStatus.OK);
       }
       return new ResponseEntity("The booking with the name " + bookingType + " is not found in the bookings collection.", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Find bookings by its Payment Methods (CASH, CARD, PAYPAL, ALIPAY, BITCOIN)")
    @GetMapping("/paymentMethods/{paymentMethods}")
    public ResponseEntity<List<Booking>> findBookingsByPaymentMethods(@PathVariable String paymentMethods) {
        List<Booking> bookingsByPaymentMethodsFound = bookingService.findBookingsByPaymentMethods(paymentMethods);
        if (bookingsByPaymentMethodsFound != null) {
            return new ResponseEntity<>(bookingsByPaymentMethodsFound, HttpStatus.OK);
        }
        return new ResponseEntity("The form " + paymentMethods + " does not exist as a payment method.", HttpStatus.BAD_REQUEST);
    }
}