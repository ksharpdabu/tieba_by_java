package info.dabu.web.filter;

/**
 * Created by AlexY on 2016/8/14.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Filter implementation class EncodingFilter
 *
 * 解决post和get的中文乱码
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor.
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        //1 创建我们包装之后的request对象
        ServletRequest req = new MyRequest((HttpServletRequest)request);
        //2放行(放行的request是我们包装后的)
        chain.doFilter(req, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}



//将已经是乱码的参数,重新编码回中文
 class MyRequest extends  HttpServletRequestWrapper{

    private Map<String,String[]> params =new HashMap<String, String[]>();

    public MyRequest(HttpServletRequest request) {
        super(request);
        // 在构造中获得封装参数的map, 将map中所有乱码解决
        //-----------------------------------------------
        //1 获得map
        Map<String,String[]> map = super.getParameterMap();
        //2 遍历map
        if(map!=null && map.size()>0){
            for(Map.Entry<String, String[]> en : map.entrySet()){
                //3 取出每个键值对,并解决值得乱码(逆推法)
                String[] values = en.getValue();
                if(values!=null){
                    String[] newValues = new String[values.length];
                    for(int i = 0; i < values.length ;i++){
                        try {
                            newValues[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                    //4 将解决的键值对 放入新的map
                    params.put(en.getKey(), newValues);
                }
            }
        }

    }

    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);

        if(values==null){//获得的参数键不存在
            return null;
        }

        return values[0];
    }

    @Override
    public Map<String,String[]> getParameterMap() {

        return params;
    }

    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }



}



