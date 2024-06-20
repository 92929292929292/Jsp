document.getElementById('dom').remove();

const obj = {
	data : '',
	fields: ['id','first_name','email','salary'],
	showList: function(ary = []){
		ary.forEach(emp=>document.querySelector('#list').appendChild(this.makeRow(emp)));
	},
	makeRow(emp= {id, first_name, email, salary}) {
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = emp[field];
			tr.appendChild(td);
		});
		return tr;
	}
}

document.getElementById('addBtn').addEventListener('click', function(e){
const emp = { id:document.getElementById('id').value,
first_name:document.getElementById('first_name').value,
email:document.getElementById('email').value,
salary:document.getElementById('salary').value }

document.querySelector('#list').appendChild(obj.makeRow(emp));
});

obj.showList(employees);

const today = new Date();

Date.prototype.format = function() {
	let yy = this.getFullYear();
	let mon = this.getMonth() + 1;
	let dd = this.getDate();
	
	return yy+'-'+mon+'-'+dd;	
}
console.log(today.format());