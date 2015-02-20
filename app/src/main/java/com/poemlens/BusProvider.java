package com.poemlens;

import com.squareup.otto.Bus;

/**
 * Created by Corey on 2/7/15.
 */
public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getBus() {
        return BUS;
    }


}
