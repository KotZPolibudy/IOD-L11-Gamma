package BuildingInfo.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Result {
    private static final Logger logger = LoggerFactory.getLogger(Result.class);
    private double value;

    public Result(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void writeToJsonFile(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String outputJson = mapper.writeValueAsString(this);

            File outputFile = new File(filename);
            mapper.writeValue(outputFile, this);
            logger.info("Result written to {}", filename);
        } catch (IOException e) {
            logger.error("Error writing result to file: {}", e.getMessage());
        }
    }
}
