package test;

import com.dao.LoginDAO;
import com.dao.LoginSuccessDAO;
import com.dao.RegistrationDAO;
import com.factory.ClassFactory;
import com.service.LoginService;
import com.service.LoginSuccessService;
import com.service.RegistrationService;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by sabya on 28/03/17.
 */
public class TestFactory {
    @Test
    public void testFactory() throws URISyntaxException, SQLException {
        Assert.assertTrue(ClassFactory.createLoginDAO() instanceof LoginDAO);
        Assert.assertTrue(ClassFactory.createRegistrationService() instanceof RegistrationService);
        Assert.assertTrue(ClassFactory.createRegistrationDAO() instanceof RegistrationDAO);
        Assert.assertTrue(ClassFactory.createLoginService() instanceof LoginService);
        Assert.assertTrue(ClassFactory.createLoginSuccessDAO() instanceof LoginSuccessDAO);
        Assert.assertTrue(ClassFactory.createLoginSuccessService() instanceof LoginSuccessService);

    }

}
