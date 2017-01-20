package bgautam.com.loctocassigment;

import android.util.Log;

import bgautam.com.loctocassigment.network.APICoordinateResponse;

/**
 * Created by gautam on 20/01/17.
 */
public class HaversineDistanceCalculator implements DistanceCalulator {
    @Override
    public Double getDistance(APICoordinateResponse point1, APICoordinateResponse point2) {

        Log.e("Point1 ", point1.toString());
        Log.e("Point1 ", point2.toString());

        final int R = 6371; // Radius of the earth
        Double lat1 = Double.parseDouble(point1.getLatitude());
        Double lon1 = Double.parseDouble(point1.getLongitude());
        Double lat2 = Double.parseDouble(point2.getLatitude());
        Double lon2 = Double.parseDouble(point2.getLongitude());
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        return distance;

    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

}
