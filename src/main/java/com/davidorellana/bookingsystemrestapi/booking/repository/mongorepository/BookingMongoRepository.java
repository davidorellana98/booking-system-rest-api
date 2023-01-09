package com.davidorellana.bookingsystemrestapi.booking.repository.mongorepository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingMongoRepository extends MongoRepository<Booking, String> {

    List<Booking> findBookingsByBookingType(String bookingType);

    List<Booking> findBookingsByPaymentMethods(String paymentMethods);
}
