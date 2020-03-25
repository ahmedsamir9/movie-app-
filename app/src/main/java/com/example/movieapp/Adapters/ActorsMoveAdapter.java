package com.example.movieapp.Adapters;

import android.app.Activity;
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
import com.example.movieapp.Models.CastItem;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.MovieDetails;
import com.jackandphantom.circularimageview.CircleImage;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class ActorsMoveAdapter extends RecyclerView.Adapter<ActorsMoveAdapter.ViewHolder> {

    private List<CastItem> data;
    private Context context;
    public ActorsMoveAdapter(List<CastItem> data,Context context) {
        this.data = data;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.actor_view_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CastItem item = data.get(position);
        holder.tv_actor_card.setText(item.getName());
        Glide.with(holder.itemView)
                .load(IMAGEBASEURL+item.getProfilePath())
                .into(holder.img_actor_card);
        holder.img_actor_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, MovieDetails.class);//your activity
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
        TextView tv_actor_card;
        CircleImage img_actor_card;
        ViewHolder(View itemView) {
            super(itemView);
            tv_actor_card=itemView.findViewById(R.id.tv_actor_card);
            img_actor_card=itemView.findViewById(R.id.img_actor_card);

        }
    }
}
