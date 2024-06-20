document.querySelectorAll('.container-fluid h3') // NodeList
.forEach(item => item.remove());

document.querySelectorAll('.container-fluid table.table') // NodeList
.forEach(item => item.remove());

document.getElementById('fruit').remove();

// 달력을 첫째날 계산하는 함수, 마지막날 계산 함수
function getFirstDay(month = 6) {
	switch(month){
		case 5:
			return 4;
		case 7:
			return 2;
	}
	
	return 7;
}

function getLastDate(month = 6) {
	switch(month){
		case 5:
		case 7:
			return 31;
	}
	return 30;
}

function makeCalender(month = 6) {
	document.getElementById('show').innerHTML = '';
	console.log(month);
	//table 생성. border="2"
	let tbl = document.createElement('table');
	tbl.setAttribute('class', 'table');
	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');
	
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	let tr = document.createElement('tr');
	
	days.forEach(day => {
		let td = document.createElement('th');
		td.innerHTML = day;
		tr.setAttribute('align', 'center');
		tr.appendChild(td);
		
	})
	
	thd.appendChild(tr);
	
	// tbody 하위요소.
	tr = document.createElement('tr');
	// 빈날짜
	for(let i = 1; i< getFirstDay(month); i++){
		let td = document.createElement('td');
		tr.appendChild(td);
	}

	//날짜 출력
	for(let d = 1; d <= getLastDate(month); d++){
		let td = document.createElement('td');
		td.innerHTML = d;
		td.setAttribute('align', 'center');
		//토요일 배경 파란색
		if( (d+getFirstDay(month)-1)%7 == 0 ) { 
			td.style.background = "blue"
			td.style.color = "white"
		}
		//일요일 배경 빨간색
		if( (d+getFirstDay(month)-2)%7 == 0 ) { 
			td.style.background = "red"
			td.style.color = "white"
		}
		tr.appendChild(td);
		if( (d+getFirstDay(month)-1)%7 == 0 ) { //7일마다 줄바꿈
			tbd.appendChild(tr);
			tr = document.createElement('tr');
		}
	}
	tbd.appendChild(tr);
	
	tbl.appendChild(thd);
	tbl.appendChild(tbd);
	
	document.getElementById('show').appendChild(tbl);
}

document.getElementById('selectMonth').addEventListener('change', function(){
	makeCalender(Number(this.value));
})


