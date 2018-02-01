$(function () {
	var userId = layui.sessionData('user').userId;
	if(isEmpty(userId)){
		location.href = '/lammy/login.html';
	}else{
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
	}
	
})
