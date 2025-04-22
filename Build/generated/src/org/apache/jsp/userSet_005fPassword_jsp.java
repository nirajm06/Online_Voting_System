package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userSet_005fPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Set Password</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"Set Password.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container d-flex justify-content-center align-items-center min-vh-100\">\n");
      out.write("        <div class=\"row border rounded-5 p-3 bg-white shadow box-area\">\n");
      out.write("            <div class=\"col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box\" style=\"background: #103cbe;\">\n");
      out.write("                <div class=\"featured-image mb-3\">\n");
      out.write("                    <img src=\"images/1.png\" class=\"img-fluid\" style=\"width: 250px;\">\n");
      out.write("                </div>\n");
      out.write("                <p class=\"text-white fs-2\" style=\"font-family: 'Courier New', Courier, monospace; font-weight: 600;\">Be Verified</p>\n");
      out.write("                <small class=\"text-white text-wrap text-center\" style=\"width: 17rem;font-family: 'Courier New', Courier, monospace;\">Join experienced Designers on this platform.</small>\n");
      out.write("            </div> \n");
      out.write("            <div class=\"col-md-6 right-box\">\n");
      out.write("                <div class=\"row align-items-center\">\n");
      out.write("\n");
      out.write("                    <!-- Form 1: For Sending OTP -->\n");
      out.write("                    <form action=\"userSet_PasswordEmail\" method=\"post\">\n");
      out.write("                        <div class=\"header-text mb-4\">\n");
      out.write("                            <h2>Send OTP</h2>\n");
      out.write("                            <p>Enter your email to receive the OTP.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control form-control-lg bg-light fs-6\" placeholder=\"Email address\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" value=\"Send OTP\" class=\"btn btn-lg btn-primary mb-3\" />\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <!-- Form 2: For Password Reset -->\n");
      out.write("                    <form action=\"setPassword\" method=\"post\">\n");
      out.write("                        <div class=\"header-text mb-4\">\n");
      out.write("                            <h2>Set Password</h2>\n");
      out.write("                            <p>Enter your new password and OTP to reset.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Reuse the Email Field -->\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control form-control-lg bg-light fs-6\" placeholder=\"Email address\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control form-control-lg bg-light fs-6\" placeholder=\"New Password\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-group mb-1\">\n");
      out.write("                            <input type=\"password\" id=\"confirm-password\" name=\"confirm-password\" class=\"form-control form-control-lg bg-light fs-6\" placeholder=\"Confirm Password\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-group mb-1\">\n");
      out.write("                            <input type=\"text\" id=\"otp\" name=\"otp\" class=\"form-control form-control-lg bg-light fs-6\" placeholder=\"Enter OTP\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <input class=\"btn btn-lg btn-primary w-100 fs-6\" type=\"submit\" value=\"Reset Password\" />\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
