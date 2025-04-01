package com.example.loadmanagement.controller;

import com.example.loadmanagement.model.Booking;
import com.example.loadmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(value="transporterId", required = false) String transporterId, @RequestParam(value="loadId", required = false) UUID loadId) {
        return new ResponseEntity<>(bookingService.getAllBookings(transporterId, loadId), HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable UUID bookingId) {
        return new ResponseEntity<>(bookingService.getBookingById(bookingId), HttpStatus.OK);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable UUID bookingId, @RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.updateBooking(bookingId, booking), HttpStatus.OK);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{bookingId}/status/{status}")
    public ResponseEntity<Void> updateBookingStatus(@PathVariable UUID bookingId, @PathVariable String status) {
        bookingService.updateBookingStatus(bookingId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}