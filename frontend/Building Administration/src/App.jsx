import { useState } from 'react';
import ApiService from './ApiService'; // Import your ApiService
import './App.css';

function App() {
  const [responseMessage, setResponseMessage] = useState('');

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
            // Add more floors if needed
          ],
        },
      };

      const result = await ApiService.setJson(json);
      console.log(result);
      setResponseMessage(result); // Update state with the response message from the backend
    } catch (error) {
      // Handle error
      console.error(error);
    }
  };

  return (
    <div className="App">
      <h1>Send JSON to Backend</h1>
      <button onClick={handleSendJson}>Send JSON to Backend</button>
      {responseMessage && <p>Response from backend: {responseMessage}</p>}
    </div>
  );
}

export default App;
