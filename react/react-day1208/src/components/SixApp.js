import React from 'react';
import Alert from '@mui/material/Alert';
import ElectricBikeIcon from '@mui/icons-material/ElectricBike';


function SixApp(props) {
    return (
        <div>
            <h3 className='alert alert-info'>SixApp입니다.</h3>
            <Alert severity="success">배열연습_#6<ElectricBikeIcon/></Alert>

        </div>
    );
}

export default SixApp;