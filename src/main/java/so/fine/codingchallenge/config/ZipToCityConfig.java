package so.fine.codingchallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "zip")
@Data
public class ZipToCityConfig {
    private Map<String, String> zipMap = new HashMap<>();;

    // Explicit getter & setter for tools that don't process Lombok
    public Map<String, String> getZipMap() {
        return this.zipMap;
    }

    public void setZipMap(Map<String, String> zipMap) {
        this.zipMap = zipMap;
    }
}