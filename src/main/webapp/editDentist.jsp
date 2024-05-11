
<%@page import="logic.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Dentist Edition </h1>
<p>This is the section to edit a Dentist. </p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Edit Dentist </h1>
                            </div>
                            <% 
                             Dentist dent = (Dentist)request.getSession().getAttribute("dentistEdit");    
                             %>
                             <form class="user" action="SvEditDentist" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="dni"
                                             name="dni" placeholder="DNI" value="<%=dent.getDni()%>">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="phone"
                                             name="phone" placeholder="Phone" value="<%=dent.getPhone()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="firstName"
                                             name="firstName" placeholder="First Name" value="<%=dent.getName()%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="lastName"
                                             name="lastName" placeholder="Last Name" value="<%=dent.getLast_name()%>">
                                    </div>
                                   
                                <div class="col-sm-12 mb-3">
                                    <input type="text" class="form-control form-control-user" id="address"
                                        name="address" placeholder=" Address" value="<%=dent.getAddress()%>">
                                </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="date" class="form-control form-control-user"
                                            id="date_birth" name="dateBirth" placeholder="Date of Birth" value="<%=dent.getDate_birth()%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                            id="speciality" name="specialty" placeholder="Specialty" value="<%=dent.getSpecialty()%>">
                                    </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="idSchedule"
                                             name="aScheduleId"placeholder="Id Schedule" value="<%=dent.getaUser()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="idUser"
                                             name="aUserId"placeholder="Id User" value="<%=dent.getaSchedule()%>">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                   Save Changes
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>
           