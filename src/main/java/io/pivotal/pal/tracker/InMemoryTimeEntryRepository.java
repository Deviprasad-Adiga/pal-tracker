package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
	
	Map<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();
	long idKey = 0L;

	public TimeEntry create(TimeEntry timeEntry) {
		idKey+=1L;
		timeEntry.setId(idKey);
		timeEntries.put(idKey, timeEntry);
		return timeEntry;
	}

	public TimeEntry find(long id) {
		return timeEntries.get(id);
	}

	public List<TimeEntry> list() {
		List<TimeEntry> list = new ArrayList<TimeEntry>(timeEntries.values());
		return list;
	}

	public TimeEntry update(long id, TimeEntry timeEntry) {
		timeEntry.setId(id);
		timeEntries.put(id, timeEntry);
		return timeEntries.get(id);
	}

	public void delete(long id) {
		timeEntries.remove(id);		
	}

}
