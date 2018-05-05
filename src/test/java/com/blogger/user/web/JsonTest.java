package com.blogger.user.web;

import com.blogger.user.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
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
public class JsonTest {

    Logger logger = Logger.getLogger(this.getClass());

    private static XStream xStream = null;

    static {

        xStream = new XStream(new JettisonMappedXmlDriver());

        // 需要转换的类型
        xStream.processAnnotations(User.class);

        // 开启注解
        xStream.autodetectAnnotations(true);
    }

    public static void main(String[] args) throws Exception {

        User user = getUser();

        objectToJson(user);

        xmlToObject();

        // 持久化
        persist();
    }

    public static void persist() {

        File file = new File("userjson");

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

    public static void objectToJson(User user) throws Exception {

        File file = new File("json.json");

        if (!file.exists()) {

            file.createNewFile();
        }

        PrintWriter printWriter = new PrintWriter(file);

        PrettyPrintWriter writer = new PrettyPrintWriter(printWriter);

        ObjectOutputStream objectOutputStream = xStream.createObjectOutputStream(writer);

        /*PrintWriter printWriter = new PrintWriter(file);

        PrettyPrintWriter writer = new PrettyPrintWriter(printWriter);

        ObjectOutputStream objectOutputStream = xStream.createObjectOutputStream(writer);

        objectOutputStream.writeObject(user);

        objectOutputStream.close();*/

        xStream.setMode(XStream.NO_REFERENCES);

        xStream.toXML(user, objectOutputStream);
    }

    public static void xmlToObject() throws Exception {

        File file = new File("json.json");

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
}
