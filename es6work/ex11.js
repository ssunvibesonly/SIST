const array=[1,2,3,4,5]; //3을 제거하고 싶다.
//const delIndex=2; 3을 제거하고 싶으면 인덱스 2를 제거한다

array.splice(2,1) //인덱스 2번에 1개를 삭제한다는 뜻
console.log(array);

//slice
//slice는 원본 배열은 건드리지 않고 수정된복사 배열을 리턴한다.(교체는 안됨)
//3,4를 출력
var array2=[1,2,3,4,5];
var a2=array2.slice(2,4); //시작 인덱스, 뽑고싶은 자리의 갯수(인덱스아님)-1
console.log(a2);

var a3=array2.slice(1,4);
console.log(a3);

//Arrays.concat(value);
//concat메서드는 원하는 값을 원본배열 끝에 추가한 뒤 새로운 배열을 만든다.
let con=[1,2,3].concat([4,5],[6,7]);
console.log(con);

//filter
var arr=[1,2,3,4,5]; //2를 제거하고 싶다.
var delIndex=1; //2의 인덱스는 1이다.

arr=arr.filter(function(item,index){ //filter안에 인자로 함수를 받고, index만 필요하니까 명시

    return index !==delIndex; //배열을 돌면서 인덱스 1이 아닌 나머지만 다시 소집

});
console.log(arr);
