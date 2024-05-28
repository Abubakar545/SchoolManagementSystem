// src/App.js
import React from 'react';
import StudentForm from './components/StudentForm';
import StudentList from './components/StudentList';

function App() {
  return (
    <div>
      <StudentForm />
      <StudentList />
    </div>
  );
}

export default App;


// import React from 'react';
// import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import AddStudentForm from './components/AddStudentForm';
// import StudentList from './components/StudentList';
// import Navbar from './components/Navbar';
// import './App.css';

// function App() {
//   return (
//     <Router>
//     <div className="app">
//       <Navbar />
//       <Routes>
//         <Route path="/add-student" element={<AddStudentForm />} />
//         <Route path="/students" element={<StudentList />} />
//       </Routes>
//     </div>
//   </Router>
//   );
// }

// export default App;