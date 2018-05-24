package co.edu.konradlorenz.todosobreseries;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TemporadasAdapter extends RecyclerView.Adapter<TemporadasAdapter.MyViewHolder> {

    private Context mContext;
    private List<Temporada> temporadaList;
    public TextView numeroCapitulo, nombreCapitulo, descripcionCapitulo;
    private SerieDetailActivity serieActivity;

    Comunicador comunicador;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView numero;
        private View elementView;

        public MyViewHolder(View view) {
            super(view);
            numero = (TextView) view.findViewById(R.id.season_text);
            elementView = view;
        }
    }

    public TemporadasAdapter(Context mContext, List<Temporada> temporadaList) {
        this.mContext = mContext;
        this.temporadaList = temporadaList;
        serieActivity = new SerieDetailActivity();
    }

    @NonNull
    @Override
    public TemporadasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.temporada_card, parent, false);

        return new MyViewHolder(itemView);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animateCircularReveal(View view) {
        int centerX = 0;
        int centerY = 0;
        int startRadius = 0;
        int endRadius = Math.max(view.getWidth(), view.getHeight());
        Animator animation = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);
        view.setVisibility(View.VISIBLE);
        animation.start();
    }

    @Override
    public void onBindViewHolder(@NonNull TemporadasAdapter.MyViewHolder holder, int position) {
        final Temporada temporada = temporadaList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                animateCircularReveal(view);
            }
        });
        holder.numero.setText(temporada.getNombre());


        //Glide.with(mContext).load(serie.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return temporadaList.size();
    }


}
