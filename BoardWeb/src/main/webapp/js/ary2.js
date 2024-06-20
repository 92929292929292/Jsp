

let result = [23, 45, 22, 39, 10, 56].filter(function(item, idx, ary) {
	if(item % 2 == 0) {
		return item;
	}
});
//console.log(result);

//employees.forEach(console.log);

/*filterFnc = function(emp) {
	return emp.gender =='Female' && emp.salary > 5000;
}
*/
//급여가 5000이 넘는 여자만 필터링;

let over5000Sum = 0;
let over5000 = employees.filter( emp => emp.gender == 'Female' && emp.salary > 5000);

// [a, a, a] -> [A,A,A]

employees
	.map(function(elem, idx, ary){
		const obj = {}
		obj.name = elem.first_name + '-' + elem.last_name;
		obj.no = elem.id;
		obj.salary = elem.salary;
		return obj;
	})
	.forEach(console.log);
	
