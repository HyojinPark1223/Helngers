$(function() {
		var form = $("#board");
		var board_no = $("#boardNo").val();
		
		// 등록 버튼 클릭 이벤트
			$("#btnRegister").on("click", function() {
				form.attr("action", "/board/register");
				form.attr("method", "post");
				form.submit(); 
			});
		
		//댓글 목록 조회 요청
		replyList(board_no);
		
		//답장버튼 클릭 이벤트
		$("#btnAnswer").on("click", function() {
			self.location = "/board/answer?groupNo=" + board_no;
		})
		
		
		
		//수정버튼 클릭 이벤트
		$("#btnModify").on("click", function() {
			self.location = "/board/modify?boardNo=" + board_no;
		})

		//삭제버튼 클릭 이벤트
		$("#btnRemove").on("click", function() {
			
			form.submit();
		});

		//목록 버튼 클릭 이벤트
		$("#btnList").on("click", function() {
			self.location = "/board/list";
		});
		// 댓글 등록 버튼 클릭 이벤트
		$("#btnReplyRegister").on('click', function() {
			var reply_writer = $('#replyWriter').val();
			var reply_content = $('#replyContent').val();
			writeReply(board_no, reply_writer, reply_content); //함수 만들어서 ajax 요청
		});
	
		//답글 등록 버튼 클릭 이벤트
		$("#btnAnswerRegister").on('click', function(){
			form.attr("action", "/board/answerRegister");
			form.submit();
		});	
	});
	
	
	
	

	//댓글 목록 조회
	
	function replyList(board_no){
	$.ajax({
			//필수 포함 내용: url, type,  data,  dataType,  success,  error
			url : '/board/replyList', //request 보낼 서버의 경로
			type : 'get', // method(get, post, put ) 등
			data : {
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