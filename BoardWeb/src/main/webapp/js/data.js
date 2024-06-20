const myMembers = [
	{id: 'user01', name: '홍길동', phone: '010-1111-2222', point: 90}, // new object();
	{id: 'user02', name: '박석민', phone: '010-2341-2321', point: 95},
	{id: 'user03', name: '김시후', phone: '010-4567-7896', point: 120}
]; // new Array();

const json = `[{"id":1,"first_name":"Elsa","last_name":"Munroe","email":"emunroe0@tripadvisor.com","gender":"Female","salary":5762},
{"id":2,"first_name":"Erl","last_name":"Scriviner","email":"escriviner1@google.com.au","gender":"Male","salary":5363},
{"id":3,"first_name":"Patsy","last_name":"Reiglar","email":"preiglar2@photobucket.com","gender":"Female","salary":6752},
{"id":4,"first_name":"Rodrique","last_name":"Raft","email":"rraft3@360.cn","gender":"Male","salary":5983},
{"id":5,"first_name":"Diego","last_name":"Emer","email":"demer4@acquirethisname.com","gender":"Male","salary":4045},
{"id":6,"first_name":"Yolande","last_name":"Chippendale","email":"ychippendale5@acquirethisname.com","gender":"Female","salary":3782},
{"id":7,"first_name":"Thacher","last_name":"Karpenya","email":"tkarpenya6@ask.com","gender":"Male","salary":7206},
{"id":8,"first_name":"Brose","last_name":"Dallywater","email":"bdallywater7@i2i.jp","gender":"Male","salary":6650},
{"id":9,"first_name":"Raddie","last_name":"Anster","email":"ranster8@businessinsider.com","gender":"Male","salary":6005},
{"id":10,"first_name":"Faulkner","last_name":"Flavelle","email":"fflavelle9@drupal.org","gender":"Male","salary":7374},
{"id":11,"first_name":"Rob","last_name":"Haugg","email":"rhaugga@chronoengine.com","gender":"Male","salary":3210},
{"id":12,"first_name":"Franciska","last_name":"Heads","email":"fheadsb@nyu.edu","gender":"Female","salary":4002},
{"id":13,"first_name":"Selina","last_name":"Maclean","email":"smacleanc@toplist.cz","gender":"Female","salary":5456},
{"id":14,"first_name":"Zane","last_name":"Moro","email":"zmorod@reference.com","gender":"Male","salary":3712},
{"id":15,"first_name":"Ivie","last_name":"Glazzard","email":"iglazzarde@hibu.com","gender":"Female","salary":5393}]`;

const employees = JSON.parse(json);
