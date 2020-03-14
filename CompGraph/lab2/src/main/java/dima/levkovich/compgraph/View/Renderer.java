package dima.levkovich.compgraph.View;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import dima.levkovich.compgraph.Model.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.jogamp.opengl.GL.*;
import static java.lang.Math.*;

@Component
public class Renderer extends Thread implements GLEventListener {
    private int GLCode = GL2.GL_LINES;
    private int scissor_x = 600, scissor_y = 600;
    private int AlphaCode = GL_ALWAYS;
    private float AlphaParam = 0f;
    private int sfactor = GL_ZERO, dfactor = GL_ZERO;
    private float alpha = 0.5f;
    private int deep = 0;
    public Renderer(){

    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public void setAlphaParam(float alphaParam) {
        AlphaParam = alphaParam;
    }

    public void setAlphaCode(int alphaCode) {
        AlphaCode = alphaCode;
    }

    public void setSfactor(int sfactor) {
        this.sfactor = sfactor;
    }

    public void setDfactor(int dfactor) {
        this.dfactor = dfactor;
    }

    public void init(GLAutoDrawable drawable) {
        /* nothing to initiate yet */
    }

    public void dispose(GLAutoDrawable drawable) {
        /* nothing to dispose yet */
    }

    public void setGLCode(int GLCode) {
        System.out.println(GLCode);
        this.GLCode = GLCode;
    }

    public void setScissor_x(int scissor_x) {
        this.scissor_x = scissor_x;
    }

    public void setScissor_y(int scissor_y) {
        this.scissor_y = scissor_y;
    }

    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gl2.glScissor(0, 0, scissor_x, scissor_y);
        gl2.glEnable(GL2.GL_SCISSOR_TEST);
        gl2.glEnable(GL2.GL_ALPHA_TEST);
        gl2.glAlphaFunc(AlphaCode, AlphaParam);
       // gl2.glEnable(GL_BLEND);
        gl2.glBlendFunc(sfactor, dfactor);
        gl2.glPointSize(2);
        Point source = new Point( -0.5f, -0.5f);
        Point dest = new Point(0.5f, -0.5f);
        gl2.glColor3f(1, 0, 0);
        drawFractal(gl2, this.deep, source, dest, 0);
        gl2.glColor3f(0, 1, 0);
        drawFractal(gl2, this.deep, source, dest, 72);
        gl2.glColor3f(0, 0, 1);
        drawFractal(gl2, this.deep, source, dest, 72*2);
        gl2.glColor3f(1, 1, 0);
        drawFractal(gl2, this.deep, source, dest, 72*3);
        gl2.glColor3f(1, 0, 1);
        drawFractal(gl2, 5, source, dest, 72*4);

        gl2.glDisable(GL2.GL_SCISSOR_TEST);
        gl2.glDisable(GL2.GL_ALPHA_TEST);
        //gl2.glDisable(GL_BLEND);
        gl2.glFlush();
    }

    private void drawLines(GL2 gl2, Point dest, Point source) {
        gl2.glLineWidth(1);
        gl2.glBegin(GL_LINES);
        gl2.glVertex3d(dest.getX(),dest.getY(),0.0f);
        gl2.glVertex3d(source.getX(),source.getY(),0.0f);
        gl2.glEnd();
    }

    private static Point rotatePoint(final Point center, final Point point, double angle){
        angle = Math.PI *angle/180;
        return new Point(
                cos(angle) * (point.getX() - center.getX()) - sin(angle) * (point.getY() - center.getY()) + center.getX(),
                sin(angle) * (point.getX() - center.getX()) + cos(angle) * (point.getY() - center.getY()) + center.getY());
    }

    private List<Point> first2Lines(Point source, Point dest){
        List<Point> list = new ArrayList<>();
        Point point1 = new Point(source.getX(), source.getY());
        double scale = 1d/2;
        Point point2 = new Point((source.getX()+scale*dest.getX())/(1+scale), (source.getY()+scale*dest.getY())/(1+scale));
        point2 = rotatePoint(point1, point2, 12);
        Point point3 = new Point(2*point2.getX()-point1.getX(), 2*point2.getY()-point1.getY());
        point3 = rotatePoint(point2, point3, 72);
        list.add(point1);
        list.add(point2);
        list.add(point3);
        return list;
    }

    private List<Point> last2Lines(Point source, Point dest){
        List<Point> list = new ArrayList<>();
        Point point3 = new Point(dest.getX(), dest.getY());
        double scale = 2;
        Point point2 = new Point((source.getX()+scale*dest.getX())/(1+scale), (source.getY()+scale*dest.getY())/(1+scale));
        point2 = rotatePoint(point3, point2, 12);
        Point point1 = new Point(2*point2.getX()-point3.getX(), 2*point2.getY()-point3.getY());
        point1 = rotatePoint(point2, point1, -72);
        list.add(point1);
        list.add(point2);
        list.add(point3);
        return list;
    }

    private List<Point> middle2Lines(Point source, Point dest){
        List<Point> list = new ArrayList<>();
        Point point1 = new Point(2*dest.getX()-source.getX(), 2*dest.getY()-source.getY());
        point1 = rotatePoint(dest, point1, -72);
        list.add(point1);
        return list;
    }

    private List<Point> calculate6Lines(Point source, Point dest){
        List<Point> points = new ArrayList<>();
        List<Point> first2Lines = first2Lines(source, dest);
        points.addAll(first2Lines);
        points.addAll(middle2Lines(first2Lines.get(1), first2Lines.get(2)));
        points.addAll(last2Lines(source, dest));
        return points;
    }

    private void draw4Lines(GL2 gl2, List<Point> points){
        Iterator<Point> iterator = points.iterator();
        iterator.next();
        for (Point point:
             points) {
            if (iterator.hasNext()) {
                drawLines(gl2, point, iterator.next());
            }
        }
    }

    private void drawFractal(GL2 gl2, int deep, Point point1, Point point2, double angle) {
        Point source = new Point(point1.getX(), point1.getY());
        Point dest = new Point(point2.getX(), point2.getY());
        if(deep==2){
            List<Point> list = calculate6Lines(source, dest);
            List<Point> rotatedPoints = list.stream().map(s->rotatePoint(new Point(0, 0.13527055229209678), s, angle)).collect(Collectors.toList());
            draw4Lines(gl2, rotatedPoints);
            return;
        }
        List<Point> list = calculate6Lines(source, dest);
        Iterator<Point> iterator = list.iterator();
        iterator.next();
        for (Point point:
             list) {
                if(iterator.hasNext()){
                    drawFractal(gl2, deep-1, point, iterator.next(), angle);
                }
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
        /* no action to be taken on reshape */
    }

}
