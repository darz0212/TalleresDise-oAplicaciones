package co.edu.konradlorenz.todosobreseries;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class CapitulosAdapter extends RecyclerView.Adapter<CapitulosAdapter.MyViewHolder> {

    private Context mContext;
    private List<Capitulo> capitulosList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView numero;
        public TextView nombre;
        private View elementView;

        public MyViewHolder(View view) {
            super(view);
            numero = (TextView) view.findViewById(R.id.chapter_number);
            nombre = (TextView) view.findViewById(R.id.champter_name);
            elementView = view;
        }
    }

    public CapitulosAdapter(Context mContext, List<Capitulo> capitulosList) {
        this.mContext = mContext;
        this.capitulosList = capitulosList;
    }

    @NonNull
    @Override
    public CapitulosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.capitulo_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CapitulosAdapter.MyViewHolder holder, int position) {
        final Capitulo capitulo = capitulosList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"Capítulo: "+capitulo.getNombre(),Toast.LENGTH_SHORT).show();
                holder.numero.setText(capitulo.getNumeroCapitulo()+". "+capitulo.getNombre()+":  \n"+capitulo.getDescripción()+" "+capitulo.getNumeroCapitulo());
            }
        });
        holder.numero.setText(capitulo.getNumeroCapitulo()+". "+capitulo.getNombre());
        //holder.nombre.setText(capitulo.getNombre());


        //Glide.with(mContext).load(serie.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return capitulosList.size();
    }

}
