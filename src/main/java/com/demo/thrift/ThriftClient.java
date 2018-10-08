package com.demo.thrift;

import com.demo.thrift.generated.Person;
import com.demo.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

    public static void main(String[] args) throws Exception {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person1 = client.getPersonByUsername("张三");

            System.out.println(person1.getUsername());
            System.out.println(person1.getAge());
            System.out.println(person1.isMarried());
            System.out.println("--------------------------");

            Person person2 = new Person();
            person2.setUsername("李四");
            person2.setAge(25);
            person2.setMarried(true);
            client.savePerson(person2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}
