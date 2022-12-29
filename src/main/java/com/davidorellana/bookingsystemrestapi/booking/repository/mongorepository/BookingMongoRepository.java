package com.davidorellana.bookingsystemrestapi.booking.repository.mongorepository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookingMongoRepository extends MongoRepository<Booking, String> {

    //@Query(value = "{'bookingType' : ?0}", exists = true)
    List<Booking> findBookingsByBookingType(String bookingType);

    //@Query(value = "{'paymentMethods' : ?0}", exists = true)
    List<Booking> findBookingsByPaymentMethods(String paymentMethods);
}
