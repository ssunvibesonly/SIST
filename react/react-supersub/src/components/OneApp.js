import React, { useState } from 'react';
import Alert from '@mui/material/Alert';
import AcUnitIcon from '@mui/icons-material/AcUnit';
import RowItemApp from './RowItemApp';
import WriteForm from './WriteForm';
function OneApp(props) {

    const [board,setBoard]=useState([

        {
            name:'유재석', //이어지는 컬럼이 있으면 , 로 준다.
            photo: '유재석',
            blood: 'A',
            today: new Date()
        },
        {
            name:'장순영', //이어지는 컬럼이 있으면 , 로 준다.
            photo: '증명사진',
            blood: 'O',
            today: new Date()
        },
        {
            name:'김선범', //이어지는 컬럼이 있으면 , 로 준다.
            photo: '선범증명사진',
            blood: 'O',
            today: new Date()
        },
        {
            name:'진현규', //이어지는 컬럼이 있으면 , 로 준다.
            photo: '현규사진',
            blood: 'B',
            today: new Date()
        }
    ]);

    //데이터 추가하는 함수이벤트
    //board를 바꾸면 렌더링이 되면서 추가된다
    const datasave=(data)=>{
        setBoard(board.concat({
            name:data.name,
            photo:data.photo,
            blood:data.blood,
            today:new Date()
        }))
    }

    // 데이터 삭제하는 함수
    //index가 아닌 것들을 다시 setBoard 취합
    const deleteData = (index) => {
        setBoard(board.filter((item,i)=>(i!==index)));
    };

    return (
        <div style={{marginLeft:'100px'}}>
            <Alert severity="error">OneApp!!!(부모 자식간의 통신)<AcUnitIcon/></Alert>
            <WriteForm onSave={datasave}/>
            <table className='table table-bordered' style={{width:'500px'}}>
                <caption align='top'><b>Board 배열 출력</b></caption>
                <thead>
                    <tr className='table-success'>
                        <th width='100'>이름</th>
                        <th width='120'>사진</th>
                        <th width='80'>혈액형</th>
                        <th width='160'>날짜</th>
                        <th width='70'>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        //데이터 갯수만큼 호출됨..출력은 아직 안됨..출력은 RowItem
                        board.map((row,index)=>(<RowItemApp row={row} idx={index} onDelete={deleteData}/>))

                    }
                </tbody>
            </table>
        </div>
        
    );
}

export default OneApp;