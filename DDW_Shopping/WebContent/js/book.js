// JavaScript Document
/*获取元素对象*/
function $(element) {
	return document.getElementById(element);
}

/*默认图片数组，用于滚动的*/
var scorll_img = new Array();
scorll_img[0] = "images/dd_scroll_1.jpg";
scorll_img[1] = "images/dd_scroll_2.jpg";
scorll_img[2] = "images/dd_scroll_3.jpg";
scorll_img[3] = "images/dd_scroll_4.jpg";
scorll_img[4] = "images/dd_scroll_5.jpg";
scorll_img[5] = "images/dd_scroll_6.jpg";
/*滚动序号*/
var scroll_number = new Array();
scroll_number[0] = "scroll_number_1";
scroll_number[1] = "scroll_number_2";
scroll_number[2] = "scroll_number_3";
scroll_number[3] = "scroll_number_4";
scroll_number[4] = "scroll_number_5";
scroll_number[5] = "scroll_number_6";
var NowFrame = 1; //初始1
var MaxFrame = 6; //最大6
function loopShow(d1) {
	if (Number(d1)) {
		NowFrame = d1; //验证是否为数字
	}
	for ( var i = 1; i < (MaxFrame + 1); i++) {
		if (i == NowFrame) {
			document.getElementById("dd_scroll").src = scorll_img[i - 1]; //上一张
			document.getElementById(scroll_number[i - 1]).className = "scroll_number_over"; //鼠标进入
		} else {
			document.getElementById(scroll_number[i - 1]).className = "scroll_number_out";//鼠标离开
		}
	}
	if (NowFrame == MaxFrame) { //最后一张
		NowFrame = 1;
	} else {
		NowFrame++;
	}
}
var theTimer = setInterval('loopShow()', 3000); //定时器，3秒换一张	

/*记录图书信息*/
var bookCate = new Array();
bookCate[0] = "book_history";
bookCate[1] = "book_family";
bookCate[2] = "book_culture";
bookCate[3] = "book_novel";
var bookClass = new Array();
bookClass[0] = "history";
bookClass[1] = "family";
bookClass[2] = "culture";
bookClass[3] = "novel";
function bookPutUp(elementId) {
	for ( var i = 0; i < bookCate.length; i++) {
		if (elementId == i) {
			document.getElementById(bookCate[i]).className = "book_show";
			document.getElementById(bookClass[i]).className = "book_type_out";

		} else {
			document.getElementById(bookCate[i]).className = "book_none";
			document.getElementById(bookClass[i]).className = "book_type";
		}
	}
}

/*获取对象*/
var dome = $("dome");
var dome1 = $("dome1");
var dome2 = $("dome2");
var speed = 50; //速度
dome2.innerHTML = dome1.innerHTML;
//移动的速度
function moveTop() {
	if (dome2.offsetTop - dome.scrollTop <= 0) //高度在范围之内
		dome.scrollTop -= dome1.offsetHeight; //向上移动
	else {
		dome.scrollTop++;
	}
}
var MyMar = setInterval(moveTop, speed);
//鼠标进入，停止动画
dome.onmouseover = function() {
	clearInterval(MyMar);
};
//鼠标离开，继续移动
dome.onmouseout = function() {
	MyMar = setInterval(moveTop, speed);
};

/*记录上下左右位置*/
var rightT;
var rightR;
var objRight;
var rightWidth;
function place() {
	objRight = document.getElementById("right");
	rightWidth = document.getElementById("right1").width;
	if (objRight.currentStyle) {//IE浏览器
		rightT = parseInt(objRight.currentStyle.top);
		rightR = parseInt(objRight.currentStyle.right);
	} else {//fireFox等浏览器
		rightT = parseInt(document.defaultView.getComputedStyle(objRight, null).top);
		rightR = parseInt(document.defaultView.getComputedStyle(objRight, null).right);
	}

}

function move() {
	objRight.style.top = rightT + parseInt(document.documentElement.scrollTop)
			+ "px";
	objRight.style.left = parseInt(document.documentElement.scrollLeft)
			+ parseInt(document.documentElement.clientWidth) - rightR
			- rightWidth + "px";
	document.getElementById("dd_close").style.left = "63px";
}

window.onload = place;
window.onscroll = move;

/*关闭移动框*/
function dd_close() {
	var objRight = document.getElementById("right");
	objRight.style.display = "none";
}
/*打开*/
window.open('open.html', '',
		'top=0,left=200,width=500,height=327,scrollbars=0,resizable=0');
