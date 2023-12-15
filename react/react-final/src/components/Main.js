import React from 'react';
import bbang1 from '../image/8.png';
import bbang2 from '../image/3.png';
import bbang3 from '../image/6.png';
import bbang4 from '../image/7.png';

function Main(props) {
    return (
        <div>
            <img src={bbang1} style={{width:'200px', height:'200px',borderRadius:'20px'}}/>
            <img src={bbang2} style={{width:'200px',borderRadius:'20px',marginLeft:'10px'}}/>
            <img src={bbang3} style={{width:'200px',height:'200px',borderRadius:'20px',marginLeft:'10px'}}/>
            <img src={bbang4} style={{width:'200px',borderRadius:'20px',marginLeft:'10px'}}/>
        </div>
    );
}

export default Main;