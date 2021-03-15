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
        	var area = $("input[name='radio1']:checked").val();
        	var type = $("input[name='radio2']:checked").val();	
            $.ajax({
                type: "GET",
                url: "../activity/addType",
                data:{'area':area,'type':type},
                success: function(r){
                	if(r.code == 00000){
                		 var d = eval("(" + r.data + ")");  // 将json字符串数据解析成对象
                		 var area=d.area;
                         window.location.href="../pages/modular/business/activity/addType.html?area="+encodeURIComponent(area);
					}else{
						alert(r.msg);
					}
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
