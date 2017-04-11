
//1,如果 没有项目名 用户   / 就成 
//2,如果有项目名  用户   ../

function sy(){
	var curWwwPath = window.document.location.href;
	var pathName =  window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPaht = curWwwPath.substring(0,pos);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return (localhostPaht + projectName);
}