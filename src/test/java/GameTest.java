import org.example.entities.Game;
import org.example.entities.Plateau;
import org.example.entities.Segment;
import org.example.entities.Snake;
import org.example.enums.Direction;
import org.example.enums.TypeSegment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {


    @Test
    public void testCheckBorderCollision() {
        Game game = new Game(10,7);
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE,     1, 1));
        game.setSnake(snake);
        game.move(Direction.LEFT);
       assertTrue(game.checkBorderCollision());
    }
    @Test
    public void testCheckSnackCollision() {
        Game game = new Game(10, 10);
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 3, 3));
        game.setSnake(snake);
        snake.add(new Segment(TypeSegment.SNACK_NODE, 3, 4));
        snake.add(new Segment(TypeSegment.SNACK_NODE, 3, 5));
        snake.add(new Segment(TypeSegment.SNACK_NODE, 3, 6));
        snake.add(new Segment(TypeSegment.SNACK_NODE, 3, 7));
        snake.moveUp();
        assertFalse(game.checkSnackCollision());
        snake.moveLeft();
        assertFalse(game.checkSnackCollision());
        snake.moveDown();
        assertTrue(game.checkSnackCollision());
    }

    @Test
    public void testMove() {
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 2, 2));
        Game game = new Game(5, 5);
        game.setSnake(snake);
        game.move(Direction.LEFT);
        assertEquals(Direction.LEFT, game.getDirection());
        assertEquals(1, snake.getSnakeList().get(0).getColonne());
        assertFalse(game.isGameOver());

    }
}



