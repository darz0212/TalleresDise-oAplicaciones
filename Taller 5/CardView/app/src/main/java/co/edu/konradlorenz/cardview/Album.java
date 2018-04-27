package co.edu.konradlorenz.cardview;

    import android.os.Parcel;
    import android.os.Parcelable;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Album implements Parcelable {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    protected Album(Parcel in) {
        name = in.readString();
        numOfSongs = in.readInt();
        thumbnail = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(numOfSongs);
        dest.writeInt(thumbnail);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {

        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}