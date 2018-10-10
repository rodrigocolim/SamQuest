/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author rodri
 */
public class Manipulator {

    private static final Manipulator objectManipulator = new Manipulator();

    private Manipulator() {

    }

    public static Manipulator getObjectManipulator() {
        return objectManipulator;
    }

    public Object deserialize(byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception ec) {
            System.out.println("exceção byte to obj "+ec.getMessage() );
        }
        return null;
    }

    public byte[] serialize(Object obj) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();

    }

    public void saveObject(String path, byte[] object) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
            buffWrite.append(new String(object));
            buffWrite.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no final do arquivo: " + e.getMessage());
        }
    }

    public byte[] getObject(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        ByteArrayOutputStream object = new ByteArrayOutputStream();
        return object.toByteArray();
    }
}
