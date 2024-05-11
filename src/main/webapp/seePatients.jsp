
<%@page import="logic.Patient"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Registered Patients</h1>
<p>This is the section to see the different patients of the system.</p>

<div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Registered Patients</h6>
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
                                            <th>Blood Type</th>
                                            <th>Have_Medical_Insurance</th>
                                            <th>Id_Responsible</th>    
                                            
                                            <th style="width:210px">Action</th>
                                        </tr>
                                    </thead>
                                    <%
                                    List<Patient>listPatients = (List)request.getSession().getAttribute("listPatients");    
                                    %>
                                    <tbody>
                                        <%for(Patient patie:listPatients){%>
                                        <tr>
                                            
                                            <td><%=patie.getId()%></td>
                                            <td><%=patie.getAddress()%></td>
                                            <td><%=patie.getDate_birth()%></td>
                                            <td><%=patie.getDni()%></td>
                                            <td><%=patie.getLast_name()%></td>
                                            <td><%=patie.getName()%></td>
                                            <td><%=patie.getPhone()%></td>
                                            <td><%=patie.getBlood_type()%></td>
                                            <td><%=patie.isHave_medical_insurance()%></td>
                                            <%-- Revisa que sea diferente a null y pone el ID si es null no pone nada --%>
                                            <td><%= (patie.getaResponsible() != null) ? patie.getaResponsible().getId() : "" %></td>
                  
                                            <td style="display:flex;">
                                                <form name="delete" action="SvDeletePatient" method="POST">
                                                   <button type="submit" class="btn btn-danger btn-icon-split" style="margin-right:5px">
                                                        <span class="icon text-white-50">
                                                         <i class="fas fa-trash-alt"></i>
                                                        </span>
                                                        <span class="text">Delete</span>
                                                      </button>
                                                    <input type="hidden" name="id" value="<%=patie.getId()%>">
                                                </form>
                                                <form name="edit" action="SvEditPatient" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-icon-split" style="margin-left: 5px">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-pencil-alt"></i>
                                                        </span>
                                                        <span class="text">Edit</span>
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=patie.getId()%>">
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