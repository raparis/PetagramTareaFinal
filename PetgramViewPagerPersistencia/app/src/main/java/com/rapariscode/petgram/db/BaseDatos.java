package com.rapariscode.petgram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import com.rapariscode.petgram.ActivityFavoritos;
import com.rapariscode.petgram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTA);
        //db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTA_EST);

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA + "(" +
                ConstantesBD.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_MASCOTA_FOTO + " INTEGER " +
                ")";

        db.execSQL( queryCrearTablaMascota );

        String queryCrearTablaMascotaEstrellas = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA_EST + "(" +
                ConstantesBD.TABLE_MASCOTA_EST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTA_EST_MASCOTA_ID + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTA_EST_ESTRELLAS + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_MASCOTA_EST_ID + ") " +
                "REFERENCES " + ConstantesBD.TABLE_MASCOTA + "("  + ConstantesBD.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL( queryCrearTablaMascotaEstrellas );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTA_EST);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTA + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery( query, null);

        while ( registro.moveToNext() ) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId( registro.getInt( ConstantesBD.POSITION_MASCOTA_ID ));
            mascotaActual.setNombreMascota( registro.getString( ConstantesBD.POSITION_MASCOTA_NOMBRE));
            mascotaActual.setFoto( registro.getInt( ConstantesBD.POSITION_MASCOTA_FOTO));
            //mascotaActual.setEstrellas( registro.getInt( ConstantesBD.POSITION_MASCOTA_ESTRELLAS));

            mascotas.add( mascotaActual );
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert( ConstantesBD.TABLE_MASCOTA, null,contentValues);
        db.close();
    }

    public void borrarMascotas() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( ConstantesBD.TABLE_MASCOTA, null,null);
        db.close();
    }

    public void agregarEstrellas(ContentValues contentValues ) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update( ConstantesBD.TABLE_MASCOTA, contentValues,
                ConstantesBD.TABLE_MASCOTA_ID + "=" + contentValues.get(ConstantesBD.TABLE_MASCOTA_ID), null );
        db.close();

    }

    public void dbRecords(ActivityFavoritos view) {
        String query = "SELECT COUNT(*) FROM " + ConstantesBD.TABLE_MASCOTA + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registro = db.rawQuery( query, null);
        Toast.makeText(view.getBaseContext() , "Registros: " +  registro.getCount(), Toast.LENGTH_LONG ).show();
        db.close();

    }

    public void insertarEstrellas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert( ConstantesBD.TABLE_MASCOTA_EST, null, contentValues);
        db.close();

    }

    public int obtenerLikesMascota ( Mascota mascota ) {
        int likes = 0;

        String query = "SELECT COUNT("+  ConstantesBD.TABLE_MASCOTA_EST_ESTRELLAS + ") " +
                " FROM " + ConstantesBD.TABLE_MASCOTA_EST +
                " WHERE " + ConstantesBD.TABLE_MASCOTA_EST_MASCOTA_ID + "=" +
                mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery( query, null);

        if ( registros.moveToNext() ) {
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
