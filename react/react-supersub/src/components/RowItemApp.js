import React from 'react';

function RowItemApp({row,idx,onDelete}) {
    
    //let {row,idx,onDelete}=props; //함수 부분에 props로 값을 넘길 땐 이런 식으로 써줘도 된다.

    const btnDelete=()=>{
        onDelete(idx); //부모가 props로 보낸 이벤트 호출
    }
    return (
        <tr>
            <td>{row.name}</td>
            <td><img src={`../image/${row.photo}.png`} style={{width:'60px',border:'1px solid gray',
        height:'80px'}}/></td> 
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString('ko-kr')}</td>
            <td>
                <button type='button' className='btn btn-danger' onClick={btnDelete}>삭제</button>
            </td>
        </tr>
    );
}
    export default RowItemApp;