package testrunner;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;
import setup.ReadGmail;
import setup.Setup;
import setup.UserModel;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RegistrationExtraTestRunner extends Setup {

    @Test(priority = 1, description = "Run 3 times to register user 3 times")
    public void userRegistration() throws InterruptedException, IOException, ParseException, ConfigurationException {

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/extra_users.csv"));
        String line;
        reader.readLine();
        UserModel[] userModels = new UserModel[3];
        int index = 0;
        while ((line = reader.readLine()) != null && index < 3) {
            String[] data = line.split(",", -1);
            UserModel userModel = new UserModel();
            userModel.setFirstname(data[0]);
            userModel.setLastname(data[1]);
            userModel.setEmail(data[2]);
            userModel.setPassword(data[3]);
            userModel.setPhonenumber(data[4]);
            userModel.setAddress(data[5]);
            userModels[index++] = userModel;
        }
        reader.close();

        String successMessage;
        RegistrationPage registrationPage;



        registrationPage = new RegistrationPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();

        registrationPage.doRegister(userModels[0]);
        Thread.sleep(3000);
        successMessage = driver.findElement(By.className("Toastify__toast")).getText();
        Assert.assertTrue(successMessage.contains("registered successfully"));
        readGmailMultipleUse();
        Thread.sleep(2000);



        registrationPage = new RegistrationPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();

        registrationPage.doRegister(userModels[1]);
        Thread.sleep(3000);
        successMessage = driver.findElement(By.className("Toastify__toast")).getText();
        Assert.assertTrue(successMessage.contains("registered successfully"));
        readGmailMultipleUse();
        Thread.sleep(2000);


        registrationPage = new RegistrationPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();

        registrationPage.doRegister(userModels[2]);
        Thread.sleep(3000);
        successMessage = driver.findElement(By.className("Toastify__toast")).getText();
        Assert.assertTrue(successMessage.contains("registered successfully"));
        readGmailMultipleUse();
        Thread.sleep(2000);

        Utils.updateExtraUsersEmailsInCSV("src/test/resources/extra_users.csv");

    }

    public void readGmailMultipleUse() throws InterruptedException, ConfigurationException, IOException {
        Thread.sleep(3000);
        
        ReadGmail readGmail = new ReadGmail();

        Thread.sleep(1000);
        String mailBody = readGmail.readMailById1();

        Assert.assertTrue(mailBody.contains("Welcome to our platform!"));
    }

//    @Test(priority = 1, description = "Run 3 times to register user 3 times")
//    public void registerUser() throws ConfigurationException, IOException, ParseException, InterruptedException {
//        RegistrationExtraTestRunner registrationExtraTestRunner = new RegistrationExtraTestRunner();
//        ForgotPasswordTestRunner forgotPasswordTestRunner = new ForgotPasswordTestRunner();
//        ResetPasswordTestRunner resetPasswordTestRunner = new ResetPasswordTestRunner();
//        LoginTestRunner loginTestRunner = new LoginTestRunner();
//        UserProfileTestRunner userProfileTestRunner = new UserProfileTestRunner();
//        LoginByUpdatedEmailTestRunner loginByUpdatedEmailTestRunner = new LoginByUpdatedEmailTestRunner();
//        for (int i = 1; i <= 1; i++) {
//            registrationExtraTestRunner.userRegistration();
//            forgotPasswordTestRunner.resetPasswordUsingValidEmail();
//            resetPasswordTestRunner.resetPassword();
//            loginTestRunner.userLoginByRegisteredAccount();
//            userProfileTestRunner.userLoginByRegisteredAccount();
//            userProfileTestRunner.doUpdateEmail();
//            loginByUpdatedEmailTestRunner.doLoginByUpdatedEmail();
//        }
//
//    }

}
