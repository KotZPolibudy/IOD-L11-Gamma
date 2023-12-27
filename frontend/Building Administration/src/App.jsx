import { useState } from 'react';
import ApiService from './ApiService'; // Import your ApiService
import './App.css';

function App() {
  const [responseMessage, setResponseMessage] = useState('');
  const [responseVolume, setResponseVolume] = useState('');
  const [responseSurfaceArea, setResponseSurfaceArea] = useState('');
  const [responseLightIntensity, setResponseLightIntensity] = useState('');
  const [responseEnergyConsumption, setResponseEnergyConsumption] = useState('');
  const [responseHighConsumptionEntities, setResponseHighConsumptionEntities] = useState([]);

  const handleSendJson = async () => {
    try {
      const json = {
        // Your JSON payload here
        // Modify this object to match your expected JSON structure
        building: {
          floors: [
            {
              rooms: [
                { name: 'Room1', surfaceArea: 20, volume: 30, lightIntensity: 50, energyConsumption: 100 },
                { name: 'Room2', surfaceArea: 25, volume: 35, lightIntensity: 60, energyConsumption: 120 },
              ],
            },
            {
              rooms: [
                {name: "Room3", surfaceArea: 18, volume: 28, lightIntensity: 45, energyConsumption: 90},
                {name: "Room4", surfaceArea: 22, volume: 32, lightIntensity: 55, energyConsumption: 110}
              ]
            }
          ],
        },
      };

      const result = await ApiService.setJson(json);
      setResponseMessage(result); // Update state with the response message from the backend
      setResponseSurfaceArea('');
      setResponseVolume('');
      setResponseLightIntensity('');
      setResponseEnergyConsumption('');
      setResponseHighConsumptionEntities([]);
    } catch (error) {
      // Handle error
      console.error(error);
    }
  };

  const handleCalculateVolume = async () => {
    try {
      const volumeData = await ApiService.getVolume();
      setResponseMessage('');
      setResponseVolume(`Volume: ${volumeData.volume}`); // Update state with volume data
    } catch (error) {
      console.error(error);
    }
  };

  const handleCalculateSurfaceArea = async () => {
    try {
      const surfaceAreaData = await ApiService.getSurfaceArea();
      setResponseMessage('');
      setResponseSurfaceArea(`Surface Area: ${surfaceAreaData.surfaceArea}`); // Update state with surface area data
    } catch (error) {
      console.error(error);
    }
  };

  const handleCalculateLightIntensity = async () => {
    try {
      const lightIntensityData = await ApiService.getLightIntensity();
      setResponseMessage('');
      setResponseLightIntensity(`Light Intensity: ${lightIntensityData.lightIntensity}`); // Update state with light intensity data
    } catch (error) {
      console.error(error);
    }
  };

  const handleCalculateEnergyConsumption = async () => {
    try {
      const energyConsumptionData = await ApiService.getEnergyConsumption();
      setResponseMessage('');
      setResponseEnergyConsumption(`Energy Consumption: ${energyConsumptionData.energyConsumption}`); // Update state with energy consumption data
    } catch (error) {
      console.error(error);
    }
  };

  const handleHighConsumptionEntities = async () => {
    try {
      const highConsumptionEntitiesData = await ApiService.getHighConsumptionEntities(100); // Example limit value
      setResponseMessage('');
      setResponseHighConsumptionEntities(highConsumptionEntitiesData.RoomNames); // Update state with high consumption entities data
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="App">
      <h1>Send JSON to Backend</h1>
      <div>
        <button onClick={handleSendJson}>Send JSON to Backend</button>
        {responseMessage && <p>{responseMessage}</p>}
      </div>

      <div>
        <button onClick={handleCalculateVolume}>Calculate Volume</button>
        {responseVolume && <p>{responseVolume}</p>}
      </div>

      <div>
        <button onClick={handleCalculateSurfaceArea}>Calculate Surface Area</button>
        {responseSurfaceArea && <p>{responseSurfaceArea}</p>}
      </div>

      <div>
        <button onClick={handleCalculateLightIntensity}>Calculate Light Intensity</button>
        {responseLightIntensity && <p>{responseLightIntensity}</p>}
      </div>

      <div>
        <button onClick={handleCalculateEnergyConsumption}>Calculate Energy Consumption</button>
        {responseEnergyConsumption && <p>{responseEnergyConsumption}</p>}
      </div>

      <div>
        <button onClick={handleHighConsumptionEntities}>High Consumption Entities</button>
        {responseHighConsumptionEntities.length > 0 && (
          <ul>
            {responseHighConsumptionEntities.map((entity, index) => (
              <li key={index}>{entity}</li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default App;