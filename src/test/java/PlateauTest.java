import org.example.entities.Plateau;
import org.example.entities.Segment;
import org.example.enums.TypeSegment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlateauTest {
    @Test
    public void testProduireAliment() {
        Segment[][] segments = new Segment[5][5];
        for (int i = 0; i < segments.length; i++) {
            for (int j = 0; j < segments[i].length; j++) {
                segments[i][j] = new Segment(TypeSegment.EMPTY, i, j);
            }
        }
        Plateau plateau = new Plateau(segments, 5, 5);

        Segment aliment = plateau.produireAliment();

        assertNotNull(aliment);
        assertEquals(TypeSegment.ALIMENT, aliment.getTypeSegment());

    }
}
