class ApiService {
    static async setJson(jsonData) {
      const response = await fetch('http://localhost:8080/api', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(jsonData),
      });
      if (!response.ok) {
        throw new Error('Failed to send JSON data');
      }
      return 'JSON sent successfully';
    }
  
    static async getVolume() {
      const response = await fetch('http://localhost:8080/api/Volume');
      if (!response.ok) {
        throw new Error('Failed to get volume');
      }
      const data = await response.json();
      return data;
    }
  
    static async getSurfaceArea() {
      const response = await fetch('http://localhost:8080/api/SurfaceArea');
      if (!response.ok) {
        throw new Error('Failed to get surface area');
      }
      const data = await response.json();
      return data;
    }
  
    static async getLightIntensity() {
      const response = await fetch('http://localhost:8080/api/LightIntensity');
      if (!response.ok) {
        throw new Error('Failed to get light intensity');
      }
      const data = await response.json();
      return data;
    }
  
    static async getEnergyConsumption() {
      const response = await fetch('http://localhost:8080/api/EnergyConsumption');
      if (!response.ok) {
        throw new Error('Failed to get energy consumption');
      }
      const data = await response.json();
      return data;
    }
  
    static async getHighConsumptionEntities(limit) {
      const response = await fetch(`http://localhost:8080/api/HighConsumptionEntities?limit=${limit}`);
      if (!response.ok) {
        throw new Error('Failed to get high consumption entities');
      }
      const data = await response.json();
      return data;
    }
  }
  
  export default ApiService;
  