package com.example.movieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.Movie.MovieDetails;
import com.github.islamkhsh.CardSliderAdapter;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class MoviesTopRatedAdapter extends CardSliderAdapter<MoviesTopRatedAdapter.ViewHolder> {

    private List<ResultsMovieItem> data;

    private Context context;
    public MoviesTopRatedAdapter(List<ResultsMovieItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.popularmovieitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void bindVH(ViewHolder holder, int i) {
        ResultsMovieItem item = data.get(i);
        if(item.getPosterPath()!=null)
            Glide.with(holder.itemView)
                    .load(IMAGEBASEURL+item.getPosterPath())
                    .into(holder.img_movie);
        else if(item.getBackdropPath()!=null)

            Glide.with(holder.itemView)
                    .load(IMAGEBASEURL+item.getBackdropPath())
                    .into(holder.img_movie);
        else   holder.img_movie.setImageDrawable(context.getResources().getDrawable(R.drawable.movie));

        holder.img_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("id",item.getId());
                context.startActivity(intent);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImage img_movie;
        ViewHolder(View itemView) {
            super(itemView);
            img_movie=itemView.findViewById(R.id.popular_movie_cover);

        }
    }
}
