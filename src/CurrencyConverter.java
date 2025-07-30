import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyConverter {
    private static final String API_KEY = "a1097a64da8fd800c5f69b19";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double getConversionRate(String from, String to) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + from;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ExchangeRateResponse exchangeData = gson.fromJson(response.body(), ExchangeRateResponse.class);

        Map<String, Double> rates = exchangeData.getConversion_rates();

        if (rates.containsKey(to)) {
            return rates.get(to);
        } else {
            throw new IllegalArgumentException("Moneda no soportada: " + to);
        }
    }

    public double convert(String from, String to, double amount) throws Exception {
        double rate = getConversionRate(from, to);
        return amount * rate;
    }
}
