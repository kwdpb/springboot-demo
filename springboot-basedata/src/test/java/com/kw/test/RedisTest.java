package com.kw.test;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class RedisTest {


    @Test
    public void test1(){

        try {
            int[] arr={1,2,3};
            for(int i=0;i<3;i++){
                System.out.println(arr[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕捉到异常");
        }
    }

    public static void main(String[] args) {
        try {
            int[] arr={1,2,3};
            for(int i=0;i<4;i++){
                System.out.println(arr[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕捉到异常");
        }
    }




}
