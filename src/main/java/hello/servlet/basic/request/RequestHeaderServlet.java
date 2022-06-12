package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {

        System.out.println("--- ECT START ---");
        System.out.println("RemoteHost : " + request.getRemoteHost());
        System.out.println("RemoteAddr : " + request.getRemoteAddr());
        System.out.println("RemotePort : " + request.getRemotePort());
        System.out.println();

        System.out.println("LocalName : " + request.getLocalName());
        System.out.println("LocalAddr : " + request.getLocalAddr());
        System.out.println("LocalPort : " + request.getLocalPort());
        System.out.println();

        System.out.println("--- ECT END ---");
    }

    private void printHeaderUtils(HttpServletRequest request) {

        System.out.println("--- Utils START ---");
        System.out.println("ServerName : " + request.getServerName());
        System.out.println("ServerPort : " + request.getServerPort());
        System.out.println();

        System.out.println("Locale : " + request.getLocale());
        request.getLocales().asIterator()
                        .forEachRemaining(locale -> System.out.println("getLocales : " + locale));
        System.out.println();

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " : "+ cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("ContentType : " + request.getContentType());
        System.out.println("ContentLength : " + request.getContentLength());
        System.out.println("CharacterEncoding : " + request.getCharacterEncoding());

        System.out.println("--- Utils END ---");
    }

    private void printStartLine(HttpServletRequest request) {

        System.out.println("--- REQUEST LINE START ---");
        System.out.println("Method : " + request.getMethod());
        System.out.println("Protocol = " + request.getProtocol());
        System.out.println("Scheme = " + request.getScheme());
        System.out.println("RequestURL = " + request.getRequestURL());
        System.out.println("RequestURI = " + request.getRequestURI());
        System.out.println("QueryString = " + request.getQueryString());
        System.out.println("IsSecure = " + request.isSecure());
        System.out.println("--- REQUEST LINE END ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {

        System.out.println("--- HEADER START ---");
//        예전 스타일
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String s = headerNames.nextElement();
//            System.out.println(s + " : " + s);
//        }

        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));

        System.out.println("--- HEADER END ---");
        System.out.println();
    }
}
