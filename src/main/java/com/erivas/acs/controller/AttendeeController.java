package com.erivas.acs.controller;

import com.erivas.acs.model.Attendee;
import com.erivas.acs.repostory.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {

    @Autowired
    private AttendeeRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllAttendees() {
        try {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addAttendee(@RequestBody Attendee attendee) {
        try {
            return new ResponseEntity<>(repository.save(attendee), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> getAttendeeByDni(@PathVariable String dni) {
        try {
            return new ResponseEntity<>(repository.findAttendeeByDni(dni), HttpStatus.ACCEPTED);
        } catch (Exception error) {
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> DeleteAttendeeByDni(@PathVariable String dni) {
        try {
            Attendee attendee = repository.findAttendeeByDni(dni);
            repository.delete(attendee);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
