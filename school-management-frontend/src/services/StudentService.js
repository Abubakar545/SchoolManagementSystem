// src/services/StudentService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/students';

const saveStudent = async (student) => {
  try {
    const response = await axios.post(API_URL, student);
    return response.data;
  } catch (err) {
    throw err;
  }
};

const getAllStudents = async () => {
  try {
    const response = await axios.get(API_URL);
    return response;
  } catch (err) {
    throw err;
  }
};

const StudentService = {
  saveStudent,
  getAllStudents,
};

export default StudentService;