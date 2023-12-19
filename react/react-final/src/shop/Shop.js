import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ShopRowItem from './ShopRowItem';
function Shop(props) {

     //경로 이동
     const navi=useNavigate();

     //백엔드에서 받아올 리스트에 대한 데이터 변수
     const [shopList,setShopList]=useState([]);
     
     //데이터 가져오는 함수
     const list=()=>{
        let url="http://localhost:9000/shop/list";

        axios.get(url)
        .then(res=>{
            //스프링으로부터 받아온 list를 shopList에 넣기
            setShopList(res.data);
            console.log("len: "+res.data.length); //이걸 확인 후 RowItem에서 출력 예정
        })
     }

     //처음 렌더링 시 딱 한번 데이터 가져오기
     useEffect(()=>{

        console.log("list: "+list);
        list();
     },[]);

    return (
        <div>
             <button type='button' className='btn btn-info'
            style={{width:'120px'}} onClick={()=>{
                navi("/shop/form");
            }}>상품 등록</button>
            <hr/>
            <table className='table table-bordered' style={{width:'500px'}}>
                <thead>
                    <tr>
                        <th width='60'>번호</th>
                        <th width='140'>상품명</th>
                        <th width='300'>상세보기</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        shopList.map((row,index)=>(<ShopRowItem row={row} idx={index}/>))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default Shop;