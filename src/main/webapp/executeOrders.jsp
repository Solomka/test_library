<%@include file="header.jsp"%>
<%@ page import="vo.Book"%>


<nav class="navbar navbar-inverse navbar-fixed-top">
</nav>
<br />  <br />  <br />  

<h2>Execute Order</h2>

<!-- all books -->
<div class="container-fluid">
<p>${param.message}</p>
<form name="MainForm"  action="ExecuteOrder" method="POST" role="form">
	<table class="table table-bordered table-hover" id="booksTable">
		<thead>
			<tr>
			    <th class="col-md-4">Choose</th>
				<th class="col-md-4">ID</th>
				<th class="col-md-4">Status</th>
				
				
			</tr>
		</thead>
		
		<tbody>
				<c:forEach items="${orders}" var="order">
				<tr>
				    <td><input type="radio" name="orderId" class="checker" value="${order.id}" /></td>
					<td>${order.id}</td>
					<td>${order.status}</td>
					
        		</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="submit" class="btn btn-primary" id="submitButton" >Execute order</button>
</form>

</div>

<script>
	$(document).ready(function () {
		var booksTable = $('#booksTable').DataTable({
			columns : [ {      
				data : 'id'
			}, {
				data : 'choose'
			},{
				data : 'status'
			} ],
			rowId : 'id',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
		
		
	});
	</script>

		


<%@include file="footer.jsp"%>