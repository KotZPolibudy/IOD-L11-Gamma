package BuildingInfo.Controllers;

import BuildingInfo.Services.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String Json) {
        logger.info("Loaded JSON: {}", Json);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode buildingNode = objectMapper.readTree(Json);
            //Check object type and parse it
            Object entityObject = new EntityParser().parse(buildingNode);
            //Check function type
            String function = new FunctionParser().parseFunction(buildingNode);
            logger.debug("Function: {}", function);
            //Write to json
            if (entityObject != null && function != null) {
                Object result = invokeFunction(entityObject, function);
                double doubleResult = (double) result; // Cast the Object to double
                Result finalResult = new Result(doubleResult);
                finalResult.writeToJsonFile("result.json");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Object invokeFunction(Object entityObject, String functionName) {
        try {
            Method method = entityObject.getClass().getMethod(functionName);
            Object result = method.invoke(entityObject);
            logger.info("Result of {} is: {}", functionName, result);
            return result;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error("Error invoking function {}: {}", functionName, e.getMessage());
        }
        return null;
    }
}
