
<%@page import="logic.Secretary"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Secretaries</h1>
<p>This is the section to see the different secretaries.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Secretaries</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Address</th>
                                            <th>Date_Birth</th> 
                                            <th>DNI</th> 
                                            <th>Last_Name</th>
                                            <th>Name</th>
                                            <th>Phone</th>
                                            <th>Sector</th>
                                            <th>Id_User</th>
                                            
                                            
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                    <%
                                    List<Secretary>listSecretaries = (List)request.getSession().getAttribute("listSecretaries");    
                                    %>
                                    <tbody>
                                         <%for(Secretary secre:listSecretaries){%>
                                        <tr>
                                            <td><%=secre.getId()%></td>
                                            <td><%=secre.getAddress()%></td>
                                            <td><%=secre.getDate_birth()%></td>
                                            <td><%=secre.getDni()%></td>
                                            <td><%=secre.getLast_name()%></td>
                                            <td><%=secre.getName()%></td>
                                            <td><%=secre.getPhone()%></td>
                                            <td><%=secre.getSector()%></td>                                       
                                           
                                         <td><%=(secre.getaUser() != null) ? secre.getaUser().getId_user() : "" %></td> 

                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeleteSecretary" method="POST">
                                                     <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=secre.getId()%>">
                                                </form>
                                                <form name="edit" action="SvEditSecretary" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=secre.getId()%>">
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