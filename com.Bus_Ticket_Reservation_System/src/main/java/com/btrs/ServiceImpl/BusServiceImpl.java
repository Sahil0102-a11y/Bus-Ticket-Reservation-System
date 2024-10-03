package com.btrs.ServiceImpl;

import com.btrs.DaoImpl.BusDAOImpl;
import com.btrs.Service.BusService;
import com.btrs.entity.Bus;

public class BusServiceImpl implements BusService {

    private BusDAOImpl busDAO = new BusDAOImpl();

    @Override
    public void createBus(int busNumber,int seatCapacity) {
        Bus bus = new Bus(busNumber,seatCapacity);
        busDAO.save(bus);
        System.out.println("Bus created successfully: " + bus);
    }

    @Override
    public Bus getBusById(int id) {
        return busDAO.findById(id);
    }

    @Override
    public void updateBus(Bus bus) {
        busDAO.update(bus);
        System.out.println("Bus updated successfully: " + bus);
    }

    @Override
    public void deleteBus(int id) {
        Bus bus = busDAO.findById(id);
        if (bus != null) {
            busDAO.delete(bus);
            System.out.println("Bus deleted successfully: " + bus);
        } else {
            System.out.println("Bus not found!");
        }
    }
}

