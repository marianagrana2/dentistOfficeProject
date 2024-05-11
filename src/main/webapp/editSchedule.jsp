

<%@page import="logic.Schedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Schedule Editation</h1>
<p>This is the section to edit a schedule.</p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Edit Schedule </h1>
                            </div>
                            <% Schedule schedu = (Schedule)request.getSession().getAttribute("scheduEdit");
                            %>
                            <form class="user" action="SvEditSchedules" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="startSchedule" name="start_schedule"
                                            placeholder="Start Schedule (For example 9:30 hrs)" value="<%=schedu.getStart_schedule()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="finishSchedule" name="finish_schedule"
                                            placeholder="Finish Schedule (For example 17:00 hrs)" value="<%=schedu.getFinish_schedule()%>">
                                    </div>
                             </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                   Save Changes
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>