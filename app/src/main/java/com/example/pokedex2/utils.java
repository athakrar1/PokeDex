package com.example.pokedex2;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class utils extends MainActivity {

    static ArrayList<Pokemon> pokemonArray = new ArrayList<Pokemon>();

    public static ArrayList parseJSON(Context context){
        String allPokemon = null;
        try {
            InputStream is = context.getAssets().open("pokeData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            allPokemon = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("error!!");
        }
        System.out.println("got through");

        JSONObject obj = null;
        System.out.println(allPokemon);

        try{
            obj = new JSONObject(allPokemon);
            Iterator<String> keys = (Iterator<String>) obj.keys();

            while(keys.hasNext()){
                JSONArray type;
                String pokeName = keys.next();
                System.out.println("POKE NAME IS:::" + pokeName);
                JSONObject pokemon = obj.getJSONObject(pokeName);
                ArrayList<String> types = new ArrayList<String>();

                //int hash = allPokemon.pokemon.getInteger("Attack");
                int hash = Integer.parseInt(pokemon.getString("#"));
                int attack = Integer.parseInt(pokemon.getString("Attack"));
                int defense = Integer.parseInt(pokemon.getString("Defense"));
                String flavorText = pokemon.getString("FlavorText");
                int hp = Integer.parseInt(pokemon.getString("HP"));
                int spAttack = Integer.parseInt(pokemon.getString("Sp. Atk"));
                int spDef = Integer.parseInt(pokemon.getString("Sp. Def"));
                int speed = Integer.parseInt(pokemon.getString("Speed"));
                int total = Integer.parseInt(pokemon.getString("Total"));
                type = pokemon.getJSONArray("Type");

                for(int i = 0; i < type.length(); i++){
                    String currentString;
                    currentString = type.getString(i);
                    types.add(currentString);
                }

                Pokemon pOkEmOn = new Pokemon(pokeName, hash, attack, defense, flavorText, hp, spAttack, spDef, speed, total, types);
                pokemonArray.add(pOkEmOn);
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        return pokemonArray;
    }

}
