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
	} ]

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
		'<h6 style="color:black">國賓影城(新莊)</h6>'
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
		}
	});



};

// 地圖側邊影城顯示

$(function() {
	$("a.tab").on("click", function(e) {
		e.preventDefault();

		/* 將頁籤列表移除所有 -on，再將指定的加上 -on */
		$(this).closest(".tab_list_block").find("a.tab").removeClass("-on");
		$(this).addClass("-on");

		/* 找到對應的頁籤內容，加上 -on 來顯示 */
		$("div.tab").removeClass("-on");
		$("div.tab." + $(this).attr("data-target")).addClass("-on");
	});
});

// 點擊影城名取消預設動作
$(function() {
	$("div.tab").on("click", 'a', function(e) {
		e.preventDefault();
	})
})

// 取得使用者地理位置

window.addEventListener("load", function() {

	var fetchLocation;
	var api_key = '75dbb58980664b4a9259ede880434358';

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			console.log(position);

			fetchLocation = {
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};

			console.log(fetchLocation.lat);
			console.log(fetchLocation.lng);

			var request_url = 'https://api.opencagedata.com/geocode/v1/json'
					+ '?'
					+ 'key='
					+ api_key
					+ '&q='
					+ encodeURIComponent(fetchLocation.lat + ','
							+ fetchLocation.lng) + '&pretty=1'
					+ '&no_annotations=1';

			// var request = new XMLHttpRequest();
			// request.open('GET', request_url, true);

			// var data = JSON.parse(request.responseText);
			// console.log(data.results[0].components.county);

			fetch(request_url).then(function(res) {
				return res.json();
			}).then(
					function(data) {
						console.log(data);

						var city = JSON.stringify(
								data.results[0].components.city).replace(/\"/g,
								"");
						console.log(city);

						$("select[name='select_search_area']").prepend(
								"<option selected = 'selected' value='" + city
										+ "'>" + city + "</option>");

						removeSameOption();

					});

		})
	}

})

// 在選項中刪除同樣的
function removeSameOption() {

	var found = [];
	$("select[name='select_search_area'] option").each(function() {
		if ($.inArray(this.value, found) != -1)
			$(this).remove();
		found.push(this.value);
	});
	// console.log(found);
};