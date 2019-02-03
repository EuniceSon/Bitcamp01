<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<%
	/*
	form tag
	   >> 아래에 있는 3개의 button[type="submit"]과 연결해서 POST방식으로 요청을 보내는데 사용한다.
	   >> 수정이나 삭제를 하는데 반드시 게시물 번호인 bno가 필요하기 때문에 input[type="hidden"]으로 bno를 넘긴다.
	*/
%>
<form role="form" action="modifyPage" method="post">
	<input type="hidden" name="bno" value="${boardVO.bno}"> <input
		type="hidden" name="page" value="${cri.page}"> <input
		type="hidden" name="perPageNum" value="${cri.perPageNum}"> <input
		type="hidden" name="searchType" value="${cri.searchType }"> <input
		type="hidden" name="keyword" value="${cri.keyword }">
</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label> <input type="text"
			name="title" class="form-control" value="${boardVO.title}"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea rows="3" class="form-control" name="content"
			readonly="readonly">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label> <input type="text"
			name="writer" class="form-control" value="${boardVO.writer}"
			readonly="readonly">
	</div>
</div>

<ul class="mailbox-attachments clearfix uploadedList"></ul>
<!-- /.box-body -->

<div class="box-footer">
	<c:if test="${login.uid==boardVO.writer }">
		<button type="submit" class="btn btn-warning " id="modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger " id="removeBtn">REMOVE</button>

	</c:if>
	<button type="submit" class="btn btn-primary " id="goListBtn">RETURNTO
		LIST</button>
</div>


<div class="row">
	<div class="col-md-12">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>

			<c:if test="${not empty login }">
				<div class="box-body">
					<label for="newReplyWriter">Writer</label> <input
						class="form-control" type="text" placeholder="USER ID"
						id="newReplyWriter"> <label for="newReplyText">ReplyText</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT"
						id="newReplyText">
				</div>
				<!-- box body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD
						REPLY</button>
				</div>
			</c:if>
			
			<c:if test="${empty login }">
				<div class="box-body">
					<div><a href="javascript:goLogin();">Login Please</a></div>
				</div>
			</c:if>

		</div>

	</div>
</div>

<ul class="timeline">
	<li class="time-label" id="repliesDiv"><span class="bg-green">
			Replies List<small id="replycntSmall">[ ${boardVO.replycnt }
				]</small>
	</span></li>

</ul>


<div class="text-center">
	<ul id="pagination" class="pagination pagination-sm no-margin">

	</ul>

</div>
<!-- Modal -->

<div id="modifyModal" class="modal modal-primary fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class=modal-title></h4>
			</div>
			<div class="modal-body" data-rno>
				<p>
					<input type="text" id="replytext" class="form-control">
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
				<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<style>
.popup {
	position: absolute;
}

.back {
	background-color: gray;
	opacity: 0.5;
	width: 100%;
	height: 300%;
	overflow: hidden;
	z-index: 1101;
}

.front {
	z-index: 1110;
	opacity: 1;
	boarder: 1px;
	margin: auto;
}

.show {
	position: relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
}
</style>

<!--  파일면 눌렀을 때 팝업창 -->
<div class="popup back" style="display: none"></div>
<div id="popup_front" class="popup_front" style="display: none">
	<img id="popup_img">
</div>




<%@ include file="../include/footer.jsp"%>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/sboard/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#removeBtn").on("click", function() {
			formObj.attr("action", "/sboard/removePage");
			formObj.submit();
		});

		$("#goListBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/sboard/list");
			formObj.submit();
		});

	});
</script>

<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="replyLi" data-rno={{rno}}>
<i class="fa fa-comments bg-blue"></i>
	<div class="timeline-item">
		<span class="time">
			<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
		</span>
		<h3 class="timeline-header"><strong>{{rno}}</strong>-{{replyer}}</h3>
		<div class="timeline-body">{{replytext}}</div>
			<div class="timeline-footer">
			{{#eqRepyer replyer}}
			<a class="btn btn-primary btn-xs"
				data-toggle="modal" data-target="#modifyModal">Modify</a>
			{{/eqReplyer}}
			</div>
	</div>
</li>
{{/each}}

		

</script>

<script>
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});

	var printData = function(replyArr, target, templateObject) {
		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
	}

	var bno = ${boardVO.bno};
	console.log(bno)
	var replyPage = 1;

	function getPage(pageInfo) {
		$.getJSON(pageInfo, function(data) {

			printData(data.list, $("#repliesDiv"), $("#template"));
			printPaging(data.pageMaker, $(".pagination"));

			$("#modifyModal").modal('hide');
			$("#replycntSmall").html("[" + data.pageMaker.totalCount + "]");
		});
	}

	var printPaging = function(pageMaker, target) {
		var str = "";
		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1)
					+ "'>  << </a></li>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}
		if (pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >></a></li>";
		}

		target.html(str);
	};

	$("#repliesDiv").on("click", function() {
		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("/replies/" + bno + "/1")
	})

	$(".pagination").on("click", "li a", function(event) {
		event.preventDefault();
		replyPage = $(this).attr("href");
		getPage("/replies/" + bno + "/" + replyPage);

	})

	$("#replyAddBtn").on("click", function() {
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		$.ajax({
			type : 'post',
			url : '/replies/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dateType : 'text',
			data : JSON.stringify({
				bno : bno,
				replyer : replyer,
				replytext : replytext
			}),
			success : function(result) {
				console.log("result :" + result);
				if (result == 'SUCCESS') {
					alert('등록되었습니다');
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					replyerObj.val();
					replytextObj.val("");
				}
			}
		})
	});

	$(".timeline").on("click", ".replyLi", function() {
		var reply = $(this);

		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
	});

	$("#replyModBtn").on("click", function() {
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'put',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify({
				replytext : replytext
			}),
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("수정 되었습닏다");

					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});

	$("#replyDelBtn").on("click", function() {
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("삭제 되었습닏다");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});

	var bno = ${boardVO.bno};
	var template = Handlebars.compile($("#templateAttach").html());

	$.getJSON("/sboard/getAttach/" + bno, function(list) {

		$(list).each(function() {
			var fileInfo = getFileInfo(this);
			var html = template(fileInfo);
			$(".uploadedList").append(html);
		});
	})

	$(".uploadedList").on("click", ".mailbox-attachment-info a",
			function(event) {
				var fileLink = $(this).attr("href");

				if (checkImageType(fileLink)) {
					event.preventDefault();

					var imgTag = $("#popup-img");
					imgTag.attr("src", fileLink);
					console.log(imgTag.attr("src"));

					$(".popup").show('slow');
					imgTag.addClass("show");
				}
			});

	$("#popup_img").on("click", function() {
		$(".popup").hide('slow');
	});
	
	
	Handlebars.registerHelper("eqReply", function(replyer, block) {
		 	var accum='';
		 	if(replyer=='${login.uid}'){
		 		accum+=block.fn();
		 	}
		 	
		 	return accum;
		});
</script>
<!--  
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script id="template" type="text/x-handlebars-template">
		<li data-src='{{fullName}}'>
			<span class="mailbox-attachment-icon has-img">
				<img src="{{imgsrc}}" alt="Attachment">
			</span>
			<div class="mailbox-attacchment-info">
				<a href="{{getLink}}" class="mail-attachment-name">{{fileName}}</a>
			</div>
		
		</li>

	</script>
	
-->	