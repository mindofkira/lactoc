package bgautam.com.loctocassigment.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gautam on 20/01/17.
 */
public class APICoordinateRequest {

    @SerializedName("permKey")
    private String permKey;

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
    }

    @Override
    public String toString() {
        return "APICoordinateRequest{" +
                "permKey='" + permKey + '\'' +
                '}';
    }
}
