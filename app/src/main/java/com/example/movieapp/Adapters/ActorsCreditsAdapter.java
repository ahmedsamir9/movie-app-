package com.example.movieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.CrewItemMoviee;
import com.example.movieapp.R;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class ActorsCreditsAdapter extends RecyclerView.Adapter<ActorsCreditsAdapter.ViewHolder> {

    private List<CrewItemMoviee> data;

Context context;
    private OnClickLisnterr onClickmovie;
    public ActorsCreditsAdapter(List<CrewItemMoviee> data, Context context) {
        this.data = data;
        this.context=context;
    }

    public void setOnClickmovie(OnClickLisnterr onClickmovie) {
        this.onClickmovie = onClickmovie;
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
       CrewItemMoviee item = data.get(position);
        holder.tv_title.setText(item.getTitle());
        if(item.getPosterPath()!=null)
            Glide.with(holder.itemView)
                    .load(IMAGEBASEURL+item.getPosterPath())
                    .into(holder.img_movie);
        else if(item.getBackdropPath()!=null)

            Glide.with(holder.itemView)
                    .load(IMAGEBASEURL+item.getBackdropPath())
                    .into(holder.img_movie);
        else   holder.img_movie.setImageDrawable(context.getResources().getDrawable(R.drawable.movie));

        holder.tv_desc.setText(String.valueOf(item.getVoteAverage()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickmovie.onClickOnMovie(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(data == null)return 0;
        return data.size();
    }
    public void onChange(List<CrewItemMoviee> data){
        this.data =data;
        notifyDataSetChanged();
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
    public interface OnClickLisnterr{
        public void onClickOnMovie(CrewItemMoviee movie);
    }
}
