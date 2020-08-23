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
