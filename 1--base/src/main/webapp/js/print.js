//1用 <!--startprint1-->  <!--endprint1--> 把要打印的内容包围
//2设置一个 按钮  触发 preview 函数  preview(1)
//3点击打印按钮   打印
//4扩展  打印是没有样式的 可以用 <style media="print">  来 调整样式
function preview(oper)	{
	if (oper < 10){
		bdhtml=window.document.body.innerHTML;//获取当前页的html代码
		sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
		eprnstr="<!--endprint"+oper+"-->";// 设置打印结束区域
		prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
		window.document.body.innerHTML=prnhtml;
		window.print();
		window.document.body.innerHTML=bdhtml;
	} else {
		window.print();
	}
}

