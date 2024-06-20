//댓글리스트 출력
svc.replyList(bno, replyListFnc);

function replyListFnc() {
	let data = JSON.parse(this.responseText);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
}

function cloneRow(reply ={}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	template.style.display = 'block';
	template.setAttribute('id', reply.replyNo);
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	return template;
}

//댓글 삭제
function deleteRow(e) {
	let li = e.target.parentElement.parentElement;
	let rno = li.getAttribute('id');
	
	svc.removeReply(rno, deleteReplyFnc);
	// 아래 함수가 위 문장으로 전달
	function deleteReplyFnc() {
		let result = JSON.parse(this.responseText);
		if(result.retCode=='OK') {
			alert(result.retMsg);
			document.getElementById(rno).remove();
		} else {
			alert('Error=>' + result.retMsg);
		}
	}
}

//댓글등록 이벤트
document.getElementById('addReply').addEventListener('click', addReplyFnc);

function addReplyFnc() {
	if(!replyer) {
		alert('로그인하세요!!');
		return;
	}
	
	let reply = document.getElementById('reply').value;
	
	if(!reply) {
		alert('댓글 내용이 없습니다!!');
		return;
	}
	
	svc.addReply({replyer, reply, bno}, addReplyCallback);
}

function addReplyCallback() {
	//화면에 댓글정보 갱신
	let result = JSON.parse(this.responseText);
	if(result.returnCode=='OK'){
		alert('등록성공!!');
		document.querySelector('div.content>ul').appendChild(cloneRow(result.retVal));
		document.getElementById('reply').value = '';
	} else {
		alert('등록실패!!' + result.retVal);
	}
}

