$(function(){
    console.log("Helloxx")
});

$(function(){

    $(".context").mouseover(function(){
        $(this).css("color","#AABBCC");
        $(this).find(".name").css("color","white");
    })
    
    $(".context").mouseleave(function(){
        $(this).css("color","#678");
        $(this).find(".name").css("color","#AABBCC");
    })

});