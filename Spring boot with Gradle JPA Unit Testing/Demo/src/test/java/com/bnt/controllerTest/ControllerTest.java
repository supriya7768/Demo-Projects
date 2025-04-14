package com.bnt.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.bnt.controller.DemoController;
import com.bnt.model.Demo;
import com.bnt.repository.DemoRepository;
import com.bnt.service.DemoService;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    DemoRepository demoRepository;

    @Mock
    DemoService demoService;

    @InjectMocks
    DemoController demoController;

    @Test
    void check(){
        ResponseEntity<String> expectedResult = ResponseEntity.ok("Hello");
        ResponseEntity<String> actualResult = demoController.check();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCreate() {
        Demo demo = new Demo(1L, "Supriya", "Pune", "BNT", null);
        ResponseEntity<Demo> expectedResult = ResponseEntity.status(HttpStatus.CREATED).body(demo);
        when(demoService.create(demo)).thenReturn(demo);
        ResponseEntity<Demo> actualResult = demoController.create(demo);
        assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
        assertEquals(expectedResult.getBody(), actualResult.getBody());
    }

    @Test
    void testGetAll(){
       List<Demo> demo = new ArrayList<>();
       demo.add(new Demo(1L, "Supriya", "Pune", "BNT", null));
       demo.add(new Demo(2L, "Vijaya", "Pune", "BNT", null));
       ResponseEntity<List<Demo>> expectedResult = ResponseEntity.status(HttpStatus.FOUND).body(demo);
       when(demoService.getAll()).thenReturn(demo);
       ResponseEntity<List<Demo>> actualResult = demoController.getAll();
       assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
       assertEquals(expectedResult.getBody(), actualResult.getBody());
    }
    
    @Test
    void testDelete(){
        ResponseEntity<String> expectedResult = demoController.delete(1L);
        verify(demoService).delete(1L);
        assertEquals(HttpStatus.OK, expectedResult.getStatusCode());
        assertEquals("Deleted the user with id 1", expectedResult.getBody());

    }

    @Test
    void testUpdate(){
        Demo demo = new Demo(1L, "Sup", "Pune", "BNT", null);
        ResponseEntity<Demo> expectedResult = ResponseEntity.status(HttpStatus.OK).body(demo);
        when(demoService.updateDemo(demo)).thenReturn(demo);
        ResponseEntity<Demo> actualResult = demoController.updateDemo(1L, "Sup", "Pune", "BNT");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testPatch(){
        Demo demo = new Demo();
        demo.setId(1L);
        demo.setName("Suppp");
        ResponseEntity<Demo> expectedResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(demo);
        when(demoService.patchName(1L, "Suppp")).thenReturn(demo);
        ResponseEntity<Demo> actualResult = demoController.patchName(1L, "Suppp");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetById(){
       Demo demo = new Demo(1L, "Supriya", "Pune", "BNT", null);
        ResponseEntity <Demo> expectedResult = ResponseEntity.status(HttpStatus.OK).body(demo);
        when(demoService.getById(1L)).thenReturn(demo);
        ResponseEntity <Demo> actualaresult = demoController.getById(1L);
        assertEquals(expectedResult, actualaresult);
    }


}
