package com.blog.manage.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.function.IntConsumer;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2022-04-13-16:48
 */
@SpringBootTest
public class BlogManageControllerTest {

    @Test
    public  void test() {
       foreeach((int value) ->{
            System.out.println(value);
        });
    }

    public static void foreeach(IntConsumer intConsumer){
        int[] arr={1,2,3,4,5,6,7,8,9};
        for (int i : arr){
            intConsumer.accept(i);
        }

    }

}
