import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api'; // Replace with your backend URL

const ApiService = {
  setJson: async (json) => {
    try {
      const response = await axios.post(`${BASE_URL}`, json);
      return response.data; // Assuming the backend returns a success message
    } catch (error) {
      console.error('Error setting JSON:', error);
      throw new Error('Failed to set JSON');
    }
  },
};

export default ApiService;
