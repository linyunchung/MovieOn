function initMap() {

	var Station_latlng = {
		lat : 25.046607081558978,
		lng : 121.54413496050566
	};

	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 14, // 放大的倍率
		center : Station_latlng, // 初始化的地圖中心位置

		styles : [ {
			featureType : 'poi',
			stylers : [ {
				visibility : 'off'
			} ]
		} ],

		mapTypeControl : false

	});

	// --------下面是呼叫一個新marker------

	/*******************************新增marker到地圖上的資訊*********************************/
	var markers = [];

	var marker_taipei = [ {
		position : {
			lat : 25.046607081558978,
			lng : 121.54413496050566
		},
		map : map,
		title : '微風國賓影城'
	}, {
		position : {
			lat : 25.035670596105025,
			lng : 121.56744668144084
		},
		map : map,
		title : '信義威秀影城'
	}, {
		position : {
			lat : 25.054356073878296,
			lng : 121.52598753541452
		},
		map : map,
		title : '欣欣秀泰影城'
	}, {
		position : {
			lat : 25.083392190400286,
			lng : 121.55804041027716
		},
		map : map,
		title : '美麗華大直影城'
	}, {
		position : {
			lat : 25.044079486853477,
			lng : 121.5076202642498
		},
		map : map,
		title : '喜滿客絕色影城'
	}
	];

	var marker_newtaipei = [ {
		position : {
			lat : 25.01251150098337,
			lng : 121.46232980657818
		},
		map : map,
		title : '板橋秀泰影城'
	}, {
		position : {
			lat : 25.014260134114906,
			lng : 121.46754003541375
		},
		map : map,
		title : '板橋大遠百威秀影城'
	}, {
		position : {
			lat : 25.06419567349789,
			lng : 121.46009584040972
		},
		map : map,
		title : '國賓影城(新莊)'
	},{
		position : {
			lat : 24.97879788646031,
			lng : 121.44508241128159
		},
		map : map,
		title : '土城秀泰影城'
	}
	];
	
	var marker_taoyuan = [ {
		position : {
			lat : 24.99133236773878,
			lng : 121.31315380232883
		},
		map : map,
		title : '統領威秀影城'
	}, {
		position : {
			lat : 25.053796355167314,
			lng : 121.28924041397428
		},
		map : map,
		title : '美麗新台茂影城'
	}, {
		position : {
			lat : 25.016845855664233,
			lng : 121.21323386182053
		},
		map : map,
		title : '桃園新光影城'
	} ];
	
	var marker_taichung = [ {
		position : {
			lat : 24.164364716729004,
			lng : 120.63840553355078
		},
		map : map,
		title : '老虎城威秀影城'
	}, {
		position : {
			lat : 24.143817790449162,
			lng : 120.6756681353993
		},
		map : map,
		title : '日新大戲院'
	}, {
		position : {
			lat : 24.164914114652024,
			lng : 120.64390395074193
		},
		map : map,
		title : '台中新光影城'
	} ];
	
	var marker_kaohsiung = [ {
		position : {
			lat : 22.6322776249371,
			lng : 120.32579073722441
		},
		map : map,
		title : '環球影城'
	}, {
		position : {
			lat : 22.613265265631163,
			lng : 120.30429463167765
		},
		map : map,
		title : '大遠百威秀影城'
	}, {
		position : {
			lat : 22.594969075938884,
			lng : 120.30757047160611
		},
		map : map,
		title : '喜滿客夢時代影城'
	} ];

	/*******************************marker要顯示的資訊*********************************/
	
	var info_config = [ '<h6 style="color:black">微風國賓影城</h6>',
			'<h6 style="color:black">信義威秀影城</h6>',
			'<h6 style="color:black">欣欣秀泰影城</h6>',
			'<h6 style="color:black">美麗華大直影城</h6>',
			'<h6 style="color:black">喜滿客絕色影城</h6>',
	]
	
	var info_config_newtaipei = [
		'<h6 style="color:black">板橋秀泰影城</h6>',
		'<h6 style="color:black">板橋大遠百威秀影城</h6>',
		'<h6 style="color:black">國賓影城(新莊)</h6>',
		'<h6 style="color:black">土城秀泰影城</h6>'
	]
	
	var info_config_taoyuan = [
		'<h6 style="color:black">統領威秀影城</h6>',
		'<h6 style="color:black">美麗新台茂影城</h6>',
		'<h6 style="color:black">桃園新光影城</h6>'
	]
	
	var info_config_taichung = [
		'<h6 style="color:black">老虎城威秀影城</h6>',
		'<h6 style="color:black">日新大戲院</h6>',
		'<h6 style="color:black">台中新光影城</h6>'
	]
	
	var info_config_kaohsiung = [
		'<h6 style="color:black">環球影城</h6>',
		'<h6 style="color:black">大遠百威秀影城</h6>',
		'<h6 style="color:black">喜滿客夢時代影城</h6>'
	]
	

	var infoWindow = [];

	// 資訊窗顯示
