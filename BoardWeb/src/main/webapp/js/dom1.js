let cnt1 = 0;

//document.getElementsById('fruit').style.display = 'none';
document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');

//추가버튼 클릭이벤트 등록.
document.getElementById('addBtn').addEventListener('click', addMemberFnc);
document.getElementById('modBtn').addEventListener('click', modMemberFnc);
document.getElementById('delBtn').addEventListener('click', remMemberFnc);
document.querySelector('thead input[type="checkbox"]').addEventListener('change', allCheckFnc);

function remMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	for(let tr of targetTr) {
		if(tr.children[5].children[0].checked){
			tr.remove()
		}
	}
}

function allCheckFnc() {
	document.querySelectorAll('tbody#memberList tr').forEach(item => item.children[5].children[0].checked = this.checked);
	
	/*let targetTr = document.querySelectorAll('#memberList tr');
	if(this.checked == true) {
		for(let tr of targetTr) {
				tr.children[5].children[0].checked = true;
		}
	} else if(this.checked == false) {
		for(let tr of targetTr) {
			tr.children[5].children[0].checked = false;
		}
	}*/
}

//페이지 로딩하면서 회원 3명 출력.
for (let mem of myMembers){
	document.getElementById('memberList').appendChild(addRow(mem));
}

function addMemberFnc(){
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;
	
	if(!id || !name || !phone || !point) {
		alert('필수값을 입력.');
		return;
	}
	
	document.getElementById('memberList').appendChild(addRow({id, name, phone, point}));
	
	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value = "";
} //end of addMemberFnc()

function modMemberFnc(){
	const id = document.getElementById('mid').value;
	let targetTr = document.querySelectorAll('#memberList tr');
	for(let tr of targetTr) {
		if(tr.children[0].innerText == id){
			tr.children[1].innerText = document.getElementById('mname').value;
			tr.children[2].innerText = document.getElementById('mphone').value;
			tr.children[3].innerText = document.getElementById('mpoint').value;
		}
	}
}

function addRow(member = {id, name, phone, point}) {
	// tr > td * 4
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);
	
	for ( let prop in member ) {
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}
	//삭제 버튼 생성 //<td><button>삭제</button></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', removeTrElement);
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	//체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	btn.addEventListener('click', cnt);
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}//end of addRow()

function removeTrElement(e){
	console.log('btn', e);
	e.stopPropagation(); //상위요소로 이벤트 전파 차단
	console.log(this.parentElement.parentElement.remove());
}



function cnt(){
	let targetTr = document.querySelectorAll('#memberList tr');
	
	if(this.checked==true){
		cnt1+=1;
	} else if(this.checked==false) {
		cnt1-=1;
	}
	if(cnt1==targetTr.length){
		document.querySelector('thead input[type="checkbox"]').cheacked = true;
	}
}

function showDetailFnc(e){
	document.getElementById('mid').value = this.children[0].innerText;
	document.getElementById('mname').value = this.children[1].innerText;
	document.getElementById('mphone').value = this.children[2].innerText;
	document.getElementById('mpoint').value = this.children[3].innerText;
}