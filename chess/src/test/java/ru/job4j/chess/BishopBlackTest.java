package ru.job4j.chess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream sdtOut = System.out;

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(sdtOut);
    }

    @Test
    public void whenCreatedThenCorrectPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell c8 = Cell.C8;
        assertThat(c8, is(bishop.position()));
    }

    @Test
    public void whenCopyThenSamePosition() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        BishopBlack newBishop = (BishopBlack) bishop.copy(Cell.A6);
        assertThat(newBishop.position(), is(Cell.A6));

    }

    @Test
    public void whenWayC1toG5Then4Cells() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] trace = bishop.way(Cell.C1, Cell.G5);
        assertThat(trace, is(
                new Cell[] {Cell.D2,
                        Cell.E3,
                        Cell.F4,
                        Cell.G5}
        ));
    }

    @Test
    public void whenIsNotDiagThenISE() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        try{
            Cell[] trace = bishop.way(Cell.C1, Cell.G4);
        } catch (IllegalStateException ise) {
            System.out.print("Could not way by diagonal from C1 to G4");
        }
        String expect = "Could not way by diagonal from C1 to G4";
        assertThat(new String(out.toByteArray()), is(expect));
    }
}
