package dataprovider;

import models.UserModel;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderForRegistration {

    @DataProvider
    public Iterator<Object[]> DpFile_registrationPositiveTest() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForRegistration/data_RegistrationPositiveTest.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .name(split[0])
                    .email(split[1])
                    .password(split[2])
                    .confirmPassword(split[3])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_registrationNegativeTest_WrongEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForRegistration/data_RegistrationNegativeTest_WrongEmail.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .name(split[0])
                    .email(split[1])
                    .password(split[2])
                    .confirmPassword(split[3])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_registrationNegativeTest_DuplicateEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForRegistration/data_RegistrationNegativeTest_DuplicateEmail.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .name(split[0])
                    .email(split[1])
                    .password(split[2])
                    .confirmPassword(split[3])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_registrationNegativeTest_WrongPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForRegistration/data_RegistrationNegativeTest_WrongPassword.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .name(split[0])
                    .email(split[1])
                    .password(split[2])
                    .confirmPassword(split[3])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_registrationNegativeTest_PasswordsNotMatch() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForRegistration/data_RegistrationNegativeTest_PasswordNotMatch.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .name(split[0])
                    .email(split[1])
                    .password(split[2])
                    .confirmPassword(split[3])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
