package co.edu.konradlorenz.todosobreseries;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

public class Serie implements Parcelable {
    private ArrayList<Temporada> temporadaList;
    private String nombre;
    private ArrayList<String> genero;
    private ArrayList<String> actores;
    private int thumbnail;

    public Serie(){

    }

    public Serie(ArrayList<Temporada> temporadaList, String nombre, ArrayList<String> genero, ArrayList<String> actores, int thumbnail) {
        this.temporadaList = temporadaList;
        this.nombre = nombre;
        this.genero = genero;
        this.actores = actores;
        this.thumbnail = thumbnail;
    }

    public ArrayList<Temporada> getTemporadaList() {
        return temporadaList;
    }

    public void setTemporadaList(ArrayList<Temporada> temporadaList) {
        this.temporadaList = temporadaList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<String> genero) {
        this.genero = genero;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    protected Serie(Parcel in) {
        if (in.readByte() == 0x01) {
            temporadaList = new ArrayList<Temporada>();
            in.readList(temporadaList, Temporada.class.getClassLoader());
        } else {
            temporadaList = null;
        }
        nombre = in.readString();
        thumbnail = in.readInt();
        if (in.readByte() == 0x01) {
            genero = new ArrayList<String>();
            in.readList(genero, String.class.getClassLoader());
        } else {
            genero = null;
        }
        if (in.readByte() == 0x01) {
            actores = new ArrayList<String>();
            in.readList(actores, String.class.getClassLoader());
        } else {
            actores = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (temporadaList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(temporadaList);
        }
        dest.writeString(nombre);
        dest.writeInt(thumbnail);
        if (genero == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genero);
        }
        if (actores == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(actores);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Serie> CREATOR = new Parcelable.Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };
}