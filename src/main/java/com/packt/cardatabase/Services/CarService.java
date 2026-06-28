package com.packt.cardatabase.Services;

import com.packt.cardatabase.DAO.CarDAO;
import com.packt.cardatabase.DAO.OwnerDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {

    private final CarDAO carDAO;
    private final OwnerDAO ownerDAO;

    @Autowired
    public CarService(CarDAO carDAO, OwnerDAO ownerDAO) {
        this.carDAO = carDAO;
        this.ownerDAO = ownerDAO;
    }
}
