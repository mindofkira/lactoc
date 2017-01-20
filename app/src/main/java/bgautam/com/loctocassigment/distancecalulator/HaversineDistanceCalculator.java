package bgautam.com.loctocassigment.distancecalulator;

import android.util.Log;

import bgautam.com.loctocassigment.entity.APICoordinateResponse;

/**
 * Created by gautam on 20/01/17.
 */
public class HaversineDistanceCalculator implements DistanceCalulator {

    private static final int R = 6371;
    public static final int DEGREE = 180;

    private static Double toRad(Double value) {
        return value * Math.PI / DEGREE;
    }

    @Override
    public Double getDistance(APICoordinateResponse firstCoordinate, APICoordinateResponse secondCoordinate) {

        Log.d("Coordinate 1 ", firstCoordinate.toString());
        Log.d("Coordinate 2 ", secondCoordinate.toString());


        Double lat1 = Double.parseDouble(firstCoordinate.getLatitude());
        Double lon1 = Double.parseDouble(firstCoordinate.getLongitude());
        Double lat2 = Double.parseDouble(secondCoordinate.getLatitude());
        Double lon2 = Double.parseDouble(secondCoordinate.getLongitude());

        Double latDistance = toRad(lat2 - lat1);
        Double lonDistance = toRad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = R * c;

        Log.d("Distance : ", distance.toString());

        return distance;

    }

}
