const xthp = new XMLHttpRequest();
xthp.open('get', 'membersAjax.do');
xthp.send();
xthp.onload=function(){
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(user => document.getElementById('List').appendChild(makeRow(user)));
};

const fields = ['userId', 'userName', 'userPw', 'responsibility'];
function makeRow(obj = {}){
	let tr = document.createElement('tr');
	tr.addEventListener('dblclick', function(e){
		document.getElementById('myModal').style.display = 'block';
		document.getElementById('modify_id').value = this.children[0].innerHTML;
		document.getElementById('modify_name').value = this.children[1].innerHTML;
		document.getElementById('modify_pass').value = this.children[2].innerHTML;
	});
	
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	
    btn.addEventListener('click', function(){
		
		let id = tr.children[0].innerText;
	
		const addAjax = new XMLHttpRequest();
		let url = 'removeIdAjax.do?id='+id;
		addAjax.open('get', url);
		addAjax.send();
		addAjax.onload=function(){
			let result = JSON.parse(addAjax.responseText);
			if(result.retCode == 'OK'){
				let targetTr = document.querySelectorAll('#List tr');
					for(let tr of targetTr) {
						tr.remove()
					}
				const xthp = new XMLHttpRequest();
				xthp.open('get', 'membersAjax.do');
				xthp.send();
				xthp.onload=function(){
					console.log(xthp);
					let data = JSON.parse(xthp.responseText);
					data.forEach(user => document.getElementById('List').appendChild(makeRow(user)));
				};		
				alert(result.retMsg);	
			} else {
				alert('Nope');
			}
	    }
	});
	
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

document.getElementById('addBtn').addEventListener('click', function(){
	let id = document.getElementById('uid').value;
	let pw = document.getElementById('upw').value;
	let nm = document.getElementById('unm').value;
	let rp = document.getElementById('auth').value;
	
	const addAjax = new XMLHttpRequest();
	let url = 'addAjax.do?id='+id+'&pw='+pw+'&nm='+nm+'&rp='+rp;
	addAjax.open('get', url);
	addAjax.send();
	addAjax.onload=function(){
		let result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'OK'){
			let newMem = {userId: id, userName:nm, userPw:pw, responsibility:rp};
			document.getElementById('List').appendChild(makeRow(newMem));
			alert(result.retMsg);	
		} else {
			alert('Nope');
		}
	}
})


document.getElementById('remBtn').addEventListener('click', function(){
	let id = document.getElementById('uid').value;
	
	const addAjax = new XMLHttpRequest();
	let url = 'removeIdAjax.do?id='+id;
	addAjax.open('get', url);
	addAjax.send();
	addAjax.onload=function(){
		let result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'OK'){
			let targetTr = document.querySelectorAll('#List tr');
				for(let tr of targetTr) {
				tr.remove()
			}
			const xthp = new XMLHttpRequest();
			xthp.open('get', 'membersAjax.do');
			xthp.send();
			xthp.onload=function(){
				console.log(xthp);
				let data = JSON.parse(xthp.responseText);
				data.forEach(user => document.getElementById('List').appendChild(makeRow(user)));
			};		
			alert(result.retMsg);	
		} else {
			alert('Nope');
		}
	}
})



document.getElementById('modBtn').addEventListener('click', function(){
	let id = document.getElementById('modify_id').value;
	let pw = document.getElementById('modify_pass').value;
	let nm = document.getElementById('modify_name').value;
	
	const modAjax = new XMLHttpRequest();
	modAjax.open('get', 'modAjax.do?id='+id+'&pw='+pw+'&nm='+nm);
	modAjax.send();
	modAjax.onload=function(){
		let result = JSON.parse(modAjax.responseText);
		if(result.retCode == 'OK'){
			let targetTr = document.querySelectorAll('#List tr');
				for(let tr of targetTr) {
				tr.remove()
			}
			const xthp = new XMLHttpRequest();
			xthp.open('get', 'membersAjax.do');
			xthp.send();
			xthp.onload=function(){
				console.log(xthp);
				let data = JSON.parse(xthp.responseText);
				data.forEach(user => document.getElementById('List').appendChild(makeRow(user)));
			};		
			alert(result.retMsg);	
		} else {
			alert('Nope');
		}
	}
	
	document.getElementById('myModal').style.display = 'none';
});


document.getElementById('uid').addEventListener('change', function(){
	let checkId = this.value;
	const checkAjax = new XMLHttpRequest();
	checkAjax.open('get', 'checkIdAjax.do?id='+checkId);
	checkAjax.send();
	checkAjax.onload = function() {
		let result = JSON.parse(checkAjax.responseText);
		if (result.retCode == 'Exist') {
			alert('이미 존재하는 아이디입니다.');
			document.querySelector('#addBtn').disabled = true;
		} else {
			alert('등록 가능한 아이디입니다.');
			document.querySelector('#addBtn').disabled = false;
		}
	}
	
});