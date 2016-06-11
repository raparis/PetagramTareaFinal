package com.rapariscode.petgram.db;

/**
 * Created by root on 11/06/16.
 */
public class ConstantesBD {
    public static final String DATABASE_NAME = "mascotasdb";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";

    public static final String TABLE_MASCOTA_EST = "mascota_estrellas";
    public static final String TABLE_MASCOTA_EST_ID = "id";
    public static final String TABLE_MASCOTA_EST_MASCOTA_ID = "mascota_id";
    public static final String TABLE_MASCOTA_EST_ESTRELLAS = "estrellas";

    public static final byte POSITION_MASCOTA_ID = 0;
    public static final byte POSITION_MASCOTA_NOMBRE = 1;
    public static final byte POSITION_MASCOTA_FOTO = 2;
}
