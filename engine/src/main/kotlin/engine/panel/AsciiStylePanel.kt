package engine.panel

import java.awt.*
import javax.swing.JPanel

class AsciiStylePanel(
    var cols: Int = 80,
    var rows: Int = 50,
    var baseFont: Font = Font("Monospaced", Font.PLAIN, 16)
) : JPanel() {
    
    private data class Cell(var ch: Char, var fg: Color, var bg: Color)
    
    private var scale = 20.0
    private var terminalFont: Font = baseFont
    
    private var charWidth = 10
    private var charHeight = 16
    private var ascent = 12
    
    private var defaultFg = Color.WHITE
    private var defaultBg = Color.BLACK
    
    private val buffer =
        Array(rows) { Array(cols) { Cell(' ', defaultFg, defaultBg) } }
    
    init {
        background = defaultBg
        applyFont()
    }
    
    /* ---------------- FONT & SCALING ---------------- */
    
    /** Zooms by scaling FONT SIZE (correct way) */
    fun setScale(s: Double) {
        scale = s
        applyFont()
    }
    
    fun applyFont() {
        terminalFont = baseFont.deriveFont((baseFont.size * scale).toFloat())
        font = terminalFont
        
        val metrics = getFontMetrics(terminalFont)
        charWidth = metrics.charWidth('M')
        charHeight = metrics.height
        ascent = metrics.ascent
        
        revalidate()
        repaint()
    }
    
    override fun getPreferredSize(): Dimension {
        return Dimension(
            cols * charWidth,
            rows * charHeight
        )
    }

    
    /* ---------------- WRITING ---------------- */
    
    fun writeChar(
        x: Int,
        y: Int,
        ch: Char,
        fg: Color = defaultFg,
        bg: Color = defaultBg
    ) {
        if (x !in 0 until cols || y !in 0 until rows) return
        
        buffer[y][x] = Cell(ch, fg, bg)
        
        repaint(
            x * charWidth,
            y * charHeight,
            charWidth,
            charHeight
        )
    }
    
    fun write(
        text: String,
        x: Int,
        y: Int,
        fg: Color = defaultFg,
        bg: Color = defaultBg
    ) {
        text.forEachIndexed { i, ch ->
            if (x + i < cols) {
                writeChar(x + i, y, ch, fg, bg)
                
            }
        }
    }
    
    fun clear() {
        for (row in buffer) {
            for (cell in row) {
                cell.ch = ' '
                cell.bg = Color.BLACK
                cell.fg = Color.WHITE
            }
            
        }
    }
    
    fun setBgColor(color: Color) {
        defaultBg = color
    }
    
    fun setFgColor(color: Color) {
        defaultFg = color
    }
    
    
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D
        g2.font = terminalFont
        
        g2.setRenderingHint(
            RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_OFF
        )
        
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val cell = buffer[row][col]
                
                // Background
                g2.color = cell.bg
                g2.fillRect(
                    col * charWidth,
                    row * charHeight,
                    charWidth,
                    charHeight
                )
                
                // Foreground glyph
                g2.color = cell.fg
                g2.drawString(
                    cell.ch.toString(),
                    col * charWidth,
                    row * charHeight + ascent
                )
            }
        }
    }
}