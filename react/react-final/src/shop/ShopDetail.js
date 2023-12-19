import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

function ShopDetail(props) {

    const {num}=useParams();
    const navi=useNavigate();

    //삭제 다이얼로그에 관한 코드 추가(mui)
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    //dto들어올 변수 선언
    const [data,setData]=useState('');
    
    //url등록
    let detailUrl="http://localhost:9000/shop/detail?num="+num;
    let photoUrl="http://localhost:9000/save/";
    let deleteUrl="http://localhost:9000/shop/delete?num="+num;

    //스프링으로부터 num에 해당하는 data받기
    const onDataReceive=()=>{
        axios.get(detailUrl)
        .then(res=>{

            console.log(res.data.sangpum);
            setData(res.data);
        }).catch(err=>{
            alert(err.data);
        })
    }

    //처음 렌더링시 위의 함수 호출
    useEffect(()=>{
        onDataReceive();
    },[]);

    //삭제시 호출될 함수
    const onDelete=()=>{

        console.log('delete');

        //백엔드에서 deletemapping안하고 get했으면 getmapping으로 해줘야함
        axios.delete(deleteUrl)
        .then(res=>{
            //삭제 후 목록으로 이동
            navi("/shop/list")
        })

        handleClose(); //다이얼로그 닫아주는 것
    }


    return (
        <div>
            {/* num 출력 시 db에서 가져올 수 있음 */}
            {/* <h1>{num}</h1> */}
            <div>
                <table className='table table-bordered' style={{width:'500px'}}>
                    <caption align='top'><b>상품 상세보기</b></caption>
                <tbody>
                    <tr style={{height:'150px'}}>
                        <td width='350' rowSpan='4'>
                            <img src={photoUrl+data.photo} className='large'/>
                        </td>
                        <td>
                            <h4>상품명 : {data.sangpum}</h4>
                        </td>
                    </tr>
                    <tr>
                        <h4><td>수량:{data.su}</td></h4>
                    </tr>
                    <tr>
                        <h4><td>단가:{data.dan}</td></h4>
                    </tr>
                    <tr>
                        <h4><td>입고일:{data.ipgoday}</td></h4>
                    </tr>
                    <tr>
                        <td colSpan='2' align='center'>
                            <button type='button' className='btn btn-outline-info' 
                            onClick={()=>{
                                navi("/shop/list")
                            }}>목록</button>
                            <button type='button' className='btn btn-outline-warning' onClick={()=>{
                                navi("/shop/form")
                            }}>추가</button>
                            <button type='button' className='btn btn-outline-success'>수정</button>
                            <button type='button' className='btn btn-outline-danger'onClick={handleClickOpen}>삭제</button>
                        </td>
                    </tr>
                </tbody>
                </table>
            </div>
            
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                <h4>상품삭제확인</h4>
                </DialogTitle>
                <DialogContent>
                <DialogContentText id="alert-dialog-description">
                    <h5>상품을 삭제하려면 [확인] 버튼을 눌러주세요</h5>
                </DialogContentText>
                </DialogContent>
                <DialogActions>
                <Button onClick={onDelete} autoFocus>
                    확인
                </Button>
                <Button onClick={handleClose}>취소</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}

export default ShopDetail;