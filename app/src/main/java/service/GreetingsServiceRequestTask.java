package service;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mak on 4/6/18.
 */

public class GreetingsServiceRequestTask extends AsyncTask<Void, Void, Greeting> {

    private String serviceEndpoint = "";

    GreetingsServiceRequestTask(String endPoint) {
        this.serviceEndpoint = endPoint;
    }

    @Override
    protected Greeting doInBackground(Void... voids) {
        try {
            if (this.serviceEndpoint.isEmpty()) {
                Log.e("GreetingsServiceRequestTask", "Service endpoint is empty");
                return null;
            }
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(this.serviceEndpoint, Greeting.class);
        } catch (Exception e) {
            Log.e("GreetingsServiceRequestTask", e.getMessage(), e);
        }
        return null;
    }
}
