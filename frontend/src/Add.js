import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';

function Add() {
    const [inputData,setInputData] = useState({name:"",author:"",publisher:"",numberofpages:"",price:"",booktype:""})
    const navigat = useNavigate();
    function handleSubmit(event){
        event.preventDefault()
        axios.post("http://localhost:8090/book-management-back/postBook",inputData)
        .then(res => {
            alert("Data Added Successfully");
            navigat('/');
        }).catch(err => console.log(err));
    }
    return (
        <div className='container mt-5'>
         <Navbar/>
        <div className='container min-vh-100 d-flex justify-content-center align-items-center mt-4'>
           

           <form onSubmit={handleSubmit} >
        <div>
            <label htmlFor='name'>Name:</label>
            <input type='text' name='name' className='form-control'
            onChange={e=>setInputData({...inputData,name:e.target.value})}/>
        </div>
        <div>
            <label htmlFor='author'>Author:</label>
            <input type='text' name='author' className='form-control'
            onChange={e=>setInputData({...inputData,author:e.target.value})}/>
        </div>
        <div>
            <label htmlFor='publisher'>publisher:</label>
            <input type='text' name='publisher' className='form-control'
            onChange={e=>setInputData({...inputData,publisher:e.target.value})}/>
        </div>
        <div>
            <label htmlFor='price'>Price:</label>
            <input type='text' name='price' className='form-control'
            onChange={e=>setInputData({...inputData,price:e.target.value})}/>
        </div>
        <div>
            <label htmlFor='numberofpages'>Number of Pages:</label>
            <input type='text' name='numberofpages' className='form-control'
            onChange={e=>setInputData({...inputData,numberofpages:e.target.value})}/>
        </div>
        <div>
            <label htmlFor='booktype'>booktype:</label>
            <input type='text' name='booktype' className='form-control'
            onChange={e=>setInputData({...inputData,booktype:e.target.value})}/>
        </div>

        <button className='btn btn-primary mt-2'>Submit</button>
        </form>
        </div>
    
        </div>
    
  )
}

export default Add