package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class TimeEntry {
	
	private long id;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;

	public TimeEntry() {
	}
	
	@Override
	public boolean equals(Object target) {
		if (target.getClass().getName().equalsIgnoreCase("io.pivotal.pal.tracker.TimeEntry")) {
			TimeEntry t = (TimeEntry)target;
			if (this.id == t.id && this.projectId == t.projectId && this.userId == t.userId &&
					this.date.toString().equalsIgnoreCase(t.date.toString()) && this.hours == t.hours)
				return true;
		}
		return false;
	}

	public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
		this.id = id;
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}

	public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getProjectId() {
		return this.projectId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getHours() {
		return this.hours;
	}
}
