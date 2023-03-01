package dataprovider;

import models.UserModel;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderForLogin {

    @DataProvider
    public Iterator<Object[]> DpFile_loginPositiveTest() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForLogin/data_LoginPositiveTest.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_loginNegativeTest_WrongEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForLogin/data_LoginNegativeTest_WrongEmail.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_loginNegativeTest_WrongPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForLogin/data_LoginNegativeTest_WrongPassword.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DpFile_loginNegativeTest_UnregisteredUser() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForLogin/data_LoginNegativeTest_UnregisteredUser.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
