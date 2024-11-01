package edu.rpi.legup.puzzle.minesweeper;

import edu.rpi.legup.ui.boardview.GridElementView;
import java.awt.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MinesweeperElementView extends GridElementView {

    private static final Font FONT = new Font("TimesRoman", Font.BOLD, 16);
    private static final Color FONT_COLOR = Color.BLACK;

    public MinesweeperElementView(@NotNull MinesweeperCell cell) {
        super(cell);
    }

    @Override
    public @NotNull MinesweeperCell getPuzzleElement() {
        return (MinesweeperCell) super.getPuzzleElement();
    }

    @Override
    @SuppressWarnings("Duplicates")
    @Contract(pure = true)
    public void drawElement(@NotNull Graphics2D graphics2D) {
        final MinesweeperCell cell = (MinesweeperCell) puzzleElement;
        final MinesweeperTileType type = cell.getTileType();
        if (type == MinesweeperTileType.FLAG) {
            graphics2D.setStroke(new BasicStroke(1));
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillRect(location.x, location.y, size.width, size.height);

            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(location.x, location.y, size.width, size.height);
            int intValue = ((MinesweeperCell) puzzleElement).getData().data();
            boolean newClick = false;
            if(intValue > 10) {
                intValue -= 10;
                //newClick = true; // uncomment this if you want to click on flag tiles to make them red
            }
            final String value = String.valueOf(intValue);
            if(newClick) {
                graphics2D.setColor(Color.RED);
                graphics2D.fillRect(location.x, location.y, size.width, size.height);
            }
            if(intValue== 1) {
                Color MSBLUE = new Color(7,3,251);
                graphics2D.setColor(MSBLUE);
            } else if(intValue == 2) {
                Color MSGREEN = new Color(7,123,3);
                graphics2D.setColor(MSGREEN);
            } else if(intValue == 3) {
                Color MSRED = new Color(255,3,3);
                graphics2D.setColor(MSRED);
            } else if(intValue == 4) {
                Color MSDARKBLUE = new Color(0,0,125);
                graphics2D.setColor(MSDARKBLUE);
            } else if(intValue == 5) {
                Color MSMAROON = new Color(135,3,3);
                graphics2D.setColor(MSMAROON);
            } else if(intValue == 6) {
                Color MSCYAN = new Color(7,131,131);
                graphics2D.setColor(MSCYAN);
            } else if(intValue == 7) {
                Color MSDARKGRAY = new Color(7,3,3);
                graphics2D.setColor(MSDARKGRAY);
            } else {
                Color MSLIGHTGRAY = new Color(135,131,131);
                graphics2D.setColor(MSLIGHTGRAY);
            }

            graphics2D.setFont(FONT);
            final FontMetrics metrics = graphics2D.getFontMetrics(FONT);

            final int xText = location.x + (size.width - metrics.stringWidth(value)) / 2;
            final int yText =
                    location.y + ((size.height - metrics.getHeight()) / 2) + metrics.getAscent();
            graphics2D.drawString(value, xText, yText);
            return;
        }
        if (type == MinesweeperTileType.UNSET) {
            graphics2D.setStroke(new BasicStroke(1));
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(location.x, location.y, size.width, size.height);
            graphics2D.setColor(Color.DARK_GRAY);
            graphics2D.fillRect(location.x, location.y, size.width, size.height);
            return;
        }
        if (type == MinesweeperTileType.EMPTY) {
            graphics2D.setColor(Color.LIGHT_GRAY);
            graphics2D.fillRect(location.x, location.y, size.width, size.height);
            graphics2D.drawImage(
                    MinesweeperView.EMPTY_IMAGE,
                    location.x,
                    location.y,
                    size.width,
                    size.height,
                    Color.GRAY,
                    null);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(location.x, location.y, size.width, size.height);
        }
        if (type == MinesweeperTileType.BOMB) {
            graphics2D.setColor(Color.LIGHT_GRAY);
            graphics2D.fillRect(location.x, location.y, size.width, size.height);
            graphics2D.drawImage(
                    MinesweeperView.BOMB_IMAGE,
                    location.x,
                    location.y,
                    size.width,
                    size.height,
                    Color.GRAY,
                    null);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(location.x, location.y, size.width, size.height);
        }
    }
}
