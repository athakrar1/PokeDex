package com.example.pokedex2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
* Every recycler view needs an adapter (you can reuse adapters!)
* The purpose of an adapter is literally bind our app-data to the views that are displayed within a RecyclerView object, this class will tell our recycler how to populate the "sub-views", view in each row, with our data
 */
public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> implements Filterable{

    // It is helpful to have variable for context because `this` really only works when calling stuff from within Activities
    private Context context;
    List<Pokemon> data;
    List<Pokemon> dataFull;
    private OnItemClickListener Listener;

    // Adapter construtor, whenever we make a new adapter from this class we need to pass in a context and the data that we want to bind
    Adapter(Context context, ArrayList<Pokemon> data) {
        this.context = context;
        this.data = data;
        dataFull = new ArrayList<Pokemon>(data);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            Listener = listener;

    }

    /* Pro-tip look-up @NonNull its good practice to use it!
    * Inflate the row layout from `row_view.xml` when it is needed within the view lifecycle, so we map its location in the resource directory `R.layout.row_view`
     */
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_view, viewGroup, false);
        return new CustomViewHolder(view);
    }

    // Updates the `RecyclerView.ViewHolder` contents with the item at the given position (from your data)
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.name.setText((data.get(i)).Name.toString());
    }

    // Must be overriden to explicitly tell your Recycler how much data to allocate space for (number of rows)
    @Override
    public int getItemCount() {
        return data.size();
    }

    // This describes the item view and meta data about its place within the recycler view, think of this as looking at one row and linking the relevant stuff from xml

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public Filter exampleFilter = new Filter() {
        @Override
        public FilterResults performFiltering(CharSequence constraint) {
            List<Pokemon> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Pokemon item : dataFull) {
                    if (item.Name.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        public void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            data.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pokemonName);
            image = itemView.findViewById(R.id.pokemonImage);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if (Listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);{
                            Listener.onItemClick(position);
                        }

                    }

                }
            });
        }
    }


}
