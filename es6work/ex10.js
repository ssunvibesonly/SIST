//배열연습
var numbers=[1,2,3,4,5];

//map은 배열의 요소를 하나씩 불러주는 것
var processed=numbers.map(function(num){
    return num*num;
});

console.log(processed); //1,4,9,16,25

var colors=['red','pink','gray','yellow','cyan'];

colors.map((color,index)=>{
    console.log(color,index);
})