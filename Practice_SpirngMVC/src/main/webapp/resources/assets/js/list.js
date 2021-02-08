
function btnAction(btn) {
	const li = document.getElementById("content-list-item");
	// data-*에 정의한 속성값은 element.dataset.*을 통해 접근할 수 있다.
	// alert("눌린 버튼 : " + btn.dataset.btnType)
	// const prefix = "/practice_mvc/rest/";
	const uri = prefix + btn.dataset.btnType;
	
	// alert(uri);
	
	
	/* Ajax : Asynchronous JavaScript and XML (or JSON)
		- 웹 서버와 비동기적으로 상호작용 할 수 있다.
		- 페이지를 변화시키지 않으면서 웹 서버로 요청을 보낸다.
		- 보낸 요청이 도착하면 readyState값이 변한다.
		- 받은 응답을 통해 하고싶은 것을 한다.
	*/
	
	xhttp = new XMLHttpRequest();
	
	// readyState가 변할때마다 발생하는 이벤트를 생성
	xhttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE // 4
				&& this.status == 200){
			// 우리가 @RestController에서 응답한 내용
			const ul = document.getElementById("content-list");
			var newLi = document.createElement("li");
			newLi.innerHTML = this.responseText;
			ul.appendChild(newLi);
			
		} else {
			
		}
		
	}
	
	// open(method, uri, true)
	xhttp.open('GET', uri, true); // 1
	xhttp.send(); // 2
	
	console.log('sent xhttp ...');
}

function addList() {
	const ul = document.getElementById("content-list");
	var newLi = document.createElement("li");
	newLi.innerHTML = "비어 있음 JS";
	
	ul.appendChild(newLi);
}


function printXML(btn) {
	const li = document.getElementById("content-list-item");
	
	const uri = prefix + btn.dataset.btnType;
	
	xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE 
				&& this.status == 200){
			
			li.innerHTML = this.responseXML;
			
			console.log(this.responseXML);
			
		} else {
			
		}
	
	}
	
	xhttp.open('GET', uri, true);
	
	xhttp.send();
	
}
	


