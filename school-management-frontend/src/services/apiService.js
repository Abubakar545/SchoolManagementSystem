// import axios from 'axios';
// import { API_BASE_URL } from '../utils/constants';

// export const fetchStudents = async () => {
//   try {
//     const response = await axios.get(`${API_BASE_URL}/students`);
//     return response.data;
//   } catch (error) {
//     console.error('Error fetching students:', error);
//     throw error;
//   }
// };

// export const addStudent = async (studentData) => {
//   try {
//     const response = await axios.post(`${API_BASE_URL}/students`, studentData, {
//       headers: {
//         'Content-Type': 'application/json', // Set the content type to 'application/json'
//       },
//     });
//     return response.data;
//   } catch (error) {
//     console.error('Error adding student:', error);
//     throw error;
//   }
// };