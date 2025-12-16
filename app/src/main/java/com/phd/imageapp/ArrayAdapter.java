package com.phd.imageapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phd.imageapp.ListItems;

import java.util.List;

public class ArrayAdapter extends BaseAdapter {

    private Context context;
    private List<ListItems> listItems; // Liste des objets issus de la classe ListIems (qui n'est pas une liste mais seulement
    // un objet seulement)
    private LayoutInflater inflater;
    public ArrayAdapter(Context context, List<ListItems> listItems ) { //Catalog_display_Activity catalogDisplayActivity, int simpleListItem1, Object p2) {

        this.context = context;
        this.listItems = listItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Math.min(listItems.size(), 4);
    } // un tableau de type "ListItem"

    @Override
    public ListItems getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = (View) inflater.inflate(R.layout.mobiles_models,null); // on gonfle la vue unitaire

        ListItems itemUsed  = getItem(position);
        String nomObjet = itemUsed.getMobileRef();
        int priceObjet = itemUsed.getPrice();

        ImageView Mobile = convertView.findViewById(R.id.Samsung1);
        int position_= position +1;
        String resourceFetch = "mobile_"+ position_ ;
        int resId = context.getResources().getIdentifier(resourceFetch, "drawable", context.getPackageName());
        Mobile.setImageResource(resId);


        TextView nomMobile = convertView.findViewById(R.id.mobileName);
        nomMobile.setText(nomObjet);

        TextView priceMobile = convertView.findViewById(R.id.price);
        priceMobile.setText(priceObjet + " €");

        TextView compteur = convertView.findViewById(R.id.compteur);
        compteur.setText( resourceFetch + " #");

        return convertView;
    }


}
