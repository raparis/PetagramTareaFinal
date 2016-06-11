package com.rapariscode.petgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rapariscode.petgram.activities.IFavoritos;
import com.rapariscode.petgram.adapter.MascotaAdaptador;
import com.rapariscode.petgram.db.BaseDatos;
import com.rapariscode.petgram.pojo.Mascota;
import java.util.ArrayList;


public class ActivityFavoritos extends AppCompatActivity implements IFavoritos {

    private RecyclerView listadoMascotas;
    ArrayList<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        BaseDatos db = new BaseDatos( this );
        mascotas = new ArrayList<Mascota>();
        mascotas = db.obtenerTodasLasMascotas();

        listadoMascotas = (RecyclerView) findViewById( R.id.recyclerViewMascotas );
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager( llm );

        MascotaAdaptador adaptador = new MascotaAdaptador( mascotas, this);
        listadoMascotas.setAdapter( adaptador );

    }

    public void addStar( View v ) {
        //Toast.makeText( this, R.string.mensaje_add_stars, Toast.LENGTH_LONG).show();
    }

    public void getBack( View v ) {
        finish();
    }

    @Override
    public void generarLinearLayoutVertical() {
        listadoMascotas = (RecyclerView) findViewById( R.id.recyclerViewMascotas );
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager( llm );
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador( mascotas, this );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listadoMascotas.setAdapter( adaptador );
    }
}
