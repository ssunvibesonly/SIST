import React from 'react';
import {NavLink} from 'react-router-dom';

function Menu(props) {
    return (
        <div>
            <ul className='menu'>
                <li><NavLink to='/'>Home</NavLink></li>
                <li><NavLink to='/about'>About</NavLink></li>
                <li><NavLink to='/about/Lee'>About_Lee</NavLink></li>
                <li><NavLink to='/bbang/7/8'>빵시리즈1탄</NavLink></li>
                <li><NavLink to='/bbang/9/10'>빵시리즈2탄</NavLink></li>
            </ul>
        </div>
    );
}

export default Menu;