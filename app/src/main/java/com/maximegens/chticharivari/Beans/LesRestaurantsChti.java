package com.maximegens.chticharivari.Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LesRestaurantsChti {
    /**
     * An array of sample (dummy) items.
     */
    public static ArrayList<RestaurantChti> lesRestaurants = new ArrayList<>();

    static{
        RestaurantChti aireSurLaLys = new RestaurantChti("1","Air sur la Lys");
        RestaurantChti amiens = new RestaurantChti("2","Amiens");
        RestaurantChti arras = new RestaurantChti("3","Arras");
        RestaurantChti bethune = new RestaurantChti("4","Bethune");
        RestaurantChti boulogneSurMer = new RestaurantChti("5","Boulogne sur Mer");
        RestaurantChti calais = new RestaurantChti("6","Calais");
        RestaurantChti douai = new RestaurantChti("7","Douai");
        RestaurantChti dunkerque = new RestaurantChti("8","Dunkerque");
        RestaurantChti heninbeaumont = new RestaurantChti("9","Henin-Beaumont");
        RestaurantChti leTouquet = new RestaurantChti("10","Le Touquet");
        RestaurantChti lomme = new RestaurantChti("11","Lomme");
        RestaurantChti saintOmer = new RestaurantChti("12","Saint-Omer");
        RestaurantChti valenciennes = new RestaurantChti("13","Valenciennes");
        RestaurantChti villeneuveAscq = new RestaurantChti("14","Villeneuve d'ascq");
        RestaurantChti wimereux = new RestaurantChti("15","Wimereux ");

        lesRestaurants.add(aireSurLaLys);
        lesRestaurants.add(amiens);
        lesRestaurants.add(arras);
        lesRestaurants.add(bethune);
        lesRestaurants.add(boulogneSurMer);
        lesRestaurants.add(calais);
        lesRestaurants.add(douai);
        lesRestaurants.add(dunkerque);
        lesRestaurants.add(heninbeaumont);
        lesRestaurants.add(leTouquet);
        lesRestaurants.add(lomme);
        lesRestaurants.add(saintOmer);
        lesRestaurants.add(valenciennes);
        lesRestaurants.add(villeneuveAscq);
        lesRestaurants.add(wimereux);

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
