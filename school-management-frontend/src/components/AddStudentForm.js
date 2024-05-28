// import React, { useState } from 'react';
// import { Form, Input, Button, DatePicker, Radio, Upload } from 'antd';
// import { API_BASE_URL } from '../utils/constants';
// import axios from 'axios';
// import "../styles/StudentForm.css"

// const AddStudentForm = () => {
//   const [form] = Form.useForm();
//   const [formData, setFormData] = useState({
//     standard: '',
//     rollNumber: '',
//     firstName: '',
//     middleName: '',
//     lastName: '',
//     gender: '',
//     dateOfBirth: null,
//     address: '',
//     city: '',
//     state: '',
//     zipCode: '',
//     phone: '',
//     email: '',
//     userName: '',
//     password: '',
//     imageUrl: null,
//   });

//   const handleChange = (e) => {
//     const { name, value } = e.target;
//     setFormData({ ...formData, [name]: value });
//   };

//   const handleDateChange = (date, dateString) => {
//     setFormData({ ...formData, dateOfBirth: dateString });
//   };

//   const handleGenderChange = (e) => {
//     setFormData({ ...formData, gender: e.target.value });
//   };

//   const handleImageChange = (info) => {
//     if (info.file.status === 'done') {
//       setFormData({ ...formData, imageUrl: info.file.originFileObj });
//     }
//   };

//   const handleSubmit = async () => {
//     try {
//       const formDataToSend = new FormData();
//       Object.entries(formData).forEach(([key, value]) => {
//         if (value !== null) {
//           formDataToSend.append(key, value);
//         }
//       });

//       const response = await axios.post(`${API_BASE_URL}/students`, formDataToSend, {
//         headers: {
//           'Content-Type': 'multipart/form-data',
//         },
//       });

//       console.log('New student added:', response.data);
//       form.resetFields();
//     } catch (error) {
//       console.error('Error adding student:', error);
//     }
//   };

//   return (
    // <Form form={form} layout="vertical" onFinish={handleSubmit}>
    //   <Form.Item
    //     name="standard"
    //     label="Class"
    //     rules={[{ required: true, message: 'Please enter the standard' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="rollNumber"
    //     label="Roll Number"
    //     rules={[{ required: true, message: 'Please enter the roll number' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="firstName"
    //     label="First Name"
    //     rules={[{ required: true, message: 'Please enter the first name' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item name="middleName" label="Middle Name">
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="lastName"
    //     label="Last Name"
    //     rules={[{ required: true, message: 'Please enter the last name' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="gender"
    //     label="Gender"
    //     rules={[{ required: true, message: 'Please select a gender' }]}
    //   >
    //     <Radio.Group onChange={handleGenderChange}>
    //       <Radio value="Male">Male</Radio>
    //       <Radio value="Female">Female</Radio>
    //     </Radio.Group>
    //   </Form.Item>

    //   <Form.Item
    //     name="dateOfBirth"
    //     label="Date of Birth"
    //     rules={[{ required: true, message: 'Please select the date of birth' }]}
    //   >
    //     <DatePicker onChange={handleDateChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="address"
    //     label="Address"
    //     rules={[{ required: true, message: 'Please enter the address' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="city"
    //     label="City"
    //     rules={[{ required: true, message: 'Please enter the city' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="state"
    //     label="State"
    //     rules={[{ required: true, message: 'Please enter the state' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="zipCode"
    //     label="Zip Code"
    //     rules={[{ required: true, message: 'Please enter the zip code' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="phone"
    //     label="Phone"
    //     rules={[{ required: true, message: 'Please enter the phone number' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="email"
    //     label="Email"
    //     rules={[{ required: true, message: 'Please enter the email' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="userName"
    //     label="User Name"
    //     rules={[{ required: true, message: 'Please enter the user name' }]}
    //   >
    //     <Input onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="password"
    //     label="Password"
    //     rules={[{ required: true, message: 'Please enter the password' }]}
    //   >
    //     <Input.Password onChange={handleChange} />
    //   </Form.Item>

    //   <Form.Item
    //     name="imageUrl"
    //     label="ImageUrl"
    //     rules={[{ required: true, message: 'Please upload an imageUrl' }]}
    //   >
    //     <Upload onChange={handleImageChange} beforeUpload={() => false}>
    //       <Button>Upload Image</Button>
    //     </Upload>
    //   </Form.Item>

    //   <Button type="primary" htmlType="submit">
    //     Add Student
    //   </Button>
    // </Form>
//   );
// };

// export default AddStudentForm;