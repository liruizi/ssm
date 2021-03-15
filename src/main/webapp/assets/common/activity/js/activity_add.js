function f_kg(){
    $("#w_mengban").fadeIn(200);
    $("#w_warning").delay(100).show().animate({top:"75px"}, 300);
    $("#closets,#fangqi,#w_mengban").click(function() {
        $("#w_warning").animate({top:"-400px"}, 200).hide(200);
        $("#w_mengban").delay(100).fadeOut(200);
    });
    $("#continue").click(function(){
        $("#w_warning").hide(200);
        $("#w_mengban").delay(100).fadeOut(200);
        $(".modal-wzsm table tr p").hide();
        var is_error = true;
        if(!$(".modal-wzsm table tr:first-child input[type='radio']").is(':checked')){
            $(".modal-wzsm table tr:first-child p").show();
            is_error = false;
        }
        if(!$(".modal-wzsm table tr:last-child input[type='radio']").is(':checked')){
            $(".modal-wzsm table tr:last-child p").show();
            is_error = false;
        }
        shake($(".alert-error"),"toBlod",2);
        if(is_error){
            var radio1 = $("radio[name='radio1']").val();
            var radio2 = $("radio[name='radio2']").val();
            $.ajax({
                type: "GET",
                url: "../activity/test",
                data:{'radio1':radio1,'radio2':radio2},
                success: function(r){
                	
                    // (success=true, code=00000, message=请求成功, data={'number':1,'total':1,'type':123,'area':'SSSS'})

//                    window.open(r);
                    window.open("../pages/modular/business/activity/book01.html"+r);
                }
            });
        }
        return is_error;

    })
}

function shake(element,className,times){
    var i = 0,
        t = false ,
        o = element.attr("class"),
        c = "",
        times = times||2;
    if(t) return;
    t = setInterval(function(){
        i++;
        c = i%2 ? o + ' ' + className : o;
        element.attr("class",c);

        if(i==2*times){
            clearInterval(t);
            element.removeClass(className);
        }
    },200);
};
