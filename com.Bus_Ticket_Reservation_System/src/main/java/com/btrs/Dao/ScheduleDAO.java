package com.btrs.Dao;

import com.btrs.entity.Schedule;

public interface ScheduleDAO {
    void save(Schedule schedule);
    Schedule findById(int id);
    void update(Schedule schedule);
    void delete(Schedule schedule);
}

