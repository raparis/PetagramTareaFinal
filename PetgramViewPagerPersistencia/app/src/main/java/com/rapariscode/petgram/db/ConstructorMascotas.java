package com.rapariscode.petgram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.rapariscode.petgram.R;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public class ConstructorMascotas {
    private static final Integer ESTRELLA = 1;
    private static final byte LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        BaseDatos db = new BaseDatos( context );
        // insertarCincoMascotas( db );
        return db.obtenerTodasLasMascotas();

    }

    public void insertarCincoMascotas ( BaseDatos db ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Jacky");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota01);

        db.insertarMascota( contentValues );

        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Duquesa");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota02);

        db.insertarMascota( contentValues );

        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Kiddo");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota03);

        db.insertarMascota( contentValues );

        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Snoopy");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota04);

        db.insertarMascota( contentValues );

        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "TopCat");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.mascota05);

        db.insertarMascota( contentValues );
    }

    public void agregarEstrellas( Mascota mascota ) {
        BaseDatos db = new BaseDatos( context );
        int curEstrella = mascota.getEstrellas();
        ContentValues contentValues = new ContentValues();
        contentValues.put( ConstantesBD.TABLE_MASCOTA_ID, mascota.getId());
        //contentValues.put( ConstantesBD.TABLE_MASCOTA_ESTRELLAS, curEstrella);
        db.agregarEstrellas( contentValues );

    }

    public void darLikeMascota( Mascota mascota ) {
        BaseDatos db = new BaseDatos( context );
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_EST_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_EST_ESTRELLAS, LIKE);
        db.insertarEstrellas( contentValues );
    }

    public int obtenerLikesMascota ( Mascota mascota ) {
        BaseDatos db = new BaseDatos( context );
        return db.obtenerLikesMascota( mascota );
    }
}
