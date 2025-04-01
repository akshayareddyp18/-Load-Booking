package com.example.loadmanagement.service;

import com.example.loadmanagement.model.Booking;
import java.util.List;
import java.util.UUID;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings(String transporterId, UUID loadId);
    Booking getBookingById(UUID bookingId);
    Booking updateBooking(UUID bookingId, Booking booking);
    void deleteBooking(UUID bookingId);
    void updateBookingStatus(UUID bookingId, String status);
}