package com.example.codeclan.BookingService.components;

import com.example.codeclan.BookingService.models.Booking;
import com.example.codeclan.BookingService.models.Course;
import com.example.codeclan.BookingService.models.Customer;
import com.example.codeclan.BookingService.repositories.BookingRepository;
import com.example.codeclan.BookingService.repositories.CourseRepository;
import com.example.codeclan.BookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("jun","Edinburgh", 44);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("lily", "Aberdeen", 34);
        customerRepository.save(customer2);

        Course course1 = new Course("Phython", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Ruby", "Glasgow", 3);
        courseRepository.save(course2);

        Booking booking1 = new Booking("01-05-2020",customer1,course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-11-1987", customer2, course2);
        bookingRepository.save(booking2);
    }
}
