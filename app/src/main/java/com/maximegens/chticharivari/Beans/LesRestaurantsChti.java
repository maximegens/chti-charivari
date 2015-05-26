package com.maximegens.chticharivari.beans;

import java.util.ArrayList;

public class LesRestaurantsChti {

    public ArrayList<RestaurantChti> restaurants;

    public ArrayList<RestaurantChti> getRestaurants(){
        return restaurants;
    }

    public RestaurantChti getrestaurantById(Integer id){
        for (RestaurantChti restaurant : restaurants){
            if(restaurant.getId().equals(id)){
                return restaurant;
            }
        }
        return null;
    }
}
