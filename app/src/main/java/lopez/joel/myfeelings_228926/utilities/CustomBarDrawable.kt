package lopez.joel.myfeelings_228926.utilities

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import lopez.joel.myfeelings_228926.R

class CustomBarDrawable:Drawable {
    var coordenadas:RectF?=null
    var context: Context? =null
    var emocion : Emociones? = null

    constructor(context: Context,emocion: Emociones){
        this.emocion=emocion
        this.context=context
    }

    override fun draw(p0: Canvas) {

        val fondo: Paint = Paint()
        fondo.style = Paint.Style.FILL
        fondo.isAntiAlias = true
        fondo.color = context?.resources?.getColor(R.color.gray) ?: R.color.gray
        val ancho: Float = (p0.width - 10).toFloat()
        val alto: Float = (p0.height - 10).toFloat()
        coordenadas = RectF(0.0F, 0.0F, ancho, alto)
        p0.drawRect(coordenadas!!, fondo)
        if (this.emocion != null) {
            val porcentaje: Float = this.emocion!!.porcentaje * (p0.width - 10) / 100
            var coordenadas2 = RectF(0.0F, 0.0F, porcentaje, alto)
            var seccion: Paint = Paint()
            seccion.style = Paint.Style.FILL
            seccion.isAntiAlias = true
            seccion.color = ContextCompat.getColor(this.context!!, emocion!!.color)
            p0.drawRect(coordenadas2!!, seccion)
        }
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

}