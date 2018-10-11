package top.ninwoo.java.serializable;

import java.io.*;

public class MainTest {
    public static void writeSerializableObject() {
        try (OutputStream outputStream = new FileOutputStream("out.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            Cat cat = new Cat("hellokitty");
            Person person = new Person("ninwoo", 13, cat);
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(new String("abc"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSerializableObject() {
        try (InputStream inputStream = new FileInputStream("out.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.toString());

            String string = (String) objectInputStream.readObject();
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeSerializableObject();
        readSerializableObject();
    }
}
