package com.rapariscode.petgram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rapariscode.petgram.R;
import com.rapariscode.petgram.adapter.MascotaAdaptador;
import com.rapariscode.petgram.pojo.Mascota;
import com.rapariscode.petgram.presentador.IRecyclerViewFragmentPresenter;
import com.rapariscode.petgram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentInterface {

    private RecyclerView listadoMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment( ) {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listadoMascotas = (RecyclerView) v.findViewById( R.id.recyclerViewMascotas );
        presenter = new RecyclerViewFragmentPresenter( this, getContext() );

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager( llm );

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas ) {
        MascotaAdaptador adaptador = new MascotaAdaptador( mascotas, getActivity() );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listadoMascotas.setAdapter( adaptador );
    }
}
