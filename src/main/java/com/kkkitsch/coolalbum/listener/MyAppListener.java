package com.kkkitsch.coolalbum.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // 将项目路径放在application域中
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appPath", servletContext.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 项目关闭，销毁application域汇中的所有数据

    }

}
