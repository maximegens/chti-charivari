package com.maximegens.chticharivari;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.maximegens.chticharivari.adapters.RestaurantsAdapter;
import com.maximegens.chticharivari.beans.LesRestaurantsChti;
import com.maximegens.chticharivari.beans.RestaurantChti;
import com.maximegens.chticharivari.utils.Constantes;
import com.maximegens.chticharivari.utils.Json;

/**
 * A list fragment representing a list of LesRestaurants. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link RestaurantDetailFragment}.
 * <p/>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class RestaurantListFragment extends ListFragment {

    LesRestaurantsChti restaurants;
    RestaurantsAdapter adapter;
    boolean isconnected = false;
    String json;
    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        void onItemSelected(RestaurantChti item);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(RestaurantChti item) {
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On verifie si la connexion internet est activée ou non
        //isconnected = Connection.isConnectedInternet(getActivity());

        if(isconnected){
            //on recupere la liste des restaurants en ligne
            //on met a jour le fichier local.
            Toast.makeText(getActivity().getApplicationContext(),"Connexion internet ok", Toast.LENGTH_SHORT).show();

        }else{
            //on recupere la liste dans le fichier local
            json = Json.getJsonFromAssets(getActivity().getAssets(), Constantes.LOCAL_JSON_RESTAURANTS_CHTI_CHARIVARI);
            restaurants = new Gson().fromJson(json, LesRestaurantsChti.class);
        }

        //Création et initialisation de l'Adapter pour les personnes
        adapter = new RestaurantsAdapter(getActivity(), restaurants.restaurants);
        setListAdapter(adapter);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        RestaurantChti item = (RestaurantChti) getListAdapter().getItem(position);
        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        if(restaurants != null) {
            mCallbacks.onItemSelected(item);
        }else{
            Toast.makeText(getActivity(),"Erreur, la liste des restaurants est null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
}
