function createPersonItem(m){
	var li=document.createElement("li");
	li.className="list-group-item";
	var row=createDivByClass("row");
	li.appendChild(row);
	
	var avatar=createAvatar(m.avatar);
	row.appendChild(avatar);
	
	var col=createDivByClass("col-sm-9");
	row.appendChild(col);
	
	var id=createId(m.id);
	col.appendChild(id);
	
	var introduction=createIntruduction(m.introduction);
	col.appendChild(introduction);
	
	var watch=createWatch(m.watch);
	row.appendChild(watch);
	
	var article=createArticle(m.article);
	row.appendChild(article);
	
	var button=createButton();
	li.appendChild(button);
	
	document.getElementById("peopleList").appendChild(li);
}

function createAvatar(avatar){
	var col=createDivByClass("col-sm-1")
	var img=document.createElement("img");
	img.className="img-rounded";
	img.src=avatar;
	img.style.cssText="height: 50px; width: 50px;"
	col.appendChild(img);
	return col
}
function createId(id){
	var row=createDivByClass("row");
	var col=createDivByClass("col-sm-12 pull-left");
	var a=document.createElement("a");
	a.innerHTML=id;
	a.href="#";
	col.appendChild(a);
	row.appendChild(col);
	return row;
}

function createIntruduction(introduction){
	var row=createDivByClass("row");
	var col=createDivByClass("col-sm-12 pull-right");
	col.innerHTML=introduction;
	row.appendChild(col);
	return row;
}

function createWatch(num){
	var col1=createDivByClass("col-sm-1");
	var row=createDivByClass("row");
	var col2=createDivByClass("col-sm-12");
	col2.innerHTML="watch <br> <strong>"+num+"</strong>"
	row.appendChild(col2);
	col1.appendChild(row);
	return col1;
}

function createArticle(num){
	var col1=createDivByClass("col-sm-1");
	var row=createDivByClass("row");
	var col2=createDivByClass("col-sm-12");
	col2.innerHTML="article <br> <strong>"+num+"</strong>"
	row.appendChild(col2);
	col1.appendChild(row);
	return col1;
}

function createDivByClass(className){
	var div=document.createElement("div");
	div.className=className;
	return div;
}

function createButton(){
	var row=createDivByClass("row");
	var right=createDivByClass("pull-right");
	right.innerHTML="<button type=\"button\" class=\"btn btn-primary\">watch <span class=\"glyphicon glyphicon-heart\"></span></button>";
	row.appendChild(right)
	return row;
}
