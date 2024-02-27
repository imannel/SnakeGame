import org.example.entities.Plateau;
import org.example.entities.Segment;
import org.example.enums.TypeSegment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlateauTest {
    @Test
    public void testProduireAliment() {
        Plateau plateau = new Plateau( 5, 5);
        Segment aliment = plateau.produireAliment();
        assertNotNull(aliment);
        assertEquals(TypeSegment.ALIMENT, aliment.getTypeSegment());

    }
}
