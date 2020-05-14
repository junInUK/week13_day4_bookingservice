package com.example.codeclan.BookingService.repositories;

import com.example.codeclan.BookingService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
