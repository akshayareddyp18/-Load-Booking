package com.example.loadmanagement.service;

import com.example.loadmanagement.exception.InvalidStateException;
import com.example.loadmanagement.exception.ResourceNotFoundException;
import com.example.loadmanagement.model.Booking;
import com.example.loadmanagement.model.Load;
import com.example.loadmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private LoadService loadService;

    @Override
    public Booking createBooking(Booking booking) {
        Load load = loadService.getLoadById(booking.getLoadId());
        if(load.getStatus().equals("CANCELLED")){
            throw new InvalidStateException("Load is cancelled, cannot create booking");
        }
        booking.setRequestedAt(new Timestamp(System.currentTimeMillis()));
        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings(String transporterId, UUID loadId) {
        if(transporterId != null){
            return bookingRepository.findByTransporterId(transporterId);
        }
        if(loadId != null){
            return bookingRepository.findByLoadId(loadId);
        }
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(UUID bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));
    }

    @Override
    public Booking updateBooking(UUID bookingId, Booking booking) {
        Booking existingBooking = getBookingById(bookingId);
        existingBooking.setLoadId(booking.getLoadId());
        existingBooking.setTransporterId(booking.getTransporterId());
        existingBooking.setProposedRate(booking.getProposedRate());
        existingBooking.setComment(booking.getComment());
        existingBooking.setStatus(booking.getStatus());
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        Booking booking = getBookingById(bookingId);
        loadService.updateLoadStatus(booking.getLoadId(), "CANCELLED");
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public void updateBookingStatus(UUID bookingId, String status) {
        Booking existingBooking = getBookingById(bookingId);
        existingBooking.setStatus(status);
        bookingRepository.save(existingBooking);
        if (status.equals("ACCEPTED")) {
            loadService.updateLoadStatus(existingBooking.getLoadId(), "BOOKED");
        }
    }
}