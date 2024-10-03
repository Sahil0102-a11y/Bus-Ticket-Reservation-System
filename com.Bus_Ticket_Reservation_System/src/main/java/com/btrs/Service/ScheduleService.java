package com.btrs.Service;

import java.time.LocalDateTime;

import com.btrs.entity.Schedule;

public interface ScheduleService {
    void createSchedule(int busId, int routeId, LocalDateTime departureTime);
    Schedule getScheduleById(int id);
    void updateSchedule(Schedule schedule);
    void deleteSchedule(int id);
}

