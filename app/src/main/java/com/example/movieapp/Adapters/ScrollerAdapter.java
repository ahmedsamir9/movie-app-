package com.example.movieapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class ScrollerAdapter extends RecyclerView.Adapter<ScrollerAdapter.ViewHolder> {

    private List<ResultsMovieItem> data;
    private ReachEndListner reachEndListner;
    private DetailedMovieListner movieListner;
    public ScrollerAdapter(List<ResultsMovieItem> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.popularmovieitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        ResultsMovieItem item = data.get(position);
//        if (position == data.size() - 1){
//
//           reachEndListner.reachEnd();
//        }

        Glide.with(holder.itemView.getContext())
                .load(IMAGEBASEURL+data.get(position).getBackdropPath())
                .into(holder.MovieImage);
        holder.Moviename.setText(data.get(position).getTitle());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                movieListner.onclick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setReachEnd(ReachEndListner reachEnd) {
        this.reachEndListner = reachEnd;
    }

    public void setMovieListner(DetailedMovieListner movieListner) {
        this.movieListner = movieListner;
    }

    private interface ReachEndListner {
        public void reachEnd();
}
    private interface DetailedMovieListner{
        public void onclick(int pos);
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        private RoundedImage MovieImage;
        private TextView Moviename;
        public ViewHolder(View itemView) {
            super(itemView);
            MovieImage =  itemView.findViewById(R.id.popular_movie_cover);

        }
    }
}
