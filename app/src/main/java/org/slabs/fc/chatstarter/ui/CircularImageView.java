package org.slabs.fc.chatstarter.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class CircularImageView extends ImageView {
    private Bitmap bmg;
    private int borderWidth;
    private int cdj;
    private int cdk;
    private Paint cdl;
    private Paint cdm;
    private BitmapShader cdn;

    public CircularImageView(Context context) {
        super(context);
        this.borderWidth = 0;
        setup();
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.borderWidth = 0;
        setup();
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.borderWidth = 0;
        setup();
    }

    private void setup() {
        this.cdl = new Paint();
        this.cdl.setAntiAlias(true);
        this.cdm = new Paint();
        setBorderColor(-1);
        this.cdm.setAntiAlias(true);

    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        invalidate();
    }

    public void setBorderColor(int i) {
        if (this.cdm != null) {
            this.cdm.setColor(i);
        }
        invalidate();
    }

    private void alK() {
        Drawable drawable;
        drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            this.bmg = ((BitmapDrawable) drawable).getBitmap();
        } else {
            this.bmg = null;
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        alK();
        if (this.bmg != null) {

                this.cdn = new BitmapShader(Bitmap.createScaledBitmap(this.bmg, this.cdj, this.cdk, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
           // }
            this.cdl.setShader(this.cdn);
            int i = this.cdj / 2;
            if (this.borderWidth > 0) {
                canvas.drawCircle((float) i, (float) i, (float) i, this.cdm);
            }
            canvas.drawCircle((float) i, (float) i, (float) (i - this.borderWidth), this.cdl);
        }
    }

    protected void onMeasure(int i, int i2) {
        int kK = kK(i);
        int bf = bf(i2, i);
        this.cdj = kK;
        this.cdk = bf;
        setMeasuredDimension(kK, bf);
    }

    private int kK(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != MeasureSpec.EXACTLY) {
            return this.cdj;
        }
        return size;
    }

    private int bf(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != MeasureSpec.EXACTLY) {
            size = this.cdk;
        }
        return size + 2;
    }
}
