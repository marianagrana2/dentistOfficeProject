<%@page import="logic.Schedule"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Schedules</h1>
<p>This is the section to see the different schedules.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Schedules</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Start_Schedule</th>
                                            <th>Finish_Schedule</th> 
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                    <%
                                    List<Schedule>listSchedules = (List)request.getSession().getAttribute("listSchedules");
                                    %>
                                    <tbody>
                                        <%for(Schedule schedu :listSchedules){%>
                                        <tr>
                                            <td id="id_schedule<%=schedu.getId_schedule()%>"><%=schedu.getId_schedule()%></td>
                                            <td><%=schedu.getStart_schedule()%></td>
                                           <td><%=schedu.getFinish_schedule()%></td>
                                            
                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeleteSchedule" method="POST">
                                                     <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=schedu.getId_schedule()%>">
                                                </form>
                                                <form name="edit" action="SvEditSchedules" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=schedu.getId_schedule()%>">
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
            
    </div>

<%@include file="components/footer.jsp" %>