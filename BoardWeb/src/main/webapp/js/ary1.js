const numAry = [23, 17, 6, 41, 30, 12];
let result = 0;
let result2 = 0;

let evenSum = function(elem, idx, ary) {
	console.log(elem, idx, ary);
	if(elem % 2 == 0) {
		result += elem;
	}
}

let oddSum = function(elem, idx, ary) {
	console.log(elem, idx, ary);
		if((idx+1) % 2 == 1) {
			result += elem;
		}
}

let under35 = function(elem, idx, ary) {
	console.log(elem, idx, ary);
		if(elem < 35) {
			result += elem;
		}
}

numAry.forEach(evenSum);
console.log('짝수합은 ', result);
result = 0;
numAry.forEach(oddSum);
console.log('홀수번쨰의 합은 ', result);
result = 0;
numAry.forEach(under35);
console.log('35보다 작은 값들의 합은 ', result);

const dupAry = [10, 27, 32, 55, 27, 10];
const ary = []; // indexOf()

dupAry.forEach(function(elem){
	console.log(dupAry.indexOf(elem));
	if(dupAry.indexOf(elem) == -1) {
		ary.push = elem;
	}
});

console.log(ary);