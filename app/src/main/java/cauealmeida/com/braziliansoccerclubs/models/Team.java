package cauealmeida.com.braziliansoccerclubs.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cauealmeida on 11/22/16.
 */

public class Team implements Parcelable {

    @SerializedName("nome")
    private String name;
    @SerializedName("estado")
    private String state;
    @SerializedName("escudo")
    private String logo;
    @SerializedName("anoFundacao")
    private int birth;

    // Because we have to return a new Team
    protected Team (Parcel p) {
        name = p.readString();
        state = p.readString();
        logo = p.readString();
        birth = p.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(logo);
        dest.writeInt(birth);
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
