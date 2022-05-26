package com.erivas.acs.repostory;

import com.erivas.acs.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
    Attendee findAttendeeByDni(String dni);
}
