package service;

import android.util.Log;

/**
 * Created by mak on 4/6/18.
 */

public class MainServiceImpl implements MainService {

    private String serviceEndpointUrl = "";

    public MainServiceImpl(String url) {
        this.serviceEndpointUrl = url;
    }

    @Override
    public Greeting getGreeting() {
        try {
            Greeting greeting = new GreetingsServiceRequestTask(this.serviceEndpointUrl).execute().get();
            if (greeting == null) {
                return Greeting.getDefault();
            }
            return greeting;
        } catch (Exception e) {
            Log.e("Service Exception", e.getMessage(), e);
        }
        return Greeting.getDefault();
    }
}
