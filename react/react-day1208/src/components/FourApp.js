import React from 'react';
import Alert from '@mui/material/Alert';
import AppleIcon from '@mui/icons-material/Apple';


function FourApp(props) {

    //배열변수선언
    const names=['영환','성경','호석','민규','성신','형준'];

    //배열을 변수에 저장 후 출력해도 된다.
    const namelist=names.map((name)=>(<li>{name}</li>));

    //색상을 5개 배열로 주고, 결과물을 div로 출력하세요(className을 box로 주고 할 것!)
    const colors=['red','orange','yellow','green','blue']
    const colorlist=colors.map((color)=>(<div style={{backgroundColor:color}}  className='box'>{color}</div>))

    return (
        <div>
            <h3 className='alert alert-info'>FourApp입니다.</h3>
            <Alert severity="warning">배열연습_#4<AppleIcon/></Alert>
            <div>
                <h3>map연습</h3>
                <ol>
                    {
                    //배열을 직접 리턴에 주기
                    names.map((name,index)=>(<b style={{marginLeft:'10px'}}>{index}:{name}</b>))
                    }
                </ol>
                <ol>
                    {namelist}
                </ol>
                    {colorlist}
            </div>
        </div>
    );
}

export default FourApp;