

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Shift Registration </h1>
<p>This is the section to register Shift. </p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Shift Registration</h1>
                            </div>
                            <form class="user" action="SvShifts" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="date" class="form-control form-control-user" id="dateSchift"
                                            name="dateShift" placeholder="Date Shift (For example 01-11-2024)">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="timeSchift"
                                             name="timeShift" placeholder="Time Shift (For example 10:20)">
                                    </div>
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user" id="treatment"
                                             name="treatment" placeholder="Treatment">
                                    </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="idDentist"
                                            name="dentiId" placeholder="Id Dentist">
                                    </div>
                                    
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="idPatient"
                                             name="patieId" placeholder="Id Patient">
                                    </div>
                                    
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Register Shift
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>