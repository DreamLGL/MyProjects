package com.lgl.lambda.test2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/15 8:15 下午
 */
public class ArraysDemo1 {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("张三", 38),
                new Person("李四", 18),
                new Person("王五", 19)
        };
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        //使用lambda表达式简化
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
