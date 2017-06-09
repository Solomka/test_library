<%@include file="header.jsp"%>
<%@ page import="vo.Book"%>


<nav class="navbar navbar-inverse navbar-fixed-top">
</nav>
<br />  <br />  <br />  

<h2>Order Books</h2>

<!-- all books -->
<div class="container-fluid">

	<table class="table table-bordered table-hover" id="booksTable" >
		<thead>
			<tr>
				<th>ID</th>
				<th class="col-md-4">Author Surname</th>
				<th class="col-md-4">Author Name</th>
				<th class="col-md-4">Title</th>
			</tr>
		</thead>
		
		<tbody>
				<c:forEach items="${oBooks}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.authorSurname}</td>
					<td>${book.authorName}</td>
					<td>${book.title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

		<button type="submit" class="btn btn-primary" id="submitButton" onClick="window.open('librarian.jsp');" >Back</button>
</div>


<script> 
	$(document).ready(function () {
		var booksTable = $('#booksTable').DataTable({
			columns : [ {
				data : 'id'
			}, {
				data : 'authorSurname'
			}, { 
				data : 'authorName'
			}, {
				data: 'title'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'id',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});

		
	});

		
	
</script>


<%@include file="footer.jsp"%>