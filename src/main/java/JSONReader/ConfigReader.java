package JSONReader;

import DTOs.ConfigPropertiesDTO;
import Utils.ConfigConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class ConfigReader {

    ConfigConstants configConstants;
    ObjectMapper mapper;
    ConfigPropertiesDTO configPropertiesDto;

    public ConfigPropertiesDTO readConfigProperties(){

        configConstants = new ConfigConstants();

        configPropertiesDto = getConfigPropertiesDTO();

        return configPropertiesDto;
    }

    private ConfigPropertiesDTO getConfigPropertiesDTO(){

        mapper = new ObjectMapper();
        ConfigPropertiesDTO tempDto = null;
            try {
                tempDto = mapper.readValue(new File(configConstants.CONFIG_PROPERTIES_FILE_LOCATION),
                        ConfigPropertiesDTO.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return tempDto;
    }
}
