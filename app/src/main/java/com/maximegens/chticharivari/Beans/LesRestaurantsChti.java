package com.maximegens.chticharivari.Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maxime on 13/05/2015.
 */
public class LesRestaurantsChti {
    /**
     * An array of sample (dummy) items.
     */
    public static ArrayList<RestaurantChti> lesRestaurants = new ArrayList<RestaurantChti>();

    static{
        RestaurantChti calais = new RestaurantChti("1","Calais");
        RestaurantChti wimereux = new RestaurantChti("2","Wimereux ");
        RestaurantChti boulogneSurMer = new RestaurantChti("3","Boulogne sur Mer");
        RestaurantChti leTouquet = new RestaurantChti("4","Le Touquet");
        RestaurantChti aireSurLaLys = new RestaurantChti("5","Air sur la Lys");
        RestaurantChti bethune = new RestaurantChti("6","Bethune");
        RestaurantChti douai = new RestaurantChti("7","Douai");
        RestaurantChti valenciennes = new RestaurantChti("8","Valenciennes");
        RestaurantChti arras = new RestaurantChti("9","Arras");
        RestaurantChti amiens = new RestaurantChti("10","Amiens");
        lesRestaurants.add(calais);
        lesRestaurants.add(wimereux);
        lesRestaurants.add(boulogneSurMer);
        lesRestaurants.add(leTouquet);
        lesRestaurants.add(aireSurLaLys);
        lesRestaurants.add(bethune);
        lesRestaurants.add(douai);
        lesRestaurants.add(valenciennes);
        lesRestaurants.add(arras);
        lesRestaurants.add(amiens);
    }

    public ArrayList<RestaurantChti> getRestaurants(){
        return lesRestaurants;
    }

    public static RestaurantChti getrestaurantById(String id){
        for (RestaurantChti restaurant : lesRestaurants){
            if(restaurant.getId().equals(id)){
                return restaurant;
            }
        }
        return null;
    }
}
