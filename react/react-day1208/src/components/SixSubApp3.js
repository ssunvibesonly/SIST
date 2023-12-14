import React from 'react';

function SixSubApp3(props) {
    return (
        <div>
            <h3>3번째 자식</h3>
            <button type='button' className='btn btn-success' onClick={()=>{
                props.incre();
            }}>증가</button>
            <button type='button' className='btn btn-danger' 
            onClick={()=>{
                props.decre();
            }} style={{marginLeft:'10px'}}>감소</button>
        </div>
    );
}

export default SixSubApp3;