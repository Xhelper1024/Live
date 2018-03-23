/**
 * 
 */
// 保存时 存储当前时间
function setLocalStorageItem(key, value) {
	var curTime = new Date().getTime();
	window.localStorage.setItem(key, JSON.stringify({
		data : value,
		time : curTime
	}));
}

// 读取数据
function getLocalStorageItem(key, time) {
	var data = window.localStorage.getItem(key);
	var dataObj = JSON.parse(data);
	if (new Date().getTime() - dataObj.time > time) {
		console.log('信息已过期');
		window.localStorage.setItem(key, null);
		return null;
	} else {
		// console.log("data="+dataObj.data);
		// console.log(JSON.parse(dataObj.data));
		var dataObjDatatoJson = JSON.parse(dataObj.data)
		return dataObjDatatoJson;
	}
}