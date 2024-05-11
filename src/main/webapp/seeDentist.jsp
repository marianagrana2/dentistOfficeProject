
<%@page import="logic.Dentist"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Dentists</h1>
<p>This is the section to see the different dentist of the system.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Dentists</h6>
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
                                            <th>Speciality</th>
                                            <th>Id_Schedule</th>
                                            <th>Id_User</th>
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                     <%
                                        List<Dentist>listDentists = (List)request.getSession().getAttribute("listDentists");    
                                    %>
                                    <tbody>
                                        <%for(Dentist dent:listDentists){%>
                                        <tr>
                                            <td><%=dent.getId()%></td>
                                            <td><%=dent.getAddress()%></td>
                                            <td><%=dent.getDate_birth()%></td>
                                            <td><%=dent.getDni()%></td>
                                            <td><%=dent.getLast_name()%></td>
                                            <td><%=dent.getName()%></td>
                                            <td><%=dent.getPhone()%></td>
                                            <td><%=dent.getSpecialty()%></td>
                                            <td><%=(dent.getaSchedule() != null) ? dent.getaSchedule().getId_schedule(): ""%></td>
                                            <td><%=(dent.getaUser() != null) ? dent.getaUser().getId_user() : "" %></td>

                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeleteDentist" method="POST">
                                                     <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=dent.getId()%>">
                                                </form>
                                                <form name="edit" action="SvEditDentist" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=dent.getId()%>">
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
