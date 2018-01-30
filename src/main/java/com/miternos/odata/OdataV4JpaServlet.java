package com.miternos.odata;

import org.apache.olingo.commons.api.ex.ODataException;
import org.apache.olingo.jpa.processor.core.api.JPAODataContext;
import org.apache.olingo.jpa.processor.core.api.JPAODataGetHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by miternos on 7/31/17.
 */
public class OdataV4JpaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String PUNIT_NAME = "com.miternos.odata";

    protected void service(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        try {


            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PUNIT_NAME );


            //EntityManagerFactoryImpl hibernateEmf = (EntityManagerFactoryImpl) emFactory;
           // DatasourceConnectionProviderImpl dp = (DatasourceConnectionProviderImpl)hibernateEmf.getSessionFactory().getServiceRegistry().getService(ConnectionProvider.class);
           // DataSource ds = dp.getDataSource();

            //SessionFactoryImpl sf = (SessionFactoryImpl) ((EntityManagerFactoryImpl) emFactory).getSessionFactory();


            //DatasourceConnectionProviderImpl provider = (DatasourceConnectionProviderImpl) sf.getConnectionProvider();

            JPAODataGetHandler handler = new JPAODataGetHandler(PUNIT_NAME,null);

            handler.process(req, resp);
        } catch (RuntimeException e) {
            throw new ServletException(e);
        } catch (ODataException e) {
            throw new ServletException(e);
        }
    }
}
