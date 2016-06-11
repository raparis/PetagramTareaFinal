package com.rapariscode.petgram.fragments;

import com.rapariscode.petgram.adapter.MascotaPerfilAdaptador;
import com.rapariscode.petgram.pojo.Mascota;
import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public interface IPerfilMascotaFragmentInterface {
    public void generarLinearLayoutVertical();
    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV( MascotaPerfilAdaptador adaptador);
}
