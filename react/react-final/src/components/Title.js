import React from 'react';
import titleimg from '../image/title.png'; //src에 만든 이미지 폴더는 import 받아서 사용

function Title(props) {
    return (
        <div>
            <div align='center'>
            <img src={titleimg} style={{height:'100px',borderRadius:'100px'}}/><br/>
            <b style={{fontSize:'20px'}}>
                React_Spring Boot Project
            </b>
            </div>
        </div>
    );
}

export default Title;