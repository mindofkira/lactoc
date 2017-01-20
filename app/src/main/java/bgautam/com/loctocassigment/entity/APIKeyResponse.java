package bgautam.com.loctocassigment.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gautam on 20/01/17.
 */
public class APIKeyResponse implements Serializable {

    @SerializedName("tempKey")
    private String tempKey;

    @SerializedName("permKey")
    private String permKey;

    private String timestamp;

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public String getTempKey() {
        return tempKey;
    }

    public void setTempKey(String tempKey) {
        this.tempKey = tempKey;
    }

    @Override
    public String toString() {
        return "APIKeyResponse{" +
                "tempKey='" + tempKey + '\'' +
                ", permKey='" + permKey + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
