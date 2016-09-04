package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoreTranslationServiceTest {

    private TennisScoreTranslationService service;

    @Before
    public void setUp() throws Exception {
        service = new TennisScoreTranslationService();
    }

    @Test
    public void testDeuce() throws Exception {
        String result = service.translatedScore(3, 3);
        assertEquals("Deuce", result);
        result = service.translatedScore(4, 4);
        assertEquals("Deuce", result);
        result = service.translatedScore(5, 5);
        assertEquals("Deuce", result);
    }

    @Test
    public void testAdvantageA() throws Exception {
        String result = service.translatedScore(4, 3);
        assertEquals("Advantage A", result);
        result = service.translatedScore(5, 4);
        assertEquals("Advantage A", result);
        result = service.translatedScore(6, 5);
        assertEquals("Advantage A", result);
    }

    @Test
    public void testAdvantageB() throws Exception {
        String result = service.translatedScore(3, 4);
        assertEquals("Advantage B", result);
        result = service.translatedScore(4, 5);
        assertEquals("Advantage B", result);
        result = service.translatedScore(5, 6);
        assertEquals("Advantage B", result);
    }

    @Test
    public void testGameA() throws Exception {
        String result = service.translatedScore(4, 0);
        assertEquals("Game A", result);
        result = service.translatedScore(4, 1);
        assertEquals("Game A", result);
        result = service.translatedScore(4, 2);
        assertEquals("Game A", result);
        result = service.translatedScore(5, 3);
        assertEquals("Game A", result);
    }

    @Test
    public void testGameB() throws Exception {
        String result = service.translatedScore(0, 4);
        assertEquals("Game B", result);
        result = service.translatedScore(1, 4);
        assertEquals("Game B", result);
        result = service.translatedScore(2, 4);
        assertEquals("Game B", result);
        result = service.translatedScore(3, 5);
        assertEquals("Game B", result);
    }

    @Test
    public void testInvalidPoints() throws Exception {
        String result = service.translatedScore(0, 5);
        assertEquals("N/A", result);
        result = service.translatedScore(1, 5);
        assertEquals("N/A", result);
        result = service.translatedScore(2, 5);
        assertEquals("N/A", result);
        result = service.translatedScore(5, 0);
        assertEquals("N/A", result);
        result = service.translatedScore(5, 1);
        assertEquals("N/A", result);
        result = service.translatedScore(5, 2);
        assertEquals("N/A", result);
        result = service.translatedScore(14, 3);
        assertEquals("N/A", result);
    }
}