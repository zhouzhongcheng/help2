/**
 * 
 */
function setLoactionSelect(parrentId, selectElement) {
    $.ajax({
        async: false,
        url: "findLoactionByParrentId",
        type: "Post",
        data: {parrentId: parrentId},
        success: function(data, result) {
            $(selectElement).empty();
            $(selectElement).append("<option value='-1'>请选择</option>");
            for ( var i = 0; i < data.length; i++) {
                $(selectElement).append("<option value='"+ data[i].id + "'>" + data[i].name + "</option>");
            }
            $(selectElement).val("-1");
        }
    });
}

function setSchoolSelect(parrentId, selectElement) {
    $.ajax({
        async: false,
        url: "findSchoolByParrentId",
        type: "Post",
        data: {parrentId: parrentId},
        success: function(data, result) {
            $(selectElement).empty();
            $(selectElement).append("<option value='-1'>请选择</option>");
            for ( var i = 0; i < data.length; i++) {
                $(selectElement).append("<option value='"+ data[i].id + "'>" + data[i].name + "</option>");
            }
            $(selectElement).val("-1");
        }
    });
}