package engine.terminal

import engine.panel.AsciiStylePanel
import javax.swing.JFrame
import java.awt.Color
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

class Terminal(
    width: Int = 80,
    height: Int = 24,
    title: String = "Nameless Window",
    fontScale: Double = 1.0
) {

    private val FSEX300 = "/fonts/FSEX300.ttf"
    private val IBMEGA8x8 = "/fonts/Ac437_IBM_EGA_8x8.ttf"
    
    val font = loadFont(IBMEGA8x8, 16f)
    private val panel = AsciiStylePanel(width, height, font)
    private val frame: JFrame = JFrame(title)
    
    private var scale = fontScale
    private val scaleStep = 0.2
    
    init {
        panel.font = font
        panel.applyFont()
        panel.setScale(scale)
        frame.add(panel)
        frame.pack()
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.isVisible = true
        frame.isResizable = false
        frame.setLocationRelativeTo(null)
        frame.pack()
    }

    /** Set terminal size in columns x rows (not font scale) */
    fun setSize(w: Int, h: Int) {
        val width = w
        val height = h
        panel.resizePanel(height, width)
        updateWindow()
    }

    fun setBgColor(color: Color) {
        panel.setBgColor(color)
    }
    fun setBgColor(color: Int) {
        panel.setBgColor(Color(color))
    }
    
    fun setFgColor(color: Color) {
        panel.setFgColor(color)
    }
    fun setFgColor(color: Int) {
        panel.setFgColor(Color(color))
    }
    
    fun write(text: String, x: Int, y: Int) {
        panel.write(text, x, y)
    }
    
    fun clear() {
        panel.clear()
    }
    
    fun refresh() {
        panel.revalidate()
        panel.paintImmediately(0, 0, panel.width, panel.height)
    }
    
    fun getHeight(): Int { return panel.rows }
    fun getWidth(): Int { return panel.cols }

    fun addKeyHandler(handler: (KeyEvent) -> Unit) {
        panel.isFocusable = true
        panel.requestFocusInWindow()
        panel.addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                handler(e)
            }
        })
    }
    
    fun increaseScale() {
        scale += scaleStep
        panel.setScale(scale)
        updateWindow()
    }
    
    fun decreaseScale() {
        if (scale > scaleStep) scale -= scaleStep
        panel.setScale(scale)
        updateWindow()
    }
    
    fun getScale(): Double {
        return scale
    }
    
    private fun updateWindow() {
        frame.pack()
        frame.revalidate()
        frame.repaint()
    }
}