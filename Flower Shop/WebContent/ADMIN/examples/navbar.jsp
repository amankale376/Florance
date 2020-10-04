
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:;"></a>
          </div>
         
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
             
              <li class="nav-item dropdown">
                <a class="nav-link" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">notifications</i>
              
         <%!
         String b ="<span class='notification'>";
         String c= "</span>";
         %>
                <%
                if(a!=0){
                	out.print(b+a+c);
                }
               
                %>
               
                   <%--VARIABLE --%>
                  <p class="d-lg-none d-md-block">
                    Some Actions
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
					
                  <a class="dropdown-item" href="<%= request.getContextPath()%>/admin_controller?action=navbar_enq">You have <%= a %> new Enquires</a> <%--VARIABLE --%>
                 
                </div>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                  <a class="dropdown-item" href="<%=request.getContextPath()%>/admin_controller?action=profile">Profile</a>
 
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="">Log out</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>