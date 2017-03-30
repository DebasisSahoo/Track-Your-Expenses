package test;

import com.bean.Registration;
import com.service.RegistrationServiceImpl;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by sabya on 30/03/17.
 */
public class TestRegistrationServiceImpl {
    @Test
    public void testRegisterServiceImpl() throws Exception {
        assertNotNull(new RegistrationServiceImpl().registerNewMember(new Registration      ("abc","xyz","abc_xyz@gmail.com")));
    }
}
