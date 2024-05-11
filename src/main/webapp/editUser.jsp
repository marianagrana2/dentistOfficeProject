

<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>User Edition</h1>
<p>This is the section to edit a user.</p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Edit User</h1>
                            </div>
                            <% User usu = (User)request.getSession().getAttribute("usuEdit");
                            %>
                            <form class="user" action="SvEditUsers" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="userName" name="userName"
                                            placeholder="User Name" value="<%=usu.getUser_name()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control form-control-user" id="password" name="password"
                                            placeholder="Password" value="<%=usu.getPassword()%>">
                                    </div>
                                   
                                <div class="col-sm-6 mb-3">
                                    <input type="text" class="form-control form-control-user" id="role" name="role"
                                        placeholder="Role" value="<%=usu.getRole()%>">
                                </div>
                               
                             </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                   Save Changes
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>