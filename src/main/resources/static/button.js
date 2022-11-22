function update() {
	var updateForm = document.getElementById("update");
	if(confirm("수정하시겠습니까?")){
		updateForm.submit();
	}
	else{
		return;
	}
}

function delete() {
	if(confirm("삭제하시겠습니까?")){
		href="deleteBoard?seq=${board.seq }"
	}
	else{
		return;
	}
}