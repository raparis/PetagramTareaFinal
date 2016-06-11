package com.rapariscode.petgram.fragments;

import com.rapariscode.petgram.adapter.MascotaAdaptador;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public interface IRecyclerViewFragmentInterface {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV( MascotaAdaptador adaptador);

}
