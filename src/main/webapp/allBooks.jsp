<%@include file="header.jsp"%>
<%@ page import="vo.Book"%>


<nav class="navbar navbar-inverse navbar-fixed-top">
</nav>
<br />  <br />  <br />  

<h2>All Books</h2>

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
				<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.authorSurname}</td>
					<td>${book.authorName}</td>
					<td>${book.title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<button id="addButton" class="btn btn-default">
		<span class="btn btn-primary" aria-hidden="true"></span> Add book
	</button>
</div>

<!-- books in one order -->
<div id="order" class="container-fluid">
	<h3>Your Order</h3>
	<table class="table table-bordered table-hover" id="orderTable" action="CreateOrderPage" method="POST" >
		<thead>
			<tr>
				<th>ID</th>
				<th >Author Surname</th>
				<th >Author Name</th>
				<th >Title</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<button id="removeButton" class="btn btn-default">
		<span class="btn btn-primary" aria-hidden="true"></span>
		Remove book
	</button>
</div>

<div class="container-fluid">
	<div class="row">
		<button id="createButton"
			class="btn btn-default col-md-2 col-md-offset-5" >
			<span class="btn btn-primary" aria-hidden="true"></span>
			Make order
		</button>
	</div>
</div>

<form >
<input type="hidden" id="userId" name="userId" value="${sessionScope.user.id}" />
</form>
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

		$('#booksTable tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				booksTable.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});
		var orderTable = $('#orderTable').DataTable({
			columns :[ {
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
			lengthChange : false,
			info : false,
			searching : false,
			paging : false
		});

		$('#order').hide();

		$('#createButton').prop('disabled', true);

		$('#addButton').click(function() {
			var contains = false;
			orderTable.rows().ids().each(function(id) {
				if (id == booksTable.row('.selected').id()) {
					contains = true;
					return;
				}
			})
			if (contains)
				return;
			$('#order').show();
			orderTable.row.add(booksTable.row('.selected').data()).draw();
			$('#createButton').prop('disabled', false);
		});

		$('#orderTable tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				orderTable.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});

		$('#removeButton').click(function() {
			orderTable.row('.selected').remove().draw();
			if (orderTable.rows().count() == 0) {
				$('#order').hide();
				$('#createButton').prop('disabled', true);
			}
		});
		
		$('#createButton').click(function() {
			var id = $('#userId').val();
			var user = {"user": {"idU": id}};
			var books = orderTable.column( 0).data().toArray();
			
			alert(id);
			alert(books[0]);
			
			$.ajax({
				type : "POST",
				url : "CreateOrderPage",
				data : {books:books},
				contentType : "application/json; charset=utf-8",
				async : false,
				error: function () {
				       alert("Error occured!!!");
				     },
				success : function(){ 
					alert("Success!");
				}
			});
		})
	});

		
	
</script>


<%@include file="footer.jsp"%>