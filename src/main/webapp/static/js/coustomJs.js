$().ready(function () {
    //下拉里面的监听事件
    $(".xlMenu").click(function () {
        $(this).parent("li").addClass("active").siblings().removeClass("active");
        var $child = $(this).children("span");
        $child.hasClass("glyphicon-minus-sign") ? $child.removeClass("glyphicon-minus-sign").addClass("glyphicon-plus-sign") : $child.removeClass("glyphicon-plus-sign").addClass("glyphicon-minus-sign");
        var $target = $(this).next("ul");
        $target.hasClass("hidden") ? $target.removeClass("hidden").addClass("show") : $target.removeClass("show").addClass("hidden");
    });
    $("#department").change(function () {
        //获取到当前选择的是哪个学院
        var deptName = $("#department").prop("value");
        if (deptName != "None") {
            $.ajax({
                type: "POST",
                url: "/getClassDetail",
                data: "deptName=" + deptName,
                dataType: "json",
                success: function (res) {
                    //移除上次选择的结果
                    $("#deptDetail>option:not(:first)").remove();
                    $(res).each(function (i, o) {
                        //将查询出来的结果异步的添加到其中去。
                        $("#deptDetail").append("<option value='" + res[i].cId + "'>" + res[i].cName + "</option>");
                    });
                }
            });
        }
    })

});