package com.davidorellana.bookingsystemrestapi.booking.repository;

import com.davidorellana.bookingsystemrestapi.booking.model.data.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingCrudRepository extends CrudRepository<Booking, Long> { }
