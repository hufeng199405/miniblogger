package com.blogger.user.web;

import com.blogger.user.aop.SimulateUserOperate;
import com.blogger.user.aop.SimulateUserOperateImpl;
import com.blogger.user.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-06 17:35
 * @desc
 * @since 1.8
 */
public class MainTest {

    Logger logger = Logger.getLogger(this.getClass());

    private static XStream xStream = null;

    static {

        xStream = new XStream(new DomDriver());

        // 需要转换的类型
        xStream.processAnnotations(User.class);

        // 开启注解
        xStream.autodetectAnnotations(true);
    }

    public static void main(String[] args) throws Exception {

        User user = getUser();

        objectToXml(user);

        xmlToObject();

        // 持久化
        persist();
    }

    public static void persist() {

        File file = new File("user");

        if (!file.exists()) {

            file.mkdir();
        }

        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {

            User user = getUser();

            users.add(user);
        }

        PersistenceStrategy strategy = new FilePersistenceStrategy(file);

        List<Object> list = new XmlArrayList(strategy);

        list.add(users);
    }

    public static void objectToXml(User user) throws Exception {

        File file = new File("user.xml");

        if (!file.exists()) {

            file.createNewFile();
        }

        //OutputStream outputStream = new FileOutputStream(file);

        PrintWriter printWriter = new PrintWriter(file);

        PrettyPrintWriter writer = new PrettyPrintWriter(printWriter);

        ObjectOutputStream objectOutputStream = xStream.createObjectOutputStream(writer);

        objectOutputStream.writeObject(user);

        objectOutputStream.close();
    }

    public static void xmlToObject() throws Exception {

        File file = new File("user.xml");

        if (!file.exists()) {

            file.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream inputStream = xStream.createObjectInputStream(fileInputStream);

        User user = (User) inputStream.readObject();

        System.out.println(user.getUserId() + "----" + user.getLastIp());
    }

    public static User getUser() {

        User user = new User();

        user.setUserId(111);

        user.setUserName("xxxx");

        user.setPassword("xxpassword");

        user.setLastIp("192.168.1.1");

        return user;
    }

    @Test
    private void mytest() throws Exception {

        /*String aa =  "1m² < X <= 10m²";

        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(aa);

        while(matcher.find()){

            logger.info(matcher.group());
        }*/
        /*BigDecimal bigDecimal = BigDecimal.valueOf(0.05);
        BigDecimal bigDecimal1 = new BigDecimal(0.05);

        logger.info(bigDecimal.add(BigDecimal.valueOf(5)));
        logger.info(bigDecimal1.add(BigDecimal.valueOf(5)));*/

        /*SimulateUserOperate simulateUserOperate = new SimulateUserOperateImpl();

        SimulateUserOperate test = (SimulateUserOperate) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{SimulateUserOperate.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                logger.info("运行方法前------------");

                Object object = method.invoke(simulateUserOperate, args);

                logger.info("运行方法后--------------");

                return object;
            }
        });

        test.deleteUser("test");*/


    }
}
