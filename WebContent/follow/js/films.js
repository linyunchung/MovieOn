
// This will run once JavaScript is ready
$(document).ready(function(e){
    console.log("Helloxx")
});


$(document).ready(function(e){

    $(".rated-5").each(function(i, obj){
        console.log(
            this.innerHTML
        )

        switch(this.innerHTML){
            case "0.5":
                $(this).html("½");
                break;
            case "1.0":
                $(this).html("★");
                break;
            case "1.5":
                $(this).html("★½");
                break;
            case "2.0":
                $(this).html("★★");
                break;
            case "2.5":
                $(this).html("★★½");
                break;
            case "3.0":
                $(this).html("★★★");
                break;
            case "3.5":
                $(this).html("★★★½");
                break;
            case "4.0":
                $(this).html("★★★★");
                break;
            case "4.5":
                $(this).html("★★★★½");
                break;
            case "5.0":
                $(this).html("★★★★★");
                break;
        }
    });
});
