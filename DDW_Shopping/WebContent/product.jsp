<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>当当网商品展示页面</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('#btnOK').on('click', function() {
			var page = $('#txtPage').val();
			if(page.length==0){
				page=1;
			}
			location.href = 'getgoods?page=' + page + '&count=12';
		});
	});
function lookDetail(id) {
	location.href = 'getgoodsbyid?t=1&id='+id;
}
</script>
</head>

<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<!--中间部分开始-->
<div id="main">
  <div class="dd_index_top_adver"><img src="images/dd_index_top_adver.jpg" alt="通栏广告图片" /></div>
  <div class="current_place">您现在的位置：<a href="index.jsp">当当图书</a> &gt;&gt; 小说 &gt;&gt; 财经</div>
  <!--左侧菜单开始-->
  <div id="product_left">
  <div id="product_catList">
   <div class="product_catList_top">浏览同级分类</div>
   <div id="product_catList_class"><!--使用javaScript显示图书分类--></div>
   </div>
  <div class="product_catList_end">
  <img src="images/product_01.gif" alt="shopping">
  <img src="images/product_02.gif" alt="shopping">
  </div>
  </div>
  <!--右侧内容开始-->
  <div id="product_storyList">
   <div id="product_storyList_top">
      <ul>
         <li>排序方式</li>
         <li><img src="images/dd_arrow_right.gif" alt="arrow"></li>
         <li><select id="compositor">
           <option>按销量 降序</option>
           <option>按价格 升序</option>
           <option>按价格 降序</option>
           <option>按折扣 升序</option>
           <option>按折扣 降序</option>
           <option>按出版时间 升序</option>
           <option>按出版时间 降序</option>
           <option>按上架时间 升序</option>
           <option>按上架时间 降序</option>
         </select></li>
         <li><img src="images/product_icon_01.gif" alt="icon"></li>
         <li><img src="images/product_icon_02.gif" alt="icon"></li>
         <li><img src="images/product_icon_03.gif" alt="icon"></li>
         <li><img src="images/product_icon_04.gif" alt="icon"></li>
         <li>每页显示的数量</li>
         <li><img src="images/dd_arrow_right.gif" alt="arrow"></li>
         <li><img src="images/product_icon_20.gif" alt="icon"></li>
         <li><img src="images/product_icon_40.gif" alt="icon"></li>
         <li style="float:right; padding-right:10px;"><img src="images/product_page_down.gif" alt="icon"></li>
         <li style="float:right;">第1页</li>
         <li style="float:right;"><img src="images/product_page_up.gif" alt="icon"></li>
      </ul>
      </div>
      <!--图书排列开始-->
   <div class="product_storyList_content">
  
   <table width="100%">
   <!--列表开始-->
   <c:forEach items="${pb.list}" var="book" varStatus="vs">
         <c:if test="${(vs.count-1)%4==0}">
         	<tr>
         </c:if>
         <td><img width="80px" height="80px" src="../upload/${book.picture}" alt="${book.name}" onclick="lookDetail(${book.id })"><br/>
         名称：${book.name }<br/>
         价格：${book.price }<br/>
         评分：<c:forEach begin="1" end="${book.star}">
              		<img src="images/star_red.gif" alt="star" />
              	</c:forEach>
              	<br/>
          </td>
           <c:if test="${(vs.count-1)%4==3}">
         	</tr>
         </c:if>
   </c:forEach>
   </table>  
   <div>
       <dl class="product_content_dd">
       <dd><input type="button" id="btnOK" value="确定"></dd>
       <dd>页</dd>
       <dd><input id="txtPage" name="page" type="text" value="${pb.currPage}" style="width:20px;"></dd>
       <dd>跳转到第</dd>
       <c:if test="${pb.currPage < pb.totalPage}">
       <dd><a href="getgoods?page=${pb.currPage+1}&count=${pb.count}"><img src="images/next.gif" alt="ok" id="btnNextPage"></a></dd>
       </c:if>
        <c:if test="${pb.currPage > 1}">
        <dd><a href="getgoods?page=${pb.currPage-1}&count=${pb.count}"><img src="images/product_page_up.gif" alt="ok" id="btnPrevPage"></a></dd>
        </c:if>
       </dl>
   </div>
   </div>
  </div>
  <!--右侧内容结束-->
  <script src="js/product.js" type="text/javascript"></script>
</div>
<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
