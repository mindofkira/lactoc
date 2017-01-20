package bgautam.com.loctocassigment.network;

import com.squareup.otto.Bus;

/**
 * Created by gautam on 20/01/17.
 */
public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
