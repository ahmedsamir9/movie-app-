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
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.Movie.MovieDetails;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

/**
 * Created by Abdo GHazi
 */
public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieAdapter.ViewHolder>  {

    private Context context;
    private List<ResultsMovieItem> data;

    public SearchMovieAdapter(List<ResultsMovieItem> data, Context context) {
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
        ResultsMovieItem item = data.get(position);
        String img="";
                if (item.getBackdropPath() != null) img =String.valueOf( item.getBackdropPath());
                else img =String.valueOf( item.getPosterPath());
        holder.tv_search_item_name.setText(item.getTitle());
        holder.tv_search_item_type.setText(" "+item.getReleaseDate().substring(0, 4));
        holder.tv_search_item_rate.setText(String.valueOf(item.getVoteAverage()));
        Glide.with(holder.itemView)
                .load(IMAGEBASEURL+img)
                .into(holder.img_search_item);
        holder.layout_view_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("id",item.getId());
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



