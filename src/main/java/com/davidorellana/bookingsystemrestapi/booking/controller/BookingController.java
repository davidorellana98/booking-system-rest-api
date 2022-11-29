package com.davidorellana.bookingsystemrestapi.booking.controller;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import com.davidorellana.bookingsystemrestapi.booking.model.dto.BookingDto;
import com.davidorellana.bookingsystemrestapi.booking.service.BookingService;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Long, Booking>> getAllBookings() {
        HashMap<Long, Booking> listBooking = bookingService.getAllBookings();
        if (listBooking.isEmpty()) {
            return new ResponseEntity("There are no bookings to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listBooking, HttpStatus.OK);
    }

    @GetMapping("/{idBooking}")
    public ResponseEntity<Booking> findBookingById(@PathVariable Long idBooking) {
        Booking bookingById = bookingService.findBookingById(idBooking);
        if (bookingById != null) {
            return new ResponseEntity<>(bookingById, HttpStatus.OK);
        }
        return new ResponseEntity("That booking id does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<User> createBooking(@RequestBody BookingDto bookingDto) {
        Optional<Booking> bookingValidationCreated = Optional.ofNullable(bookingService.createBooking(bookingDto));
        if (bookingValidationCreated != null) {
            return new ResponseEntity("Created booking!", HttpStatus.CREATED);
        }
        return new ResponseEntity("Booking not created!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{idBooking}")
    public ResponseEntity<User> updateBookingById(@PathVariable Long idBooking, @RequestBody BookingDto bookingDto) {
        Booking bookingUpdated = bookingService.updateBookingById(idBooking, bookingDto);
        if (bookingUpdated != null){
            return new ResponseEntity("Updated booking!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Booking not updated by id not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idBooking}")
    public ResponseEntity deleteBookingById(@PathVariable Long idBooking) {
        Boolean isDeletedBooking = bookingService.deleteBookingById(idBooking);
        if (isDeletedBooking) {
            return new ResponseEntity("Deleted booking!", HttpStatus.OK);
        }
        return new ResponseEntity("The booking does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}