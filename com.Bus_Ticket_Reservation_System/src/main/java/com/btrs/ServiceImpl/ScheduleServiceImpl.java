package com.btrs.ServiceImpl;



import java.time.LocalDateTime;

import com.btrs.DaoImpl.BusDAOImpl;
import com.btrs.DaoImpl.RouteDAOImpl;
import com.btrs.DaoImpl.ScheduleDAOImpl;
import com.btrs.Service.ScheduleService;
import com.btrs.entity.Bus;
import com.btrs.entity.Route;
import com.btrs.entity.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
    private BusDAOImpl busDAO = new BusDAOImpl();
    private RouteDAOImpl routeDAO = new RouteDAOImpl();

    @Override
    public void createSchedule(int busId, int routeId, LocalDateTime departureTime) {
        Bus bus = busDAO.findById(busId);
        Route route = routeDAO.findById(routeId);

        if (bus != null && route != null) {
            Schedule schedule = new Schedule(bus, route, departureTime);
            scheduleDAO.save(schedule);
            System.out.println("Schedule created successfully: " + schedule);
        } else {
            System.out.println("Bus or Route not found!");
        }
    }

    @Override
    public Schedule getScheduleById(int id) {
        return scheduleDAO.findById(id);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleDAO.update(schedule);
        System.out.println("Schedule updated successfully: " + schedule);
    }

    @Override
    public void deleteSchedule(int id) {
        Schedule schedule = scheduleDAO.findById(id);
        if (schedule != null) {
            scheduleDAO.delete(schedule);
            System.out.println("Schedule deleted successfully: " + schedule);
        } else {
            System.out.println("Schedule not found!");
        }
    }
}

