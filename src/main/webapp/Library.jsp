<%@include file="header.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top"></nav>



<br />
<br />
<br />
<br />
<br />

<center>
	<font color="gray" size="7"> Welcome to the University Library!
	</font>
	<p>${param.message}</p>
</center>

<div id="content">

	<div class="container-full">

		<div class="row">

			<div class="col-lg-12 text-center v-center">
				<br /> <br /> <br />


				<form class="col-lg-12" action="LoginPage" method="POST" role="form">

					<div class="input-group input-group-lg col-sm-offset-4 col-sm-4">

						<input type="text" class="center-block form-control input-lg"
							id="login" name="login" required="required"
							placeholder="Enter your login" />
					</div>
					<br /> <br />
					<div class="input-group input-group-lg col-sm-offset-4 col-sm-4">

						<input type="password" class="center-block form-control input-lg"
							id="pwd" name="password" required="required"
							placeholder="Enter your password" />
					</div>
					<br /> <br />
					<button type="submit" class="btn btn-primary" id="submitButton">Submit</button>

				</form>
			</div>


		</div>
		<!-- /row -->

	</div>
	<!-- /container full -->
</div>

<%@include file="footer.jsp"%>