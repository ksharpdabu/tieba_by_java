package info.dabu.web.filter;


import info.dabu.utils.HibernateUtils;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by AlexY on 2016/8/14.
 */
public class TransactionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      Session session =  HibernateUtils.getCurrentSession();

//        开启事务
        session.beginTransaction();


        try {
            filterChain.doFilter(servletRequest,servletResponse);


            if ( null != session && session.isOpen()){

                session.getTransaction().commit();

//                下面这行必须删除
//                session.close();

            }

        }catch (Exception e){

            e.printStackTrace();


            if ( null != session && session.isOpen()){

                session.getTransaction().rollback();


            }


        }
    }

    @Override
    public void destroy() {

    }
}
