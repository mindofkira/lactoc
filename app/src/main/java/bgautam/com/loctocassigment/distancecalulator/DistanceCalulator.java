package bgautam.com.loctocassigment.distancecalulator;

import bgautam.com.loctocassigment.entity.APICoordinateResponse;

/**
 * Created by gautam on 20/01/17.
 */
public interface DistanceCalulator {

    public Double getDistance(APICoordinateResponse point1, APICoordinateResponse point2);

}
