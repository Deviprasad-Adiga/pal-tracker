package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeEntryController {

	@Autowired
	private TimeEntryRepository timeEntryRepository;

	public TimeEntryController(TimeEntryRepository timeEntryRepository) {
		this.timeEntryRepository = timeEntryRepository;
	}

	@PostMapping("/time-entries")
	public ResponseEntity<?> create(@RequestBody TimeEntry timeEntryToCreate) {
		return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
	}

	@GetMapping("/time-entries/{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable long id) {
		TimeEntry timeEntry = timeEntryRepository.find(id);
		if (timeEntry != null)
			return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
		else
			return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/time-entries")
	public ResponseEntity<List<TimeEntry>> list() {
		return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);
	}

	@PutMapping("/time-entries/{id}")
	public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
		TimeEntry timeEntryIn = timeEntryRepository.update(id, timeEntry);
		if (timeEntryIn != null)
			return new ResponseEntity<TimeEntry>(timeEntryIn, HttpStatus.OK);
		else
			return new ResponseEntity<TimeEntry>(timeEntryIn, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/time-entries/{id}")
	public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
		TimeEntry timeEntry = timeEntryRepository.find(id);
		timeEntryRepository.delete(id);
		return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NO_CONTENT);
	}

}
