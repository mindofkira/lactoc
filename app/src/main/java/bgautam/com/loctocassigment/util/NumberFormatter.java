package bgautam.com.loctocassigment.util;

import java.text.DecimalFormat;

/**
 * Created by gautam on 20/01/17.
 */
public class NumberFormatter {

    public static String convertDoubleToTwoDecimals(Double input) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatted = df.format(input);
        return formatted;
    }

}
