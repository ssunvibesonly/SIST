import React from 'react';
import infoimg from '../image/2.png';

function Info(props) {
    return (
        <div>
            <img src={infoimg} style={{width:'150px',borderRadius:'40px'}}/>
            <br/><br/>
            <div>빵빵이의 일상</div>
            <div>010-1234-56789</div>
        </div>
    );
}

export default Info;