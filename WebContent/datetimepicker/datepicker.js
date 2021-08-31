var somedate1 = new Date();

$(function () {
  $("#datepicker").datepicker({
    dateFormat: "yy-mm-dd", //修改顯示順序

    beforeShowDay: function (date) {
      if (date.getYear() < somedate1.getYear() ||
        (date.getYear() == somedate1.getYear() && date.getMonth() < somedate1.getMonth()) ||
        (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
      ) {
        return [false, ""]
      }
      return [true, ""];
    }

  });

  $(".timepicker").timepicker({
    timeFormat: "H:mm:ss", // 時間隔式
    interval: 5, //時間間隔
    minTime: "09", //最小時間
    maxTime: "23:59pm", //最大時間
    startTime: "01:00", // 開始時間
    dynamic: true, //是否顯示項目，使第一個項目按時間順序緊接在所選時間之後
    dropdown: true, //是否顯示時間條目的下拉列表
    scrollbar: false //是否顯示捲軸
  });

});

