import React from 'react';
import { useNavigate } from 'react-router-dom';

function Home(props) {

    const navi=useNavigate();

    return (
        <div>
            <button type='button' className='btn btn-info'
            onClick={()=>{
                navi("/about");
            }}>About</button>
            <button type='button' className='btn btn-danger'
            onClick={()=>{
                navi("/about/Lee");
            }}>About2</button>
            <button type='button' className='btn btn-success'
            onClick={()=>{
                navi("/bbang/7/8")
            }}>빵시리즈1탄</button>
            <button type='button' className='btn btn-warning'
            onClick={()=>{
                navi("/bbang/9/10")
            }}>빵시리즈2탄</button>
        </div>
    );
}

export default Home;