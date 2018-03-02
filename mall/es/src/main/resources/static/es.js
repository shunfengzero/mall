//查询
function search() {
    $.get("http://localhost:9200/books/_search",function (d) {
        var d2 = JSON.stringify(d)
        alert(d2);
    });
}
//创建索引
function  createIndex() {
    $.ajax({
        method:"put",
        url:"http://localhost:9200/sf",
        success:function (d) {
            alert(d);
        }

    });
}
//删除索引
function  deleteIndex() {
    $.ajax({
        method:"delete",
        url:"http://localhost:9200/sf",
        success:function (d) {
            alert(d);
        }
    });

}

//添加数据
function  insertData() {
    //创建js对象
    var a = {title:"送快递"};
    $.ajax({
       url:"http://localhost:9200/sf/test",
        data:JSON.stringify(a),
        method:"post",
        contentType:"application/json",
        success:function (d) {
            alert(d);
        }

    });
}