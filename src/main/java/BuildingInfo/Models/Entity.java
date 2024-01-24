package BuildingInfo.Models;

import java.util.List;

public interface Entity {
    double calcSurfaceArea();
    double calcVolume();
    double calcLightIntensity();
    double calcEnergyConsumption();
    List<String> findHighConsumption(double limit);
}
