package com.maximegens.chticharivari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maximegens.chticharivari.Beans.RestaurantChti;
import com.maximegens.chticharivari.R;

import java.util.ArrayList;

/**
 * Created by Maxime on 13/05/2015.
 */
public class RestaurantsAdapter extends BaseAdapter {

    // Une liste de restaurants
    private ArrayList<RestaurantChti> listRestaurants;

    //Le contexte dans lequel est present notre adapter
    private Context mContext;

    //Un mecanisme pour gerer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;

    public RestaurantsAdapter(Context context, ArrayList<RestaurantChti> listeRestaurants) {
        this.mContext = context;
        this.listRestaurants = listeRestaurants;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return this.listRestaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listRestaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Reutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item a partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adpater_liste_restaurants, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Recuperation des TextView de notre layout
        TextView restaurantId = (TextView)layoutItem.findViewById(R.id.restaurant_id);
        TextView restaurantVille = (TextView)layoutItem.findViewById(R.id.restaurant_ville);

        //(3) : Renseignement des valeurs
        restaurantId.setText(listRestaurants.get(position).getId());
        restaurantVille.setText(listRestaurants.get(position).getVille());

        //On retourne l'item cree.
        return layoutItem;
    }
}
