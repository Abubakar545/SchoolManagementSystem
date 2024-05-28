import React, { useEffect, useState } from 'react';
import StudentService from '../services/StudentService';

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await StudentService.getAllStudents();
      setStudents(response.data);
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            {student.firstName} {student.middleName} {student.lastName}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentList;


// import React, { useState, useEffect } from 'react';
// import { Table, Button } from 'antd';
// import { API_BASE_URL } from '../utils/constants';
// import axios from 'axios';
// import '../styles/StudentList.css';
// // import StudentListItem from './StudentListItem';

// const StudentList = () => {
//   const [students, setStudents] = useState([]);

//   useEffect(() => {
//     const fetchStudents = async () => {
//       try {
//         const response = await axios.get(`${API_BASE_URL}/students`);
//         setStudents(response.data);
//       } catch (error) {
//         console.error('Error fetching students:', error);
//       }
//     };

//     fetchStudents();
//   }, []);

//   const columns = [
//     {
//       title: 'Photo',
//       dataIndex: 'imageUrl',
//       key: 'imageUrl',
//       render: (photo) => <img src={photo} alt="Student" style={{ width: '50px' }} />,
//     },
//     {
//       title: 'Student Name',
//       dataIndex: 'name',
//       key: 'name',
//       render: (text, record) => {
//         return `${record.firstName} ${record.middleName} ${record.lastName}`;
//       },
//     },    
//     {
//       title: 'Class',
//       dataIndex: 'standard',
//       key: 'standard',
//     },
//     {
//       title: 'Student Email',
//       dataIndex: 'email',
//       key: 'email',
//     },
//     {
//       title: 'Action',
//       key: 'action',
//       render: (_, record) => (
//         <>
//           <Button type="primary" style={{ marginRight: '8px' }}>
//             Edit
//           </Button>
//           <Button type="danger" style={{ marginRight: '8px' }}>
//             Delete
//           </Button>
//           <Button type="default" style={{ marginRight: '8px' }}>
//             View Result
//           </Button>
//           <Button type="default">View Parent</Button>
//         </>
//       ),
//     },
//   ];

//   return (
//     <Table
//       dataSource={students}
//       columns={columns}
//       rowKey={(record) => record.id}
//       pagination={{ pageSize: 10 }}
//     />
//   );
// };

// export default StudentList;