import React from 'react';
import { useNavigate } from 'react-router-dom';

function Shop(props) {

     //경로 이동
     const navi=useNavigate();

    return (
        <div>
             <button type='button' className='btn btn-info'
            style={{width:'120px'}} onClick={()=>{
                navi("/shop/form");
            }}>상품 등록</button>
            <h1>Shop..목록출력</h1>
        </div>
    );
}

export default Shop;