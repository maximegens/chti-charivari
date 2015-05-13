package com.maximegens.chticharivari;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.maximegens.chticharivari.beans.LesRestaurantsChti;
import com.maximegens.chticharivari.beans.RestaurantChti;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (restaurant != null) {
            ((TextView) rootView.findViewById(R.id.restaurant_detail_id)).setText(String.valueOf(restaurant.getId()));
            ((TextView) rootView.findViewById(R.id.restaurant_detail_ville)).setText(restaurant.getNom());
        }

        return rootView;
    }
}
