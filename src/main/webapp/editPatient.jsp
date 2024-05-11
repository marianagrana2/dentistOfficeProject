
<%@page import="logic.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Patient Edition </h1>
<p>This is the section to edit a Patient. </p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Edit Patient </h1>
                            </div>
                            <% 
                             Patient patie = (Patient)request.getSession().getAttribute("patientEdit");    
                             %>
                            <form class="user" action="SvEditPatient" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="dni"
                                             name="dni"placeholder="DNI" value="<%=patie.getDni()%>">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="phone"
                                             name="phone"placeholder="Phone"value="<%=patie.getPhone()%>" >
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="firstName"
                                            name="firstName"placeholder="First Name" value="<%=patie.getName()%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="lastName"
                                               name="lastName"placeholder="Last Name" value="<%=patie.getLast_name()%>">
                                    </div>
                                   
                                <div class="col-sm-6 mb-3">
                                    <input type="text" class="form-control form-control-user" id="bloodType"
                                         name="bloodType"placeholder="Blood Type" value="<%=patie.getBlood_type()%>" >
                                </div>
                                
                                    <div class="col-sm-6 mb-3">
                                       
                                        <input type="date" class="form-control form-control-user"
                                            id="date_birth" name="dateBirth" placeholder="Date of Birth" value="<%=patie.getDate_birth()%>" >
                                    </div>
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="address" name="address" placeholder="Address" value="<%=patie.getAddress()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="insurance" name="medicalInsurance" placeholder="Have Medical Insurance?" value="<%=patie.isHave_medical_insurance()%>">
                                    </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="responsible" name="responsibleId" placeholder="Responsible Id" value="<%=patie.getaResponsible()%>">
                                    </div>
                                </div>
                                <button type="submit"class="btn btn-primary btn-user btn-block">
                                    Save Changes
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>