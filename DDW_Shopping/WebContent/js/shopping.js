// JavaScript Document
/*切换图片*/
function shopping_commend_show() {
	var imgId = document.getElementById("shopping_commend_arrow"); //图片对象
	var sortId = document.getElementById("shopping_commend_sort"); // 排序对象

	if (sortId.style.display == "none") {
		sortId.style.display = "block";
		imgId.src = "images/shopping_arrow_up.gif";
	} else {
		sortId.style.display = "none";
		imgId.src = "images/shopping_arrow_down.gif";
	}

}

/* 鼠标进入改变颜色 */
function productOver(elementId) {
	var Element = document.getElementById(elementId);
	Element.style.backgroundColor = "#ffffff";
}

/* 鼠标离开改变颜色 */
function productOut(elementId) {
	var Element = document.getElementById(elementId);
	Element.style.backgroundColor = "#fefbf2";
}

/* 删除商品 */
function deleteProduct(elementId) {
	var delElement = document.getElementById(elementId); // 获取对象
	var flag = confirm("确认删除吗？");
	if (flag == true) {
		delElement.parentNode.removeChild(delElement);
		productCount();
	}
}