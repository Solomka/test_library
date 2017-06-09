<%@include file="header.jsp"%>

 
   <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
      
        <div class="navbar-header">
        
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
       
        </div>
        
        <div id="navbar" class="collapse navbar-collapse">
        
          <ul class="nav navbar-nav">
           <li><a href="BookOrderPage">Show all books</a></li>
            <li><a href="MyOrders">My orders</a></li>
            <li ><a href="Library.jsp">Exit</a></li>
           
          </ul>
          
        </div><!--/.nav-collapse -->
        
      </div>
    </nav>

 <div id="content">
      
<br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br /> 
   <center> 
      <font color="gray" size="7">  Welcome to the Library, <br/><span  STYLE="color: gray; font-size: 30pt"> ${user.role} </span>  ${user.name} ${user.surname}   </font> 
   </center>
     <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  <br />  
   
<%@include file="footer.jsp"%>