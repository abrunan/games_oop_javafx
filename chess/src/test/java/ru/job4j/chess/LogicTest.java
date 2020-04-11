package ru.job4j.chess;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;



public class LogicTest {

    @Test
    public void whenWayIsNotFreeThenFalse() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        Figure bishopInTheWay = new BishopBlack(Cell.E3);
        logic.add(bishop);
        logic.add(bishopInTheWay);
        boolean result = logic.move(Cell.C1, Cell.G5);

        assertThat(result, is(false));
    }

    @Test
    public void whenWayIsFreeThenTrue() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        boolean result = logic.move(Cell.C1, Cell.D2);

        assertThat(result, is(true));
    }
}
