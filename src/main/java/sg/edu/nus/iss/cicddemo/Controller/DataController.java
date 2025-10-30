package sg.edu.nus.iss.cicddemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;

@RestController
public class DataController {
    @GetMapping("/")
    public String healthCheck() {
        return "HEALTH CHECK OK!";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }

    @GetMapping("/nations")
    public JsonNode getRandomNations() {
    var objectMapper = new ObjectMapper();
    var faker = new Faker();
    var nations = objectMapper.createArrayNode();
    for (var i = 0; i < 10; i++) {
        nations.add(objectMapper.createObjectNode()
            .put("nationality", faker.nation().nationality())
            .put("capitalCity", faker.nation().capitalCity())
            .put("flag", faker.nation().flag())
            .put("language", faker.nation().language()));
    }
    return nations;
    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
    var objectMapper = new ObjectMapper();
    var faker = new Faker();
    var currencies = objectMapper.createArrayNode();
    for (var i = 0; i < 20; i++) {
        currencies.add(objectMapper.createObjectNode()
            .put("name", faker.currency().name())
            .put("code", faker.currency().code()));
    }
    return currencies;

    }

}
