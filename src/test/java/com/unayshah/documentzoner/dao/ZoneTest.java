package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ZoneTest {

    @Mock
    Zone zone;

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Zone test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Zone test completed");
    }

    @BeforeEach
    public void before() {
        zone = new Zone();
    }

    @Test
    public void checkZone() {
        assertNotEquals(zone, null);
    }

    @Test
    public void getZone() {
        assertEquals(zone.getContent(), String.valueOf(""));
        assertEquals(zone.getX(), 0);
        assertEquals(zone.getY(), 0);
        assertEquals(zone.getW(), 0);
        assertEquals(zone.getH(), 0);
    }

    @Test
    public void modifyZone() {
        String zoneContent = "Test";
        Integer zoneX = 1;
        Integer zoneY = 2;
        Integer zoneW = 3;
        Integer zoneH = 4;
        zone.setContent(zoneContent);
        zone.setX(zoneX);
        zone.setY(zoneY);
        zone.setW(zoneW);
        zone.setH(zoneH);
        assertEquals(zone.getContent(), zoneContent);
        assertEquals(zone.getX(), zoneX);
        assertEquals(zone.getY(), zoneY);
        assertEquals(zone.getW(), zoneW);
        assertEquals(zone.getH(), zoneH);
    }

}
