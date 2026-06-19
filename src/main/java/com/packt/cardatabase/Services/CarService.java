package com.packt.cardatabase.Services;

import com.packt.cardatabase.DAO.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {

    private final CarDAO carDAO;

    @Autowired
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }
}
