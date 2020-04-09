package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static java.lang.Math.abs;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Unan Abraamyan (abrunan@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) / size;
        int deltaY = (dest.y - source.y) / size;
        for (int index = 0; index < size; index++) {
            int x = source.x + 1 + deltaX * index;
            int y = source.y + 1 + deltaY * index;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int diffX = dest.x - source.x;
        int diffY = dest.y - source.y;
        return (abs(diffX) == abs(diffY));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
