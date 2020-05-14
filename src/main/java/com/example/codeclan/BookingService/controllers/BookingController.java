package com.example.codeclan.BookingService.controllers;

import com.example.codeclan.BookingService.models.Booking;
import com.example.codeclan.BookingService.models.Customer;
import com.example.codeclan.BookingService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getALlBookings(

    ){
        return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking,@PathVariable Long id){
        if(booking.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    //  response entity with no body
        }
        //  get the booking with the given id
        //  save the new booking body
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

//    @DeleteMapping(value = "/bookings/{id}")
//    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id){
//        customerRepository.deleteById(id);
//        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
//    }
}
