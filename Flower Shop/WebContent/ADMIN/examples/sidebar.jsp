  <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><a href="<%= request.getContextPath()%>/admin_controller?action=enquires" class="simple-text logo-normal">
          Admin
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
        <li class="nav-item  ">
            <a class="nav-link" href="<%= request.getContextPath()%>/admin_controller?action=enquires">
              <i class="material-icons">table</i>
              <p>Enquires</p>
            </a>
          </li>
          <li class="nav-item  ">
            <a class="nav-link" href="<%= request.getContextPath()%>/admin_controller?action=aboutAdmin">
              <i class="material-icons">About</i>
              <p>About</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath()%>/admin_controller?action=flowersAdmin">
              <i class="material-icons">preview</i>
              <p>Flowers</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="<%= request.getContextPath()%>/admin_controller?action=contactAdmin">
              <i class="material-icons">library_books</i>
              <p>Contact</p>
            </a>
          </li>
        </ul>
      </div>
    </div>