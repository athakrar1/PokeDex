package com.example.pokedex2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
//import android.widget.SearchView;
import android.support.v7.widget.SearchView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

// A fragment is a combination of XML and a java class, much like an Activity, this is the template of a Java Controller for a fragment
public class ListFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    ArrayList<Pokemon> pokeArray = new ArrayList<>(utils.pokemonArray);
    ArrayList<String> names = new ArrayList<>();
    //RecyclerView.Adapter adapter;
    Adapter adapter;
    static FragmentManager fm;
    //SendMessage SM;

    @NonNull
    public static ListFragment newInstance() { return new ListFragment(); }

    /*
    The onCreateView method is called when Fragment should create its View object hierarchy,
    either dynamically or via XML layout inflation.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // define the xml file for the fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // this is triggered soon after onCreateView() specifically when host activity has completed `onCreate()`, and any view setup should be done here
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Sample data for us to populate the RecyclerView with
        populateNames(utils.pokemonArray); // how to change the data coming through here?


//        for (int i = 0; i < utils.pokemonArray.size(); i ++) {
//            System.out.println(utils.pokemonArray.get(i).Name);
//            //the data that will go inside of the rowview view.
//        }


        // Setting up the RecyclerView
        RecyclerView recycler = getView().findViewById(R.id.recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);
        adapter = new Adapter(getContext(), pokeArray);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position){
                String currentPokemon = pokeArray.get(position).Name;

//                Intent i = new Intent(ListFragment.this, MainActivity.class);
//                String strName = null;
//                i.putExtra(currentPokemon, strName);
            }
//            public void onItemClick(int position) {
//                PokeDataFragment otherFrag = new PokeDataFragment();
//                Pokemon currentPokemon = pokeArray.get(position);
//
//                PokeDataFragment pokeDataFragment = new PokeDataFragment();;
////                FragmentTransaction ft=fm.beginTransaction();
////                Bundle b = new Bundle();
////                b.putParcelable("poke", currentPokemon);
////                pokeDataFragment.setArguments(b);
//                fm.beginTransaction().replace(R.id.frame, pokeDataFragment).addToBackStack("").commit();
//            }
        });
    }

//    interface SendMessage {
//        void sendData(Pokemon pokemon);
//    }

    public void populateNames(ArrayList<Pokemon> pokemon){
        for (int i = 0; i < pokemon.size(); i++) {
            System.out.println(pokemon.get(i).Name);
            names.add(pokemon.get(i).Name);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_bar, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(this);

    }
    @Override
    public boolean onQueryTextSubmit(String query){
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText){
        adapter.getFilter().filter(newText);
        return false;
    }



    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }

}
