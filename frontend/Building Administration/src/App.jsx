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
  const [showAlert, setShowAlert] = useState(false);
  
  const [rooms, setRooms] = useState([]);
  const [floors, setFloors] = useState([]);
  const [roomDetails, setRoomDetails] = useState({
    name: '',
    surfaceArea: '',
    volume: '',
    lightIntensity: '',
    energyConsumption: ''
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setRoomDetails((prevDetails) => ({
      ...prevDetails,
      [name]: value
    }));
  };

  const handleAddRoom = () => {
    const newRoom = { ...roomDetails };
    setRooms((prevRooms) => [...prevRooms, newRoom]);
    setRoomDetails({
      name: '',
      surfaceArea: '',
      volume: '',
      lightIntensity: '',
      energyConsumption: ''
    });
  };

  const handleRoomDragStart = (e, index) => {
    e.dataTransfer.setData('text/plain', index.toString());
    e.target.style.opacity = '0.5';
  };

  const handleRoomDragEnd = (e) => {
    e.target.style.opacity = '1';
  };

  const handleRoomDragOver = (e) => {
    e.preventDefault();
  };

  const handleRoomDrop = (e, destination) => {
    e.preventDefault();
    const droppedRoomIndex = e.dataTransfer.getData('text/plain');
    const newIndex = parseInt(droppedRoomIndex, 10);
  
    let roomToMove;
  
    if (destination === 'rooms') {
      // Move room from floors to rooms
      roomToMove = floors[newIndex];
      setFloors((prevFloors) => prevFloors.filter((floor, index) => index !== newIndex));
      setRooms((prevRooms) => [...prevRooms, roomToMove]);
    } else if (destination === 'floors') {
      // Move room from rooms to floors
      roomToMove = rooms[newIndex];
      setRooms((prevRooms) => prevRooms.filter((room, index) => index !== newIndex));
      setFloors((prevFloors) => [...prevFloors, roomToMove]);
    }
  };
  

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
      setShowAlert(false);
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
      if (highConsumptionEntitiesData.RoomNames.length === 0) {
        setShowAlert(true);
      } else {
        setShowAlert(false);
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="App">
      <h1>Building Administration</h1>
      <div class="method">
        <button onClick={handleSendJson}>Send JSON to Backend</button>
        {responseMessage && <p>{responseMessage}</p>}
      </div>

      <div class="method">
        <button onClick={handleCalculateVolume}>Calculate Volume</button>
        {responseVolume && <p>{responseVolume}</p>}
      </div>

      <div class="method">
        <button onClick={handleCalculateSurfaceArea}>Calculate Surface Area</button>
        {responseSurfaceArea && <p>{responseSurfaceArea}</p>}
      </div>

      <div class="method">
        <button onClick={handleCalculateLightIntensity}>Calculate Light Intensity</button>
        {responseLightIntensity && <p>{responseLightIntensity}</p>}
      </div>

      <div class="method">
        <button onClick={handleCalculateEnergyConsumption}>Calculate Energy Consumption</button>
        {responseEnergyConsumption && <p>{responseEnergyConsumption}</p>}
      </div>

      <div class="method">
        <button onClick={handleHighConsumptionEntities}>High Consumption Entities</button>
        {responseHighConsumptionEntities.length > 0 && (
          <ul>
            {responseHighConsumptionEntities.map((entity, index) => (
              <li key={index}>{entity}</li>
            ))}
          </ul>
        )}
        {showAlert && <p>No high consumption entities found.</p>}
      </div>

      <div className="method">
        <h2>Create Room</h2>
        <div className="input-group">
          <label>
            Name:
            <input
              className="input-field"
              type="text"
              name="name"
              value={roomDetails.name}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Surface Area:
            <input
              className="input-field"
              type="number"
              name="surfaceArea"
              value={roomDetails.surfaceArea}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Volume:
            <input
              className="input-field"
              type="number"
              name="volume"
              value={roomDetails.volume}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Light Intensity:
            <input
              className="input-field"
              type="number"
              name="lightIntensity"
              value={roomDetails.lightIntensity}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Energy Consumption:
            <input
              className="input-field"
              type="number"
              name="energyConsumption"
              value={roomDetails.energyConsumption}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <button
          className="add-room-button"
          onClick={handleAddRoom}
          disabled={
            !roomDetails.name ||
            !roomDetails.surfaceArea ||
            !roomDetails.volume ||
            !roomDetails.lightIntensity ||
            !roomDetails.energyConsumption ||
            isNaN(Number(roomDetails.surfaceArea)) ||
            isNaN(Number(roomDetails.volume)) ||
            isNaN(Number(roomDetails.lightIntensity)) ||
            isNaN(Number(roomDetails.energyConsumption))
          }
        >
          Add Room
        </button>
      </div>
      
      <div className="method">
        <h2>Unassigned Rooms</h2>
        <div className="room-list">
          {rooms.map((room, index) => (
            <div
              key={index}
              draggable
              onDragStart={(e) => handleRoomDragStart(e, index)}
              onDragEnd={handleRoomDragEnd}
              className="room"
            >
              Name: {room.name}, Surface Area: {room.surfaceArea}, Volume: {room.volume}, Light Intensity: {room.lightIntensity}, Energy Consumption: {room.energyConsumption}
            </div>
          ))}
        </div>
        <div className="drop-zone" onDragOver={(e) => handleRoomDragOver(e)} onDrop={(e) => handleRoomDrop(e, 'rooms')}>
          <div className="drop-message">Drag rooms here</div>
        </div>
      </div>

      <div className="method">
        <h2>Create Floor</h2>
        <div className="room-list">
          {floors.map((room, index) => (
            <div
              key={index}
              draggable
              onDragStart={(e) => handleRoomDragStart(e, index)}
              onDragEnd={handleRoomDragEnd}
              className="room"
            >
              Name: {room.name}, Surface Area: {room.surfaceArea}, Volume: {room.volume}, Light Intensity: {room.lightIntensity}, Energy Consumption: {room.energyConsumption}
            </div>
          ))}
        </div>
        <div className="drop-zone" onDragOver={(e) => handleRoomDragOver(e)} onDrop={(e) => handleRoomDrop(e, 'floors')}>
          <div className="drop-message">Drag rooms here</div>
        </div>
      </div>

    </div>
  );
}

export default App;