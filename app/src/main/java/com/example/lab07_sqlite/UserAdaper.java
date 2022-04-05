package com.example.lab07_sqlite_nguyenhoanganh;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.constraintlayout.widget.ConstraintLayout;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class UserAdaper extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<User> listLanguage;
    private int positionSelect = -1;
    private Button btnDelete;

    public UserAdaper(Context context, int idLayout, List<User> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listLanguage = listLanguage;
    }

    @Override
    public int getCount() {
        if (listLanguage.size() != 0 && !listLanguage.isEmpty()) {
            return listLanguage.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.name);

        final ConstraintLayout linearLayout = (ConstraintLayout ) convertView.findViewById(R.id.idLinearLayout);
        final User language = listLanguage.get(position);

        if (listLanguage != null && !listLanguage.isEmpty()) {

            tvName.setText(language.getName());



        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.valueOf(language.getId()) , Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();


            }
        });


        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.rgb(223, 223, 222));
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}