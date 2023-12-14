import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';

function Bbang(props) {

    const {bbang1,bbang2}=useParams();
    const navi=useNavigate();
    return (
        <div>
            <h3>오늘의 빵빵이</h3>
            <button type='button' className='btn btn-info'
            onClick={()=>{
                navi(-1);
            }}>이전 페이지</button>
            {/* 사진을 두개 넘길 땐 ../../ 이러식으로 쓴다. */}
            <img src={`../../image/${bbang1}.png`} className='img-thumbnail'
            style={{width:'200px',height:'200px'}}/>
            <img src={`../../image/${bbang2}.png`} className='img-thumbnail'
            style={{width:'200px',height:'200px'}}/>
        </div>
    );
}

export default Bbang;