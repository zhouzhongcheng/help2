/**
 * 
 */
$(document).ready(function() {
    // 获取当前用户信息
    var schoolLocationId = $("#schoolLocationSelect").val();
    var schoolId = $("#schoolSelect").val();
    var provinceId = $("#provinceSelect").val();
    var cityId = $("#citySelect").val();
    var areaId = $("#areaSelect").val();
    
    // 设置学校区域下拉框
    setLoactionSelect(0, "#schoolLocationSelect");
    $("#schoolLocationSelect").val(schoolLocationId);
    
    // 设置学校下拉框
    if (schoolLocationId != -1) {
        setSchoolSelect(schoolLocationId, "#schoolSelect");
        $("#schoolSelect").val(schoolId);
    }
    
    // 监听学校区域下拉框
    $("#schoolLocationSelect").change(
        function() {
            var parrentId = $("#schoolLocationSelect").val();
            if (parrentId != "-1") {
                setSchoolSelect(parrentId, "#schoolSelect");
            }
            else {
                $("#schoolSelect").empty();
                $("#schoolSelect").append("<option value='-1'>请选择</option>");
            }
            $("#schoolSelect").val("-1");
        }
    )
    
    // 设置省下拉框
    setLoactionSelect(0, "#provinceSelect");
    $("#provinceSelect").val(provinceId);
    
    // 设置市下拉框
    setLoactionSelect(provinceId, "#citySelect");
    $("#citySelect").val(cityId);
    
    // 设置区下拉框
    setLoactionSelect(cityId, "#areaSelect");
    $("#areaSelect").val(areaId);
    if (cityId == -1) {
        $("#areaSelect").hide();
    }
    
    // 监听省下拉框
    $("#provinceSelect").change(
        function() {
            var parrentId = $("#provinceSelect").val();
            if (parrentId != "-1") {
                setLoactionSelect(parrentId, "#citySelect");
            }
            else {
                $("#citySelect").empty();
                $("#citySelect").append("<option value='-1'>请选择</option>");
            }
            $("#citySelect").val("-1");
            $("#areaSelect").empty();
            $("#areaSelect").hide();
        }
    )
    
    // 监听市下拉框
    $("#citySelect").change(
        function() {
            var parrentId = $("#citySelect").val();
            if (parrentId != "-1") {
                setLoactionSelect(parrentId, "#areaSelect");
                $("#areaSelect").show();
            }
            else {
                $("#areaSelect").empty();
                $("#areaSelect").hide();
            }
            $("#areaSelect").val("-1");
        }
    )
});
