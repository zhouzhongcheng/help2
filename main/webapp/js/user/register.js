/**
 * 
 */
$(document).ready(function() {
    // 设置学校区域下拉框
    setLoactionSelect(0, "#schoolLocationSelect");
    
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
});