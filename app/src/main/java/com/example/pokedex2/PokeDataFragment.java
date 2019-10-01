package com.example.pokedex2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PokeDataFragment extends Fragment {
    Pokemon pokemon;


    @NonNull
    public static PokeDataFragment newInstance() {
        return new PokeDataFragment(); }

    /*
    The onCreateView method is called when Fragment should create its View object hierarchy,
    either dynamically or via XML layout inflation.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // define the xml file for the fragment


//        String scoreString = Integer.toString(score);
//            tv1.setText("Score:" + scoreString);
        //pokemon =(Pokemon)getArguments().getSerializable("poke");
        System.out.println("pokemon name: "+ pokemon.Name);
        return inflater.inflate(R.layout.poke_data_fragment, container, false);
    }

//    protected void displayReceivedData(Pokemon receivedObject)
//    {
//        pokemon = receivedObject;
//    }


    // this is triggered soon after onCreateView() specifically when host activity has completed `onCreate()`, and any view setup should be done here
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Sample data for us to populate the RecyclerView with
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 42; i > 0; i -= 1) {
            data.add(i);
            //the data that will go inside of the rowview view.
        }

        // Setting up the RecyclerView
        RecyclerView recycler = getView().findViewById(R.id.recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);
        RecyclerView.Adapter adapter = new Adapter(getContext(), utils.pokemonArray);
        recycler.setAdapter(adapter);
    }
}
