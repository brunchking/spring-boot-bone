import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Route,
  Routes,
} from 'react-router-dom';
import Member from './components/Member';
import Login from './components/Login';
import Signup from './components/Signup';
import PersonalInfoForm from './components/PersonalInfoForm';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/signin' element={<Login />} />
        <Route path='/signup' element={<Signup />} />
        <Route path='/personalInfoForm' element={<PersonalInfoForm />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

