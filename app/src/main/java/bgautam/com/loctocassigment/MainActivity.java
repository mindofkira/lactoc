package bgautam.com.loctocassigment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import bgautam.com.loctocassigment.network.API;
import bgautam.com.loctocassigment.network.APICoordinateRequest;
import bgautam.com.loctocassigment.network.APICoordinateResponse;
import bgautam.com.loctocassigment.network.APIKeyRequest;
import bgautam.com.loctocassigment.network.APIKeyResponse;
import bgautam.com.loctocassigment.network.InterfaceAPI;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button getDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        initializeListeners();
    }


    private class getDistanaceAsync extends AsyncTask<Void, Void, Double> {

        private ProgressDialog pd = null;
        private String permanentKey;

        @Override
        protected void onPostExecute(Double result) {
            super.onPostExecute(result);
            pd.dismiss();
            if(result==null) {
                Toast.makeText(MainActivity.this.getBaseContext(),"Error while computing the distance",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this.getBaseContext(), "Distance in KMS : "+result, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected Double doInBackground(Void... params) {

            final InterfaceAPI service = new API().getInstance();

            APIKeyRequest req = new APIKeyRequest();
            req.setTempKey("oVQST5D6NT");

            APICoordinateResponse coordinateResponse1;
            APICoordinateResponse coordinateResponse2;


            Call<APIKeyResponse> responseCall = service.getKey(req);


            try {
                permanentKey = responseCall.execute().body().getPermKey();
            } catch (Exception exception){
               return null;
            }

            APICoordinateRequest apiCoordinateRequest = new APICoordinateRequest();
            apiCoordinateRequest.setPermKey(permanentKey);

            Call<APICoordinateResponse> coordinateResponseCall1 =  service.getCoordinates(apiCoordinateRequest);
            Call<APICoordinateResponse> coordinateResponseCall2 =  service.getCoordinates(apiCoordinateRequest);

            try {
                coordinateResponse1 = coordinateResponseCall1.execute().body();
            } catch (IOException e) {
                return null;
            }

            try {
                coordinateResponse2 = coordinateResponseCall2.execute().body();
            } catch (IOException e) {
                return null;
            }

            HaversineDistanceCalculator haversineDistanceCalculator = new HaversineDistanceCalculator();

            return  haversineDistanceCalculator.getDistance(coordinateResponse1,coordinateResponse2);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Getting Distance");
            pd.setTitle("Progress Dialog");
            pd.setCancelable(false);
            pd.show();

        }



    }



    private void initializeView() {
        getDistance = (Button) findViewById(R.id.get_distance_button);
    }

    private void initializeListeners() {
        getDistance.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        new getDistanaceAsync().execute();
    }
}
