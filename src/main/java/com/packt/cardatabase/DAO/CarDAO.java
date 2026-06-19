package com.packt.cardatabase.DAO;


import com.packt.cardatabase.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDAO extends JpaRepository<Car,Long> {
    //fetch car by brand
    List<Car> findByBrand(String brand);

    //fetch car by color
    List<Car> findByColor(String color);

    //fetch car by model
    List<Car> findByModelYear(int modelYear);

}
