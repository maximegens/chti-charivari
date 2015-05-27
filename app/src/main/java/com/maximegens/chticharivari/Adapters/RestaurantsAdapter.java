package com.maximegens.chticharivari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maximegens.chticharivari.beans.RestaurantChti;
import com.maximegens.chticharivari.R;

import java.util.ArrayList;

/**
 * Adapter pour la liste des restaurants ChTiCharivari.
 */
public class RestaurantsAdapter extends BaseAdapter {

    // Une liste de restaurants chti Charivari.
    private ArrayList<RestaurantChti> listRestaurants;

    //Le contexte dans lequel est present notre adapter.
    private Context mContext;

    //Un mecanisme pour gerer l'affichage graphique depuis un layout XML.
    private LayoutInflater mInflater;

    /**
     *     Constructeur de l'adapter.
     */
    public RestaurantsAdapter(Context context, ArrayList<RestaurantChti> listeRestaurants) {
        this.mContext = context;
        this.listRestaurants = listeRestaurants;
        this.mInflater = LayoutInflater.from(mContext);
    }

    /**
     * Permet de connaitre le nombre d'item ( de restaurants) dans la liste.
     * @return Le nombre (int) de restaurants dans la liste.
     */
    @Override
    public int getCount() {
        return this.listRestaurants.size();
    }

    /**
     * Permet de retourner le restaurant � la position pass� en param�tre.
     * @param position La position de l'objet demand�.
     * @return Un ChtiCharivari correspond � la position demand�e.
     */
    @Override
    public Object getItem(int position) {
        return this.listRestaurants.get(position);
    }

    /**
     * Permet de retourner l'id du restaurant � la position pass� en param�tre.
     * @param position La position de l'objet demand�.
     * @return L'id du ChtiCharivari correspond � la position demand�e.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * D�fini et construis la vue pour chaque items.
     * @param position la position de l'item dans la liste.
     * @param convertView La vue a convertir.
     * @param parent Le parents.
     * @return La vue associ�e avec les valeurs.
     */
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
        TextView restaurantVille = (TextView)layoutItem.findViewById(R.id.restaurant_list_nom);
        TextView restaurantAdresse = (TextView)layoutItem.findViewById(R.id.restaurant_list_adresse);

        //(3) : Renseignement des valeurs
        restaurantId.setText(String.valueOf(listRestaurants.get(position).getId()));
        restaurantVille.setText(listRestaurants.get(position).getNom());
        restaurantAdresse.setText(listRestaurants.get(position).getAdresse());
        //On retourne l'item cree.
        return layoutItem;
    }
}
