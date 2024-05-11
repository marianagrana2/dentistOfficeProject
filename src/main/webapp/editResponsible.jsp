

<%@page import="logic.Responsible"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/body.jsp"%>

<h1>Responsible Edition </h1>
<p>This is the section to edit Responsible from some Patient. </p>
<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Edit Responsible </h1>
                            </div>
                            <%
                                Responsible respo = (Responsible)request.getSession().getAttribute("respoEdit");
                            %>
                            <form class="user"action="SvEditResponsible" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="dni"
                                            name="dni" placeholder="DNI" value="<%=respo.getDni()%>">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="phone"
                                             name="phone" placeholder="Phone" value="<%=respo.getPhone()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" id="first_name"
                                             name="firstName"placeholder="First Name" value="<%=respo.getName()%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="last_name"
                                             name="lastName" placeholder="Last Name" value="<%=respo.getLast_name()%>">
                                    </div>
                                   
                                <div class="col-sm-6 mb-3">
                                    <input type="text" class="form-control form-control-user" id="responsible_type"
                                         name="responsibleType" placeholder="Type of Responsible (Parent,Tutor,Sibling)"
                                         value="<%=respo.getType_resp()%>">
                                </div>
                                
                                    <div class="col-sm-6 mb-3">
                                        <input type="date" class="form-control form-control-user"
                                            id="date_birth" name="dateBirth"placeholder="Date of Birth" value="<%=respo.getDate_birth()%>">
                                    </div>
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="address" name="address" placeholder="Address" value="<%=respo.getAddress()%>">
                                    </div>
                                    
                                </div>
                                <button  type="submit" class="btn btn-primary btn-user btn-block">
                                    Save Changes
                                </button>
                               
                            </form>
                        </div>
            </div>
        </div>
    </div>

<%@include file="components/footer.jsp" %>