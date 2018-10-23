package com.example.lenovo.newsreaderapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.newsreaderapp.HeadLinesActivity;
import com.example.lenovo.newsreaderapp.R;
import com.example.lenovo.newsreaderapp.model.Article;
import com.example.lenovo.newsreaderapp.model.Source;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    List<Source> arrayList = new ArrayList<>();
    Context context;


    public adapter(List<Source> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.source_itemview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Source model = arrayList.get(i);

        myViewHolder.name.setText(model.getName());

        myViewHolder.category.setText(model.getCateogry());

        myViewHolder.description.setText(model.getDescription());

        myViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, HeadLinesActivity.class);
                intent.putExtra("source", model.getId());
                intent.putExtra("name",model.getName());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView name, category, title, description, content;
        View view;
        CircleImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            imageView = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.source_name);
            category = itemView.findViewById(R.id.source_category);
            description = itemView.findViewById(R.id.source_description);


        }
    }

}

