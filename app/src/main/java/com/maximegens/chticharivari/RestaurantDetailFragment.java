package com.maximegens.chticharivari;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.maximegens.chticharivari.beans.LesRestaurantsChti;
import com.maximegens.chticharivari.beans.RestaurantChti;
import com.maximegens.chticharivari.utils.Constantes;

import org.w3c.dom.Text;

/**
 * A fragment representing a single Restaurant detail screen.
 * This fragment is either contained in a {@link RestaurantListActivity}
 * in two-pane mode (on tablets) or a {@link RestaurantDetailActivity}
 * on handsets.
 */
public class RestaurantDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private LesRestaurantsChti lesRestaurantsChti;
    private RestaurantChti restaurant;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LesRestaurantsChti lesRestaurantsChti = new LesRestaurantsChti();
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider
            restaurant = getArguments().getParcelable(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        TextView nomRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_ville);
        TextView adresseRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_adresse);
        TextView horaireRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_horaire);
        TextView nbPlacesRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_nb_place);
        TextView terrasseRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_terrasse);
        TextView infoComplementairesRestaurant = (TextView) rootView.findViewById(R.id.restaurant_detail_infos_complementaires);
        ImageView logoWifi = (ImageView) rootView.findViewById(R.id.restaurant_detail_logo_wifi);
        ImageView logoAccesHandicapee =(ImageView) rootView.findViewById(R.id.restaurant_detail_logo_acces_handicapes);
        ImageView logoParking = (ImageView) rootView.findViewById(R.id.restaurant_detail_logo_parking);
        ImageView imgRestaurant = (ImageView) rootView.findViewById(R.id.imageView_detail_restaurant);
        TextView service = (TextView) rootView.findViewById(R.id.restaurant_detail_services);
        TextView informations = (TextView) rootView.findViewById(R.id.info_detail);
        Button itineraireButton = (Button) rootView.findViewById(R.id.button_detail_itineraire);
        Button appelButton = (Button) rootView.findViewById(R.id.button_detail_appel);
        Button reserverButton = (Button) rootView.findViewById(R.id.button_detail_reserver);
        boolean existeService = false;
        boolean existeInformations = false;

        //On masque les informations
        nbPlacesRestaurant.setVisibility(View.GONE);
        terrasseRestaurant.setVisibility(View.GONE);
        infoComplementairesRestaurant.setVisibility(View.GONE);
        informations.setVisibility(View.GONE);

        //Gestion des services - On masque les logo.
        logoWifi.setVisibility(View.GONE);
        logoAccesHandicapee.setVisibility(View.GONE);
        logoParking.setVisibility(View.GONE);
        service.setVisibility(View.GONE);

        // Si le restaurant existe on rempli les informations dans le details du restaurants.
        if (restaurant != null) {
            nomRestaurant.setText(restaurant.getNom());
            adresseRestaurant.setText(restaurant.getAdresse());
            horaireRestaurant.setText(restaurant.getOuverture());

            //On affiche les informations si le restaurants en possede.
            if(restaurant.getNb_place() != null && !restaurant.getNb_place().equals(Constantes.NULL) && !restaurant.getNb_place().isEmpty()){
                nbPlacesRestaurant.setText(restaurant.getNb_place() + Constantes.PLACES);
                nbPlacesRestaurant.setVisibility(View.VISIBLE);
                existeInformations = true;
            }
            if(restaurant.getTerrasse() != null && !restaurant.getTerrasse().equals(Constantes.NULL) && !restaurant.getTerrasse().isEmpty()){
                terrasseRestaurant.setText(restaurant.getTerrasse());
                terrasseRestaurant.setVisibility(View.VISIBLE);
                existeInformations = true;
            }
            if(restaurant.getInfos_complementaires() != null && !restaurant.getInfos_complementaires().equals(Constantes.NULL) && !restaurant.getInfos_complementaires().isEmpty()){
                infoComplementairesRestaurant.setText(restaurant.getInfos_complementaires());
                infoComplementairesRestaurant.setVisibility(View.VISIBLE);
                existeInformations = true;
            }
            if(existeInformations){
                informations.setVisibility(View.VISIBLE);
            }

            //On affiche l'image du restaurant
            String uri = restaurant.getUrl_local();
            int imageResource = getResources().getIdentifier(uri, "drawable", getActivity().getApplicationContext().getPackageName());
            imgRestaurant.setImageResource(imageResource);

            //On affiche les logos si le restaurants en possede.
            if(restaurant.getWifi().equals(Constantes.TRUE)){
                logoWifi.setVisibility(View.VISIBLE);
                existeService = true;
            }
            if(restaurant.getAcces_handicapes().equals(Constantes.TRUE)){
                logoAccesHandicapee.setVisibility(View.VISIBLE);
                existeService = true;
            }
            if(restaurant.getParking().equals(Constantes.TRUE)){
                logoParking.setVisibility(View.VISIBLE);
                existeService = true;
            }
            if(existeService){
                service.setVisibility(View.VISIBLE);
            }
        }

        //On affecte les actions aux boutons itineraire, appel , reserver.
        appelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Appeler le Ch'ti Charivari");
                alertDialogBuilder
                        .setMessage("Voulez vous appeler le Ch'ti Charivari de "+restaurant.getNom()+" ("+restaurant.getTelephone()+") ?")
                        .setCancelable(false)
                        .setPositiveButton("Appeler",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + restaurant.getTelephone()));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        itineraireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        reserverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return rootView;
    }
}
