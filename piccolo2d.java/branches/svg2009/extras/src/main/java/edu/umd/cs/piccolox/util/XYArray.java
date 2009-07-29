/*
 * Copyright (c) 2008-2009, Piccolo2D project, http://piccolo2d.org
 * Copyright (c) 1998-2008, University of Maryland
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * None of the name of the University of Maryland, the name of the Piccolo2D project, or the names of its
 * contributors may be used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package edu.umd.cs.piccolox.util;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class XYArray implements MutablePoints, Cloneable {
    // the coordinates are stored as alternating x and y pairs
    private double[] points = null;

    // the number of valid x, y pairs,
    // i.e. not the length of the points array

    private int numPoints = 0;

    public XYArray(final double[] points) {
        initPoints(points, points.length / 2);
    }

    public XYArray(final int n) {
        initPoints(null, n);
    }

    public XYArray() {
        this(0);
    }

    public int getPointCount() {
        return numPoints;
    }

    // normalize an index, negative counts from end

    private int normalize(final int i) {
        if (i >= numPoints) {
            throw new IllegalArgumentException("The point index " + i + " is not below " + numPoints);
        }

        return i < 0 ? numPoints + i : i;
    }

    public double getX(final int i) {
        return points[normalize(i) * 2];
    }

    public double getY(final int i) {
        return points[normalize(i) * 2 + 1];
    }

    public Point2D getPoint(final int i, final Point2D dst) {
        final int pointIndex = normalize(i);
        dst.setLocation(points[pointIndex * 2], points[pointIndex * 2 + 1]);
        return dst;
    }

    public void setX(final int i, final double x) {
        points[normalize(i) * 2] = x;
    }

    public void setY(final int i, final double y) {
        points[normalize(i) * 2 + 1] = y;
    }

    public void setPoint(final int i, final double x, final double y) {
        final int pointIndex = normalize(i);
        points[pointIndex * 2] = x;
        points[pointIndex * 2 + 1] = y;
    }

    public void setPoint(final int i, final Point2D pt) {
        setPoint(i, pt.getX(), pt.getY());
    }

    public void transformPoints(final AffineTransform t) {
        t.transform(points, 0, points, 0, numPoints);
    }

    public Rectangle2D getBounds(final Rectangle2D dst) {
        int i = 0;
        if (dst.isEmpty() && getPointCount() > 0) {
            dst.setRect(getX(i), getY(i), 1.0d, 1.0d);
            i++;
        }
        while (i < getPointCount()) {
            dst.add(getX(i), getY(i));
            i++;
        }
        return dst;
    }

    public static double[] initPoints(double[] points, final int n, final double[] old) {
        if (points == null || n * 2 > points.length) {
            points = new double[n * 2];
        }
        if (old != null && points != old) {
            System.arraycopy(old, 0, points, 0, Math.min(old.length, n * 2));
        }
        return points;
    }

    private void initPoints(final double[] points, final int n) {
        this.points = initPoints(points, n, this.points);
        numPoints = points != null ? points.length / 2 : 0;
    }

    public void addPoints(final int pos, final Points pts, int start, int end) {
        if (end < 0) {
            end = pts.getPointCount() + end + 1;
        }
        final int n = numPoints + end - start;
        points = initPoints(points, n, points);
        final int pos1 = pos * 2;
        final int pos2 = (pos + end - start) * 2;
        final int len = (numPoints - pos) * 2;

        System.arraycopy(points, pos1, points, pos2, len);

        numPoints = n;
        if (pts != null) {
            for (int count = 0; start < end; count++, start++) {
                setPoint(pos + count, pts.getX(start), pts.getY(start));
            }
        }
    }

    public void addPoints(final int pos, final Points pts) {
        addPoints(pos, pts, 0, pts.getPointCount());
    }

    public void appendPoints(final Points pts) {
        addPoints(numPoints, pts);
    }

    public static XYArray copyPoints(final Points pts) {
        final XYArray newList = new XYArray(pts.getPointCount());
        newList.appendPoints(pts);
        return newList;
    }

    public void addPoint(final int pos, final double x, final double y) {
        addPoints(pos, null, 0, 1);
        setPoint(pos, x, y);
    }

    public void addPoint(final int pos, final Point2D pt) {
        addPoint(pos, pt.getX(), pt.getY());
    }

    public void removePoints(final int pos, int num) {
        num = Math.min(num, numPoints - pos);
        if (num <= 0) {
            return;
        }
        System.arraycopy(points, (pos + num) * 2, points, pos * 2, (numPoints - (pos + num)) * 2);
        numPoints -= num;
    }

    public void removeAllPoints() {
        removePoints(0, numPoints);
    }

    public Object clone() {
        XYArray ps = null;

        try {
            ps = (XYArray) super.clone();
            ps.points = initPoints(ps.points, numPoints, points);
            ps.numPoints = numPoints;
        }
        catch (final CloneNotSupportedException e) {
        }

        return ps;
    }
}
