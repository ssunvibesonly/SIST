import React, { useState } from 'react';
import Alert from '@mui/material/Alert';
import ForestIcon from '@mui/icons-material/Forest';
import TwoSubApp from './TwoSubApp';
import TwoSubApp2 from './TwoSubApp2';


function TwoApp(props) {

    // useState는 초기값 설정
    const [color,setColor]=useState('pink');
    const [message,setMessage]=useState('오늘은 수요일^^');
    const [photo,setPhoto]=useState('1');

    //app2
    const [likeColor,setLikeColor]=useState(['pink','gray','lightblue','green','yellow'])

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

    //sub2_색상 추가
    const addColorEvent=(co)=>{
        setLikeColor(likeColor.concat(co)) //concat은 추가 한다는 뜻
    }
    return (
        <div>
           
            <Alert severity="success"> TwoApp!!!<ForestIcon/></Alert>
            <br/>
            <h1 style={{color:color}}>{message}</h1>
            <img src={`../image/${photo}.png`}/>
            <br/>
            {
                likeColor.map((co,idx)=>(<div className='box' style={{backgroundColor:co}}>{idx}</div>))
            }   onDoucleClick={()=>{
                deleteLikeColor
            }}
            <br/>
            <TwoSubApp onMessage={changeMessage} onColor={changeColor} onImg={changeImg}/>
            <br/>
            <TwoSubApp2 onAddColor={addColorEvent}/>
        </div>
    );
}

export default TwoApp;