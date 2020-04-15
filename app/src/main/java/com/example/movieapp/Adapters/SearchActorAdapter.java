package com.example.movieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.ResultsActorItem;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.actor.Actor_screen;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

/**
 * Created by Abdo GHazi
 */
public class SearchActorAdapter extends RecyclerView.Adapter<SearchActorAdapter.ViewHolder>  {

    private Context context;
    private List<ResultsActorItem> data;

    public SearchActorAdapter(List<ResultsActorItem> data, Context context) {
        System.out.println(data.size()+"////////////////");
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_card, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        ResultsActorItem item = data.get(position);
        String img="";
        img = String.valueOf(item.getProfilePath());
        holder.tv_search_item_name.setText(item.getName());
        holder.tv_search_item_type.setText("most famous films : "+item.getKnownFor().size());
        holder.tv_search_item_rate.setText(String.valueOf(item.getPopularity()));
        Glide.with(holder.itemView)
                .load(IMAGEBASEURL+img)
                .into(holder.img_search_item);
        holder.layout_view_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Actor_screen.class);
                intent.putExtra("A-id",item.getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {

        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_search_item_name, tv_search_item_type, tv_search_item_rate;
        ConstraintLayout layout_view_search;
        RoundedImage img_search_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_search_item_rate = itemView.findViewById(R.id.tv_search_item_rate);
            layout_view_search = itemView.findViewById(R.id.layout_view_search);
            tv_search_item_name = itemView.findViewById(R.id.tv_search_item_name);
            tv_search_item_type = itemView.findViewById(R.id.tv_search_item_type);
            img_search_item = itemView.findViewById(R.id.img_search_item);
        }
    }
}



