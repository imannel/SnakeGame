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

        Segment[][] segments = new Segment[10][7];
        Plateau plateau = new Plateau(segments, 10, 7);
        Game game = new Game(plateau);
        Snake snake = new Snake(new Segment(TypeSegment.SNACK_NODE, 0, 0));
        game.setSnake(snake);
        assertFalse(game.checkBorderCollision());
        snake.moveLeft();
        assertTrue(game.checkBorderCollision());
    }

    @Test
    public void testCheckSnackCollision() {
        Segment[][] segments = new Segment[10][7];
        Plateau plateau = new Plateau(segments, 10, 10);
        Game game = new Game(plateau);
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
        Segment[][] segments = new Segment[5][5];
        for (int i = 0; i < segments.length; i++) {
            for (int j = 0; j < segments[i].length; j++) {
                segments[i][j] = new Segment(TypeSegment.EMPTY, i, j);
            }
        }
        Plateau plateau = new Plateau(segments, 5, 5);

        Game game = new Game(plateau);
        game.setSnake(snake);

        game.move(Direction.LEFT);

        assertEquals(Direction.LEFT, game.getDirection());

        assertEquals(1, snake.getSnakeList().get(0).getColonne());

        assertFalse(game.isGameOver());


    }

}



