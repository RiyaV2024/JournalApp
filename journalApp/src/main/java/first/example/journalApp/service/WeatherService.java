package first.example.journalApp.service;

import first.example.journalApp.api.response.WeatherResponse;
import first.example.journalApp.cache.AppCache;
import first.example.journalApp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        String cacheKey = "weather_" + city;

        WeatherResponse weatherResponse = redisService.get(cacheKey, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        } else {
            String finalAPI = appCache.App_Cache.get("weather_api")
                    .replace("<city>", city)
                    .replace("<apiKey>", apiKey);

            ResponseEntity<WeatherResponse> response =
                    restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);

            WeatherResponse body = response.getBody();
            if (body != null) {
                redisService.set(cacheKey, body, 300L);
            }
            return body;
        }
    }
}