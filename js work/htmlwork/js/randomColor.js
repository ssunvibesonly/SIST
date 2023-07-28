function randomColor(){
    //rgb 색상 얻기
    var r=parseInt(Math.random()*256); //0~255
    var g=parseInt(Math.random()*256); //0~255
    var b=parseInt(Math.random()*256); //0~255
    var pcolor="rgb"+"("+r+","+g+","+b+")";

    return pcolor;
}
