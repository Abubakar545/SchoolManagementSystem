// src/components/StudentForm.js
import React, { useState } from 'react';
import StudentService from '../services/StudentService';

const StudentForm = () => {
  const [student, setStudent] = useState({
    standard: '',
    rollNumber: '',
    firstName: '',
    middleName: '',
    lastName: '',
    gender: '',
    dateOfBirth: null,
    address: '',
    city: '',
    state: '',
    zipCode: '',
    phone: '',
    email: '',
    userName: '',
    password: '',
    imageUrl: null,
  });


  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await StudentService.saveStudent(student);
      // Reset form or handle success response
      console.log('Student saved successfully');
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      {/* Form fields */}
      <input
        type="text"
        name="standard"
        placeholder="Class"
        value={student.standard}
        onChange={handleChange}
      />
      <input
        type="text"
        name="roolNumber"
        placeholder="Roll Number"
        value={student.rollNumber}
        onChange={handleChange}
      />
      <input
        type="text"
        name="firstName"
        placeholder="First Name"
        value={student.firstName}
        onChange={handleChange}
      />
      <input
        type="text"
        name="middleName"
        placeholder="Middle Name"
        value={student.middleName}
        onChange={handleChange}
      />
      <input
        type="text"
        name="lastName"
        placeholder="Last Name"
        value={student.lastName}
        onChange={handleChange}
      />
      <div>
        <label>Gender:</label>
        <input
          type="radio"
          name="gender"
          value="Male"
          checked={student.gender === 'Male'}
          onChange={handleChange}
        />
        <label>Male</label>
        <input
          type="radio"
          name="gender"
          value="Female"
          checked={student.gender === 'Female'}
          onChange={handleChange}
        />
        <label>Female</label>
      </div>
      <input
        type="date"
        name="dateOfBirth"
        placeholder="Date of Birth"
        value={student.dateOfBirth}
        onChange={handleChange}
      />
      <input
        type="text"
        name="address"
        placeholder="Address"
        value={student.address}
        onChange={handleChange}
      />
      <input
        type="text"
        name="city"
        placeholder="City"
        value={student.city}
        onChange={handleChange}
      />
      <input
        type="text"
        name="state"
        placeholder="State"
        value={student.state}
        onChange={handleChange}
      />
      <input
        type="text"
        name="zipCode"
        placeholder="Zip Code"
        value={student.zipCode}
        onChange={handleChange}
      />
      <input
        type="text"
        name="phone"
        placeholder="Phone"
        value={student.phone}
        onChange={handleChange}
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={student.email}
        onChange={handleChange}
      />
      <input
        type="text"
        name="userName"
        placeholder="User Name"
        value={student.userName}
        onChange={handleChange}
      />
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={student.password}
        onChange={handleChange}
      />
      <button type="submit">Save Student</button>
    </form>
  );
};

export default StudentForm;