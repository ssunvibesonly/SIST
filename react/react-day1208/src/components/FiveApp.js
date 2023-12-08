import React from 'react';
import Alert from '@mui/material/Alert';
import CardGiftcardIcon from '@mui/icons-material/CardGiftcard';


function FiveApp(props) {
    return (
        <div>
            <h3 className='alert alert-info'>FiveApp입니다.</h3>
            <Alert severity="error">배열연습_#5<CardGiftcardIcon/></Alert>

        </div>
    );
}

export default FiveApp;