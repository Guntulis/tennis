package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoreCountingServiceTest {

    private TennisScoreCountingService service;

    @Before
    public void setUp() throws Exception {
        service = new TennisScoreCountingService();
    }

    @Test
    public void testDeuce() throws Exception {
        String result = service.currentScore(3, 3);
        assertEquals("Deuce", result);
        result = service.currentScore(4, 4);
        assertEquals("Deuce", result);
        result = service.currentScore(5, 5);
        assertEquals("Deuce", result);
    }

    @Test
    public void testAdvantageA() throws Exception {
        String result = service.currentScore(4, 3);
        assertEquals("Advantage A", result);
        result = service.currentScore(5, 4);
        assertEquals("Advantage A", result);
        result = service.currentScore(6, 5);
        assertEquals("Advantage A", result);
    }

    @Test
    public void testAdvantageB() throws Exception {
        String result = service.currentScore(3, 4);
        assertEquals("Advantage B", result);
        result = service.currentScore(4, 5);
        assertEquals("Advantage B", result);
        result = service.currentScore(5, 6);
        assertEquals("Advantage B", result);
    }

    @Test
    public void testGameA() throws Exception {
        String result = service.currentScore(4, 0);
        assertEquals("Game A", result);
        result = service.currentScore(4, 1);
        assertEquals("Game A", result);
        result = service.currentScore(4, 2);
        assertEquals("Game A", result);
        result = service.currentScore(5, 3);
        assertEquals("Game A", result);
    }

    @Test
    public void testGameB() throws Exception {
        String result = service.currentScore(0, 4);
        assertEquals("Game B", result);
        result = service.currentScore(1, 4);
        assertEquals("Game B", result);
        result = service.currentScore(2, 4);
        assertEquals("Game B", result);
        result = service.currentScore(3, 5);
        assertEquals("Game B", result);
    }
}