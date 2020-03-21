package com.example.movieapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.github.islamkhsh.CardSliderAdapter;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class MoviesTopRatedAdapter extends CardSliderAdapter<MoviesTopRatedAdapter.ViewHolder> {

    private List<ResultsMovieItem> data;

    public MoviesTopRatedAdapter(List<ResultsMovieItem> data) {
        this.data = data;
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
    public void bindVH(ViewHolder viewHolder, int i) {
        ResultsMovieItem item = data.get(i);

        Glide.with(viewHolder.itemView)
                .load(IMAGEBASEURL+item.getPosterPath())
                .into(viewHolder.img_movie);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,tv_desc;
        RoundedImage img_movie;
        ViewHolder(View itemView) {
            super(itemView);
            img_movie=itemView.findViewById(R.id.popular_movie_cover);

        }
    }
}
