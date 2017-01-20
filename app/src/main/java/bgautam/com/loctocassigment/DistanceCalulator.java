package bgautam.com.loctocassigment;

import bgautam.com.loctocassigment.network.APICoordinateResponse;

/**
 * Created by gautam on 20/01/17.
 */
public interface DistanceCalulator {

    public Double getDistance (APICoordinateResponse point1, APICoordinateResponse point2);

}
