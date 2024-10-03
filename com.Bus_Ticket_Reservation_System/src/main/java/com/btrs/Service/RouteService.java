package com.btrs.Service;

import com.btrs.entity.Route;

public interface RouteService {
    void createRoute(String startLocation, String endLocation);
    Route getRouteById(int id);
    void updateRoute(Route route);
    void deleteRoute(int id);
}

