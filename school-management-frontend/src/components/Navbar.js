import React from 'react';
import { Link } from 'react-router-dom';
import { Menu } from 'antd';
import '../styles/Navbar.css'; 

const Navbar = () => {
  return (
    <Menu mode="horizontal">
      <Menu.Item key="students">
        <Link to="/students">Student List</Link>
      </Menu.Item>
      <Menu.Item key="add-student">
        <Link to="/add-student">Add New Student</Link>
      </Menu.Item>
    </Menu>
  );
};

export default Navbar;