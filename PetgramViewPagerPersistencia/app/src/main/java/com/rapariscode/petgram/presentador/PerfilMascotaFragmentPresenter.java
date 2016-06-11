package com.rapariscode.petgram.presentador;

import android.content.Context;

import com.rapariscode.petgram.db.ConstructorMascotas;
import com.rapariscode.petgram.fragments.IPerfilMascotaFragmentInterface;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {

    private IPerfilMascotaFragmentInterface iPerfilMascotaFragmentInterface;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public PerfilMascotaFragmentPresenter(IPerfilMascotaFragmentInterface iPerfilMascotaFragmentInterface, Context context) {
        this.iPerfilMascotaFragmentInterface = iPerfilMascotaFragmentInterface;
        this.context = context;
        obtenerMascotasBaseDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas( context );
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilMascotaFragmentInterface.inicializarAdaptadorRV(iPerfilMascotaFragmentInterface.crearAdaptador( mascotas ));
        iPerfilMascotaFragmentInterface.generarLinearLayoutVertical();

    }
}
