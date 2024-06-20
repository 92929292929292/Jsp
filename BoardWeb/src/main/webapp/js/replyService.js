const svc = {
	replyList(bno=1, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyListJson.do?bno='+bno);
		xhtp.send();
		xhtp.onload=successCall;
	},
	
	getReply() {
		
	},
	
	addReply(rvo= {replyer, reply, bno}, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('bno='+ rvo.bno +'&replyer='+ rvo.replyer +'&reply='+ rvo.reply);
		xhtp.onload=successCall;
	},
	
	removeReply(rno=1, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno='+rno);
		xhtp.send();
		xhtp.onload=successCall;
	}
}