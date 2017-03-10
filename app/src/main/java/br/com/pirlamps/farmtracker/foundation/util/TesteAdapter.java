package br.com.pirlamps.farmtracker.foundation.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import br.com.pirlamps.farmtracker.R;

/**
 * Created by root-matheus on 06/02/17.
 */

public class TesteAdapter extends BaseAdapter {

    private int number;
    private Context context;

    public TesteAdapter(Context context) {
        this.context = context;
    }

    public void setData(int number){
        this.number = number;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return number;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_current_culture,parent,false);
        return view ;
    }
}
