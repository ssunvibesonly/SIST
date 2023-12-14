import React, { useState } from 'react';
import Alert from '@mui/material/Alert';
import ForestIcon from '@mui/icons-material/Forest';
import TwoSubApp from './TwoSubApp';


function TwoApp(props) {

    // useState는 초기값 설정
    const [color,setColor]=useState('pink');
    const [message,setMessage]=useState('오늘은 수요일^^');
    const [photo,setPhoto]=useState('1');

    //3개의 이벤트를 만들어 전달
    const changeMessage=(msg)=>{
        setMessage(msg)
    }

    const changeColor=(col)=>{
        setColor(col)
    }

    const changeImg=(img)=>{
        setPhoto(img)
    }
    return (
        <div>
           
            <Alert severity="success"> TwoApp!!!<ForestIcon/></Alert>
            <br/>
            <h1 style={{color:color}}>{message}</h1>
            <img src={`../image/${photo}.png`}/>
            <br/>
            <TwoSubApp onMessage={changeMessage} onColor={changeColor} onImg={changeImg}/>
        </div>
    );
}

export default TwoApp;