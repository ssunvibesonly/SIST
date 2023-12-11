import React from 'react';
import Alert from '@mui/material/Alert';
import CardGiftcardIcon from '@mui/icons-material/CardGiftcard';
import img1 from '../image/bb1.png';
import img2 from '../image/bb2.png';
import img3 from '../image/bb3.png';
import img4 from '../image/bb4.png';
import img5 from '../image/bb5.png';


function FiveApp(props) {

    //이미지를 배열변수에 넣기(src)
    const imgArr=[img1,img2,img3,img4,img5];
    const imglist=(imgArr).map((img)=><div><img src={img} style={{width:'100px'}}/></div>)

    //이미지를 배열변수에 넣기(public)
    const imgArr2=['kda아칼리','미포','사미라','카이사','트리스타나'];
    return (
        <div>
            <h3 className='alert alert-info'>FiveApp입니다.</h3>
            <Alert severity="error">배열연습_#5<CardGiftcardIcon/></Alert>
            {/* public에 있는 이미지는 그냥 호출해서 쓸 수 있지만,
            src 경로에 있는 이미지는 import를 해서 사용하는게 원칙이다. */}
            <h4>src의 이미지를 배열로 넣어 반복하기</h4>
            {imglist}

            <h4>public의 이미지를 배열에 넣어 반복하기</h4>
            {
                //예전 방식
                // imgArr2.map((photo)=>(<img className='photo' src={'../image2/'+photo+'.png'}/>))

                //리터럴 방식(작은 따옴표(')가 아니라 백틱(`)이다)
                imgArr2.map((photo)=>(<img src={`../image2/${photo}.png`} className='photo'/>))
            }

        </div>
    );
}

export default FiveApp;