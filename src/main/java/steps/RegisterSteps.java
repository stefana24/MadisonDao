package steps;

import dao.registration.UserAbstractDao;
import dao.registration.UserDao;
import models.User;
import net.thucydides.core.annotations.Step;
import pages.HeaderPage;
import pages.RegisterPage;
import tools.constants.MessageConstants;
import org.junit.Assert;

public class RegisterSteps {
    private RegisterPage registerPage;
    private UserAbstractDao userDao = new UserDao();
    private HeaderPage headerPage;

    public User getUserData(){
        User user = new User();
        user.setFirstName(registerPage.getFirstName());
        user.setMiddleName(registerPage.getAttribute("middlename"));
        user.setLastName(registerPage.getAttribute("lastname"));
        user.setEmail(registerPage.getAttribute("email"));
        user.setPassword(registerPage.getAttribute("password"));

        return user;
    }

    @Step
    public void goToRegister(){
        headerPage.clickOnAccount();
        headerPage.clickOnALinkFromAccount("Register");
        Assert.assertEquals(registerPage.getCreateAnAccountMsg(),MessageConstants.CREATE_ACCOUNT_MSG);
    }

    @Step
    public void registerUser(User user){
        registerPage.fillUserDetails(user);
        registerPage.clickOnRegisterBtn();
        Assert.assertEquals(registerPage.getRegistrationMsg(), MessageConstants.REGISTRATION_MSG);
        userDao.saveUser(user);

//        List<User> users = userDao.getAllUsers();
//        for(User singleUser:users){
//            System.out.println("Lista: " + singleUser);
//        }

        User user2  = userDao.getUserByEmail(user.getEmail());
        System.out.println("User: " + user2);

        String welcomeMsg = headerPage.getWelcomeMsg();
        String[] names = welcomeMsg.split(" ");
        String last = names[3].substring(0,names[3].length()-1);

        Assert.assertTrue(user2.getFirstName().equalsIgnoreCase(names[1]));
        Assert.assertTrue(user2.getMiddleName().equalsIgnoreCase(names[2]));
        Assert.assertTrue(user2.getLastName().equalsIgnoreCase(last));

    }



}
