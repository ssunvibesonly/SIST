import React from 'react';

function TwoSubApp(props) {
    return (
        <div style={{marginLeft:'100px'}}>
            <b>메세지</b>
            <input type='text' style={{width:'400px'}} className='form-control'
            onChange={(e)=>{
                props.onMessage(e.target.value);
            }}/>
            <br/>
            <b>글자색 변경</b>
            <input type='color' defaultValue='#ffc' className='form-control' 
            style={{width:'400px'}} onChange={(e)=>{
                props.onColor(e.target.value);
            }}/>
            <br/>
            <b>이미지 변경</b>
            <select className='form-control' onChange={(e)=>{
                props.onImg(e.target.value);
            }}>
                {
                    [...new Array(5)].map((a,idx)=>(<option>{`${idx+1}`}</option>))
                }
            </select>
        </div>
    );
}

export default TwoSubApp;