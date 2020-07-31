/**
 * 实现页码功能
 * */
function load(currentPage, pageSize, totalPage, url){

    // 选中分页参数
    $("#pageSize option[value=" + pageSize + "]").attr("selected",true);

    /**
     * 改变分页参数
     * */
    $("#pageSize").change(function () {
        var pageSize = $(this).val();
        location.href = url+"?currentPage=1&pageSize=" + pageSize;
    });

    var lis = "";

    // 首页
    var firstPage = '<li>\n' +
        '        <a href='+url+'?pageSize='+ pageSize +' aria-label="Previous">首页</a>\n' +
        '         </li>';
    // 末页
    var lastPage = '<li>\n' +
        '        <a href='+url+'?currentPage='+ totalPage +'&pageSize=' + pageSize +' aria-label="Previous">尾页</a>\n' +
        '         </li>';

    lis += firstPage;

    // 上一页
    var prePage = "";
    if (currentPage <= 1){
        prePage = '<li><a href='+url+'?pageSize='+ pageSize +'>上一页</a></li>'
    } else {
        prePage = '<li><a href='+url+'?currentPage=' + (currentPage-1) + '&pageSize='+ pageSize +'>上一页</a></li>'
    }
    // 下一页
    var nextPage = "";
    if (currentPage >= totalPage){
        nextPage = '<li><a href='+url+'?currentPage='+ totalPage +'&pageSize='+ pageSize +'>下一页</a></li>'
    } else{
        nextPage = '<li><a href='+url+'?currentPage='+ (currentPage + 1) +'&pageSize='+ pageSize +'>下一页</a></li>'
    }

    // 添加上一页的 html 代码
    lis += prePage;

    // 要实现当前页码总在中间的效果
    // 总共显示 5 个页码
    // 判断当前页前面够不够两页
    var begin;
    var end;

    // 1. 要显示5个页码
    if (totalPage < 5) {
        // 总页码不够 5 页
        begin = 1;
        end = totalPage;
    } else {
        // 如果总页码超过 5 页
        begin = currentPage - 2;
        end = currentPage + 2;
        if (begin < 1){
            // 如果前面不够两页，后面要补齐直至5页
            begin = 1;
            end = begin + 4;
        }
        if (end > totalPage){
            // 如果后面不够两页，前面需要补齐直至5页
            end = totalPage;
            begin = end - 4;
        }
    }

    for(var i = begin; i <=end; i++){
        var li;
        // 判断当前页码是或否等于 i
        if (currentPage == i){
            li = '<li><a style="background: lightblue;" href='+url+'?currentPage='+ currentPage +'&pageSize=' + pageSize + '>'+ i +'</a></li>'
        } else {
            li = '<li><a href='+url+'?currentPage='+ i +'&pageSize=' + pageSize + '>'+ i +'</a></li>'
        }
        lis += li;
    }

    // 添加下一页、末页
    lis += nextPage;
    lis += lastPage;

    $("#pageNum").html(lis);
}