package com.bnt.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnt.exception.InvalidDataException;
import com.bnt.exception.UserNotFoundException;
import com.bnt.model.Demo;
import com.bnt.repository.DemoRepository;
import com.bnt.service.DemoService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    DemoRepository demoRepository;

    @InjectMocks
    DemoService demoService;

    @Test
    void testCreate(){
        Demo expectedResult = new Demo(1L, "Supriya", "Pune", "BNT", null);
        when(demoRepository.save(expectedResult)).thenReturn(expectedResult);
        Demo actualResult = demoService.create(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAll(){
        List<Demo> expectedResult = new ArrayList<>();
        expectedResult.add(new Demo (1L, "Supriya", "Pune", "BNT", null));
        expectedResult.add(new Demo (2L, "Vijaya", "Pune", "BNT", null));
        when(demoRepository.findAll()).thenReturn(expectedResult);
        List<Demo> actualResult = demoService.getAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDelete(){
        when(demoRepository.existsById(1L)).thenReturn(true);
        demoService.delete(1L);
        verify(demoRepository).deleteById(1L);
    }

    @Test
    void testUpdate(){
        when(demoRepository.existsById(1L)).thenReturn(true);
        Demo expectedResult = new Demo(1L, "Sup", "Pune", "BNT", null);
        when(demoRepository.save(expectedResult)).thenReturn(expectedResult);
        Demo actualResult = demoService.updateDemo(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testPatch(){
        Demo existingData = new Demo();
        existingData.setId(1L);
        existingData.setName("Supriya");
        when(demoRepository.findById(1L)).thenReturn(Optional.of(existingData));
        Demo expectedResult = new Demo();
        expectedResult.setId(1L);
        expectedResult.setName("Suppp");
        when(demoRepository.save(expectedResult)).thenReturn(expectedResult);
        Demo actualResult = demoService.patchName(1L, "Suppp");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetById(){
        Demo expectedResult = new Demo(1L, "Supriya", "Pune", "BNT", null);
        when(demoRepository.findById(1L)).thenReturn(Optional.of(expectedResult));
        Demo actualaresult = demoService.getById(1L);
        assertEquals(expectedResult, actualaresult);
     }


     //======================================Negative Test Cases======================================


      @Test
    void testCreate_InvalidData() {
        Demo invalidDemo = new Demo();
        assertThrows(InvalidDataException.class, () -> demoService.create(invalidDemo));
        verify(demoRepository, never()).save(any());
    }

    @Test
    void testGetAll_EmptyList() {
        when(demoRepository.findAll()).thenReturn(Collections.emptyList());
        List<Demo> allDemo = demoService.getAll();
        assertTrue(allDemo.isEmpty());
        verify(demoRepository, times(1)).findAll();
    }

     @Test
    void testDelete_UserNotFound() {
        when(demoRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> demoService.delete(1L));
        verify(demoRepository, times(1)).existsById(1L);
        verify(demoRepository, never()).deleteById(anyLong());
    }

    @Test
    void testUpdateDemo_UserNotFound() {
        when(demoRepository.existsById(anyLong())).thenReturn(false);
        Demo demoToUpdate = new Demo();
        demoToUpdate.setId(1L);
        assertThrows(UserNotFoundException.class, () -> demoService.updateDemo(demoToUpdate));
        verify(demoRepository, times(1)).existsById(1L);
        verify(demoRepository, never()).save(any());
    }

    @Test
    void testPatchName_UserNotFound() {
        when(demoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> demoService.patchName(1L, "NewName"));
        verify(demoRepository, times(1)).findById(anyLong());
        verify(demoRepository, never()).save(any());
    }
}
