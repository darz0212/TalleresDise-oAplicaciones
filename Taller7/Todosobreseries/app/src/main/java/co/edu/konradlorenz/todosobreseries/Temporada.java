package co.edu.konradlorenz.todosobreseries;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

public class Temporada implements Parcelable {
    private ArrayList<Capitulo> capituloList;
    private String nombre;
    private int numeroCapitulos;

    public Temporada(){

    }

    public Temporada(ArrayList<Capitulo> capituloList, String nombre){
        this.capituloList = capituloList;
        this.nombre = nombre;
        this.numeroCapitulos = capituloList.size();
    }

    public List<Capitulo> getCapituloList() {
        return capituloList;
    }

    public void setCapituloList(ArrayList<Capitulo> capituloList) {
        this.capituloList = capituloList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    public void setNumeroCapitulos(int numeroCapitulos) {
        this.numeroCapitulos = numeroCapitulos;
    }

    protected Temporada(Parcel in) {
        if (in.readByte() == 0x01) {
            capituloList = new ArrayList<Capitulo>();
            in.readList(capituloList, Capitulo.class.getClassLoader());
        } else {
            capituloList = null;
        }
        nombre = in.readString();
        numeroCapitulos = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (capituloList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(capituloList);
        }
        dest.writeString(nombre);
        dest.writeInt(numeroCapitulos);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Temporada> CREATOR = new Parcelable.Creator<Temporada>() {
        @Override
        public Temporada createFromParcel(Parcel in) {
            return new Temporada(in);
        }

        @Override
        public Temporada[] newArray(int size) {
            return new Temporada[size];
        }
    };
}