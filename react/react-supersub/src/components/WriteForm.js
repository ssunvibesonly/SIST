import React, { useState } from 'react';

function WriteForm({onSave}) {

    const [name,setName]=useState('');
    const [blood,setBlood]=useState('A');
    const [photo,setPhoto]=useState('증명사진');

    //버튼이벤트
    const addDataEvent=()=>{
        //부모 컴포넌트에서 만든 onSave를 호출
        onSave({name,photo,blood});
    }
    return (
        <div>
            <b>이름:</b>
            <input type='text' style={{width:'120px'}} onChange={(e)=>{
                setName(e.target.value);
            }}/>
            <b style={{marginLeft:'20px'}}>혈액형:</b>
            <select onChange={(e)=>
                setBlood(e.target.value)}>
                    <option>A</option><br/>
                    <option>AB</option>
                    <option>O</option>
                    <option>B</option>
            </select>

            <b style={{marginLeft:'10px'}}>이미지</b>
            <select onChange={(e)=>
            setPhoto(e.target.value)
            }>
                <option>선범증명사진</option>
                <option>유재석</option>
                <option>증명사진</option>
                <option>현규사진</option>
            </select>
            <button type='button' className='btn btn-info btn-sm' style={{marginLeft:'10px'}} onClick={addDataEvent}>추가</button>
        </div>
    );
}

export default WriteForm;