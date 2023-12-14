import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Menu from './components/Menu';
import Home from './pages/Home';
import About from './pages/About';
import Bbang from './pages/Bbang';
import mainImg from './image2/카이사.png';

function RouterMain(props) {
    return (
        <div>
            {/* 모든 페이지에서 공통으로 포함되는 컴포넌트나 이미지 */}
            <h1>React Router 공부하기</h1>
            <Menu />
            <img src={mainImg} className='main_photo'/>
            <hr className='line'/>
            <div className='main_comp'>
            <Routes>
                <Route path='/' element={<Home />} />
                <Route path='/about' element={<About/>} />
                {/* name을 파라메터로 넘기겠다는 뜻 */}
                <Route path='/about/:name' element={<About/>}/>
                <Route path='/login/*' element={
                    <div>
                        <h1>아직 로그인 기능 구현 전입니다.</h1>
                        <img src='../image/7.png'/>
                        <h3>오늘 점심 이거 어때?</h3>
                    </div>
                }/>
                {/* 그 이외 매핑이면.. */}
                <Route path='*' element={
                    <h1>잘못된 경로 입니다.</h1>
                }/>
                <Route path='/bbang/:bbang1/:bbang2' element={<Bbang/>}/>

                
            </Routes>
            </div>
        </div>
    );
}

export default RouterMain;
