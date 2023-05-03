<%
    if(session.getAttribute("userNewSession") == null) {
        response.sendRedirect(request.getContextPath());
    }
%>