package com.github.Yasenia.flea_school.server.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.Yasenia.flea_school.server.SpringBaseTest;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.service.ICommonService;

public class CommonServiceTest extends SpringBaseTest{
    @Autowired
    private ICommonService commonService;
    
    @Before
    public void setUp() {
    }    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFindLocationById() {
        Location l = commonService.findLocationById(0);
        assertNotNull(l);
    }
    
    
}
