package com.example.lenovo.newsreaderapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    List<Article> arrayList = new ArrayList<>();
    Context context;

    public NewsAdapter(List<Article> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Article model = arrayList.get(position);

         holder.source.setText(model.getSource().getName());
        holder.author.setText(model.getAuthor());
        holder.title.setText(model.getTitle());

        holder.description.setText(model.getDescription());
        holder.content.setText(model.getContent());
        Picasso.get().load(model.urlToImage).into(holder.imageView);

        Log.e("title", model.getTitle());
        Log.e("description", model.getDescription());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.url));

                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView source, author, title, description, content;
        View view;
        CircleImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.headlinetitle);
            imageView = itemView.findViewById(R.id.imageview);
            source = itemView.findViewById(R.id.headlinesource);
            author = itemView.findViewById(R.id.headlineauthor);
            content = itemView.findViewById(R.id.headlinecontent);
            description = itemView.findViewById(R.id.headlinedescription);


        }
    }

}
