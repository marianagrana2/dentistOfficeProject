<%@page import="logic.Shift"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Shifts</h1>
<p>This is the section to see the different shifts of the system.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Shifts</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Date Shift</th>
                                            <th>Time Shift</th> 
                                            <th>Treatment</th>
                                            <th>Id_dentist</th>
                                            <th>Id_patient</th>
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                    <%
                                        List<Shift>listShifts= (List)request.getSession().getAttribute("listShifts");    
                                    %>
                                    <tbody>
                                        <%for(Shift shift:listShifts){%>
                                        <tr>
                                            <td><%=shift.getId_shift()%></td>
                                            <td><%=shift.getDate_shift()%></td>
                                            <td><%=shift.getTime_shift()%></td>
                                            <td><%=shift.getTreatment()%></td>
                                            <td><%=(shift.getDent() != null) ? shift.getDent().getId() : "" %></td>
                                            <td><%=(shift.getPatien() != null) ? shift.getPatien().getId() : "" %></td>
                                            
                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeleteShift" method="POST">
                                                     <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=shift.getId_shift()%>">
                                                </form>
                                                <form name="edit" action="SvEditShift" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=shift.getId_shift()%>">
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