$().ready(function () {
    //下拉里面的监听事件
    $(".xlMenu").click(function () {
        $(this).parent("li").addClass("active").siblings().removeClass("active");
        var $child = $(this).children("span");
        $child.hasClass("glyphicon-minus-sign") ? $child.removeClass("glyphicon-minus-sign").addClass("glyphicon-plus-sign") : $child.removeClass("glyphicon-plus-sign").addClass("glyphicon-minus-sign");
        var $target = $(this).next("ul");
        $target.hasClass("hidden") ? $target.removeClass("hidden").addClass("show") : $target.removeClass("show").addClass("hidden");
    });
    //添加学生界面中异步获取学院信息。
    $("#department").change(function () {
        //获取到当前选择的是哪个学院
        var deptId = $("#department").prop("value");
        if (deptId != "None") {
            $.ajax({
                type: "POST",
                url: "/getClassDetail",
                data: "deptId=" + deptId,
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
    });
    //删除学生 ,使用事件对象阻止a标签的默认行为.
    $("a[name='delBtn']").click(function (event) {
        if (!confirm("确认要删除这条记录吗?")) {
            window.event.returnValue = false;
        }
    });
});