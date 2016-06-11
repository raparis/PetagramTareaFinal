package com.rapariscode.petgram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rapariscode.petgram.R;
import com.rapariscode.petgram.db.ConstructorMascotas;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 21/05/16.
 */
public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity ) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_perfil_mascotas, parent, false );
        return new MascotaViewHolder( v );
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get( position );
        holder.tvNombreMascota.setText( mascota.getNombreMascota() );
        holder.imgFoto.setImageResource( mascota.getFoto() );
        ConstructorMascotas constructorMascotas = new ConstructorMascotas( activity );
        holder.tvEstrellas.setText( String.valueOf(constructorMascotas.obtenerLikesMascota( mascota )));

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

        public MascotaViewHolder(View itemView) {
            super(itemView);
            tvNombreMascota = (TextView) itemView.findViewById( R.id.tvNombreMascotaPerfil );
            imgFoto = (ImageView) itemView.findViewById( R.id.imgFotoPerfil );
            tvEstrellas = (TextView) itemView.findViewById( R.id.tvEstrellasPerfil );
        }
    }


}
