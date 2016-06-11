package com.rapariscode.petgram.activities;

import com.rapariscode.petgram.adapter.MascotaAdaptador;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public interface IFavoritos {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV( MascotaAdaptador adaptador);

}
