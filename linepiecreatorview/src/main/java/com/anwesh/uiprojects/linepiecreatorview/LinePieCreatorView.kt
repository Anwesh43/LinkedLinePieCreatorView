package com.anwesh.uiprojects.linepiecreatorview

/**
 * Created by anweshmishra on 23/08/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val colors : Array<String> = arrayOf("", "", "", "", "")
val parts : Int = 4
val scGap : Float = 0.02f / parts
val strokeFactor : Int = 90
val sizeFactor : Float = 4.6f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#BDBDBD")
val rot : Float = 45f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawLinePieCreator(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    val sf4 : Float = sf.divideScale(3, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    save()
    translate(w / 2, h / 2)
    drawLine(-size / 2 * sf1, 0f, sf1 * size / 2, 0f, paint)
    save()
    translate(0f, h / 2 * (1 - sf3))
    for (j in 0..1) {
        save()
        rotate(rot * (1 - 2 * j) * sf4)
        drawLine(0f, 0f, 0f, -size * sf2, paint)
        restore()
    }
    restore()
    restore()
}

fun Canvas.drawLPCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawLinePieCreator(scale, w, h, paint)
}
