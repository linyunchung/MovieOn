<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<!-- 導入CKEditor 5 的 CDN -->
<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
</head>
<body>

	<textarea name="content" id="editor"></textarea>

	<button id="code">Source code</button>
	<br>
	<textarea style="width: 100%;" rows="10" id="source"></textarea>
	
	
	<!----- 導入jquery的CDN ----->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
    var editor;

    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .then( newEditor => {
            editor = newEditor;
        } )
        .catch( error => {
            console.error( error );
        } );
	
    $( document ).ready(function() {
        $('#code').on('click', function() {
          $('#source').val(editor.getData());
        });
    });
	</script>
</body>
</html>