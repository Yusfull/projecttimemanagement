/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers.mailbox;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Eusuph
 */
public class MailListener implements ServletContextListener{

    /**
     *
     * @param arg0
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit( new MailSrverMonitor(arg0.getServletContext()));
    }
    
}
