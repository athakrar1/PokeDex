package com.example.pokedex2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

// Bare skeleton for a fragment
public class OtherFragment extends Fragment {

    ArrayList<String> attributes = new ArrayList<String>();
    ArrayList<Pokemon> pokeData = new ArrayList<Pokemon>();

    @NonNull
    public static OtherFragment newInstance() {
        return new OtherFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other, container, false);


        Button bug = (Button) view.findViewById(R.id.bug);
        bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("bug");

            }
        });

        Button dark = (Button) view.findViewById(R.id.dark);
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("dark");

            }
        });

        Button dragon = (Button) view.findViewById(R.id.dragon);
        dragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("dragon");

            }
        });

        Button electric = (Button) view.findViewById(R.id.electric);
        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("electric");

            }
        });

        Button fairy = (Button) view.findViewById(R.id.fairy);
        fairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("fairy");

            }
        });

        Button fighting = (Button) view.findViewById(R.id.fighting);
        fighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("fighting");

            }
        });

        Button fire = (Button) view.findViewById(R.id.fire);
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("fire");

            }
        });

        Button flying = (Button) view.findViewById(R.id.flying);
        flying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("flying");

            }
        });

        Button ghost = (Button) view.findViewById(R.id.ghost);
        ghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("ghost");

            }
        });

        Button grass = (Button) view.findViewById(R.id.grass);
        grass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("grass");

            }
        });

        Button ground = (Button) view.findViewById(R.id.ground);
        ground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributes.add("ground");

            }
        });


        Button enter = (Button) view.findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(attributes);
                pokeData = populateArray(attributes);
                System.out.println("pokedata" + pokeData);

                pokeData.clear();


                //switch to new screen

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    ///THIS ARRAY ISN'T POPULATING FOR SHIT, something is up!
    public ArrayList<Pokemon> populateArray(ArrayList<String> attributes) {
        //this function returns an arraylist of all the pokemon that adhere to the rules.


        ArrayList<Pokemon> adherentPokemon = new ArrayList<Pokemon>();
        for (int i = 0; i < utils.pokemonArray.size(); i++) {
            int value = 1;
            Pokemon currentPokemon = utils.pokemonArray.get(i);

                for (String el : attributes) {
                    if(currentPokemon.Type.contains(el)){
                        value = 1;
                    }
                    else{
                        value = 0;
                    }
                }

            if (value == 1) {
                adherentPokemon.add(currentPokemon);
            }
        }
        return adherentPokemon;
    }
}