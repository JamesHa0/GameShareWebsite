   //***************************************【删除按钮】模块： */    

    function confirmDelete(logId) {
    var isDelete = confirm("您确定要删除吗？");
    var data = new URLSearchParams(); 
    data.append('logId',logId);
    if (isDelete) {
        fetch("../DeleteUserLogServlet.do", {
            method: 'POST',
             headers: {
                 'Content-Type': 'application/x-www-form-urlencoded' 
             },
             body: data
        })
        .then(response => { // 这里接收的是Response对象
            if (!response.ok) {
                throw new Error('失败了');
            }
            return response.text(); 
        })
        .then(data => { // 这里接收的是上一步返回的数据
            console.log('服务器发来的响应数据：', data);
            location.reload();
            alert('删除成功');
        })
        .catch(error => { // 处理前面抛出的错误
            console.error('删除操作失败:', error);
            alert('删除失败');
        });
    }
}
    
    