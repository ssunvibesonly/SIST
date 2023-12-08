import React, {useState} from 'react';

function TwoApp(props) {

    const [photo,setPhoto]=useState('../image2/카이사.png');
    const changePhoto=(e)=>{
        setPhoto(e.target.value);
    }


    return (
        <div>
            <h3 className='alert alert-info'>TwoApp입니다._radio버튼</h3>
            <div><b>이미지 선택 : </b><br/>
                <label>
                    <input type='radio' name='photo' value='../image2/카이사.png'
                   onClick={changePhoto} defaultChecked/> 이미지1
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='photo' value='../image2/미포.png'
                    onClick={changePhoto}/> 이미지2
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='photo' value='../image2/사미라.png'
                    onClick={changePhoto}/> 이미지3
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='photo' value='../image2/kda아칼리.png'
                    onClick={changePhoto}/> 이미지4
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='photo' value='../image2/트리스타나.png'
                    onClick={changePhoto}/> 이미지5
                </label>
                &nbsp;&nbsp;
            </div>
            <img src={photo} />
        </div>
    );
}

export default TwoApp;