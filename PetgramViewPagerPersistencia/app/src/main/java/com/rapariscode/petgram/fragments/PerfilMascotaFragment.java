package com.rapariscode.petgram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rapariscode.petgram.R;
import com.rapariscode.petgram.adapter.MascotaPerfilAdaptador;
import com.rapariscode.petgram.pojo.Mascota;
import com.rapariscode.petgram.presentador.IPerfilMascotaFragmentPresenter;
import com.rapariscode.petgram.presentador.PerfilMascotaFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment implements IPerfilMascotaFragmentInterface{

    private RecyclerView perfilListadoMascotas;
    private IPerfilMascotaFragmentPresenter presenter;

    public PerfilMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        perfilListadoMascotas = (RecyclerView) v.findViewById( R.id.recyclerViewPerfilMascotas );
        presenter = new PerfilMascotaFragmentPresenter( this, getContext() );
        return v;


    }

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager llm = new GridLayoutManager( getContext(), 3 );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        perfilListadoMascotas.setLayoutManager( llm );
    }

    @Override
    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador( mascotas, getActivity() );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaPerfilAdaptador adaptador) {
        perfilListadoMascotas.setAdapter( adaptador );
    }

}
