

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Patient Registration </h1>
<p>This is the section to register Patient. </p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Patient Registration</h1>
                            </div>
                            <form class="user" action="SvPatients" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="dni"
                                             name="dni"placeholder="DNI">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="phone"
                                             name="phone"placeholder="Phone">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="firstName"
                                            name="firstName"placeholder="First Name">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="lastName"
                                            name="lastName"placeholder="Last Name">
                                    </div>
                                   
                                <div class="col-sm-6 mb-3">
                                    <input type="text" class="form-control form-control-user" id="bloodType"
                                         name="bloodType"placeholder="Blood Type">
                                </div>
                                
                                    <div class="col-sm-6 mb-3">
                                       
                                        <input type="date" class="form-control form-control-user"
                                            id="date_birth" name="dateBirth"placeholder="Date of Birth">
                                    </div>
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="address" name="address" placeholder="Address">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="insurance" name="medicalInsurance" placeholder="Have Medical Insurance?">
                                    </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="responsible" name="responsibleId" placeholder="Responsible Id">
                                    </div>
                                </div>
                                <button type="submit"class="btn btn-primary btn-user btn-block">
                                    Register Patient
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>