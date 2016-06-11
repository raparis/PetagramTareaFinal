package com.rapariscode.petgram.adapter;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rapariscode.petgram.db.ConstructorMascotas;
import com.rapariscode.petgram.pojo.Mascota;
import com.rapariscode.petgram.R;

import java.util.ArrayList;

/**
 * Created by root on 21/05/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_mascotas, parent, false );
        return new MascotaViewHolder( v );
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get( position );
        holder.tvNombreMascota.setText( mascota.getNombreMascota() );
        holder.imgFoto.setImageResource( mascota.getFoto() );
        //holder.tvEstrellas.setText( mascota.getEstrellasString() );

        ConstructorMascotas constructorMascotas = new ConstructorMascotas( activity );
        holder.tvEstrellas.setText( String.valueOf(constructorMascotas.obtenerLikesMascota( mascota )));

        holder.imgHuesito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas( activity );
                constructorMascotas.darLikeMascota( mascota );
                holder.tvEstrellas.setText( String.valueOf(constructorMascotas.obtenerLikesMascota( mascota )));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombreMascota;
        private ImageView imgFoto;
        private TextView tvEstrellas;
        private ImageView imgHuesito;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgHuesito = (ImageView) itemView.findViewById( R.id.imgHuesoClick);
            tvNombreMascota = (TextView) itemView.findViewById( R.id.tvNombreMascota );
            imgFoto = (ImageView) itemView.findViewById( R.id.imgFoto );
            tvEstrellas = (TextView) itemView.findViewById( R.id.tvEstrellas );

        }

    }
}
