package bgautam.com.loctocassigment.api;

import bgautam.com.loctocassigment.entity.APICoordinateRequest;
import bgautam.com.loctocassigment.entity.APICoordinateResponse;
import bgautam.com.loctocassigment.entity.APIKeyRequest;
import bgautam.com.loctocassigment.entity.APIKeyResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by gautam on 20/01/17.
 */
public interface APIEndpoint {

    @POST("/getKey")
    @Headers("Content-Type: application/json")
    Call<APIKeyResponse> getKey(
            @Body APIKeyRequest request
    );

    @POST("/getCoordinates")
    @Headers("Content-Type: application/json")
    Call<APICoordinateResponse> getCoordinates(
            @Body APICoordinateRequest request
    );
}
