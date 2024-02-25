import org.example.entities.Segment;
import org.example.entities.Snake;
import org.example.enums.TypeSegment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    @Test
    public void testMoveRight() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        snake.moveRight();
        ArrayList<Segment> snakeList = snake.getSnakeList();
        assertEquals(1, snakeList.size());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(0).getTypeSegment());
        assertEquals(1, snakeList.get(0).getColonne());
        assertEquals(0, snakeList.get(0).getLigne());
    }
    @Test
    public void testMoveLeft() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        snake.moveLeft();
        ArrayList<Segment> snakeList = snake.getSnakeList();
        assertEquals(1, snakeList.size());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(0).getTypeSegment());
        assertEquals(-1, snakeList.get(0).getColonne());
        assertEquals(0, snakeList.get(0).getLigne());
    }
    @Test
    public void testMoveUp() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        snake.moveUp();
        ArrayList<Segment> snakeList = snake.getSnakeList();
        assertEquals(1, snakeList.size());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(0).getTypeSegment());
        assertEquals(0, snakeList.get(0).getColonne());
        assertEquals(-1, snakeList.get(0).getLigne());
    }

    @Test
    public void testMoveDown() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        snake.moveDown();
        ArrayList<Segment> snakeList = snake.getSnakeList();
        assertEquals(1, snakeList.size());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(0).getTypeSegment());
        assertEquals(0, snakeList.get(0).getColonne());
        assertEquals(1, snakeList.get(0).getLigne());
    }
    @Test
    public void testGrow() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        Segment segment = new Segment(TypeSegment.SNACK_NODE, 0, 1);
        snake.grow(segment);
        ArrayList<Segment> snakeList = snake.getSnakeList();
        assertEquals(2, snakeList.size());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(0).getTypeSegment());
        assertEquals(0, snakeList.get(0).getColonne());
        assertEquals(0, snakeList.get(0).getLigne());
        assertEquals(TypeSegment.SNACK_NODE, snakeList.get(1).getTypeSegment());
        assertEquals(1, snakeList.get(1).getColonne());
        assertEquals(0, snakeList.get(1).getLigne());
    }

}
