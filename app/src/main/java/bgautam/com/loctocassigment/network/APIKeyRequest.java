package bgautam.com.loctocassigment.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gautam on 20/01/17.
 */
public class APIKeyRequest {

    @SerializedName("tempKey")
    private String tempKey;

    public String getTempKey() {
        return tempKey;
    }

    public void setTempKey(String tempKey) {
        this.tempKey = tempKey;
    }

    @Override
    public String toString() {
        return "APIKeyRequest{" +
                "tempKey='" + tempKey + '\'' +
                '}';
    }
}
