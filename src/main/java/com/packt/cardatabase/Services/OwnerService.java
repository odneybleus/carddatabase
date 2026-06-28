package com.packt.cardatabase.Services;

import com.packt.cardatabase.DAO.CarDAO;
import com.packt.cardatabase.DAO.OwnerDAO;
import com.packt.cardatabase.Model.Car;
import com.packt.cardatabase.Model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OwnerService {
    private final CarDAO carDAO;
    private final OwnerDAO ownerDAO;

    @Autowired
    public OwnerService(CarDAO carDAO, OwnerDAO ownerDAO) {
        this.carDAO = carDAO;
        this.ownerDAO = ownerDAO;
    }

    public List<Owner> getAllOwners() {
        return ownerDAO.findAll();
    }

    public Owner createOwner(Owner owner){
        return ownerDAO.save(owner);
    }

    public Optional<Owner> getOwnerById(long ownerID){
        return ownerDAO.findById(ownerID);
    }

    public Owner getOwnerByUsername(String userName){
        Optional<Owner> possibleOwner = ownerDAO.getOwnerByUserName(userName);

        return possibleOwner.orElse(null);

    }

    public void deleteOwner(Owner owner){
        ownerDAO.delete(owner);
    }

    public Owner updateOwner(Owner owner){
        return ownerDAO.save(owner);
    }

    public Owner loginOwner(String userName, String password){
         Optional<Owner> possibleOwner = ownerDAO.getOwnerByUserName(userName);

         if(possibleOwner.isEmpty()){
             return null;
         }

         Owner returnedOwner = possibleOwner.get();

         if(returnedOwner.getUserPassword().equals(password)){
             return returnedOwner;

         }
         return  null;
    }


    public Owner addCarsToCollection(String username, long id){
        Optional<Owner> possibleOwner = ownerDAO.getOwnerByUserName(username);

        Optional<Car> possibleCar = carDAO.findById(id);

        if(possibleOwner.isEmpty() || possibleCar.isEmpty()){
            return null;
        }

        Owner returnedOwner = possibleOwner.get();
        Car returnedCar = possibleCar.get();

        Set<Car> favorite = returnedOwner.getOwnedCars();
        favorite.add(returnedCar);
        returnedOwner.setOwnedCars(favorite);
        return ownerDAO.save(returnedOwner);

    }

    public Owner removeCarsToCollection(String username, long id){
        Optional<Owner> possibleOwner = ownerDAO.getOwnerByUserName(username);

        Optional<Car> possibleCar = carDAO.findById(id);

        if(possibleOwner.isEmpty() || possibleCar.isEmpty()){
            return null;
        }

        Owner returnedOwner = possibleOwner.get();
        Car returnedCar = possibleCar.get();

        Set<Car> favorite = returnedOwner.getOwnedCars();
        favorite.remove(returnedCar);
        returnedOwner.setOwnedCars(favorite);
        return ownerDAO.save(returnedOwner);

    }


}
