package com.example.movieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.CastItem;
import com.example.movieapp.R;
import com.jackandphantom.circularimageview.CircleImage;

import java.util.List;

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
        if(item.getProfilePath()!=null)
            Glide.with(holder.itemView)
                    .load(IMAGEBASEURL+item.getProfilePath())
                    .into(holder.img_actor_card);
        else
        holder.img_actor_card.setImageDrawable(context.getResources().getDrawable(R.drawable.actor));

        holder.img_actor_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onClickmovie.onClickOnMovie(item);
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

    public void setOnClickmovie(OnClickLisnterr onClickmovie) {
        this.onClickmovie = onClickmovie;
    }

    private OnClickLisnterr onClickmovie;

    public interface OnClickLisnterr{
        public void onClickOnMovie(CastItem Actor);
    }
}
