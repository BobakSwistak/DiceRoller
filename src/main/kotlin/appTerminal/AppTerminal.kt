package appTerminal

import data.ColorPalette
import engine.terminal.Terminal

lateinit var terminal: Terminal

fun Terminal.setFgColor(color: ColorPalette) = setFgColor(color.toAwtColor())
fun Terminal.setBgColor(color: ColorPalette) = setBgColor(color.toAwtColor())