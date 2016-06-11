package com.rapariscode.petgram.pojo;

/**
 * Created by root on 21/05/16.
 */
public class Mascota {
    private int id;
    private String nombreMascota;
    private int foto;
    private int estrellas;

    public Mascota(String nombreMascota, int foto, int estrellas ) {
        this.nombreMascota = nombreMascota;
        this.foto = foto;
        this.estrellas = estrellas;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getEstrellasString () {
        return "" + estrellas;
    }

    public void addStar() {
        estrellas += 1;
    }
}
