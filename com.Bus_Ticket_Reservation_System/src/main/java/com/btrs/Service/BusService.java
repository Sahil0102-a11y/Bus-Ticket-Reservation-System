package com.btrs.Service;

import com.btrs.entity.Bus;

public interface BusService {
    void createBus(int busNumber,int seatCapacity);
    Bus getBusById(int id);
    void updateBus(Bus bus);
    void deleteBus(int id);
}

