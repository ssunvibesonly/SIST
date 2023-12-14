import React, { useState } from 'react';

function TwoSubApp2(props) {

    const [color,setColor]=useState('');

    //버튼 이벤트
    const buttonEvent=()=>{
        props.onAddColor(color);
    }

    return (
        <div>
            <h4 style={{width:'500px'}}>Two2컴포넌트</h4>
            <div>
                <b>색상 선택: </b>
                <input type='color' defaultValue='#ffccff' style={{width:'100px'}}
                onChange={(e)=>{
                    setColor(e.target.value);
                }}/><br/>
                <button type='button' className='btn btn-info btn-sm'
                onClick={buttonEvent}>색상 추가</button>
            </div>
        </div>
    );
}

export default TwoSubApp2;