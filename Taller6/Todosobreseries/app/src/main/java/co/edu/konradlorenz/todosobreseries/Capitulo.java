package co.edu.konradlorenz.todosobreseries;

import android.os.Parcel;
import android.os.Parcelable;

public class Capitulo implements Parcelable {
    private String nombre;
    private String descripción;
    private float numeroCapitulo;

    public Capitulo(){

    }

    public Capitulo(String nombre, float numeroCapitulo, String descripción){
        this.nombre = nombre;
        this.numeroCapitulo = numeroCapitulo;
        this.descripción = descripción;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNumeroCapitulo() {
        return numeroCapitulo;
    }

    public void setNumeroCapitulo(float numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    protected Capitulo(Parcel in) {
        nombre = in.readString();
        numeroCapitulo = in.readFloat();
        descripción = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeFloat(numeroCapitulo);
        dest.writeString(descripción);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Capitulo> CREATOR = new Parcelable.Creator<Capitulo>() {
        @Override
        public Capitulo createFromParcel(Parcel in) {
            return new Capitulo(in);
        }

        @Override
        public Capitulo[] newArray(int size) {
            return new Capitulo[size];
        }
    };
}