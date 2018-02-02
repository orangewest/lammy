$(function () {
	var userId = layui.sessionData('user').userId;
	$.axget('/user',null,function(result){
    	if(result.code==0){
			layui.sessionData('user', {
				key: 'username',
				value: result.data.username
			});
			layui.sessionData('user', {
				key: 'userId',
				value: result.data.id
			});
		}
    })
	
})
