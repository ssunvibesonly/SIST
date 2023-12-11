import React, { useState } from 'react';
import Alert from '@mui/material/Alert';
import ElectricBikeIcon from '@mui/icons-material/ElectricBike';


function SixApp(props) {

    const [names,setNames]=useState(['강연주','최진평','진현규','박희찬','이민규']);
    const [irum,setIrum]=useState('');

    //추가버튼 이벤트
    const btnInsert=()=>{
        setNames(names.concat(irum)); //배열에 irum데이타 추가
        setIrum('');
    }

    //input창에 입력이 되도록..
    const textInput=(e)=>{
        setIrum(e.target.value);
    }
    //입력이 되도록 ..이벤트
    const textEnter=(e)=>{
        if(e.key==='Enter'){
            btnInsert();
        }
       
    }

    //더블 클릭시 삭제
    const dataRemove=(index)=>{
        console.log("remove: "+index);


        // //방법1..slice
        // setNames([
        //     ...names.slice(0,index),
        //     ...names.slice(index+1,names.length) //0번부터 index까지
        // ]) //index번지만 빼고 잘라서 넣음

        //방법2..filter
         setNames(names.filter((item,i)=>i!==index))
    }

    



    return (
        <div>
            <h3 className='alert alert-info'>SixApp입니다.</h3>
            <Alert severity="success">배열연습_#6<ElectricBikeIcon/></Alert>

            <input value={irum} onChange={textInput} onKeyUp={textEnter} placeholder='이름입력'/>
            <button type='button' className='btn btn-info' style={{marginLeft:'10px'}}
            onClick={btnInsert}>추가</button>
            <br/>
            <h4>이름을 더블 클릭하면 삭제됩니다.</h4>
            <ul>
                {
                    names.map((name,index)=>(<li className='data' onDoubleClick={()=>dataRemove(index)}>{name}</li>))
                }
            </ul>
        </div>
    );
}

export default SixApp;