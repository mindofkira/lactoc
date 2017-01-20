package bgautam.com.loctocassigment.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gautam on 20/01/17.
 */
public class APICoordinateResponse implements Serializable {

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    public APICoordinateResponse() {

    }

    public APICoordinateResponse (String longitude,String latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "APICoordinateResponse{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
