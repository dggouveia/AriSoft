package br.edu.ifpb.pos.webapp.utils;

import br.edu.ifpb.pos.webapp.Application;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class PageServerUtils {

    /**
     * Método responsável por renderizar uma página html com a tecnologia thymeleaf
     * e escrevê-la na resposta.
     * 
     * @param page nome da página que deverá ser renderizada.
     */
    public static @ResponseBody void serve (String page
            , HttpServletRequest request, HttpServletResponse response) throws IOException{
        WebContext ctx
                = new WebContext(
                        request,
                        response,
                        request.getServletContext(),
                        request.getLocale()
                );
        response.setContentType("text/html");
        Application.
                getTemplateEngine().process(page, ctx, response.getWriter());
    } 
        
}
