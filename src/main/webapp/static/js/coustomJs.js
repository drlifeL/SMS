$().ready(function () {
    //下拉里面的监听事件
    $(".xlMenu").click(function () {
        alert("hhhh");
        $(this).parent("li").addClass("active").siblings().removeClass("active");
        var $child = $(this).children("span");
        $child.hasClass("glyphicon-minus-sign") ? $child.removeClass("glyphicon-minus-sign").addClass("glyphicon-plus-sign") : $child.removeClass("glyphicon-plus-sign").addClass("glyphicon-minus-sign");
        var $target = $(this).next("ul");
        $target.hasClass("hidden") ? $target.removeClass("hidden").addClass("show") : $target.removeClass("show").addClass("hidden");
        return false;
    })
});