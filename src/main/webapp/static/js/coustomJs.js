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
    //添加学院
    $("#mtadd").click(function () {
        $("#mtform").submit();
        $('#myModal').modal('hide')
    });

    //修改学院
    $("button[name='updateBtnCol']").click(function () {
        var collegeNum = $(this).parent("td").parent("tr").find("td:first").text();
        $.ajax({
            type: "POST",
            url: "/getCollegeDetailById",
            data: "collegeNum=" + collegeNum,
            dataType: "json",
            success: function (res) {
                $("#UpModal form input[name='collegeNum']").prop("value", res.collegeNum);
                $("#UpModal form input[name='collegeName']").prop("value", res.collegeName);
                $("#UpModal").modal("show");
            }
        })
    })
    $("#upadd").click(function () {
        $("#upform").submit();
        $("#UpModal").modal("hide");
    })

    //专业展示下拉列表框
    $("#selCollege").change(function () {
        var collegeNum = $("#selCollege").val();
        if (collegeNum != 'None') {
            $.ajax({
                type: "POST",
                url: "/getClassDetail",
                data: "deptId=" + collegeNum,
                dataType: "json",
                success: function (res) {
                    var tb = $("#colId").find("tbody");
                    $(tb).find("tr").remove();
                    $(res).each(function (i, e) {
                        var tr = $("<tr></tr>");
                        var tdNum = $("<td>" + res[i].cId + "</td>")
                        var tdName = $("<td>" + res[i].cName + "</td>")
                        var btn = $("<td><a class ='btn btn-primary' href='/getCourseBySpId?spId=" + res[i].cId + "'>查看课程</a></td>")
                        $(tr).append(tdNum).append(tdName).append(btn).appendTo(tb);
                    })
                }
            })
        }
    });
    //添加班级的模态框
    $("#addClass").click(function () {
        //被选中的Value
        var sValue = $("#selCollege").val();
        //console.log(sValue);
        if (sValue != 'None') {
            //被选中学院的名称
            var sText = $("#selCollege>option:selected").text()
            //console.log();
            $("#initCollege>span").text("").text(sText);
            $("#initCollege>input").prop("value", sValue);
            $("#classModal").modal('show');
        } else {
            alert("请先选择学院！");
        }
    });
    //添加班级模态框表单提交
    $("#classAdd").click(function () {
        $("#classModal form").submit();
    })

    //添加课程模态框
    $("#addCourse").click(function () {
        var spName = $("#sp>input[name='spName']").val();
        var spId = $("#sp>input[name='spId']").val();
        $("#initCourse>span").text("").text(spName);
        $("#initCourse>input[name='cId']").val(spId);
        var selNode = $("#initCourse").parent("form").find("select");
        $.ajax({
            type: "POST",
            url: "/findAllCourseDetail",
            dataType: "json",
            success: function (res) {
                $(selNode).find("option:not(:first)").remove();
                $(res).each(function (i, o) {
                    $("<option value='" + res[i].couId + "'>" + res[i].couName + "</option>").appendTo(selNode);
                })
            }
        });

        $("#classModal").modal("show");

    })
    //提交添加课程
    $("#adCourBtn").click(function () {
        $("#adCourseform").submit();
        $("#myModal").modal("hide");
    })

});