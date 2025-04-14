package com.bnt.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bnt.model.Demo;
import com.bnt.repository.DemoRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RepositoryTest {
 
    @Mock
    DemoRepository demoRepository;

    @Test
    void testCreate(){
        Demo expectedResult = new Demo(1L, "Supriya", "Pune", "BNT", null);
        when(demoRepository.save(expectedResult)).thenReturn(expectedResult);
        Demo actualResult = demoRepository.save(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAll(){
        List<Demo> expectedResult = new ArrayList<>();
        expectedResult.add(new Demo(1L, "Supriya", "Vijaya", "BNT", null));
        expectedResult.add(new Demo(2L, "Vijaya", "Pune", "BNT", null));
        when(demoRepository.findAll()).thenReturn(expectedResult);
        List<Demo> actualResult = demoRepository.findAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDelete() {
        demoRepository.deleteById(1L);
        verify(demoRepository).deleteById(1L);
    }

    @Test
    void testUpdate(){
        Demo expectedResult = new Demo(1L, "Sup", "Pune", "BNT", null);
        when(demoRepository.save(expectedResult)).thenReturn(expectedResult);
        Demo actualResult = demoRepository.save(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetById(){
        Demo expectedResult = new Demo(1L, "Supriya", "Pune", "BNT", null);
        when(demoRepository.findById(1L)).thenReturn(Optional.of(expectedResult));
        Demo actualResult = demoRepository.findById(1L).orElse(null);
        assertEquals(expectedResult, actualResult);
    }
    
}
