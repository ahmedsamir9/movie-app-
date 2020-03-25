package com.example.movieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.MovieDetails;
import com.jackandphantom.circularimageview.CircleImage;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class MoviesPlayingNowAdapter extends RecyclerView.Adapter<MoviesPlayingNowAdapter.ViewHolder> {

    private List<ResultsMovieItem> data;
    private Context context;
    public MoviesPlayingNowAdapter(List<ResultsMovieItem> data, Context context) {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.movie_view_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ResultsMovieItem item = data.get(position);
        holder.tv_title.setText(item.getTitle());
        holder.tv_desc.setText(String.valueOf(item.getVoteAverage()));
        Glide.with(holder.itemView)
                .load(IMAGEBASEURL+item.getPosterPath())
                .into(holder.img_movie);
        holder.img_movie.setOnClickListener(new View.OnClickListener() {
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
        TextView tv_title,tv_desc;
        RoundedImage img_movie;
        ViewHolder(View itemView) {
            super(itemView);
            img_movie=itemView.findViewById(R.id.img_movie_card);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_desc=itemView.findViewById(R.id.tv_desc);

        }
    }
}
