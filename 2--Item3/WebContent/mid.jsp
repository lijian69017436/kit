<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/checksession.jsp"%>
<HTML>
<title>images/a11_2.gif</title>
<BODY background="images/col.gif">
	<DIV id=showmenu
		style="LEFT: 0px; WIDTH: 10px; POSITION: absolute; TOP: 221px; HEIGHT: 31px">
		<IMG onmouseover="this.style.cursor='hand'" onclick=leftmenu_ctrl()
			alt=显示菜单 src="images/menu/scroll_right.gif" id="myarrow">


		<script language="JavaScript">
var LEFT_MENU_VIEW=0;
function leftmenu_open(){
   LEFT_MENU_VIEW=0;
   leftmenu_ctrl();
}

function leftmenu_ctrl(){
   if(LEFT_MENU_VIEW==1){
      parent.setyou.cols="172,8,*";
      LEFT_MENU_VIEW=0;
      myarrow.src="images/menu/scroll_right.gif";
   }
   else{
      parent.setyou.cols="0,8,*";
      LEFT_MENU_VIEW=1;
      myarrow.src="images/menu/scroll_left.gif";
   }
}

function setPointer(theRow, thePointerColor){
    if (typeof(theRow.style) == 'undefined' || typeof(theRow.cells) == 'undefined'){
        return false;
    }
    var row_cells_cnt=theRow.cells.length;
    for (var c = 0; c < row_cells_cnt; c++){
        theRow.cells[c].bgColor = thePointerColor;
    }
    return true;
}

</script>


		<SCRIPT language=javascript>
//显示/隐藏左边帧( 默认情况下为显示左边帧 2003.4 )
var currentChoice = true;
arrow1=new Image;
arrow2=new Image;
arrow1.src="images/menu/scroll_right.gif";
arrow2.src="images/menu/scroll_right.gif";
function hidFrame(){
	if(currentChoice){
		if (parent.setyou.cols=="169,10,*"){	
			parent.setyou.cols="0,10,*";
			document.img1.src=arrow2.src;
			document.img1.alt="显示菜单";
		} else if (parent.setyou.cols=="169,10,*"){
			parent.setyou.cols="0,10,*";
			document.img1.src=arrow2.src;
			document.img1.alt="显示菜单";
		}
	} else {
		if (parent.setyou.cols=="0,10,*"){
			parent.setyou.cols="169,10,*";
			document.img1.src=arrow1.src;
			document.img1.alt="隐藏菜单";
		} else if (parent.setyou.cols=="0,10,*"){
			parent.setyou.cols="169,10,*";
			document.img1.src=arrow1.src;
			document.img1.alt="隐藏菜单";
		}
	}
	currentChoice = !currentChoice;
	
}

function hidFrame2(){
	parent.bottomFrame.cols="0,10,*";
	document.img1.src=arrow2.src;
	document.img1.alt="显示菜单";
	currentChoice = false;
}

function showFrame2(){
	parent.bottomFrame.cols="169,10,*";
	document.img1.src=arrow1.src;
	document.img1.alt="隐藏菜单";
	currentChoice = true;
	
}
</SCRIPT>

		<SCRIPT>
var top=54;//滚动滑块的开始位置

var frameHeight=document.body.offsetHeight;//滚动滑块可滑动距离

var barH=31;//滚动滑块高度
var currentY = 54;//滚动滑块当前位置
var contentFrame = parent.leftFrame;//被滚动的框架
var curObj = null;

function dropIt() {
curObj = null;
}

function scrollByStep(step) {
	contentFrame.scrollBy(0,step);
	scrollbar.style.pixelTop = (contentFrame.document.body.scrollTop)/(contentFrame.document.body.scrollHeight-contentFrame.document.body.clientHeight)*(frameHeight-top-barH)+top;
	if(scrollbar.style.pixelTop < top ) scrollbar.style.pixelTop=top;
	if(scrollbar.style.pixelTop > frameHeight-barH) scrollbar.style.pixelTop = frameHeight-barH;
}

function CatchIt() {
curObj = event.srcElement;
if (curObj.id!="bar") {curObj=null;return;}
if (curObj == null) { return;}
scrollbar.style.pixelTop = scrollbar.offsetTop;
currentX = (event.clientX + document.body.scrollLeft);
currentY = (event.clientY + document.body.scrollTop);
}

function moveIt() {
if (curObj == null) { return;}
if (curObj.id != "bar") { return;}
if (event.button!=1) {dropIt();return;}
newY = (event.clientY + document.body.scrollTop);
distanceY = (newY - currentY);
currentY = newY;
scrollbar.style.pixelTop += distanceY;
if(scrollbar.style.pixelTop < top) scrollbar.style.pixelTop = top;
scrollIt();
event.returnValue = false;
}
function scrollIt(){
	if(scrollbar.style.pixelTop < top ) scrollbar.style.pixelTop=top;
	if(scrollbar.style.pixelTop > frameHeight-barH) scrollbar.style.pixelTop = frameHeight-barH;
	sfTop=((scrollbar.style.pixelTop-top)/(frameHeight-barH-top))*(contentFrame.document.body.scrollHeight-contentFrame.document.body.clientHeight);
	contentFrame.scrollTo(0,sfTop);//滚动实现
}
document.onmousedown = CatchIt;
document.onmousemove = moveIt;
document.onmouseup = dropIt;
/*
	注意：

	滚动滑块的id为“bar”；并且放在id为“scrollbar”的层里。

*/
</script>
</BODY>
</HTML>
