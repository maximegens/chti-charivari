package com.maximegens.chticharivari.Beans;


/**
 * Un restaurant ChtiCharivari.
 */
public class RestaurantChti {

        public String id;
        public String ville;

        public RestaurantChti(String id, String ville) {
            this.id = id;
            this.ville = ville;
        }

        public String toString() {
            return ville;
        }

        public String getVille() {
            return ville;
        }

        public String getId() {
            return id;
        }
}
