
var board_no = $('#boardNo').val();

		// 댓글 수정 버튼 클릭 이벤트
		$(".btnReplyModify").on('click', function() {	//아이디선택자로 받아옴.
			
			var reply_list = $(this).parent(); //현재 클릭한 요소의 부모 li
			
			var reply_no = $(this).attr('data');		//replyNo
			var reply_writer = reply_list.children('.replyWriter').text();
			var reply_content = reply_list.children('.replyContent').text();
			
			var editor= "<div>"
								+ "<input type = 'text' name = 'replyWriter' class='replyWriter' value = " + reply_writer + "> <br>"
								+ "<textarea rows = '4' cols ='60' >" + reply_content+"</textarea> <br>"
								+"<button type='button' class ='btnReplyRegister' data=' " + reply_no +  " ' >  등록  </button>"
								+"<button type='button' class ='btnReplyCancel' data=' " + reply_no +  " ' >  취소  </button>"
								+ "</div>";
								
			$('.replyContent').show();								//모든 댓글 내용 보여주기
			$('.replyEditor').remove();								// 모든 댓글 수정 에디터 지우기
			reply_list.append(editor);								//현재 수정할 댓글에 대한 에디터를 추가
			reply_list.children('.replyContent').hide();		//현재 수정할 댓글 내용을 숨기기.
			
			
			//수정 삭제가 이 바깥 스코프에 존재하면 등록, 취소가 동작하지 않는다.(에디터 안에서 만들어지는 등록버튼에 대한 이벤트(btnReplyRegister,btnReplyCancel가 정의가 안됨)
			//댓글 수정 - 등록 버튼 클릭 이벤트
			$('.btnReplyRegister').on('click',function(){
				var btn = $(this);
				var reply_no = btn.attr('data');
				
				var reply_writer = btn.parent().children('input').val();
				var reply_content = btn.parent().children('textarea').val();
				
				updateReply(reply_no, board_no, reply_writer, reply_content);
		});
		
		//댓글 수정 - 취소 버튼 클릭 이벤트
		$('.btnReplyCancel').on('click',function(){
				$('.replyContent').show();
				$('.replyEditor').remove();		
			});
		});
			
			
		//댓글 삭제 버튼 클릭 이벤트
		$('.btnReplyRemove').on('click',function(){
			var reply_no = $(this).attr('data');
			removeReply(reply_no, board_no);
		});
		
		
		
		

	//댓글 등록
	function writeReply(board_no, reply_writer, reply_content) {
		$.ajax({
			//필수 포함 내용: url, type,  data,  dataType,  success,  error
			url : '/board/replyRegister', //request 보낼 서버의 경로
			type : 'post', // method(get, post, put ) 등
			data : {
				'boardNo' : board_no,
				'writer' : reply_writer,
				'content' : reply_content
			},
			dataType : "text",
			success : function(data) {
				//서버로부터 정상적으로 응답이 왔을 때 실행
				//data: 서버로 부터 응답 받은 text 또는 view(.html)
				$('#replyList').empty(); //댓글 목록 비우기
				$('#replyList').append(data); //새 댓글 포함한 댓글 목록 갱신
				$('#replyWriter').val(''); //댓글 작성자 초기화 
				$('#replyContent').val(''); //댓글 내용 초기화
			},
			error : function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리 되지 못했을 때 실행
				alert("code = " + request.status + " message = "
						+ request.responseText + " error = " + error);
			}
		});
	}
	
	//댓글 수정 
	function updateReply(reply_no, board_no, reply_writer, reply_content){
		$.ajax({
			//필수 포함 내용: url, type,  data,  dataType,  success,  error
			url : '/board/replyModify', //request 보낼 서버의 경로
			type : 'post', // method(get, post, put ) 등
			data : {
				'replyNo' : reply_no,
				'boardNo' : board_no,
				'writer' : reply_writer,
				'content' : reply_content
			},
			dataType : "text",
			success : function(data) {
				//서버로부터 정상적으로 응답이 왔을 때 실행
				//data: 서버로 부터 응답 받은 text 또는 view(.html)
				$('#replyList').empty(); //댓글 목록 비우기
				$('#replyList').append(data); //새 댓글 포함한 댓글 목록 갱신
			},
			error : function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리 되지 못했을 때 실행
				alert("code = " + request.status + " message = "
						+ request.responseText + " error = " + error);
			}
		});
	}
	
	
	//댓글 삭제
	
	function removeReply(reply_no, board_no){
		$.ajax({
			//필수 포함 내용: url, type,  data,  dataType,  success,  error
			url : '/board/replyRemove', //request 보낼 서버의 경로
			type : 'post', // method(get, post, put ) 등
			data : {
				'replyNo' : reply_no,
				'boardNo' : board_no,
			},
			dataType : "text",
			success : function(data) {
				//서버로부터 정상적으로 응답이 왔을 때 실행
				//data: 서버로 부터 응답 받은 text 또는 view(.html)
				$('#replyList').empty(); //댓글 목록 비우기
				$('#replyList').append(data); //새 댓글 포함한 댓글 목록 갱신
			},
			error : function(request, status, error) {
				//서버로부터 응답이 정상적으로 처리 되지 못했을 때 실행
				alert("code = " + request.status + " message = "
						+ request.responseText + " error = " + error);
			}
		});
	}
	