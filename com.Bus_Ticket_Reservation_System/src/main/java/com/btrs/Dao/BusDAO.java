package com.btrs.Dao;

import com.btrs.entity.Bus;

public interface BusDAO {
    void save(Bus bus);
    Bus findById(int id);
    void update(Bus bus);
    void delete(Bus bus);
}

