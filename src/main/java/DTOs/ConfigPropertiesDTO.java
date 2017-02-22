package DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by aditya.mullela on 22/02/17.
 */

@Getter
@Setter
@NoArgsConstructor
public class ConfigPropertiesDTO {

    @JsonProperty("url")
    private String url;

    @JsonProperty("browser")
    private String browser;

    @JsonProperty("chromeDriver")
    private String chromeDriver;

    @JsonProperty("firefoxDriver")
    private String firefoxDriver;

    @JsonProperty("chromeDriverLocation")
    private String chromeDriverLocation;

    @JsonProperty("firefoxDriverLocation")
    private String firefoxDriverLocation;

}
