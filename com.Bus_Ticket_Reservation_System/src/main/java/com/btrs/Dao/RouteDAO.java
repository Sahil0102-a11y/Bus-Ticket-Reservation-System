package com.btrs.Dao;

import com.btrs.entity.Route;

public interface RouteDAO {
    void save(Route route);
    Route findById(int id);
    void update(Route route);
    void delete(Route route);
}

