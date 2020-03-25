package dima.levkovich.compgraph.Model;

import com.jogamp.opengl.GL2;

public class Parallel extends Thread{
    GL2 gl2;
    public Parallel(GL2 gl2){
        this.gl2 = gl2;
    }
    @Override
    public void run(){
        float x = 0.1f;
        float y = 0.1f;
        int n = 12;
        for (int i = 0; i < n; i++) {
            float angle = (float)(2 * Math.PI * i / (n));
            float x_ = (float)(( -0.2 + Math.cos(angle) * 0.8 + x));
            float y_ = (float)(( -0.1 + Math.sin(angle) * 0.8 + y));
            gl2.glColor4f((float)1/(i+1),(float)2/(i+1),(float)3/(i+1), 0.5f);
            gl2.glVertex2f(x_, y_);
        }/*
        gl2.glColor4f(1, 0 ,0, 1);
        drawCircle(gl2, 0.1f, 0.1f);

        gl2.glColor4f(0, 1 ,0, 1);
        drawCircle(gl2, 0.1f, 0.3f);

        gl2.glColor4f(0, 0 ,1, 1);
        drawCircle(gl2, 0.1f, -0.3f);*/
    }
}
