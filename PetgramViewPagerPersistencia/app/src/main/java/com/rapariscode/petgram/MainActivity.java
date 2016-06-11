package com.rapariscode.petgram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rapariscode.petgram.adapter.PageAdapter;
import com.rapariscode.petgram.db.BaseDatos;
import com.rapariscode.petgram.db.ConstructorMascotas;
import com.rapariscode.petgram.fragments.PerfilMascotaFragment;
import com.rapariscode.petgram.fragments.RecyclerViewFragment;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar(myToolbar);
        viewPager = (ViewPager) findViewById( R.id.viewPager );
        tabLayout = (TabLayout) findViewById( R.id.tabLayout );
        setupViewPager();

    }

    public void irFavoritosActivity ( View v ) {
        Intent intent = new Intent( this, ActivityFavoritos.class );
        startActivity( intent );

    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add( new RecyclerViewFragment());
        fragments.add( new PerfilMascotaFragment());
        return fragments;
    }
    private void setupViewPager() {
        viewPager.setAdapter( new PageAdapter(getSupportFragmentManager(), agregarFragments() ) );
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon( R.drawable.dog_48);
        tabLayout.getTabAt(1).setIcon( R.drawable.dog_house_48);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate( R.menu.menu_opciones, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {
            case R.id.mAcercaDe:
                llamarAcercaDe();
                break;
            case R.id.mContacto:
                llamarContacto();
                break;
            case R.id.mAgregarDatosDummy:
                BaseDatos db = new BaseDatos( this );
                db.borrarMascotas();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas( this );
                constructorMascotas.insertarCincoMascotas( db );
                db.close();
                this.recreate();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void llamarContacto() {

        Intent intent = new Intent( this, Contacto.class );
        startActivity( intent );
    }

    public void llamarAcercaDe() {

        Intent intent = new Intent( this, AcercaDelAutor.class );
        startActivity( intent );
    }

}
