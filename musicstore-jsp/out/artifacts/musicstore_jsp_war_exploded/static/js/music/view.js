var addToCart = function(uuid) {
    $.ajax({
        url: '/musicstore/cart/create',
        type: 'post',
        async: true,
        cache: false,
        data: {
            'uuid': uuid
        },
        dataType: "json",
        success: function(data) {
            alert('添加成功');
        },
        error: function(data) {
            alert(data.responseText);
        }
    });
}
