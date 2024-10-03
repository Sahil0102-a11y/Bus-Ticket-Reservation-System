package com.btrs.ServiceImpl;

import com.btrs.DaoImpl.RouteDAOImpl;
import com.btrs.Service.RouteService;
import com.btrs.entity.Route;

public class RouteServiceImpl implements RouteService {

    private RouteDAOImpl routeDAO = new RouteDAOImpl();

    @Override
    public void createRoute(String startLocation, String endLocation) {
        Route route = new Route(startLocation, endLocation);
        routeDAO.save(route);
        System.out.println("Route created successfully: " + route);
    }

    @Override
    public Route getRouteById(int id) {
        return routeDAO.findById(id);
    }

    @Override
    public void updateRoute(Route route) {
        routeDAO.update(route);
        System.out.println("Route updated successfully: " + route);
    }

    @Override
    public void deleteRoute(int id) {
        Route route = routeDAO.findById(id);
        if (route != null) {
            routeDAO.delete(route);
            System.out.println("Route deleted successfully: " + route);
        } else {
            System.out.println("Route not found!");
        }
    }
}

