package com.rapariscode.petgram.presentador;

import android.content.Context;

import com.rapariscode.petgram.activities.IFavoritos;
import com.rapariscode.petgram.db.ConstructorMascotas;
import com.rapariscode.petgram.fragments.IRecyclerViewFragmentInterface;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public class FavoritosPresenter implements IFavoritosPresenter {

    private IRecyclerViewFragmentInterface iRecyclerViewFragmentInterface;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FavoritosPresenter(Context context) {
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas( context );
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentInterface.inicializarAdaptadorRV( iRecyclerViewFragmentInterface.crearAdaptador( mascotas ));
        iRecyclerViewFragmentInterface.generarLinearLayoutVertical();
    }
}
