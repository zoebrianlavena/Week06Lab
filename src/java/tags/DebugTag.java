/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class DebugTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException{
        
        ServletRequest request = (ServletRequest) pageContext.getServletContext();
        String domain = request.getServerName();
        String debug = request.getParameter("debug");
        
        if(debug != null){
            if(domain.equals("test") || domain.equals("localhost")){
                return EVAL_BODY_INCLUDE;
            }
        }    
        return SKIP_BODY;
    }
    
}
