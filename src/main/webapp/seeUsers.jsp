<%@page import="logic.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Users</h1>
<p>This is the section to see the different users of the system.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Users</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>User Name</th>
                                            <th>Role</th> 
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                    <% 
                                    List<User>listUsers = (List)request.getSession().getAttribute("listUsers");
                                    %>
                                    <tbody>
                                        <%for(User usu:listUsers){%>
                                        <tr>
                                            <td id="id_usu<%=usu.getId_user()%>"><%=usu.getId_user()%></td>
                                            <td><%=usu.getUser_name()%></td>
                                            <td><%=usu.getRole()%></td>
                                            
                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeleteUsers" method="POST">
                                                     <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=usu.getId_user()%>">
                                                </form>
                                                <form name="edit" action="SvEditUsers" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=usu.getId_user()%>">
                                                </form>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

    </div>

<%@include file="components/footer.jsp" %>