//	info_config.forEach(function(e, i) {
//		infoWindow[i] = new google.maps.InfoWindow({
//			content : e
//		});
//	});



	/*******************************側邊文字點擊事件*********************************/
	
	//沒選擇任何地區就取消標記
	$("#area_city").change(function(){
		if ($("#map_area_title").text() == ""){
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }
			}
		}
	});
	
	

	$("#map_theater").on('mouseenter', 'li', function(e) {

		if ($("#map_area_title").text() == "台北市") {
			
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }  
			}
			
			
			
			// 資訊窗顯示
			info_config.forEach(function(e, i) {
				infoWindow[i] = new google.maps.InfoWindow({
					content : e
				});
			});
			
			// marker顯示與點擊事件
			marker_taipei.forEach(function(e, i) {
				markers[i] = new google.maps.Marker(e);
				markers[i].setMap(map);
				markers[i].addListener('click', function() {
					infoWindow[i].open(map, markers[i]);
				})

				var theater_ul = document.querySelector(".show_theater");
				var theater_li = theater_ul.getElementsByTagName("li");
				theater_li[i].onclick = function() {
					infoWindow[i].open(map, markers[i]);
				}
			});
		}else if($("#map_area_title").text() == "新北市"){
			
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }  
			}
			
			
			// 資訊窗顯示
			info_config_newtaipei.forEach(function(e, i) {
				infoWindow[i] = new google.maps.InfoWindow({
					content : e
				});
			});
			
			// marker顯示與點擊事件
			marker_newtaipei.forEach(function(e, i) {
				markers[i] = new google.maps.Marker(e);
				markers[i].setMap(map);
				markers[i].addListener('click', function() {
					infoWindow[i].open(map, markers[i]);
				})

				var theater_ul = document.querySelector(".show_theater");
				var theater_li = theater_ul.getElementsByTagName("li");
				theater_li[i].onclick = function() {
					infoWindow[i].open(map, markers[i]);
				}
			});
		}else if($("#map_area_title").text() == "桃園市"){
			
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }  
			}
			
			
			// 資訊窗顯示
			info_config_taoyuan.forEach(function(e, i) {
				infoWindow[i] = new google.maps.InfoWindow({
					content : e
				});
			});
			
			// marker顯示與點擊事件
			marker_taoyuan.forEach(function(e, i) {
				markers[i] = new google.maps.Marker(e);
				markers[i].setMap(map);
				markers[i].addListener('click', function() {
					infoWindow[i].open(map, markers[i]);
				})

				var theater_ul = document.querySelector(".show_theater");
				var theater_li = theater_ul.getElementsByTagName("li");
				theater_li[i].onclick = function() {
					infoWindow[i].open(map, markers[i]);
				}
			});
		}else if($("#map_area_title").text() == "台中市"){
			
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }  
			}
			
			
			// 資訊窗顯示
			info_config_taichung.forEach(function(e, i) {
				infoWindow[i] = new google.maps.InfoWindow({
					content : e
				});
			});
			
			// marker顯示與點擊事件
			marker_taichung.forEach(function(e, i) {
				markers[i] = new google.maps.Marker(e);
				markers[i].setMap(map);
				markers[i].addListener('click', function() {
					infoWindow[i].open(map, markers[i]);
				})

				var theater_ul = document.querySelector(".show_theater");
				var theater_li = theater_ul.getElementsByTagName("li");
				theater_li[i].onclick = function() {
					infoWindow[i].open(map, markers[i]);
				}
			});
		}else if($("#map_area_title").text() == "高雄市"){
			
			if(markers!=null){
				for (var i = 0; i < markers.length; i++) {   
		            markers[i].setMap(null);   
		        }  
			}
			
			
			// 資訊窗顯示
			info_config_kaohsiung.forEach(function(e, i) {
				infoWindow[i] = new google.maps.InfoWindow({
					content : e
				});
			});
			
			// marker顯示與點擊事件
			marker_kaohsiung.forEach(function(e, i) {
				markers[i] = new google.maps.Marker(e);
				markers[i].setMap(map);
				markers[i].addListener('click', function() {
					infoWindow[i].open(map, markers[i]);
				})

				var theater_ul = document.querySelector(".show_theater");
				var theater_li = theater_ul.getElementsByTagName("li");
				theater_li[i].onclick = function() {
					infoWindow[i].open(map, markers[i]);
				}
			});
		}
	});



};



// 點擊影城名取消預設動作
$(function() {
	$("div.tab").on("click", 'a', function(e) {
		e.preventDefault();
	})
})

