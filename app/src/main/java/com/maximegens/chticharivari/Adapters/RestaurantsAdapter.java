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
     * Permet de retourner le restaurant à la position passé en paramétre.
     * @param position La position de l'objet demandé.
     * @return Un ChtiCharivari correspond à la position demandée.
     */
    @Override
    public Object getItem(int position) {
        return this.listRestaurants.get(position);
    }

    /**
     * Permet de retourner l'id du restaurant à la position passé en paramétre.
     * @param position La position de l'objet demandé.
     * @return L'id du ChtiCharivari correspond à la position demandée.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Défini et construis la vue pour chaque items.
     * @param position la position de l'item dans la liste.
     * @param convertView La vue a convertir.
     * @param parent Le parents.
     * @return La vue associée avec les valeurs.
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
        TextView restaurantVille = (TextView)layoutItem.findViewById(R.id.restaurant_ville);

        //(3) : Renseignement des valeurs
        restaurantId.setText(listRestaurants.get(position).getId());
        restaurantVille.setText(listRestaurants.get(position).getVille());

        //On retourne l'item cree.
        return layoutItem;
    }
}
