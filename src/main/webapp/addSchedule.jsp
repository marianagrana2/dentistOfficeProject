

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Schedule Registration</h1>
<p>This is the section to register the different schedule for each Dentist.</p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Schedule Registration</h1>
                            </div>
                            <form class="user" action="SvSchedules" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="startSchedule" name="start_schedule"
                                            placeholder="Start Schedule (For example 9:30 hrs)">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="finishSchedule" name="finish_schedule"
                                            placeholder="Finish Schedule (For example 17:00 hrs)">
                                    </div>
                             </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                   Register Schedule
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>