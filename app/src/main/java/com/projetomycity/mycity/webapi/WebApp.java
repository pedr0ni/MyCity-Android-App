package com.projetomycity.mycity.webapi;

/**
 * Created by PEDRONI on 09/08/2017.
 */

public class WebApp {

    public static String CORE_URL = "http://api.projetomycity.com/";

    public static String INIT_URL = CORE_URL + "android?key=HXW2GCZRII21S5YB7F";

    public static String getURL(String param) {
        return CORE_URL + "android/" + param + "&key=HXW2GCZRII21S5YB7F";
    }

}
