import React from 'react';
import { About, Info, Main, Menu, Title } from './components';
import { Route, Routes } from 'react-router-dom';
import Board from './board/Board';
import Member from './member/Member';
import Login from './loginfolder/Login';
import Shop from './shop/Shop';
import { ShopDetail, ShopForm } from './shop';


function RouteMain(props) {
    return (
        <div>
            <div className='title'><Title/></div>
            <div className='info'><Info/></div>
            <div className='menu'><Menu/></div>
            <div className='main'>
                <Routes>
                    <Route path='/' element={<Main/>}/>

                    {/* shop */}
                    <Route path='/shop/list' element={<Shop/>}/>
                    <Route path='/shop/form' element={<ShopForm/>}/>
                    
                    {/* detil로 가는데 num을 파라메터 값으로 넘기겠다. */}
                    <Route path='/shop/detail/:num' element={<ShopDetail/>}/> 

                    <Route path='/board/list' element={<Board/>}/>
                    <Route path='/member/form' element={<Member/>}/>
                    <Route path='/login' element={<Login/>}/>
                    <Route path='/about' element={<About/>}/>
                    <Route path='*' element={
                    <div>
                        <h1>잘못된 주소입니다.</h1>
                    </div>
                    }/>
                </Routes>
            </div>
        </div>
    );
}

export default RouteMain;